package nl.utwente.ing.team.e.dpa.security;

import nl.utwente.ing.team.e.dpa.security.authentication.AuthenticatedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation of the session controller
 * @author Martijn Noorlander
 * @since 28-02-2018
 **/
@RestController
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
