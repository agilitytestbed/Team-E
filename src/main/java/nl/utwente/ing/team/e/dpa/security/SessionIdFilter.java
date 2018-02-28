package nl.utwente.ing.team.e.dpa.security;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author Martijn Noorlander
 */
public class SessionIdFilter extends GenericFilterBean {

    private AuthenticatedService authenticatedService;

    public SessionIdFilter(AuthenticatedService authenticatedService){
        this.authenticatedService = authenticatedService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {



        filterChain.doFilter(servletRequest, servletResponse);
    }
}
