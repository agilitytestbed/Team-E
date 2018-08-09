package nl.utwente.ing.team.e.dpa.transaction.controller;

import nl.utwente.ing.team.e.dpa.transaction.category.dto.SingleCategoryIdWrapper;
import nl.utwente.ing.team.e.dpa.framework.BaseUtility;
import nl.utwente.ing.team.e.dpa.transaction.category.rule.service.CategoryRuleService;
import nl.utwente.ing.team.e.dpa.transaction.dto.NewTransactionDto;
import nl.utwente.ing.team.e.dpa.transaction.Transaction;
import nl.utwente.ing.team.e.dpa.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Martijn Noorlander
 */
@RestController
public class TransactionControllerImpl extends BaseUtility implements TransactionController {

    private final TransactionService transactionService;

    private final CategoryRuleService categoryRuleService;

    @Autowired
    public TransactionControllerImpl(TransactionService transactionService, CategoryRuleService categoryRuleService) {
        this.transactionService = transactionService;
        this.categoryRuleService = categoryRuleService;
    }

    @Override
    public ResponseEntity<List<Transaction>> getTransactions(@RequestParam(value = "offset", required = false,
            defaultValue = "0") Integer offset,
                                                             @RequestParam(value = "limit", required = false,
                                                                     defaultValue = "20") Integer limit,
                                                             @RequestParam(value = "category", required = false) String category) {
        return new ResponseEntity<>(transactionService.getTransactions(offset, limit, category, getCurrent()).getContent(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Transaction> addTransaction(@RequestBody @Valid NewTransactionDto newTransactionDto) {
        Transaction transaction = transactionService.addTransaction(newTransactionDto, getCurrent());
        //Apply categoryrules
        transaction = categoryRuleService.applyRules(transaction, getCurrent());
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Transaction> getTransaction(@PathVariable("id") Long id) {
        return new ResponseEntity<>(transactionService.getTransaction(id, getCurrent()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteTransaction(@PathVariable("id") Long id) {
        transactionService.deleteTransaction(id, getCurrent());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @Override
    public ResponseEntity<Transaction> updateTransaction(@PathVariable("id") Long id, @RequestBody @Valid NewTransactionDto newTransactionDto) {
        return new ResponseEntity<>(transactionService.updateTransaction(id, newTransactionDto, getCurrent()), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Transaction> assignCategoryToTransaction(@PathVariable("id") Long id, @RequestBody @Valid SingleCategoryIdWrapper singleCategoryIdWrapper) {
        return new ResponseEntity<>(transactionService.assignCategory(id, singleCategoryIdWrapper.getId(), getCurrent()), HttpStatus.OK);
    }
}
