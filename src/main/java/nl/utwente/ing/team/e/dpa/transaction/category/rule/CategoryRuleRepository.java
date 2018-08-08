package nl.utwente.ing.team.e.dpa.transaction.category.rule;

import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Martijn Noorlander
 */
@Repository
public interface CategoryRuleRepository extends JpaRepository<CategoryRule, Long> {

    List<CategoryRule> findAllByAuthenticatedOrderByTimeStamp(Authenticated authenticated);
}
