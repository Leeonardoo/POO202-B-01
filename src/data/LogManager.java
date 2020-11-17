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

    private static volatile LogManager INSTANCE;
    private final Path basePath;
    private final Path currentFilePath;
    private final Logger logger = Logger.getLogger("Modulo01");

    private LogManager(Path basePath) {
        //Define o formato padrão dos logs
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");

        this.basePath = basePath;

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

    /**
     * Gets a single instance, double-checking in case getInstance
     * is called from multiple threads, so it can be safe to assume
     * only one instance will ever be created and no race conditions
     * will ever occur between the multiple threads.
     *
     * @return the actual instance
     */
    public static LogManager getInstance(Path basePath) {
        LogManager result = INSTANCE;
        if (result != null) {
            return result;
        }
        synchronized (LogManager.class) {
            if (INSTANCE == null) {
                INSTANCE = new LogManager(basePath);
            }
            return INSTANCE;
        }
    }

    public int getQuantasAtivacoes() {
        return 1;
    }

    public int getQuantasExecucoesEnigma(byte enigma) {
        return 1;
    }

    public int getQuantasRespostasCorretasEnigma(byte enigma) {
        return 1;
    }

    public int getQuantosErrosCometidosEnigma(byte enigma) {
        return 1;
    }

    private void setQuantasAtivacoes(int valor) {

    }

    private void setQuantasExecucoesEnigma(byte enigma, int valor) {

    }

    private void setQuantasRespostasCorretasEnigma(byte enigma, int valor) {

    }

    private void setQuantosErrosCometidosEnigma(byte enigma, int valor) {

    }
}