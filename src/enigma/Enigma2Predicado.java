package enigma;

import callback.ModuleBehaviour;
import model.Enigma;
import ui.Enigma2PredicadoUi;

public class Enigma2Predicado extends BaseEnigma {

    public Enigma2Predicado(ModuleBehaviour modulo) {
        super(modulo);
        Enigma enigma = new Enigma();
        enigma.setId(6);
        enigma.setText("<html>jornalista(x) = x é jornalista<br>\r\nformado(x) = x é formado<br>\r\n<br>\r\n1 - Todos são formados<br>\r\n2 - Todo Jornalista é formado<br>\r\n3 - Alguns são formados, alguns não são<br>\r\n4 - Nem todo jornalista é formado<br>\r\n<br>\r\n\r\n( ) (Ax)(jornalista(x) -> formado(x))<br>\r\n( ) -((Ex)(jornalista(x) -> formado(x)))<br>\r\n( ) (Ax)(formado(x))<br>\r\n( ) (Ex)(formado(x))) ^(Ex)(-formado(x))<br>\r\n<br>\r\nAssinale a alternativa que corresponde ao<br>relacionamento entre as sentenças abaixo:</html>");
        enigma.setOptions(new String[]{"2,1,3,4", "2,4,1,3", "1,2,3,4", "3,4,1,2"});
        enigma.setCorrectAnswer(1);

        super.setEnigma(enigma);

        Enigma2PredicadoUi enigmaUi = new Enigma2PredicadoUi(this);
        this.setUi(enigmaUi.getJPanel());
    }
}