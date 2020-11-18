package ui;

import callback.EnigmaInterface;

import javax.swing.*;
import java.awt.*;

public class Enigma2ProposicionalUi extends BaseEnigmaUi {

    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final EnigmaInterface enigmaCallback;

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

        JLabel lblNewLabel = new JLabel("<html>Dada a senten\u00E7a abaixo: <br>\r\n\"Se o lutador treina bem, ele ganha. Se o lutador n\u00E3o se alimenta bem, ele n\u00E3o treina bem. O lutador se alimentou bem. Logo, ele ganhou.\" <br>\r\nSendo: <br>\r\nL - o lutador treina bem<br>\r\nG - ele ganha<br>\r\nA - o lutador se Alimenta<br>\r\nPode-se Afirmar que a f\u00F3rmula que corresponde a seten\u00E7a \u00E9:\r\n\r\n\r\n\r\n");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblNewLabel.setBounds(10, 0, 314, 117);
        frame.getContentPane().add(lblNewLabel);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("((L -> G) ^ (~A -> ~L) ^ A) -> G");
        buttonGroup.add(rdbtnNewRadioButton);
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        rdbtnNewRadioButton.setBounds(10, 121, 181, 23);
        frame.getContentPane().add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("(L -> G) ^ (~A -> ~L) ^ A -> G");
        buttonGroup.add(rdbtnNewRadioButton_1);
        rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
        rdbtnNewRadioButton_1.setBounds(10, 141, 181, 23);
        frame.getContentPane().add(rdbtnNewRadioButton_1);

        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("(L -> G) ^ ((~A ^ L) ^ A )-> G");
        buttonGroup.add(rdbtnNewRadioButton_2);
        rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
        rdbtnNewRadioButton_2.setBounds(10, 161, 181, 23);
        frame.getContentPane().add(rdbtnNewRadioButton_2);

        JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("((L -> A) ^ (~G -> ~L) ^ A) -> G");
        buttonGroup.add(rdbtnNewRadioButton_3);
        rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
        rdbtnNewRadioButton_3.setBounds(10, 181, 181, 23);
        frame.getContentPane().add(rdbtnNewRadioButton_3);

        JButton btnNewButton = new JButton("Confirmar");
        btnNewButton.setBounds(213, 141, 89, 43);
        frame.getContentPane().add(btnNewButton);

        super.setJFrame(frame);
    }
}
