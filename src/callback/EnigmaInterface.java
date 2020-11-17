package callback;

public interface EnigmaInterface<T> {

    boolean onUserConfirm(T answer);

}