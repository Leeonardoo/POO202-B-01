import callback.EnigmaInterface;

public class Enigma2Logica extends BaseEnigma implements EnigmaInterface<Integer> {

    private ModuloInterface modulo;

    public Enigma2Logica(ModuloInterface modulo) {
        this.modulo = modulo;
    }

    //TODO
    @Override
    public boolean onUserConfirm(Integer answer) {
        //Check if(.....)
        super.setResolved(true);
        super.setResolved(false);

        return true; //Disable input on UI
    }
}
