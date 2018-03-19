package nl.utwente.ing.team.e.dpa.framework.exception;

/**
 * @author Martijn Noorlander
 */
public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException() {
        super("This user is not allowed to execute the action");
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
