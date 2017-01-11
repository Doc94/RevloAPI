package net.mrdoc.revloapi.exception;

/**
 * Created by Doc on 10-01-2017.
 *
 * @author Doc
 */
public class RevloException extends Exception {

    public RevloException(String message) {
        super(message);
    }

    public RevloException(Throwable throwable) {
        super(throwable);
    }

    public RevloException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
