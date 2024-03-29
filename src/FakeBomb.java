import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class FakeBomb implements BombaInterface {

    private final ModuloInterface modulo01;
    private JFrame frame;
    private final byte enigmaIndex;

    /**
     * Create the application.
     */
    public FakeBomb() {
        this.enigmaIndex = (byte) ((byte) new Random().nextInt(((6 - 1) + 1)) + (byte) 1);
        this.modulo01 = new ModuloB01();
        modulo01.conectarBomba(this);
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FakeBomb window = new FakeBomb();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
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
        Path filePath = Paths.get("logs-fake");
        try {
            Files.createDirectories(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Paths.get("logs-fake");
    }

    @Override
    public void informarDesarme(ModuloInterface moduloInterface) {

    }
}
