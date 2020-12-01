package data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.StatsEntry;

public class LogManager {

    private final Path localFilePath;

    public LogManager(Path path) {
        localFilePath = Paths.get(path.toString(), "ModuloB01", "data.dat");

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

    @SuppressWarnings("unchecked")
    public void gravarArquivoBinario(StatsEntry entry) {
        try {
            //Ler arquivo antigo para fazer append
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

            newMap.put(entry.getEnigmaId(), entry);
            //Fechando antes de abrir uma nova OutputStream
            oldOis.close();

            ObjectOutputStream newOos = new ObjectOutputStream(new FileOutputStream(localFilePath.toFile()));
            newOos.writeObject(newMap);

            //Garantindo que os novos dados estão salvos
            newOos.flush();
            newOos.close();

        } catch (Exception e) {
            System.err.printf("Erro: %s", e.getMessage());
        }
    }

    public Map<Integer, StatsEntry> lerArquivoBinario() {

        try {
            File arq = new File(nomeArq);
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                lista = (ArrayList<Object>) objInput.readObject();
                objInput.close();
            }
        } catch (Exception e) {
            System.out.printf("Erro: %s", e.getMessage());
        }
        return lista;
    }
}