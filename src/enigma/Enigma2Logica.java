package enigma;

import callback.ModuleBehaviour;
import model.Enigma;
import ui.Enigma2LogicaUi;

public class Enigma2Logica extends BaseEnigma {

    private final Enigma enigma;

    public Enigma2Logica(ModuleBehaviour modulo) {
        super(modulo);

        enigma = new Enigma();
        super.setEnigma(enigma);

        Enigma2LogicaUi enigmaUi = new Enigma2LogicaUi(this, enigma);
        this.setUi(enigmaUi.getJPanel());
    }
}
