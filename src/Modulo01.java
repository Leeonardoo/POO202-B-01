import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;

public class Modulo01 implements ModuloInterface {

    private BombaInterface bomba;

    public Modulo01(BombaInterface bomba) {
        this.bomba = bomba;
    }

    public Modulo01() {
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
        this.bomba = bombaInterface;
    }

    @Override
    public JPanel getPainelModulo() {
        throw new NotImplementedException();
    }
}
