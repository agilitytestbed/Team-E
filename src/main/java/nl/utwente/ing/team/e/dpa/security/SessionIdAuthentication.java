package nl.utwente.ing.team.e.dpa.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author Martijn Noorlander
 * @since 28-02-2018
 **/
public class SessionIdAuthentication implements Authentication{

    private Authenticated authenticated;

    public SessionIdAuthentication(Authenticated authenticated) {
        this.authenticated = authenticated;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return authenticated;
    }

    @Override
    public Object getDetails() {
        return authenticated;
    }

    @Override
    public Object getPrincipal() {
        return authenticated;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
    }

    @Override
    public String getName() {
        return authenticated.getId().toString();
    }
}
