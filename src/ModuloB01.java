import callback.ModuleBehaviour;
import data.LogManager;
import enigma.*;

import javax.swing.*;

public class ModuloB01 implements ModuloInterface, ModuleBehaviour {

    private BombaInterface bomba;
    private BaseEnigma enigma;
    private LogManager logManager;

    @Override
    public int getQuantasAtivacoes() {
        return logManager.getQuantasAtivacoes();
    }

    @Override
    public int getQuantasExecucoes(byte enigmaIndex) {
        return logManager.getQuantasExecucoesEnigma(enigmaIndex);
    }

    @Override
    public int getQuantasRespostasCorretas(byte enigmaIndex) {
        return logManager.getQuantasRespostasCorretasEnigma(enigmaIndex);
    }

    @Override
    public int getQuantosErrosCometidos(byte enigmaIndex) {
        return logManager.getQuantosErrosCometidosEnigma(enigmaIndex);
    }

    @Override
    public boolean estaResolvido() {
        return enigma.isResolved();
    }

    @Override
    public void conectarBomba(BombaInterface bombaInterface) {
        this.bomba = bombaInterface;
        this.logManager = new LogManager(bombaInterface.getCaminhoArquivos());
        this.logManager.addQuantasAtivacoes();
    }

    @Override
    public JPanel getPainelModulo(byte enigmaIndex) {
        setEnigmaById(enigmaIndex);
        System.out.println(logManager.getQuantasExecucoesEnigma(enigmaIndex));
        return enigma.getUi();
    }

    private void setEnigmaById(byte enigmaIndex) {
        switch (enigmaIndex) {
            case 1:
                this.enigma = new Enigma1Logica(this);
                break;

            case 2:
                this.enigma = new Enigma2Logica(this);
                break;

            case 3:
                this.enigma = new Enigma1LogicaProposicional(this);
                break;

            case 4:
                this.enigma = new Enigma2LogicaProposicional(this);
                break;

            case 5:
                this.enigma = new Enigma1Predicado(this);
                break;

            case 6:
                this.enigma = new Enigma2Predicado(this);
                break;
        }
    }

    @Override
    public void notifyError() {
        bomba.addErro();
    }

    @Override
    public void notifyResolved() {
        bomba.informarDesarme(this);
    }

    @Override
    public LogManager getLogManager() {
        return logManager;
    }
}
