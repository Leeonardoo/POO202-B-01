package ui;

import callback.EnigmaInterface;

import java.awt.*;
import java.util.Enumeration;

import javax.swing.*;

public class Enigma2PredicadoUi extends BaseEnigmaUi {

    private final EnigmaInterface enigmaCallback;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JPanel indicator;
    JButton confirmButton;

    /**
     * Create the application.
     */
    public Enigma2PredicadoUi(EnigmaInterface enigmaCallback) {
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
        scrollPane.setBounds(12, 13, 328, 115);
        frame.getContentPane().add(scrollPane);

        JLabel lblNewLabel = new JLabel(enigmaCallback.getEnigma().getText());
        scrollPane.setViewportView(lblNewLabel);

        String[] options = enigmaCallback.getEnigma().getOptions();

        JRadioButton rdbtnNewRadioButton = new JRadioButton(enigmaCallback.getEnigma().getOptions()[0]);
        rdbtnNewRadioButton.setActionCommand("0");
        buttonGroup.add(rdbtnNewRadioButton);
        rdbtnNewRadioButton.setBounds(10, 133, 100, 23);
        frame.getContentPane().add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(enigmaCallback.getEnigma().getOptions()[1]); //
        rdbtnNewRadioButton_1.setActionCommand("1");
        buttonGroup.add(rdbtnNewRadioButton_1);
        rdbtnNewRadioButton_1.setBounds(10, 170, 100, 23);
        frame.getContentPane().add(rdbtnNewRadioButton_1);

        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton(enigmaCallback.getEnigma().getOptions()[2]);
        rdbtnNewRadioButton_2.setActionCommand("2");
        buttonGroup.add(rdbtnNewRadioButton_2);
        rdbtnNewRadioButton_2.setBounds(106, 133, 100, 23);
        frame.getContentPane().add(rdbtnNewRadioButton_2);

        JRadioButton rdbtnNewRadioButton_3 = new JRadioButton(enigmaCallback.getEnigma().getOptions()[3]);
        rdbtnNewRadioButton_3.setActionCommand("3");
        buttonGroup.add(rdbtnNewRadioButton_3);
        rdbtnNewRadioButton_3.setBounds(106, 170, 100, 23);
        frame.getContentPane().add(rdbtnNewRadioButton_3);

        confirmButton = new JButton("Confirmar");
        confirmButton.setBounds(214, 143, 124, 46);
        confirmButton.addActionListener(e -> {
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
