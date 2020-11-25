package ui;

import java.awt.*;

import javax.swing.*;

public class Enigma1PredicadoUi {

	private JFrame frame;
	private JPanel indicator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enigma1PredicadoUi window = new Enigma1PredicadoUi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Enigma1PredicadoUi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		indicator = new JPanel();
		indicator.setBounds(324, 0, 10, 10);
		indicator.setBackground(Color.RED);
		frame.getContentPane().add(indicator);
		
		JButton btnNewButton = new JButton("(Ex) (Ay) (jogador(x) ^ boxeador(y) -> Perde(x,y)");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButton.setBounds(9, 101, 334, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("(Ey) (Ax) (jogador(x) ^ boxeador(y) -> Perde(x,y)");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButton_1.setBounds(9, 131, 334, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("(Ex) (Ay) (jogador(y) ^ boxeador(x) -> Perde(x,y)");
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButton_2.setBounds(9, 159, 334, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("(Ex) (Ay) (jogador(x) ^ boxeador(y) -> Perde(y,y)");
		btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButton_3.setBounds(9, 187, 334, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 11, 326, 81);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("<html>Dada a senten\u00E7a: <br>\r\n\"Um Jogador perde para todos os boxeadores\" <br><br>\r\nSelecione a formula correta:\r\n</html>\r\n");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 11));
		scrollPane.setViewportView(lblNewLabel);
	}
}
