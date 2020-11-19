package ui;

import callback.EnigmaInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Arrays;

public class Enigma2LogicaUi extends BaseEnigmaUi {

    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final EnigmaInterface enigmaCallback;
    private JTable table;
    private JButton confirmButton;
    JPanel indicator;

    /**
     * Create the application.
     */
    public Enigma2LogicaUi(EnigmaInterface enigmaCallback) {
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

        JLabel lblNewLabel_1 = new JLabel(enigmaCallback.getEnigma().getText());
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(10, 11, 314, 29);
        frame.getContentPane().add(lblNewLabel_1);

        String[] numbers = Arrays.copyOfRange(enigmaCallback.getEnigma().getOptions(), 0, 9);
        table = new JTable();
        table.setEnabled(false);
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        Arrays.copyOfRange(numbers, 0,3),
                        Arrays.copyOfRange(numbers, 3,6),
                        Arrays.copyOfRange(numbers, 6,9),
                },
                new String[]{
                        "", "", ""
                }
        ));

        table.setBounds(53, 61, 225, 48);
        frame.getContentPane().add(table);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(131, 140, 67, 20);
        comboBox_1.setModel(new DefaultComboBoxModel(Arrays.copyOfRange(enigmaCallback.getEnigma().getOptions(), 9, 13)));
        comboBox_1.setSelectedIndex(-1);
        frame.getContentPane().add(comboBox_1);

        confirmButton = new JButton("Confirmar");
        confirmButton.addActionListener(arg0 -> {
            onConfirm(enigmaCallback.onUserConfirm(comboBox_1.getSelectedIndex() + 9));
        });
        confirmButton.setBounds(113, 177, 112, 23);
        frame.getContentPane().add(confirmButton);
        
        indicator = new JPanel();
        indicator.setBounds(324, 0, 10, 10);
        indicator.setBackground(Color.RED);
        frame.getContentPane().add(indicator);

        super.setJFrame(frame);
    }

    private void onConfirm(boolean isCorrect) {
        if (isCorrect) {
            indicator.setBackground(Color.GREEN);
            confirmButton.setEnabled(false);
        } else {
            indicator.setBackground(Color.RED);
        }
    }
}