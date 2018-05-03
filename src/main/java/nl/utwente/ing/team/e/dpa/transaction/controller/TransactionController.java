package nl.utwente.ing.team.e.dpa.transaction.controller;

import nl.utwente.ing.team.e.dpa.transaction.category.dto.SingleCategoryIdWrapper;
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

    /**
     * Retrieve all transactions belonging to a session
     * @param offset Int offset for paging
     * @param limit Int limit for paging
     * @param category Category to filter on
     * @return ResponseEntity 200 List<Transaction>
     */
    @RequestMapping(method = GET)
    ResponseEntity<List<Transaction>> getTransactions(@RequestParam(value = "offset", required = false,
            defaultValue = "0") Integer offset,
                                                             @RequestParam(value = "limit", required = false,
                                                                     defaultValue = "20") Integer limit,
                                                             @RequestParam(value = "category", required = false) String category);

    /**
     * Add a transaction to a session
     * @param newTransactionDto New transaction to add
     * @return ResponseEntity 200 Transaction that was added
     */
    @RequestMapping(method = POST)
    ResponseEntity<Transaction> addTransaction(@RequestBody @Valid NewTransactionDto newTransactionDto);

    /**
     * Retrieve a specific transaction
     * @param id Long id of transaction
     * @return ResponseEntity 200 Transaction
     */
    @RequestMapping(value = "/{id}", method = GET)
    ResponseEntity<Transaction> getTransaction(@PathVariable("id") Long id);

    /**
     * Delete a specific transaction
     * @param id Long id of transaction
     * @return ResponseEntity 200
     */
    @RequestMapping(value = "/{id}", method = DELETE)
    ResponseEntity deleteTransaction(@PathVariable("id") Long id);

    /**
     * Update a transaction
     * @param id Long id of transaction to update
     * @param newTransactionDto Transaction details
     * @return ResponseEntity 200 Transaction
     */
    @RequestMapping(value = "/{id}", method = PUT)
    ResponseEntity<Transaction> updateTransaction(@PathVariable("id") Long id, @RequestBody NewTransactionDto newTransactionDto);

    /**
     * Assign a category to a transaction
     * @param id Long id of transaction
     * @param singleCategoryIdWrapper Category to assign
     * @return ResponseEntity 200 Transaction
     */
    @RequestMapping(value = "/{id}/category", method = PATCH)
    ResponseEntity<Transaction> assignCategoryToTransaction(@PathVariable("id") Long id, @RequestBody SingleCategoryIdWrapper singleCategoryIdWrapper);
}
