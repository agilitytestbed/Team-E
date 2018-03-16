package nl.utwente.ing.team.e.dpa.security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Martijn Noorlander
 * @since 28-02-2018
 **/
@RestController
@RequestMapping(value = "/sessions")
public interface SessionController {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> getSession();

}
