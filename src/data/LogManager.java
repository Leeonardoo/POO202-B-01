package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import model.StatsEntry;

//TODO
public class LogManager {

	
	public LogManager(Path path){
	
	
	}
	
	public static void gravarArquivoBinario(StatsEntry entry, String nomeArq) {
		File arq =  new File(nomeArq);
		try {
			arq.delete();
			arq.createNewFile();
			
			ObjectOutputStream objOutPut = new ObjectOutputStream(new FileOutputStream(arq));
			objOutPut.writeObject(entry);
			objOutPut.flush();
			objOutPut.close();
			
		} catch (Exception e) {
			System.out.printf("Erro: %s", e.getMessage());
		}
	}
	
	public static ArrayList<Object> lerArquivoBinario(String nomeArq){
		ArrayList<Object> lista = new ArrayList();
		try {
			File arq = new File(nomeArq);
			if(arq.exists()) {
				ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
				lista = (ArrayList<Object>)objInput.readObject();
				objInput.close();
			}
		} catch (Exception e) {
			System.out.printf("Erro: %s", e.getMessage());
		}
		return lista;
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