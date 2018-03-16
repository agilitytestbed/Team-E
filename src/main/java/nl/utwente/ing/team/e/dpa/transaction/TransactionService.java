package nl.utwente.ing.team.e.dpa.transaction;

import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
@Service
public interface TransactionService {

    public Transaction getTransaction(Long id, Authenticated authenticated);

    public Transaction addTransaction(NewTransactionDto newTransaction, Authenticated authenticated);

    public void deleteTransaction(Long id, Authenticated authenticated);

    public Page<Transaction> getTransactions(int offset, int limit, String category, Authenticated authenticated);

    public Transaction updateTransaction(Long id, NewTransactionDto newTransactionDto);

    public Transaction assignCategory(Long id, Long categoryid);
}
