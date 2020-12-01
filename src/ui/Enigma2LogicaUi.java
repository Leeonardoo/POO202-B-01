package ui;

import callback.EnigmaInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Enigma2LogicaUi extends BaseEnigmaUi {

    private final EnigmaInterface enigmaCallback;
    private JButton confirmButton;
    private JPanel indicator;
    private JComboBox<String> comboBox_1;

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

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 314, 72);
        frame.getContentPane().add(scrollPane);

        JLabel lblNewLabel_1 = new JLabel(enigmaCallback.getEnigma().getText());
        scrollPane.setViewportView(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));

        //Definindo a combobox para a célula da resposta
        comboBox_1 = new JComboBox<>();
        ArrayList<String> newItems = new ArrayList<>();
        newItems.add("??");
        newItems.addAll(Arrays.asList(Arrays.copyOfRange(enigmaCallback.getEnigma().getOptions(), 9, 13)));

        comboBox_1.setModel(new DefaultComboBoxModel(newItems.toArray()));
        comboBox_1.setSelectedIndex(-1);

        DefaultCellEditor dce = new DefaultCellEditor(comboBox_1);

        //Os números ficam nos indexes de 0-8 (9)
        String[] numbers = Arrays.copyOfRange(enigmaCallback.getEnigma().getOptions(), 0, 9);
        //Definindo o modelo ta tabela em 3 linhas com 3 colunas cada
        Object[][] itemsArray = new Object[][]{
                Arrays.copyOfRange(numbers, 0, 3),
                Arrays.copyOfRange(numbers, 3, 6),
                Arrays.copyOfRange(numbers, 6, 9),
        };
        DefaultTableModel dtm = new DefaultTableModel(itemsArray, new String[]{"", "", ""});

        JTable table = new JTable(dtm) {
            @Override
            public TableCellEditor getCellEditor(int row, int column) {
                int modelColumn = convertColumnIndexToModel(column);
                int modelRow = convertRowIndexToModel(row);

                return itemsArray[modelRow][modelColumn].equals("??") ? dce : null;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                int modelColumn = convertColumnIndexToModel(column);
                int modelRow = convertRowIndexToModel(row);

                return itemsArray[modelRow][modelColumn].equals("??");
            }
        };

        table.setBounds(55, 106, 225, 48);
        frame.getContentPane().add(table);

        confirmButton = new JButton("Confirmar");
        confirmButton.addActionListener(arg0 -> {
            /*
             * O valor do index selecionado, como é um novo array
             * precisa de um offset de +9 sobre o resultado para
             * chegar ao valor do array inicial.
             * Como há o "??" adicional, é necessário -1 o resultado
             * com esse novo offset
             */

            onConfirm(enigmaCallback.onUserConfirm((comboBox_1.getSelectedIndex() + 9) -1 ));
        });
        confirmButton.setBounds(113, 177, 112, 23);
        frame.getContentPane().add(confirmButton);

        indicator = new JPanel();
        indicator.setBounds(324, 0, 10, 10);
        indicator.setBackground(Color.RED);
        frame.getContentPane().add(indicator);

        super.setJFrame(frame);
    }

    @Override
    protected void onConfirm(boolean isCorrect) {
        if (isCorrect) {
            indicator.setBackground(Color.GREEN);
            confirmButton.setEnabled(false);
            comboBox_1.setEnabled(false);
        } else {
            indicator.setBackground(Color.RED);
        }
    }
}