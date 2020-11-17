package enigma;

import callback.EnigmaInterface;
import callback.ModuleBehaviour;
import ui.Enigma1ProposicionalUi;

public class Enigma1LogicaProposicional extends BaseEnigma implements EnigmaInterface<Integer> {

    public Enigma1LogicaProposicional(ModuleBehaviour modulo, int enigmaIndex) {
        super(modulo, enigmaIndex);
        Enigma1ProposicionalUi enigma = new Enigma1ProposicionalUi(this);
        this.setUi(enigma.getJFrame());
    }

    //TODO
    @Override
    public boolean onUserConfirm(Integer answer) {
        //Check if(.....)
        super.registerCorrectAnswer();
        super.registerError();

        return true; //Disable input on UI
    }
}
