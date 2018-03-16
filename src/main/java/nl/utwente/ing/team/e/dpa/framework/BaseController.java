package nl.utwente.ing.team.e.dpa.framework;

import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import nl.utwente.ing.team.e.dpa.security.authentication.AuthenticatedService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Martijn Noorlander
 */
public class BaseController {

    @Autowired
    AuthenticatedService authenticatedService;

    public Authenticated getCurrent(){
        return authenticatedService.getCurrent();
    }
}
