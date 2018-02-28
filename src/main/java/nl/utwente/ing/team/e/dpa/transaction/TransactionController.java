package nl.utwente.ing.team.e.dpa.transaction;

import nl.utwente.ing.team.e.dpa.dto.SingleIdWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
@RestController
@RequestMapping(value = "/transactions")
public interface TransactionController {

    @RequestMapping(value = "/", params = {"offset", "limit", "category"}, method = GET)
    public ResponseEntity<List<Transaction>> getTransactions(@RequestParam(value = "offset", required = false) Long offset,
                                                             @RequestParam(value = "limit", required = false) Long limit,
                                                             @RequestParam(value = "category", required = false) String category);
    @RequestMapping(value = "/", method = POST)
    public ResponseEntity<Transaction> addTransaction(@RequestBody NewTransactionDto newTransactionDto);

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<Transaction> getTransaction(@PathVariable("id") Long id);

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity deleteTransaction(@PathVariable("id") Long id);

    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<Transaction> updateTransaction(@PathVariable("id") Long id, @RequestBody NewTransactionDto newTransactionDto);

    @RequestMapping(value = "/{id}/category", method = POST)
    public ResponseEntity<Transaction> assignCategoryToTransaction(@PathVariable("id") Long id, @RequestBody SingleIdWrapper singleIdWrapper);
}
