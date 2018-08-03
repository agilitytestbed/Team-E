package nl.utwente.ing.team.e.dpa.security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for sessions
 * @author Martijn Noorlander
 * @since 28-02-2018
 **/
@RestController
@RequestMapping(value = "/sessions")
public interface SessionController {

    /**
     * Create a new session
     * @return Created session
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> getSession();

}
