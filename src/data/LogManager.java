package data;

import java.nio.file.Path;

//TODO
public class LogManager {

    //private final Path currentFilePath;
    //private final Logger logger = Logger.getLogger("Modulo01");

    public LogManager(Path basePath) {
        //Define o formato padrão dos logs
        /*System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");

        // data
        LocalDateTime now = LocalDateTime.now();
        // formatando data
        DateTimeFormatter nameDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss-SSS");

        // setando o nome do arquivo
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
        }*/
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

    public void addQuantasAtivacoes() {

    }

    public void addQuantasExecucoesEnigma(byte enigma) {

    }

    public void addQuantasRespostasCorretasEnigma(byte enigma) {

    }

    public void addQuantosErrosCometidosEnigma(byte enigma) {

    }
}