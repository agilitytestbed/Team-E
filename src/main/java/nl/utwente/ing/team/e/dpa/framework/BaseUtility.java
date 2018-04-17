package nl.utwente.ing.team.e.dpa.framework;

import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import nl.utwente.ing.team.e.dpa.security.authentication.AuthenticatedService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Base utility class that provied common methods for services and controllers
 * @author Martijn Noorlander
 */
public abstract class BaseUtility {

    @Autowired
    AuthenticatedService authenticatedService;

    protected BaseUtility() {

    }

    protected Authenticated getCurrent(){
        return authenticatedService.getCurrent();
    }
}
