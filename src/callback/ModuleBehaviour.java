package callback;

import java.nio.file.Path;

public interface ModuleBehaviour {

    void notifyError();

    void notifyResolved();

    Path getBasePath();
}
