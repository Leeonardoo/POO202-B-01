package enigma;

import callback.ModuleBehaviour;
import data.LogManager;

import javax.swing.*;
import java.nio.file.Path;

public abstract class BaseEnigma {

    private ModuleBehaviour modulo;
    private boolean isResolved = false;
    private JPanel ui;
    private int enigmaIndex;
    private LogManager logManager;

    public BaseEnigma(ModuleBehaviour modulo, int enigmaIndex) {
        this.setModulo(modulo);
        this.setEnigmaIndex(enigmaIndex);
        this.setLogManager(modulo.getBasePath());
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

    private void setLogManager(Path basePath) {
        this.logManager = LogManager.getInstance(basePath);
    }

    public void registerError() {
        this.logManager.addQuantosErrosCometidosEnigma(getEnigmaIndex());
        this.setResolved(false);
        this.getModulo().notifyError();
    }

    public void registerCorrectAnswer() {
        this.logManager.addQuantasRespostasCorretasEnigma(getEnigmaIndex());
        this.setResolved(true);
        this.getModulo().notifyResolved();
    }
}
