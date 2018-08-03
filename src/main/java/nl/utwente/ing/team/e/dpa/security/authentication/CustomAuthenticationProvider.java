package nl.utwente.ing.team.e.dpa.security.authentication;

import nl.utwente.ing.team.e.dpa.security.SessionIdAuthentication;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * AuthenticationProvider for Authenticated objects, necessary
 * for the <code>SessionIdFilter</code> to function
 * @author Martijn Noorlander
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return authentication;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (SessionIdAuthentication.class.isAssignableFrom(aClass));
    }

}
