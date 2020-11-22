package enigma;

import callback.ModuleBehaviour;
import model.Enigma;
import ui.Enigma1ProposicionalUi;
import ui.Enigma2ProposicionalUi;

public class Enigma2LogicaProposicional extends BaseEnigma {

    public Enigma2LogicaProposicional(ModuleBehaviour modulo) {
        super(modulo);
        Enigma enigma = new Enigma();
        enigma.setId(3);
        enigma.setText("<html>" +
                "Dada a sentença abaixo:<br>" +
                "Se o lutador treina bem, ele ganha. Se o lutador não se<br>" +
                "alimenta bem, ele não treina bem. O lutador se alimentou<br>" +
                "bem. Logo, ele ganhou.<br>" +
                "Sendo:<br>" +
                "<b>L</b> - o lutador treina bem<br>" +
                "<b>G</b> - ele ganha<br>" +
                "<b>A</b> - o lutador se Alimenta<br>" +
                "Pode-se Afirmar que a fórmula que corresponde a setença é:" +
                "</html>");
        enigma.setOptions(new String[]{
                "((L -> G) ^ (~A -> ~L) ^ A) -> G",
                "(L -> G) ^ (~A -> ~L) ^ A -> G",
                "(L -> G) ^ ((~A ^ L) ^ A )-> G",
                "((L -> A) ^ (~G -> ~L) ^ A) -> G"
        });
        enigma.setCorrectAnswer(-1); //TODO adicionar resposta certa
        super.setEnigma(enigma);

        Enigma2ProposicionalUi enigmaUi = new Enigma2ProposicionalUi(this);
        this.setUi(enigmaUi.getJPanel());
    }
}