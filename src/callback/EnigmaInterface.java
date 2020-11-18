package callback;

import model.Enigma;

public interface EnigmaInterface {

    boolean onUserConfirm(int answer);

    Enigma getEnigma();
}