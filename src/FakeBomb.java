import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.nio.file.Path;

public class FakeBomb implements BombaInterface {

    private ModuloInterface modulo01;

    public FakeBomb() {
        this.modulo01 = new Modulo01(this);
    }

    @Override
    public void addErro() {
        throw new NotImplementedException();
    }

    @Override
    public Path getCaminhoArquivos() {
        throw new NotImplementedException();
    }

    @Override
    public void informarDesarme(ModuloInterface moduloInterface) {
        throw new NotImplementedException();
    }
}
