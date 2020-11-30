package data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.StatsEntry;

public class Main {

	public static void main(String[] args) throws IOException  {
		
		int enigmaId, totalActivations, totalExecutions, totalRightAnswers, totalWrongAnswers;
		StatsEntry st = new StatsEntry();
		ArrayList<Object> entry = LogManager.lerArquivoBinario("dados.dat");
		
		
		enigmaId = st.getEnigmaId();
		totalActivations = st.getTotalActivations();
		totalExecutions = st.getTotalExecutions();
		totalRightAnswers = st.getTotalRightAnswers();
		totalWrongAnswers= st.getTotalWrongAnswers();
		
		System.out.printf("Enigma Id: ", enigmaId);
		System.out.printf("Total de Ativações: ", totalActivations);
		System.out.printf("Total de Execuções: ", totalExecutions);
		System.out.printf("Total de Respostas Corretas: ", totalRightAnswers);
		System.out.printf("Total de Respostas Erradas: ", totalWrongAnswers);
		
		entry.add(new StatsEntry()); 
		
		LogManager.gravarArquivoBinario(entry, "dados.dat");
	}

}
