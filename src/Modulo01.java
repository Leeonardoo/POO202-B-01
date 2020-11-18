import callback.ModuleBehaviour;
import data.LogManager;
import enigma.*;

import javax.swing.*;

public class Modulo01 implements ModuloInterface, ModuleBehaviour {

    private BombaInterface bomba;
    private BaseEnigma enigma;
    private LogManager logManager;
    private int enigmaIndex = 0;

    public Modulo01(BombaInterface bomba, int enigmaIndex) {
        this.setEnigmaIndex(enigmaIndex);
        this.bomba = bomba;
        this.logManager = new LogManager(bomba.getCaminhoArquivos());
        this.setEnigma();
    }

    public Modulo01(byte enigmaIndex) {
        this.setEnigmaIndex(enigmaIndex);
        this.setEnigma();
        this.logManager.addQuantasAtivacoes();
    }

    public Modulo01() {
    }

    public void initEnigma(byte enigmaIndex) {
        this.setEnigmaIndex(enigmaIndex);
        this.setEnigma();
    }

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
    }

    @Override
    public JPanel getPainelModulo() {
        return enigma.getUi();
    }

    private void setEnigma() {
        switch (enigmaIndex) {
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
        this.logManager.addQuantosErrosCometidosEnigma((byte) enigmaIndex);
        bomba.addErro();
    }

    @Override
    public void notifyResolved() {
        this.logManager.addQuantasRespostasCorretasEnigma((byte) enigmaIndex);
        bomba.informarDesarme(this);
    }

    private void setEnigmaIndex(int enigmaIndex) {
        this.enigmaIndex = enigmaIndex;
    }

    @Override
    public LogManager getLogManager() {
        return logManager;
    }
}
