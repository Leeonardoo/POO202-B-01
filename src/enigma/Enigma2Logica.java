package enigma;

import callback.ModuleBehaviour;
import model.Enigma;
import ui.Enigma2LogicaUi;

public class Enigma2Logica extends BaseEnigma {

    public Enigma2Logica(ModuleBehaviour modulo) {
        super(modulo);
        Enigma enigma = new Enigma();
        enigma.setId(1);
        enigma.setText("<html>Assinale a alternativa que corresponde ao n\u00FAmero <br> faltando da tabela abaixo");
        enigma.setOptions(new String[]{"288", "576", "72", "144", "360", "??", "504", "648", "216", "432", "327", "785", "485"});
        enigma.setCorrectAnswer(9);
        super.setEnigma(enigma);

        Enigma2LogicaUi enigmaUi = new Enigma2LogicaUi(this);
        this.setUi(enigmaUi.getJPanel());
    }
}