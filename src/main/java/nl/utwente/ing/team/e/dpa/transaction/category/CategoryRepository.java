package nl.utwente.ing.team.e.dpa.transaction.category;

import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByAuthenticated(Authenticated authenticated);

    Category findByNameAndAuthenticated(String name, Authenticated authenticated);
}
