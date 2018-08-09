package nl.utwente.ing.team.e.dpa.transaction.category.rule.service;

import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import nl.utwente.ing.team.e.dpa.transaction.Transaction;
import nl.utwente.ing.team.e.dpa.transaction.category.rule.CategoryRule;
import nl.utwente.ing.team.e.dpa.transaction.category.rule.dto.NewCategoryRule;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Martijn Noorlander
 */
@Service
public interface CategoryRuleService {

    /**
     * Retrieve all rules
     * @param authenticated <code>Authenticated</code> entity belonging to session
     * @return <code>List</code> of <code>CategoryRule</code>
     */
    List<CategoryRule> getRules(Authenticated authenticated);

    /**
     * Get a specific rule
     * @param index int index of rule
     * @param authenticated <code>Authenticated</code> entity belonging to session
     * @return <code>CategoryRule</code>
     */
    CategoryRule getRule(Long index, Authenticated authenticated);

    /**
     * Add a rule
     * @param newCategoryRule <code>NewCategoryRule</code> with rule details
     * @param authenticated <code>Authenticated</code> entity belonging to session
     * @return <code>CategoryRule</code> created rule
     */
    CategoryRule addRule(NewCategoryRule newCategoryRule, Authenticated authenticated);

    /**
     * Update a specific rule
     * @param index int index of rule
     * @param newCategoryRule <code>NewCategoryRule</code> with rule details
     * @param authenticated <code>Authenticated</code> entity belonging to session
     * @return <code>CategoryRule</code> updated rule
     */
    CategoryRule updateRule(Long index, NewCategoryRule newCategoryRule, Authenticated authenticated);

    /**
     * Delete a specific rule
     * @param index int index of rule
     * @param authenticated <code>Authenticated</code> entity belonging to session
     */
    void deleteRule(Long index, Authenticated authenticated);

    /**
     * Apply the rules belonging to the session to the specified transaction
     * @param transaction <code>Transaction</code> to apply rules to
     * @param authenticated <code>Authenticated</code> entity belonging to session
     * @return <code>Transaction</code>h with applied rule
     */
    Transaction applyRules(Transaction transaction, Authenticated authenticated);
}
