package nl.utwente.ing.team.e.dpa.config;

import nl.utwente.ing.team.e.dpa.security.SessionIdFilter;
import nl.utwente.ing.team.e.dpa.security.authentication.AuthenticatedService;
import nl.utwente.ing.team.e.dpa.security.authentication.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Configuration for web security
 * @author Martijn Noorlander
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticatedService authenticatedService;

    @Autowired
    public WebSecurityConfig(AuthenticatedService authenticatedService) {
        this.authenticatedService = authenticatedService;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .addFilterAfter(getSessionIdFilter(), BasicAuthenticationFilter.class)
                .csrf().disable()
                .cors()
                .and()
                .authorizeRequests()
                    .antMatchers("/sessions").permitAll()
                    .antMatchers("/**").authenticated()
                .and()
                .logout()
                    .permitAll();
    }

    @Bean
    public SessionIdFilter getSessionIdFilter(){
        return new SessionIdFilter(authenticatedService);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    @Bean
    public CustomAuthenticationProvider authProvider() {
        return new CustomAuthenticationProvider();
    }
}
