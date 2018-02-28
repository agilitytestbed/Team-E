package nl.utwente.ing.team.e.dpa.transaction.category;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
