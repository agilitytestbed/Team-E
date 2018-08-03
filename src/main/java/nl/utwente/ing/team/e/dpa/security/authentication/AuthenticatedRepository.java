package nl.utwente.ing.team.e.dpa.security.authentication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Authenticated objects
 * @author Martijn Noorlander
 * @since 28-02-2018
 **/
@Repository
public interface AuthenticatedRepository extends JpaRepository<Authenticated, Long> {
}
