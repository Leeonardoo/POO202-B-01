import callback.EnigmaInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Enigma1LogicaUi {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private EnigmaInterface<Integer> enigmaCallback;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enigma1LogicaUi window = new Enigma1LogicaUi();
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
	public Enigma1LogicaUi() {
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

		JLabel lblNewLabel_1 = new JLabel("<html>Jo\u00E3o tem apenas um filho.<br>\r\nJunior \u00E9 primo de Betinho.<br>\r\nMaria \u00E9 m\u00E3e de Jo\u00E3o. <br>\r\nBetinho \u00E9 filho de Jo\u00E3o.</html>");
		lblNewLabel_1.setToolTipText("-");
		lblNewLabel_1.setBounds(10, 0, 168, 61);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("<html> Tendo conhecimento de que todas as senten\u00E7as acima s\u00E3o verdadeiras, assinale a alternativa que corresponde a seguinte pergunta: </html>\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 65, 314, 42);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Qual a rela\u00E7\u00E3o de Betinho com a Maria?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(10, 121, 257, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("A - Tia");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(10, 142, 65, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("D - Av\u00F3 Paterna");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(79, 181, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("C - Av\u00F3 Materna");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(79, 142, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("B - Irm\u00E3");
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(10, 181, 65, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);

		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(211, 159, 94, 29);
		frame.getContentPane().add(btnNewButton);
	}
}
