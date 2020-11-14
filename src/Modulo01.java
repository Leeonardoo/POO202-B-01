import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;

public class Modulo01 implements ModuloInterface {

    public static void main(String[] args) {

    }

    @Override
    public int getQuantasAtivacoes() {
        throw new NotImplementedException();
    }

    @Override
    public int getQuantasExecucoes(byte b) {
        throw new NotImplementedException();
    }

    @Override
    public int getQuantasRespostasCorretas(byte b) {
        throw new NotImplementedException();
    }

    @Override
    public boolean estaResolvido() {
        throw new NotImplementedException();
    }

    @Override
    public void conectarBomba(BombaInterface bombaInterface) {
        throw new NotImplementedException();
    }

    @Override
    public JPanel getPainelModulo() {
        throw new NotImplementedException();
    }
}
