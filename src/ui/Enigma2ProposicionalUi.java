package ui;

import callback.EnigmaInterface;

import javax.swing.*;
import java.awt.*;

public class Enigma2ProposicionalUi extends BaseEnigmaUi {

    private final EnigmaInterface enigmaCallback;
    private JComboBox<String> comboBox;
    private JButton confirmButton;
    private JPanel indicator;

    /**
     * Create the application.
     */
    public Enigma2ProposicionalUi(EnigmaInterface enigmaCallback) {
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
        scrollPane.setBounds(10, 0, 314, 137);
        frame.getContentPane().add(scrollPane);

        JLabel lblNewLabel = new JLabel(enigmaCallback.getEnigma().getText());
        scrollPane.setViewportView(lblNewLabel);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));

        confirmButton = new JButton("Confirmar");
        confirmButton.setBounds(112, 177, 98, 23);
        confirmButton.addActionListener(arg0 -> {
            onConfirm(enigmaCallback.onUserConfirm(comboBox.getSelectedIndex()));
        });
        frame.getContentPane().add(confirmButton);
        
        JLabel lblNewLabel_1 = new JLabel("Resposta:");
        lblNewLabel_1.setBounds(10, 148, 73, 14);
        frame.getContentPane().add(lblNewLabel_1);
        
        comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel(enigmaCallback.getEnigma().getOptions()));
        comboBox.setSelectedIndex(-1);
        comboBox.setBounds(77, 145, 247, 20);
        frame.getContentPane().add(comboBox);

        indicator = new JPanel();
        indicator.setBounds(324, 0, 10, 10);
        indicator.setBackground(Color.RED);
        frame.getContentPane().add(indicator);

        super.setJFrame(frame);
    }

    @Override
    protected void onConfirm(boolean isCorrect) {
        confirmButton.setEnabled(!isCorrect);
        comboBox.setEnabled(!isCorrect);

        indicator.setBackground(isCorrect ? Color.GREEN : Color.RED);
    }
}
