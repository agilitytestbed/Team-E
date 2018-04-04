package nl.utwente.ing.team.e.dpa.transaction.controller;

import nl.utwente.ing.team.e.dpa.dto.SingleIdWrapper;
import nl.utwente.ing.team.e.dpa.transaction.dto.NewTransactionDto;
import nl.utwente.ing.team.e.dpa.transaction.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
@RequestMapping(value = "/transactions")
public interface TransactionController {

    @RequestMapping(method = GET)
    ResponseEntity<List<Transaction>> getTransactions(@RequestParam(value = "offset", required = false,
            defaultValue = "0") Integer offset,
                                                             @RequestParam(value = "limit", required = false,
                                                                     defaultValue = "20") Integer limit,
                                                             @RequestParam(value = "category", required = false) String category);

    @RequestMapping(method = POST)
    ResponseEntity<Transaction> addTransaction(@RequestBody @Valid NewTransactionDto newTransactionDto);

    @RequestMapping(value = "/{id}", method = GET)
    ResponseEntity<Transaction> getTransaction(@PathVariable("id") Long id);

    @RequestMapping(value = "/{id}", method = DELETE)
    ResponseEntity deleteTransaction(@PathVariable("id") Long id);

    @RequestMapping(value = "/{id}", method = PUT)
    ResponseEntity<Transaction> updateTransaction(@PathVariable("id") Long id, @RequestBody NewTransactionDto newTransactionDto);

    @RequestMapping(value = "/{id}/category", method = PATCH)
    ResponseEntity<Transaction> assignCategoryToTransaction(@PathVariable("id") Long id, @RequestBody SingleIdWrapper singleIdWrapper);
}
