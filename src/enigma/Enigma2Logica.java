package enigma;

import callback.EnigmaInterface;
import callback.ModuleBehaviour;
import ui.Enigma2LogicaUi;

public class Enigma2Logica extends BaseEnigma implements EnigmaInterface<Integer> {

    public Enigma2Logica(ModuleBehaviour modulo, int enigmaIndex) {
        super(modulo, enigmaIndex);
        Enigma2LogicaUi enigma = new Enigma2LogicaUi(this);
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
