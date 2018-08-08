package nl.utwente.ing.team.e.dpa.transaction.category.rule.service;

import nl.utwente.ing.team.e.dpa.framework.exception.NotFoundException;
import nl.utwente.ing.team.e.dpa.framework.exception.UnauthorizedException;
import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import nl.utwente.ing.team.e.dpa.transaction.Transaction;
import nl.utwente.ing.team.e.dpa.transaction.category.Category;
import nl.utwente.ing.team.e.dpa.transaction.category.rule.CategoryRule;
import nl.utwente.ing.team.e.dpa.transaction.category.rule.CategoryRuleRepository;
import nl.utwente.ing.team.e.dpa.transaction.category.rule.dto.NewCategoryRule;
import nl.utwente.ing.team.e.dpa.transaction.category.service.CategoryService;
import nl.utwente.ing.team.e.dpa.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Martijn Noorlander
 */
@Service
public class CategoryRuleServiceImpl implements CategoryRuleService {

    private final CategoryRuleRepository categoryRuleRepository;

    private final TransactionService transactionService;

    private final CategoryService categoryService;

    @Autowired
    public CategoryRuleServiceImpl(CategoryRuleRepository categoryRuleRepository, TransactionService transactionService, CategoryService categoryService) {
        this.categoryRuleRepository = categoryRuleRepository;
        this.transactionService = transactionService;
        this.categoryService = categoryService;
    }

    @Override
    public List<CategoryRule> getRules(Authenticated authenticated) {
        return categoryRuleRepository.findAllByAuthenticatedOrderByTimeStamp(authenticated);
    }

    @Override
    public CategoryRule getRule(Long index, Authenticated authenticated) {
        CategoryRule categoryRule = categoryRuleRepository.findOne(index);
        if(categoryRule.getAuthenticated().equals(authenticated)){
            throw new UnauthorizedException("Rule does not belong to this user");
        }
        return categoryRule;
    }

    @Override
    public CategoryRule addRule(NewCategoryRule newCategoryRule, Authenticated authenticated) {
        CategoryRule categoryRule = new CategoryRule(newCategoryRule);
        categoryRule.setAuthenticated(authenticated);
        Category category = categoryService.find(0L, authenticated);
        if(category == null){
            throw new NotFoundException("The given category does not exist");
        }
        categoryRule.setCategory(category);
        if(categoryRule.isApplyOnHistory()){
            List<Transaction> transactions = transactionService.getAllTransaction(authenticated);
            for(Transaction ts: transactions){
                applyRule(ts, categoryRule, authenticated);
            }
        }
        return categoryRuleRepository.save(categoryRule);
    }

    @Override
    public CategoryRule updateRule(Long index, NewCategoryRule newCategoryRule, Authenticated authenticated) {
        CategoryRule categoryRule = categoryRuleRepository.findOne(index);
        if(categoryRule.getAuthenticated().equals(authenticated)){
            throw new UnauthorizedException("Rule does not belong to this user");
        }
        Category category = categoryService.find(newCategoryRule.getCategoryId(), authenticated);
        categoryRule.setCategory(category);
        categoryRule.setDescription(newCategoryRule.getDescription());
        categoryRule.setIban(newCategoryRule.getiBAN());
        return categoryRuleRepository.save(categoryRule);
    }

    @Override
    public void deleteRule(Long index, Authenticated authenticated) {
        CategoryRule categoryRule = categoryRuleRepository.findOne(index);
        if(categoryRule.getAuthenticated().equals(authenticated)){
            throw new UnauthorizedException("Rule does not belong to this user");
        }
        categoryRuleRepository.delete(index);
    }

    @Override
    public Transaction applyRules(Transaction transaction, Authenticated authenticated) {
        //Get session and its rules
        List<CategoryRule> rules = categoryRuleRepository.findAllByAuthenticatedOrderByTimeStamp(authenticated);

        for(CategoryRule rule: rules){
            if(matchRule(rule, transaction)){
                transaction = transactionService.assignCategory(transaction.getId(), rule.getCategory().getId(), authenticated);
            }
        }
        return transaction;
    }

    private boolean matchRule(CategoryRule categoryRule, Transaction transaction){
        if(categoryRule.getTransactionType() != null && transaction.getType() != categoryRule.getTransactionType()){
            return false;
        }
        if(!categoryRule.getDescription().equals("") && !transaction.getDescription().contains(categoryRule.getDescription())){
            return false;
        }
        return categoryRule.getIban().equals("") || transaction.getExternalIban().contains(categoryRule.getIban());
    }

    private void applyRule(Transaction transaction, CategoryRule categoryRule, Authenticated authenticated){
        if(matchRule(categoryRule, transaction)){
            transactionService.assignCategory(transaction.getId(), categoryRule.getCategory().getId(), authenticated);
        }
    }
}
