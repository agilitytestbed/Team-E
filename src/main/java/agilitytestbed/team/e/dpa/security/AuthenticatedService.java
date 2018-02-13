package agilitytestbed.team.e.dpa.security;

import org.springframework.stereotype.Service;

/**
 * @author Martijn Noorlander
 */

@Service
public interface AuthenticatedService {

    public Authenticated getCurrent();

    public void setCurrent(String sessionId);

}
