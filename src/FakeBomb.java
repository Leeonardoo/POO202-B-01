import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FakeBomb implements BombaInterface {

    private JFrame frame;
    private final ModuloInterface modulo01;

    /**
     * Create the application.
     */
    public FakeBomb() {
        this.modulo01 = new Modulo01(this, 0);
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FakeBomb window = new FakeBomb();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(modulo01.getPainelModulo());
    }

    @Override
    public void addErro() {

    }

    @Override
    public Path getCaminhoArquivos() {
        return Paths.get("logs-fake");
    }

    @Override
    public void informarDesarme(ModuloInterface moduloInterface) {

    }

}
