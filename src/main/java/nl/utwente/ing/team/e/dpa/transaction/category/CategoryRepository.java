package nl.utwente.ing.team.e.dpa.transaction.category;

import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     * Find all categories by authenticated
     *
     * @param authenticated <code>Authenticated</code>
     * @return List<Category> categories belonging to authenticated
     */
    List<Category> findAllByAuthenticated(Authenticated authenticated);

    /**
     * Find all categories by authenticated
     *
     * @param authenticated <code>Authenticated</code>
     * @param name String category name
     * @return List<Category> categories belonging to authenticated
     */
    Category findByNameAndAuthenticated(String name, Authenticated authenticated);
}
