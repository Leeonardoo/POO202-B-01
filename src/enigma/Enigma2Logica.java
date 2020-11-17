package enigma;

import callback.EnigmaInterface;
import callback.ModuleBehaviour;
import enigma.BaseEnigma;
import ui.Enigma1LogicaUi;
import ui.Enigma2LogicaUi;

public class Enigma2Logica extends BaseEnigma implements EnigmaInterface<Integer> {

    private ModuleBehaviour modulo;
    private Enigma2LogicaUi enigma;

    public Enigma2Logica(ModuleBehaviour modulo) {
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
