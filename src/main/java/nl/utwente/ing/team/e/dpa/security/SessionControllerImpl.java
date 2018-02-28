package nl.utwente.ing.team.e.dpa.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Martijn Noorlander
 * @since 28-02-2018
 **/
public class SessionControllerImpl implements SessionController {

    private final AuthenticatedService authenticatedService;

    public SessionControllerImpl(AuthenticatedService authenticatedService) {
        this.authenticatedService = authenticatedService;
    }

    @Override
    public ResponseEntity<Object> getSession() {
        return new ResponseEntity<Object>(authenticatedService.create(), HttpStatus.OK);
    }
}
