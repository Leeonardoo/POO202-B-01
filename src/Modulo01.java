import callback.ModuleBehaviour;
import data.LogManager;
import enigma.*;

import javax.swing.*;

public class Modulo01 implements ModuloInterface, ModuleBehaviour {

    private BombaInterface bomba;
    private BaseEnigma enigma;
    private LogManager logManager;

    @Override
    public int getQuantasAtivacoes() {
        return logManager.getQuantasAtivacoes();
    }

    @Override
    public int getQuantasExecucoes(byte b) {
        return logManager.getQuantasExecucoesEnigma(b);
    }

    @Override
    public int getQuantasRespostasCorretas(byte b) {
        return logManager.getQuantasRespostasCorretasEnigma(b);
    }

    @Override
    public boolean estaResolvido() {
        return enigma.isResolved();
    }

    @Override
    public void conectarBomba(BombaInterface bombaInterface) {
        this.bomba = bombaInterface;
        this.logManager = new LogManager(bombaInterface.getCaminhoArquivos());
    }

    @Override
    public JPanel getPainelModulo(byte b) {
        setEnigmaById(b);
        return enigma.getUi();
    }

    private void setEnigmaById(byte b) {
        switch (b) {
            case 0:
                this.enigma = new Enigma1Logica(this);
                break;

            case 1:
                this.enigma = new Enigma2Logica(this);
                break;

            case 2:
                this.enigma = new Enigma1LogicaProposicional(this);
                break;

            case 3:
                this.enigma = new Enigma2LogicaProposicional(this);
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
