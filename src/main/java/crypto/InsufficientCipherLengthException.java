package crypto;

/**
 * Created by kraghunathan on 1/31/19.
 */
public class InsufficientCipherLengthException extends Exception {
    public InsufficientCipherLengthException(String s) {
        super(s);
    }
}
