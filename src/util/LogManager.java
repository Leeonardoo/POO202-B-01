package util;

import java.nio.file.Path;

//TODO
public class LogManager {

    private static volatile LogManager INSTANCE;
    private final Path basePath;
    private final StatsRepository statsRepository;

    private LogManager(Path basePath) {
        this.basePath = basePath;
        //TODO
        this.statsRepository = new StatsRepository();
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
}