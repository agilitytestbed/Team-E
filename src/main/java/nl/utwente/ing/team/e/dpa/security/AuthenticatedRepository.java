package nl.utwente.ing.team.e.dpa.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Martijn Noorlander
 * @since 28-02-2018
 **/
@Repository
public interface AuthenticatedRepository extends JpaRepository<Authenticated, Long> {
}
