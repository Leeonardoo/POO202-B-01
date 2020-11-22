package ui;

import javax.swing.*;

abstract class BaseEnigmaUi {

    private JFrame jFrame;

    public JPanel getJPanel() {
        return (JPanel) jFrame.getContentPane();
    }

    protected void setJFrame(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    protected JFrame getjFrame() {
        return this.jFrame;
    }

    abstract protected void onConfirm(boolean isCorrect);
}