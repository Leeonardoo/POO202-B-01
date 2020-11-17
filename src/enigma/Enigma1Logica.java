package enigma;

import callback.EnigmaInterface;
import callback.ModuleBehaviour;
import ui.Enigma1LogicaUi;

public class Enigma1Logica extends BaseEnigma implements EnigmaInterface<Integer> {

    public Enigma1Logica(ModuleBehaviour modulo, int enigmaIndex) {
        super(modulo, enigmaIndex);
        Enigma1LogicaUi enigma = new Enigma1LogicaUi(this);
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
