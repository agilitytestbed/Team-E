package nl.utwente.ing.team.e.dpa.framework;

import nl.utwente.ing.team.e.dpa.dto.ErrorMessage;
import nl.utwente.ing.team.e.dpa.framework.exception.NotFoundException;
import nl.utwente.ing.team.e.dpa.framework.exception.UnauthorizedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * Custom API Exception handler
 * @author Martijn Noorlander
 */
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private final HttpHeaders httpHeaders;

    public CustomExceptionHandler() {
        this.httpHeaders = new HttpHeaders();
        this.httpHeaders.setContentType(APPLICATION_JSON);
    }

    @ExceptionHandler({NotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(RuntimeException e, WebRequest request) {
        return handleExceptionInternal(e, new ErrorMessage(e.getMessage()), httpHeaders, HttpStatus.NOT_FOUND, request);
    }


    @ExceptionHandler({UnauthorizedException.class})
    protected ResponseEntity<Object> handleUnauthorizedException(RuntimeException e, WebRequest request) {
        return handleExceptionInternal(e, new ErrorMessage(e.getMessage()), httpHeaders,
                HttpStatus.UNAUTHORIZED, request);
    }
}
