package enigma;

import callback.ModuleBehaviour;
import model.Enigma;
import ui.Enigma2LogicaUi;

public class Enigma2Logica extends BaseEnigma {

    public Enigma2Logica(ModuleBehaviour modulo) {
        super(modulo);
        super.setEnigma(new Enigma());

        Enigma2LogicaUi enigmaUi = new Enigma2LogicaUi(this);
        this.setUi(enigmaUi.getJPanel());
    }
}