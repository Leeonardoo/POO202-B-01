import callback.EnigmaInterface;
import callback.InternalModuleBehaviour;

public class Enigma1Logica extends BaseEnigma implements EnigmaInterface<Integer> {

    private InternalModuleBehaviour modulo;

    public Enigma1Logica(InternalModuleBehaviour modulo) {
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
