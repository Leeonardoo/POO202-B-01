package enigma;

import callback.ModuleBehaviour;

import javax.swing.*;

public abstract class BaseEnigma {

    private ModuleBehaviour modulo;
    private boolean isResolved = false;
    private JPanel ui;
    private int enigmaIndex;

    public BaseEnigma(ModuleBehaviour modulo, int enigmaIndex) {
        this.setModulo(modulo);
        this.setEnigmaIndex(enigmaIndex);
    }

    public boolean isResolved() {
        return isResolved;
    }

    public void setResolved(boolean resolved) {
        isResolved = resolved;
    }

    public JPanel getUi() {
        return ui;
    }

    public void setUi(JPanel ui) {
        this.ui = ui;
    }

    public int getEnigmaIndex() {
        return enigmaIndex;
    }

    public void setEnigmaIndex(int enigmaIndex) {
        this.enigmaIndex = enigmaIndex;
    }

    private ModuleBehaviour getModulo() {
        return this.modulo;
    }

    private void setModulo(ModuleBehaviour modulo) {
        this.modulo = modulo;
    }

    public void registerError() {
        this.getModulo().getLogManager().addQuantosErrosCometidosEnigma(getEnigmaIndex());
        this.setResolved(false);
        this.getModulo().notifyError();
    }

    public void registerCorrectAnswer() {
        this.getModulo().getLogManager().addQuantasRespostasCorretasEnigma(getEnigmaIndex());
        this.setResolved(true);
        this.getModulo().notifyResolved();
    }
}
