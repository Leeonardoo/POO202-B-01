package enigma;

import callback.ModuleBehaviour;
import model.Enigma;
import ui.Enigma1LogicaUi;

public class Enigma1Logica extends BaseEnigma {

    public Enigma1Logica(ModuleBehaviour modulo) {
        super(modulo);
        super.setEnigma(new Enigma());

        Enigma1LogicaUi enigmaUi = new Enigma1LogicaUi(this);
        this.setUi(enigmaUi.getJPanel());
    }
}
