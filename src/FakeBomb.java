import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class FakeBomb implements BombaInterface {

    private final ModuloInterface modulo01;
    private JFrame frame;
    private byte enigmaIndex;

    /**
     * Create the application.
     */
    public FakeBomb() {
        this.enigmaIndex = (byte) new Random().nextInt((4));
        this.modulo01 = new Modulo01();
        modulo01.conectarBomba(this);
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
        frame.setBounds(100, 100, 350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(modulo01.getPainelModulo(enigmaIndex));
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
