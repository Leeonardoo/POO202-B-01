import callback.ModuleBehaviour;
import data.LogManager;
import enigma.BaseEnigma;
import enigma.Enigma1Logica;
import enigma.Enigma1LogicaProposicional;
import enigma.Enigma2Logica;

import javax.swing.*;
import java.nio.file.Path;

public class Modulo01 implements ModuloInterface, ModuleBehaviour {

    private BombaInterface bomba;
    private BaseEnigma enigma;
    private LogManager logManager;
    private int enigmaIndex = 0;

    public Modulo01(BombaInterface bomba, int enigmaIndex) {
        this.setEnigmaIndex(enigmaIndex);
        this.bomba = bomba;
        this.logManager = LogManager.getInstance(bomba.getCaminhoArquivos());
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
        this.logManager.addQuantasExecucoesEnigma((byte) enigmaIndex);

        switch (enigmaIndex) {
            case 0:
                this.enigma = new Enigma1Logica(this, enigmaIndex);
                break;

            case 1:
                this.enigma = new Enigma2Logica(this, enigmaIndex);
                break;

            case 2:
                this.enigma = new Enigma1LogicaProposicional(this, enigmaIndex);
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
    public Path getBasePath() {
        return bomba.getCaminhoArquivos();
    }
}
