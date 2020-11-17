package enigma;

import callback.EnigmaInterface;
import callback.ModuleBehaviour;
import ui.Enigma1LogicaUi;

public class Enigma1Logica extends BaseEnigma implements EnigmaInterface<Integer> {

    private ModuleBehaviour modulo;
    private Enigma1LogicaUi enigma;

    public Enigma1Logica(ModuleBehaviour modulo) {
        this.modulo = modulo;
        this.setUi(enigma.getJFrame());
    }

    //TODO
    @Override
    public boolean onUserConfirm(Integer answer) {
        //Check if(.....)
        super.setResolved(true);
        super.setResolved(false);

        modulo.notifyError();
        modulo.notifyResolved();

        return true; //Disable input on UI
    }
}
