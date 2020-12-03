package ui;

import callback.EnigmaInterface;

import java.awt.*;

import javax.swing.*;

public class Enigma1PredicadoUi extends BaseEnigmaUi {

	private final EnigmaInterface enigmaCallback;
	private JPanel indicator;
	private JButton btnNewButtonA, btnNewButtonB, btnNewButtonC, btnNewButtonD;

	/**
	 * Create the application.
	 */
	public Enigma1PredicadoUi(EnigmaInterface enigmaCallback) {
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

		indicator = new JPanel();
		indicator.setBounds(324, 0, 10, 10);
		indicator.setBackground(Color.RED);
		frame.getContentPane().add(indicator);
		
		btnNewButtonA = new JButton(enigmaCallback.getEnigma().getOptions()[0]);
		btnNewButtonA.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButtonA.setBounds(13, 103, 311, 23);
		btnNewButtonA.addActionListener(e -> onConfirm(enigmaCallback.onUserConfirm(0)));
		frame.getContentPane().add(btnNewButtonA);
		
		btnNewButtonB = new JButton(enigmaCallback.getEnigma().getOptions()[1]);
		btnNewButtonB.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButtonB.setBounds(13, 131, 311, 23);
		btnNewButtonB.addActionListener(e -> onConfirm(enigmaCallback.onUserConfirm(1)));
		frame.getContentPane().add(btnNewButtonB);
		
		btnNewButtonC = new JButton(enigmaCallback.getEnigma().getOptions()[2]);
		btnNewButtonC.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButtonC.setBounds(13, 159, 311, 23);
		btnNewButtonC.addActionListener(e -> onConfirm(enigmaCallback.onUserConfirm(2)));
		frame.getContentPane().add(btnNewButtonC);
		
		btnNewButtonD = new JButton(enigmaCallback.getEnigma().getOptions()[3]);
		btnNewButtonD.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButtonD.setBounds(13, 187, 311, 23);
		btnNewButtonD.addActionListener(e -> onConfirm(enigmaCallback.onUserConfirm(3)));
		frame.getContentPane().add(btnNewButtonD);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 0, 311, 92);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel(enigmaCallback.getEnigma().getText());
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 11));
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
