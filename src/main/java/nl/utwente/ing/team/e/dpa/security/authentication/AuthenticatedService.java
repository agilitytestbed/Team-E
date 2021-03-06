package nl.utwente.ing.team.e.dpa.security.authentication;

import org.springframework.stereotype.Service;

/**
 * Interface for AuthenticatedService. This service provied method to verify,
 * retrieve and generate authenticated objects
 * @author Martijn Noorlander
 */

@Service
public interface AuthenticatedService {

    public Authenticated getCurrent();

    public void setCurrent(String sessionId);

    public Authenticated create();

    public boolean verify(Long id);

    public Authenticated getAuthentication(Long id);

}
