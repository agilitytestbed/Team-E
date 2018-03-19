package nl.utwente.ing.team.e.dpa.framework.exception;

/**
 * @author Martijn Noorlander
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
