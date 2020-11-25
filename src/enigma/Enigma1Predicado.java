package enigma;

import callback.ModuleBehaviour;
import model.Enigma;
import ui.Enigma1PredicadoUi;

public class Enigma1Predicado extends BaseEnigma {

    public Enigma1Predicado(ModuleBehaviour modulo) {
        super(modulo);
        Enigma enigma = new Enigma();
        enigma.setId(5);
        enigma.setText("<html>Dada a sentença: <br>\nUm Jogador perde para todos os boxeadores\" <br><br>\nSelecione a formula correta:\n</html>\n");
        enigma.setOptions(new String[]{"(Ex) (Ay) (jogador(x) ^ boxeador(y) -> Perde(x,y)", "(Ey) (Ax) (jogador(x) ^ boxeador(y) -> Perde(x,y)", "(Ex) (Ay) (jogador(y) ^ boxeador(x) -> Perde(x,y)", "(Ex) (Ay) (jogador(x) ^ boxeador(y) -> Perde(y,y)"});
        enigma.setCorrectAnswer(0);

        super.setEnigma(enigma);

        Enigma1PredicadoUi enigmaUi = new Enigma1PredicadoUi(this);
        this.setUi(enigmaUi.getJPanel());
    }
}
