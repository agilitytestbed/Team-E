package nl.utwente.ing.team.e.dpa.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Martijn Noorlander
 * @since 28-02-2018
 **/
@Service
public class AuthenticatedServiceImpl implements AuthenticatedService {

    private final AuthenticatedRepository authenticatedRepository;

    public AuthenticatedServiceImpl(AuthenticatedRepository authenticatedRepository) {
        this.authenticatedRepository = authenticatedRepository;
    }

    @Override
    public Authenticated getCurrent() {
        return (Authenticated) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public void setCurrent(String sessionId) {

    }

    @Override
    public Authenticated create() {
        return authenticatedRepository.save(new Authenticated());
    }

    @Override
    public boolean verify(Long id) {
        return authenticatedRepository.exists(id);
    }

    @Override
    public Authenticated getAuthentication(Long id) {
        return authenticatedRepository.findOne(id);
    }
}
