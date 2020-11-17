package data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//TODO
public class LogManager {

    private final Path currentFilePath;
    private final Logger logger = Logger.getLogger("Modulo01");

    public LogManager(Path basePath) {
        //Define o formato padrão dos logs
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter nameDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss-SSS");

        String logFileName = "Modulo01_log_" + nameDtf.format(now) + ".log";
        currentFilePath = Paths.get(basePath.toString(), logFileName);

        try {
            Path dirPath = Paths.get(basePath.toUri());

            if (!Files.exists(currentFilePath)) {
                if (!Files.exists(dirPath)) {
                    Files.createDirectory(dirPath);
                }

                Files.createFile(currentFilePath);
                FileHandler fileHandler = new FileHandler(currentFilePath.toString());
                fileHandler.setFormatter(new SimpleFormatter());
                logger.addHandler(fileHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getQuantasAtivacoes() {
        return 1;
    }

    public int getQuantasExecucoesEnigma(int enigma) {
        return 1;
    }

    public int getQuantasRespostasCorretasEnigma(int enigma) {
        return 1;
    }

    public int getQuantosErrosCometidosEnigma(int enigma) {
        return 1;
    }

    public void addQuantasAtivacoes() {

    }

    public void addQuantasExecucoesEnigma(int enigma) {

    }

    public void addQuantasRespostasCorretasEnigma(int enigma) {

    }

    public void addQuantosErrosCometidosEnigma(int enigma) {

    }
}