package ui;

import callback.EnigmaInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Enigma1LogicaUi extends BaseEnigmaUi {

    private final EnigmaInterface enigmaCallback;
    private JPanel indicator;
    private JButton btnNewButtonA, btnNewButtonB, btnNewButtonC, btnNewButtonD;


    /**
     * Create the application.
     */
    public Enigma1LogicaUi(EnigmaInterface enigmaCallback) {
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

        btnNewButtonA = new JButton(enigmaCallback.getEnigma().getOptions()[0]);
        btnNewButtonA.addActionListener(e -> {
            onConfirm(enigmaCallback.onUserConfirm(0));
        });
        btnNewButtonA.setBounds(10, 146, 126, 23);
        frame.getContentPane().add(btnNewButtonA);

        btnNewButtonB = new JButton(enigmaCallback.getEnigma().getOptions()[1]);
        btnNewButtonB.addActionListener(e -> {
            onConfirm(enigmaCallback.onUserConfirm(1));
        });
        btnNewButtonB.setBounds(10, 180, 126, 23);
        frame.getContentPane().add(btnNewButtonB);

        btnNewButtonC = new JButton(enigmaCallback.getEnigma().getOptions()[2]);
        btnNewButtonC.addActionListener(e -> {
            onConfirm(enigmaCallback.onUserConfirm(2));
        });
        btnNewButtonC.setBounds(198, 146, 126, 23);
        frame.getContentPane().add(btnNewButtonC);

        btnNewButtonD = new JButton(enigmaCallback.getEnigma().getOptions()[3]);
        btnNewButtonD.addActionListener(e -> {
            onConfirm(enigmaCallback.onUserConfirm(3));
        });
        btnNewButtonD.setBounds(198, 180, 126, 23);
        frame.getContentPane().add(btnNewButtonD);

        indicator = new JPanel();
        indicator.setBounds(324, 0, 10, 10);
        indicator.setBackground(Color.RED);
        frame.getContentPane().add(indicator);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 314, 124);
        frame.getContentPane().add(scrollPane);

        JLabel lblNewLabel = new JLabel(enigmaCallback.getEnigma().getText());
        scrollPane.setViewportView(lblNewLabel);
        super.setJFrame(frame);
    }

    @Override
    protected void onConfirm(boolean isCorrect) {
        if (isCorrect) {
            indicator.setBackground(Color.GREEN);
            btnNewButtonA.setEnabled(false);
            btnNewButtonB.setEnabled(false);
            btnNewButtonC.setEnabled(false);
            btnNewButtonD.setEnabled(false);
        } else {
            indicator.setBackground(Color.RED);
        }
    }
}