package enigma;

import callback.ModuleBehaviour;
import model.Enigma;
import ui.Enigma1ProposicionalUi;

public class Enigma1LogicaProposicional extends BaseEnigma {

    public Enigma1LogicaProposicional(ModuleBehaviour modulo) {
        super(modulo);
        Enigma enigma = new Enigma();
        enigma.setId(3);
        enigma.setText("<html>Dada a disjunção exclusiva \u201COu Ana é advogada<br>ou Bianca é professora (P ⊻ Q)\u201D, escolha entre<br>as alternativas a sua negação.</html>");
        enigma.setOptions(new String[]{
                "<html>A) \u201CSe Ana \u00E9 advogada, então Bianca é professora.\u201D (P \u2192 Q)</html>",
                "<html>B) \u201CSe Bianca não é advogada então Ana é professora.\u201D (\u00ACR \u2192 S)</html>",
                "<html>C) \u201CAna \u00E9 advogada se, e somente se, Bianca \u00E9 professora.\u201D (P \u2194 Q)</html>",
                "<html>D) \u201CSe Bianca \u00E9 advogada, ent\u00E3o Ana \u00E9 professora.\u201D (R \u2192 S)</html>"
        });
        enigma.setCorrectAnswer(2); //TODO colocar a resposta certa

        super.setEnigma(enigma);

        Enigma1ProposicionalUi enigmaUi = new Enigma1ProposicionalUi(this);
        this.setUi(enigmaUi.getJPanel());
    }
}
