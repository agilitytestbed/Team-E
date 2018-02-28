package nl.utwente.ing.team.e.dpa.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Martijn Noorlander
 */
public class SessionIdFilter extends GenericFilterBean {

    private final static String SECURITY_HEADER = "www_header";

    private AuthenticatedService authenticatedService;

    public SessionIdFilter(AuthenticatedService authenticatedService) {
        this.authenticatedService = authenticatedService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        try {
            Long id = new Long(servletRequest.getParameter(SECURITY_HEADER));

            if (SecurityContextHolder.getContext().getAuthentication() == null &&
                    !SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                    authenticatedService.verify(id)) {
                SecurityContextHolder.getContext().setAuthentication(
                        new SessionIdAuthentication(authenticatedService.getAuthentication(id)));
            } else {
                httpServletResponse.sendError(401);
            }
        } catch (NumberFormatException e){

        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
