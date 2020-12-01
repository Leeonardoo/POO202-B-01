package data;

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
        localModuleFilePath = Paths.get(path.toString(), "ModuloB01", "data_module.dat");

        try {
            Path dirPath = Paths.get(path.toUri().resolve("ModuloB01"));

            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }

            //Se o [...pathBomba...]/ModuloB01/data.dat não existir
            if (!Files.exists(localFilePath)) {
                //Criando arquivo onde os dados vão ficar
                Files.createFile(localFilePath);
            }

            if (!Files.exists(localModuleFilePath)) {
                Files.createFile(localModuleFilePath);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao criar os arquivos do módulo!");
        }
    }

    //TODO
    public int getQuantasAtivacoes() {
        return 0;
    }

    public int getQuantasExecucoesEnigma(byte enigma) {
        StatsEntry entry = readObject().get(enigma);

        if (entry == null) {
            return 0;
        } else {
            return entry.getTotalExecutions();
        }
    }

    public int getQuantasRespostasCorretasEnigma(byte enigma) {
    	   StatsEntry entry = readObject().get(enigma);

           if (entry == null) {
               return 0;
           } else {
               return entry.getTotalRightAnswers();
           }
    }

    public int getQuantosErrosCometidosEnigma(byte enigma) {
    	   StatsEntry entry = readObject().get(enigma);

           if (entry == null) {
               return 0;
           } else {
               return entry.getTotalWrongAnswers();
           }
    }

    //TODO
    public void addQuantasAtivacoes() {
    }

    public void addQuantasExecucoesEnigma(byte enigma) {
        StatsEntry entry = readObject().get(enigma);

        if (entry == null) {
            entry = new StatsEntry(enigma, 1, 0, 0);
        } else {
            entry.setTotalExecutions(entry.getTotalExecutions() + 1);
        }

        writeObject(entry);
    }

    public void addQuantasRespostasCorretasEnigma(byte enigma) {
    	 StatsEntry entry = readObject().get(enigma);

         if (entry == null) {
             entry = new StatsEntry(enigma, 1, 1, 0);
         } else {
             entry.setTotalRightAnswers(entry.getTotalRightAnswers() + 1);
         }

         writeObject(entry);
    }

    public void addQuantosErrosCometidosEnigma(byte enigma) {
    	StatsEntry entry = readObject().get(enigma);

        if (entry == null) {
            entry = new StatsEntry(enigma, 1, 0, 1);
        } else {
            entry.setTotalWrongAnswers(entry.getTotalWrongAnswers() + 1);
        }

        writeObject(entry);;
    }

    public void writeObject(StatsEntry entry) {
        try {
            //Ler arquivo antigo antes, para fazer append
            Map<Byte, StatsEntry> statsMap = readObject();

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

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Ocorreu um erro ao escrever o arquivo de dados dos enigmas!");
        }
    }

    @SuppressWarnings("unchecked")
    public Map<Byte, StatsEntry> readObject() {
        Map<Byte, StatsEntry> newMap;

        try {
            ObjectInputStream oldOis = new ObjectInputStream(new FileInputStream(localFilePath.toFile()));
            Object oldFile = oldOis.readObject();

            if (oldFile instanceof Map) {
                //Assumindo que o Map dentro do arquivo é um Map<Integer, StatsEntry>
                //Agora livre pra colocar a nova entidade no map
                newMap = (Map<Byte, StatsEntry>) oldFile;
            } else {
                //Se ainda não é um map (primeira execução), um novo é criado
                newMap = new HashMap<>();
            }

            //Fechando antes de abrir uma nova OutputStream no futuro
            oldOis.close();

        } catch (EOFException e) {
            newMap = new HashMap<>();
        } catch (Exception e) {
            newMap = new HashMap<>();
            e.printStackTrace();
            System.err.println("Ocorreu um erro ao ler o arquivo de dados dos enigmas!");
        }

        return newMap;
    }
}