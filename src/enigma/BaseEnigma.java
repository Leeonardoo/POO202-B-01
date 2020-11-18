package enigma;

import callback.EnigmaInterface;
import callback.ModuleBehaviour;
import model.Enigma;

import javax.swing.*;

public abstract class BaseEnigma implements EnigmaInterface {

    private ModuleBehaviour modulo;
    private boolean isResolved = false;
    private JPanel ui;
    private Enigma enigma;

    public BaseEnigma(ModuleBehaviour modulo) {
        this.setModulo(modulo);
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

    private ModuleBehaviour getModulo() {
        return this.modulo;
    }

    private void setModulo(ModuleBehaviour modulo) {
        this.modulo = modulo;
    }

    public void registerError() {
        getModulo().getLogManager().addQuantosErrosCometidosEnigma(getEnigma().getId());
        setResolved(false);
        getModulo().notifyError();
    }

    public void registerCorrectAnswer() {
        getModulo().getLogManager().addQuantasRespostasCorretasEnigma(getEnigma().getId());
        setResolved(true);
        getModulo().notifyResolved();
    }

    @Override
    public Enigma getEnigma() {
        return enigma;
    }

    public void setEnigma(Enigma enigma) {
        this.enigma = enigma;
        modulo.getLogManager().addQuantasExecucoesEnigma((byte) enigma.getId());
    }

    @Override
    public boolean onUserConfirm(int answer) {
        //Check if(.....)
        registerCorrectAnswer();
        registerError();

        return true; //Disable input on UI
    }
}
