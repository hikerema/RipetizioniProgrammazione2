/**
 * AlreadyBookedException
 */
public class AlreadyBookedException extends Exception {

    public AlreadyBookedException() {
        super();
    }
    public AlreadyBookedException(String messaggio) {
        super(messaggio);
    }
}