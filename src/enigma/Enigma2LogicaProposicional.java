package enigma;

import callback.ModuleBehaviour;
import model.Enigma;
import ui.Enigma1ProposicionalUi;
import ui.Enigma2ProposicionalUi;

public class Enigma2LogicaProposicional extends BaseEnigma {

    public Enigma2LogicaProposicional(ModuleBehaviour modulo) {
        super(modulo);
        super.setEnigma(new Enigma());

        Enigma2ProposicionalUi enigmaUi = new Enigma2ProposicionalUi(this);
        this.setUi(enigmaUi.getJPanel());
    }
}