package enigma;

import callback.ModuleBehaviour;
import model.Enigma;
import ui.Enigma1LogicaUi;

public class Enigma1Logica extends BaseEnigma {

    private final Enigma enigma;

    public Enigma1Logica(ModuleBehaviour modulo) {
        super(modulo);

        enigma = new Enigma();
        super.setEnigma(enigma);
        Enigma1LogicaUi enigmaUi = new Enigma1LogicaUi(this, enigma);

        this.setUi(enigmaUi.getJPanel());
    }
}
