package nl.utwente.ing.team.e.dpa.dto;

/**
 * @author Martijn Noorlander
 */
public class ErrorMessage {

    private String message;

    public ErrorMessage() {
    }

    public ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
