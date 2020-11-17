package enigma;

import javax.swing.*;

public class BaseEnigma {

    private boolean isResolved = false;
    private JPanel ui;

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
}
