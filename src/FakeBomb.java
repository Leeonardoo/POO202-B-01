import java.nio.file.Path;
import java.nio.file.Paths;

public class FakeBomb implements BombaInterface {

    private ModuloInterface modulo01;

    public FakeBomb() {
        this.modulo01 = new Modulo01(this, 0);
    }

    @Override
    public void addErro() {

    }

    @Override
    public Path getCaminhoArquivos() {
        return Paths.get("/logs-fake");
    }

    @Override
    public void informarDesarme(ModuloInterface moduloInterface) {

    }
}
