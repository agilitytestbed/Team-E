package nl.utwente.ing.team.e.dpa.framework.exception;

/**
 * Exception for when an object is nog found
 * @author Martijn Noorlander
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
