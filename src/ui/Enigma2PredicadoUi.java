package ui;

import java.awt.*;

import javax.swing.*;

public class Enigma2PredicadoUi {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel indicator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enigma2PredicadoUi window = new Enigma2PredicadoUi();
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
	public Enigma2PredicadoUi() {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 328, 115);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("<html>jornalista(x) = x é jornalista<br>\r\nformado(x) = x é formado<br>\r\n<br>\r\n1 - Todos são formados<br>\r\n2 - Todo Jornalista é formado<br>\r\n3 - Alguns são formados, alguns não são<br>\r\n4 - Nem todo jornalista é formado<br>\r\n<br>\r\n\r\n( ) (Ax)(jornalista(x) -> formado(x))<br>\r\n( ) -((Ex)(jornalista(x) -> formado(x)))<br>\r\n( ) (Ax)(formado(x))<br>\r\n( ) (Ex)(formado(x))) ^(Ex)(-formado(x))<br>\r\n<br>\r\nAssinale a alternativa que corresponde ao<br>relacionamento entre as sentenças abaixo:</html>");
		scrollPane.setViewportView(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("2,1,3,4");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(10, 133, 100, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2,4,1,3");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(10, 170, 100, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("1,2,3,4");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(106, 133, 100, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("3,4,1,2");
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(106, 170, 100, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(214, 143, 124, 46);
		frame.getContentPane().add(btnNewButton);

		indicator = new JPanel();
		indicator.setBounds(324, 0, 10, 10);
		indicator.setBackground(Color.RED);
		frame.getContentPane().add(indicator);
	}
}
