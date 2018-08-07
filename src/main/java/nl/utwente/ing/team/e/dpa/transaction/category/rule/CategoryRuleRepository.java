package nl.utwente.ing.team.e.dpa.transaction.category.rule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Martijn Noorlander
 */
@Repository
public interface CategoryRuleRepository extends JpaRepository<CategoryRule, Long> {
}
