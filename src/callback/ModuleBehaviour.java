package callback;

import data.LogManager;

public interface ModuleBehaviour {

    void notifyError();

    void notifyResolved();

    LogManager getLogManager();
}
