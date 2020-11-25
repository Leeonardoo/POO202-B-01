package enigma;

import callback.ModuleBehaviour;
import model.Enigma;
import ui.Enigma1LogicaUi;

public class Enigma1Logica extends BaseEnigma {

    public Enigma1Logica(ModuleBehaviour modulo) {
        super(modulo);
        Enigma enigma = new Enigma();
        enigma.setId(1);
        enigma.setText("<html>João tem apenas um filho.<br> Junior é primo de Betinho. <br>Maria é mãe de João. <br>Betinho é filho de João. <br><br>Tendo conhecimento de que todas as<br>sentenças acima são verdadeiras, assinale<br>a alternativa que corresponde a seguinte<br>pergunta:<br><br>Qual a relação de Betinho com a Maria?</html>");
        enigma.setOptions(new String[]{"A) Tia", "B) Irmã", "C) Avó Materna", "D) Avó Paterna"});
        enigma.setCorrectAnswer(3);

        super.setEnigma(enigma);

        Enigma1LogicaUi enigmaUi = new Enigma1LogicaUi(this);
        this.setUi(enigmaUi.getJPanel());
    }
}
