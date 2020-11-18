package enigma;

import callback.ModuleBehaviour;
import model.Enigma;
import ui.Enigma1ProposicionalUi;

public class Enigma1LogicaProposicional extends BaseEnigma {

    public Enigma1LogicaProposicional(ModuleBehaviour modulo) {
        super(modulo);
        super.setEnigma(new Enigma());

        Enigma1ProposicionalUi enigmaUi = new Enigma1ProposicionalUi(this);
        this.setUi(enigmaUi.getJPanel());
    }
}
