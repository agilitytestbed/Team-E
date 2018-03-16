package nl.utwente.ing.team.e.dpa.security;

import nl.utwente.ing.team.e.dpa.security.authentication.AuthenticatedService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Martijn Noorlander
 */
public class SessionIdFilter extends GenericFilterBean {

    private final static String SECURITY_HEADER = "wwwheader";

    private AuthenticatedService authenticatedService;

    public SessionIdFilter(AuthenticatedService authenticatedService) {
        this.authenticatedService = authenticatedService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        try {
            Long id = new Long(httpServletRequest.getHeader(SECURITY_HEADER));

            if (/*SecurityContextHolder.getContext().getAuthentication() == null &&
                    !SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&*/
                    authenticatedService.verify(id)) {
                SecurityContextHolder.getContext().setAuthentication(
                        new SessionIdAuthentication(authenticatedService.getAuthentication(id)));
                System.out.println("Authenticated");
            } else {
                httpServletResponse.sendError(401);
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("No header, or invalid");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
