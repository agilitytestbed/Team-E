package agilitytestbed.team.e.dpa.config;

import agilitytestbed.team.e.dpa.security.AuthenticatedService;
import agilitytestbed.team.e.dpa.security.SessionIdFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author Martijn Noorlander
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticatedService authenticatedService;

    public WebSecurityConfig(AuthenticatedService authenticatedService) {
        this.authenticatedService = authenticatedService;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .addFilterAfter(getSessionIdFilter(), BasicAuthenticationFilter.class)
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .logout()
                    .permitAll();
    }

    @Bean
    public SessionIdFilter getSessionIdFilter(){
        return new SessionIdFilter(authenticatedService);
    }

}
