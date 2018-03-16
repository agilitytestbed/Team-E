package nl.utwente.ing.team.e.dpa.transaction;

import nl.utwente.ing.team.e.dpa.dto.SingleIdWrapper;
import nl.utwente.ing.team.e.dpa.framework.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Martijn Noorlander
 */
@RestController
public class TransactionControllerImpl extends BaseController implements TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionControllerImpl(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public ResponseEntity<Page<Transaction>> getTransactions(int offset, int limit, String category) {
        return new ResponseEntity<>(transactionService.getTransactions(offset, limit, category, getCurrent()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Transaction> addTransaction(NewTransactionDto newTransactionDto) {
        return new ResponseEntity<>(transactionService.addTransaction(newTransactionDto, getCurrent()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Transaction> getTransaction(Long id) {
        return new ResponseEntity<>(transactionService.getTransaction(id, getCurrent()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteTransaction(Long id) {
        transactionService.deleteTransaction(id, getCurrent());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @Override
    public ResponseEntity<Transaction> updateTransaction(Long id, NewTransactionDto newTransactionDto) {
        return new ResponseEntity<>(transactionService.updateTransaction(id, newTransactionDto), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Transaction> assignCategoryToTransaction(Long id, SingleIdWrapper singleIdWrapper) {
        return new ResponseEntity<>(transactionService.assignCategory(id, singleIdWrapper.getId()), HttpStatus.OK);
    }
}
