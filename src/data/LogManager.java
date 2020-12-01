package data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import model.StatsEntry;

public class LogManager {

    private final Path localFilePath;
    private final Path localModuleFilePath;

    public LogManager(Path path) {
        localFilePath = Paths.get(path.toString(), "ModuloB01", "data.dat");
        localModuleFilePath = Paths.get(path.toString(), "ModuloB01", "data_module.dat");

        try {
            Path dirPath = Paths.get(path.toUri().resolve("ModuloB01"));

            //Se o [...pathBomba...]/ModuloB01 não existir
            if (!Files.exists(localFilePath)) {
                //Se o [...pathBomba...]/ModuloB01/data.dat não existir
                if (!Files.exists(dirPath)) {
                    //Criando diretório do módulo
                    Files.createDirectories(dirPath);
                }

                //Criando arquivo onde os dados vão ficar
                Files.createFile(localFilePath);
            }

            if (!Files.exists(localModuleFilePath)) {
                Files.createFile(localModuleFilePath);
            }

        } catch (IOException e) {
            System.err.printf("Erro ao criar os arquivos do módulo!: %s", e.getMessage());
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

    public void addQuantasAtivacoes() {
    }

    public void addQuantasExecucoesEnigma(byte enigma) {

    }

    public void addQuantasRespostasCorretasEnigma(byte enigma) {

    }

    public void addQuantosErrosCometidosEnigma(byte enigma) {

    }

    public void writeObject(StatsEntry entry) {
        try {
            //Ler arquivo antigo antes, para fazer append
            Map<Integer, StatsEntry> statsMap = readObject();

            //Caso nenhum erro aconteceu ao tentar ler o arquivo
            if (statsMap != null) {
                statsMap.put(entry.getEnigmaId(), entry);

                ObjectOutputStream newOos = new ObjectOutputStream(new FileOutputStream(localFilePath.toFile()));
                newOos.writeObject(statsMap);

                //Garantindo que os novos dados estão salvos
                newOos.flush();
                newOos.close();
            } else {
                //Caso ocorreu, não temos um Map e é impossível continuar
                throw new FileNotFoundException("Ocorreu um erro ao ler o arquivo de dados do módulo!");
            }

        } catch (Exception e) {
            System.err.printf("Erro: %s", e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public Map<Integer, StatsEntry> readObject() {
        try {
            ObjectInputStream oldOis = new ObjectInputStream(new FileInputStream(localFilePath.toFile()));
            Object oldFile = oldOis.readObject();

            Map<Integer, StatsEntry> newMap;

            if (oldFile instanceof Map) {
                //Assumindo que o Map dentro do arquivo é um Map<Integer, StatsEntry>
                //Agora livre pra colocar a nova entidade no map
                newMap = (Map<Integer, StatsEntry>) oldFile;
            } else {
                //Se ainda não é um map (primeira execução), um novo é criado
                newMap = new HashMap<>();
            }

            //Fechando antes de abrir uma nova OutputStream no futuro
            oldOis.close();
            return newMap;

        } catch (Exception e) {
            System.err.printf("Erro: %s", e.getMessage());
            return null;
        }
    }
}