import callback.EnigmaInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Enigma2LogicaUi {

    private JFrame frame;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTable table;
    private EnigmaInterface<Integer> enigmaCallback;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Enigma2LogicaUi window = new Enigma2LogicaUi();
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
    public Enigma2LogicaUi() {
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

        JLabel lblNewLabel_1 = new JLabel("<html>Assinale a alternativa que corresponde ao n\u00FAmero faltando da tabela abaixo");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(10, 11, 314, 29);
        frame.getContentPane().add(lblNewLabel_1);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("A - 327");
        buttonGroup.add(rdbtnNewRadioButton);
        rdbtnNewRadioButton.setBounds(10, 131, 73, 23);
        frame.getContentPane().add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("B - 485");
        buttonGroup.add(rdbtnNewRadioButton_1);
        rdbtnNewRadioButton_1.setBounds(10, 169, 73, 23);
        frame.getContentPane().add(rdbtnNewRadioButton_1);

        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("C - 785");
        buttonGroup.add(rdbtnNewRadioButton_2);
        rdbtnNewRadioButton_2.setBounds(85, 131, 73, 23);
        frame.getContentPane().add(rdbtnNewRadioButton_2);

        JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("D - 432");
        buttonGroup.add(rdbtnNewRadioButton_3);
        rdbtnNewRadioButton_3.setBounds(85, 169, 73, 23);
        frame.getContentPane().add(rdbtnNewRadioButton_3);

        JButton btnNewButton = new JButton("Confirmar");
        btnNewButton.setBounds(210, 148, 89, 23);
        frame.getContentPane().add(btnNewButton);

        table = new JTable();
        table.setEnabled(false);
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {"288", "576", "72"},
                        {"144", "360", "??"},
                        {"504", "648", "216"},
                },
                new String[]{
                        "New column", "New column", "New column"
                }
        ));
        table.setBounds(53, 61, 225, 48);
        frame.getContentPane().add(table);
    }
}