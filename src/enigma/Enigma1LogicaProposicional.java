package enigma;

import callback.ModuleBehaviour;
import model.Enigma;
import ui.Enigma1ProposicionalUi;

public class Enigma1LogicaProposicional extends BaseEnigma {

    private final Enigma enigma;

    public Enigma1LogicaProposicional(ModuleBehaviour modulo) {
        super(modulo);

        enigma = new Enigma();
        super.setEnigma(enigma);

        Enigma1ProposicionalUi enigmaUi = new Enigma1ProposicionalUi(this, enigma);
        this.setUi(enigmaUi.getJPanel());
    }
}
