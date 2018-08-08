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

    List<CategoryRule> getRules(Authenticated authenticated);

    CategoryRule getRule(Long index, Authenticated authenticated);

    CategoryRule addRule(NewCategoryRule newCategoryRule, Authenticated authenticated);

    CategoryRule updateRule(Long index, NewCategoryRule newCategoryRule, Authenticated authenticated);

    void deleteRule(Long index, Authenticated authenticated);

    Transaction applyRules(Transaction transaction, Authenticated authenticated);
}
