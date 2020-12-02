package data;

import model.ModuleStats;
import model.StatsEntry;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class LogManager {

    private final Path localFilePath;
    private final Path localModuleFilePath;

    public LogManager(Path path) {
        localFilePath = Paths.get(path.toString(), "ModuloB01", "data.dat");
        localModuleFilePath = Paths.get(path.toString(), "ModuloB01", "module_data.dat");

        try {
            Path dirPath = Paths.get(path.toUri().resolve("ModuloB01"));

            //Caso o diretório do módulo ainda não existir, é criado antes
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }

            //Se o [...pathBomba...]/ModuloB01/data.dat não existir é criado um arquivo vazio antes
            if (!Files.exists(localFilePath)) {
                Files.createFile(localFilePath);
            }

            //Se o [...pathBomba...]/ModuloB01/module_data.dat não existir é criado um arquivo vazio antes
            if (!Files.exists(localModuleFilePath)) {
                Files.createFile(localModuleFilePath);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao criar os arquivos do módulo!");
        }
    }

    public int getQuantasAtivacoes() {
        ModuleStats currentStats = readModuleStats();
        if (currentStats == null) {
            return 0;
        } else {
            return currentStats.getTotalActivations();
        }
    }

    public int getQuantasExecucoesEnigma(byte enigma) {
        StatsEntry entry = readStats().get(enigma);
        if (entry == null) {
            return 0;
        } else {
            return entry.getTotalExecutions();
        }
    }

    public int getQuantasRespostasCorretasEnigma(byte enigma) {
        StatsEntry entry = readStats().get(enigma);
        if (entry == null) {
            return 0;
        } else {
            return entry.getTotalRightAnswers();
        }
    }

    public int getQuantosErrosCometidosEnigma(byte enigma) {
        StatsEntry entry = readStats().get(enigma);
        if (entry == null) {
            return 0;
        } else {
            return entry.getTotalWrongAnswers();
        }
    }

    public void addQuantasAtivacoes() {
        ModuleStats currentStats = readModuleStats();
        if (currentStats == null) {
            currentStats = new ModuleStats();
            currentStats.setTotalActivations(1);
        } else {
            currentStats.setTotalActivations(currentStats.getTotalActivations() + 1);
        }

        writeModuleStats(currentStats);
    }

    public void addQuantasExecucoesEnigma(byte enigma) {
        StatsEntry entry = readStats().get(enigma);
        if (entry == null) {
            entry = new StatsEntry(enigma, 1, 0, 0);
        } else {
            entry.setTotalExecutions(entry.getTotalExecutions() + 1);
        }

        writeStats(entry);
    }

    public void addQuantasRespostasCorretasEnigma(byte enigma) {
        StatsEntry entry = readStats().get(enigma);
        if (entry == null) {
            entry = new StatsEntry(enigma, 1, 1, 0);
        } else {
            entry.setTotalRightAnswers(entry.getTotalRightAnswers() + 1);
        }

        writeStats(entry);
    }

    public void addQuantosErrosCometidosEnigma(byte enigma) {
        StatsEntry entry = readStats().get(enigma);
        if (entry == null) {
            entry = new StatsEntry(enigma, 1, 0, 1);
        } else {
            entry.setTotalWrongAnswers(entry.getTotalWrongAnswers() + 1);
        }

        writeStats(entry);
        ;
    }

    private void writeStats(StatsEntry entry) {
        try {
            //Ler arquivo antigo antes, para fazer append
            Map<Byte, StatsEntry> statsMap = readStats();

            //Caso nenhum erro aconteceu ao tentar ler o arquivo
            if (statsMap != null) {
                statsMap.put(entry.getEnigmaId(), entry);
            } else {
                statsMap = new HashMap<>();
            }

            ObjectOutputStream newOos = new ObjectOutputStream(new FileOutputStream(localFilePath.toFile()));
            newOos.writeObject(statsMap);

            //Garantindo que os novos dados estão salvos
            newOos.flush();
            newOos.close();

            System.out.printf(
                    "[Modulo01/LogManager@writeStats] O novo objeto de estatísticas do enigma escrito tem os dados:\n" +
                            "enigmaId: %s\n" +
                            "totalExecutions: %s\n" +
                            "totalRightAnswers: %s\n" +
                            "totalWrongAnswers: %s\n",
                    entry.getEnigmaId(),
                    entry.getTotalExecutions(),
                    entry.getTotalRightAnswers(),
                    entry.getTotalWrongAnswers()
            );

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Ocorreu um erro ao escrever o arquivo de dados dos enigmas!");
        }
    }

    @SuppressWarnings("unchecked")
    private Map<Byte, StatsEntry> readStats() {
        Map<Byte, StatsEntry> newMap;

        try {
            ObjectInputStream oldOis = new ObjectInputStream(new FileInputStream(localFilePath.toFile()));
            Object oldFile = oldOis.readObject();

            if (oldFile instanceof Map) {
                //Assumindo que o Map dentro do arquivo é um Map<Byte, StatsEntry>
                //Agora livre pra colocar a nova entidade no map
                newMap = (Map<Byte, StatsEntry>) oldFile;
            } else {
                //Se ainda não é um map (primeira execução), um novo é criado
                newMap = new HashMap<>();
            }

            //Fechando antes de abrir uma nova OutputStream no futuro
            oldOis.close();

        } catch (EOFException e) {
            //Exception esperada na primeira tentativa (arquivo vazio)
            newMap = new HashMap<>();
        } catch (Exception e) {
            newMap = new HashMap<>();
            e.printStackTrace();
            System.err.println("Ocorreu um erro ao ler o arquivo de dados dos enigmas!");
        }
        return newMap;
    }

    public void writeModuleStats(ModuleStats stats) {
        try {
            ModuleStats oldStats;

            //Caso nenhum erro aconteceu ao tentar ler o arquivo
            if (stats != null) {
                oldStats = stats;
            } else {
                oldStats = new ModuleStats();
            }

            ObjectOutputStream newOos = new ObjectOutputStream(new FileOutputStream(localModuleFilePath.toFile()));
            newOos.writeObject(oldStats);

            //Garantindo que os novos dados estão salvos
            newOos.flush();
            newOos.close();

            int activations;
            if (stats != null) {
                activations = stats.getTotalActivations();
            } else {
                activations = 0;
            }

            System.out.printf(
                    "[Modulo01/LogManager@writeModuleStats] O novo objeto de estatísticas do módulo escrito tem os dados:\n" +
                            "totalActivations: %s\n", activations
            );

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Ocorreu um erro ao escrever o arquivo de dados do módulo!");
        }
    }

    public ModuleStats readModuleStats() {
        ModuleStats newStats;

        try {
            ObjectInputStream oldOis = new ObjectInputStream(new FileInputStream(localModuleFilePath.toFile()));
            Object oldFile = oldOis.readObject();

            if (oldFile instanceof ModuleStats) {
                //Agora livre pra escrever a nova entidade
                newStats = (ModuleStats) oldFile;
            } else {
                //Se ainda não é um ModuleStats, um novo é criado
                newStats = new ModuleStats();
            }

            //Fechando antes de abrir uma nova OutputStream no futuro
            oldOis.close();

        } catch (EOFException e) {
            //Exception esperada na primeira tentativa (arquivo vazio)
            newStats = new ModuleStats();
        } catch (Exception e) {
            newStats = new ModuleStats();
            e.printStackTrace();
            System.err.println("Ocorreu um erro ao ler o arquivo de dados do módulo!");
        }
        return newStats;
    }
}