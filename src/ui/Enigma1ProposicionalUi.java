package ui;

import callback.EnigmaInterface;

import javax.swing.*;
import java.awt.*;

public class Enigma1ProposicionalUi extends BaseEnigmaUi {

    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final EnigmaInterface enigmaCallback;

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

        JLabel lblNewLabel = new JLabel("<html>\r\nDada a disjun\u00E7\u00E3o exclusiva \u201COu Ana \u00E9 advogada ou Bianca \u00E9 professora (P \u22BB Q)\u201D, o usu\u00E1rio deve analisar a mesma e escolher entre as alternativas a sua nega\u00E7\u00E3o.");
        lblNewLabel.setBounds(10, -4, 314, 59);
        frame.getContentPane().add(lblNewLabel);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("A - \u201CSe Ana \u00E9 advogada, ent\u00E3o Bianca \u00E9 professora.\u201D (P \u2192 Q)");
        buttonGroup.add(rdbtnNewRadioButton);
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        rdbtnNewRadioButton.setBounds(6, 56, 318, 15);
        frame.getContentPane().add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("<html>D - \u201CSe Bianca \u00E9 advogada, ent\u00E3o Ana \u00E9 professora.\u201D (R \u2192 S)");
        buttonGroup.add(rdbtnNewRadioButton_1);
        rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
        rdbtnNewRadioButton_1.setBounds(6, 147, 301, 23);
        frame.getContentPane().add(rdbtnNewRadioButton_1);

        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("<html>B - \u201CSe Bianca n\u00E3o \u00E9 advogada ent\u00E3o Ana \u00E9 professora.\u201D (\u00ACR \u2192 S)");
        buttonGroup.add(rdbtnNewRadioButton_2);
        rdbtnNewRadioButton_2.setVerticalAlignment(SwingConstants.TOP);
        rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
        rdbtnNewRadioButton_2.setBounds(6, 74, 268, 40);
        frame.getContentPane().add(rdbtnNewRadioButton_2);

        JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("<html> C - \u201CAna \u00E9 advogada se, e somente se, Bianca \u00E9 professora.\u201D (P \u2194 Q)");
        buttonGroup.add(rdbtnNewRadioButton_3);
        rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
        rdbtnNewRadioButton_3.setVerticalAlignment(SwingConstants.TOP);
        rdbtnNewRadioButton_3.setBounds(6, 110, 301, 37);
        frame.getContentPane().add(rdbtnNewRadioButton_3);

        JButton btnNewButton = new JButton("Confirmar");
        btnNewButton.addActionListener(arg0 -> {
            enigmaCallback.onUserConfirm(0);
        });
        btnNewButton.setBounds(121, 177, 89, 23);
        frame.getContentPane().add(btnNewButton);

        super.setJFrame(frame);
    }
}
