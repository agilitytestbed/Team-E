package nl.utwente.ing.team.e.dpa.transaction;

import nl.utwente.ing.team.e.dpa.dto.SingleIdWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Martijn Noorlander
 */
public class TransactionControllerImpl implements TransactionController {

    @Override
    public ResponseEntity<List<Transaction>> getTransactions(Long offset, Long limit, String category) {
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
