package enigma;

import callback.EnigmaInterface;
import callback.ModuleBehaviour;
import enigma.BaseEnigma;

public class Enigma2Logica extends BaseEnigma implements EnigmaInterface<Integer> {

    private ModuleBehaviour modulo;

    public Enigma2Logica(ModuleBehaviour modulo) {
        this.modulo = modulo;
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
