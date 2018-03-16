package nl.utwente.ing.team.e.dpa.transaction;

import nl.utwente.ing.team.e.dpa.dto.SingleIdWrapper;
import nl.utwente.ing.team.e.dpa.framework.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Martijn Noorlander
 */
@RestController
public class TransactionControllerImpl extends BaseController implements TransactionController {

    @Override
    public ResponseEntity<List<Transaction>> getTransactions(Long offset, Long limit, String category) {
        System.out.println("Current authenticated" + getCurrent().toString());
        return null;
    }

    @Override
    public ResponseEntity<Transaction> addTransaction(NewTransactionDto newTransactionDto) {
        return null;
    }

    @Override
    public ResponseEntity<Transaction> getTransaction(Long id) {
        return null;
    }

    @Override
    public ResponseEntity deleteTransaction(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Transaction> updateTransaction(Long id, NewTransactionDto newTransactionDto) {
        return null;
    }

    @Override
    public ResponseEntity<Transaction> assignCategoryToTransaction(Long id, SingleIdWrapper singleIdWrapper) {
        return null;
    }
}
