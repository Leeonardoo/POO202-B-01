import javax.swing.JPanel;

public class Modulo01 implements ModuloInterface {

    private BombaInterface bomba;

    public Modulo01(BombaInterface bomba) {
        this.bomba = bomba;
    }

    public Modulo01() {
    }

    @Override
    public int getQuantasAtivacoes() {
        return -1;
    }

    @Override
    public int getQuantasExecucoes(byte b) {
    	return -1;
    }

    @Override
    public int getQuantasRespostasCorretas(byte b) {
    	return -1;
    }

    @Override
    public boolean estaResolvido() {
        return false;
    }

    @Override
    public void conectarBomba(BombaInterface bombaInterface) {
        this.bomba = bombaInterface;
    }

    @Override
    public JPanel getPainelModulo() {
        return null;
    }
}
