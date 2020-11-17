import callback.InternalModuleBehaviour;

import javax.swing.JPanel;

public class Modulo01 implements ModuloInterface, InternalModuleBehaviour {

    private BombaInterface bomba;
    private BaseEnigma enigma;

    public Modulo01(BombaInterface bomba, int enigmaIndex) {
        this.bomba = bomba;
        this.setEnigmaWith(enigmaIndex);
    }

    public Modulo01(int enigmaIndex) {
        this.setEnigmaWith(enigmaIndex);
    }

    public Modulo01() {
    }

    public void initEnigma(int enigmaIndex) {
        this.setEnigmaWith(enigmaIndex);
    }

    @Override
    public int getQuantasAtivacoes() {
        return -1; //TODO
    }

    @Override
    public int getQuantasExecucoes(byte b) {
        return -1; //TODO
    }

    @Override
    public int getQuantasRespostasCorretas(byte b) {
        return -1; //TODO
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

    private void setEnigmaWith(int enigmaIndex) {
        switch (enigmaIndex) {
            case 1:
                this.enigma = new Enigma1Logica(this);
                break;

            case 2:
                this.enigma = new Enigma2Logica(this);
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
}
