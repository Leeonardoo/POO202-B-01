package ui;

import callback.EnigmaInterface;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class Enigma1ProposicionalUi extends BaseEnigmaUi {

    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final EnigmaInterface enigmaCallback;
    private JButton confirmButton;
    private JPanel indicator;

    /**
     * Create the application.
     */
    public Enigma1ProposicionalUi(EnigmaInterface enigmaCallback) {
        this.enigmaCallback = enigmaCallback;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, -4, 314, 59);
        frame.getContentPane().add(scrollPane);

        JLabel lblNewLabel = new JLabel(enigmaCallback.getEnigma().getText());
        scrollPane.setViewportView(lblNewLabel);

        JRadioButton rdbtnNewRadioButton = new JRadioButton(enigmaCallback.getEnigma().getOptions()[0]);
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        rdbtnNewRadioButton.setBounds(10, 56, 314, 15);
        rdbtnNewRadioButton.setActionCommand("0");
        buttonGroup.add(rdbtnNewRadioButton);
        frame.getContentPane().add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(enigmaCallback.getEnigma().getOptions()[3]);
        rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
        rdbtnNewRadioButton_1.setBounds(10, 150, 314, 23);
        rdbtnNewRadioButton_1.setActionCommand("3");
        buttonGroup.add(rdbtnNewRadioButton_1);
        frame.getContentPane().add(rdbtnNewRadioButton_1);

        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton(enigmaCallback.getEnigma().getOptions()[1]);
        rdbtnNewRadioButton_2.setVerticalAlignment(SwingConstants.TOP);
        rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
        rdbtnNewRadioButton_2.setBounds(10, 74, 314, 40);
        rdbtnNewRadioButton_2.setActionCommand("1");
        buttonGroup.add(rdbtnNewRadioButton_2);
        frame.getContentPane().add(rdbtnNewRadioButton_2);

        JRadioButton rdbtnNewRadioButton_3 = new JRadioButton(enigmaCallback.getEnigma().getOptions()[2]);
        rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
        rdbtnNewRadioButton_3.setVerticalAlignment(SwingConstants.TOP);
        rdbtnNewRadioButton_3.setBounds(10, 110, 314, 37);
        rdbtnNewRadioButton_3.setActionCommand("2");
        buttonGroup.add(rdbtnNewRadioButton_3);
        frame.getContentPane().add(rdbtnNewRadioButton_3);

        confirmButton = new JButton("Confirmar");
        confirmButton.addActionListener(arg0 -> {
            if (buttonGroup.getSelection() != null &&
                    buttonGroup.getSelection().getActionCommand() != null &&
                    !buttonGroup.getSelection().getActionCommand().isEmpty()
            ) {
                onConfirm(enigmaCallback.onUserConfirm(Integer.parseInt(buttonGroup.getSelection().getActionCommand())));
            } else {
                //se não tem nenhum selecionado, já está errado
                onConfirm(enigmaCallback.onUserConfirm(-1));
            }
        });
        confirmButton.setBounds(118, 177, 98, 23);
        frame.getContentPane().add(confirmButton);

        indicator = new JPanel();
        indicator.setBounds(324, 0, 10, 10);
        indicator.setBackground(Color.RED);
        frame.getContentPane().add(indicator);

        super.setJFrame(frame);
    }

    @Override
    protected void onConfirm(boolean isCorrect) {
        confirmButton.setEnabled(!isCorrect);

        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            button.setEnabled(!isCorrect);
        }

        if (isCorrect)
            indicator.setBackground(Color.GREEN);
        else
            indicator.setBackground(Color.RED);
    }
}
