package nl.utwente.ing.team.e.dpa.transaction.service;

import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import nl.utwente.ing.team.e.dpa.transaction.dto.NewTransactionDto;
import nl.utwente.ing.team.e.dpa.transaction.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
@Service
public interface TransactionService {

    /**
     * Get a transaction by Id
     * @param id Long id of transaction
     * @param authenticated Authenticated session
     * @return Transaction
     */
    public Transaction getTransaction(Long id, Authenticated authenticated);

    /**
     * Add a transaction
     * @param newTransaction details of Transaction
     * @param authenticated Authenticated session
     * @return Transaction
     */
    public Transaction addTransaction(NewTransactionDto newTransaction, Authenticated authenticated);

    /**
     * Delete a transaction
     * @param id Long id of Transaction
     * @param authenticated Authenticated session
     */
    public void deleteTransaction(Long id, Authenticated authenticated);

    /**
     * Get all transactions for a session
     * @param offset Int offset for paging
     * @param limit Int limit for paging
     * @param category String name of category to filter
     * @param authenticated Authenticated session
     * @return Page<Transaction>
     */
    public Page<Transaction> getTransactions(int offset, int limit, String category, Authenticated authenticated);

    /**
     * Update a transaction
     * @param id Long id of Transaction
     * @param newTransactionDto Transaction details to update
     * @return Transaction
     */
    public Transaction updateTransaction(Long id, NewTransactionDto newTransactionDto);

    /**
     * Assign a category to a transaction
     * @param id Long id of transaction
     * @param categoryid id of category
     * @return Transaction
     */
    public Transaction assignCategory(Long id, Long categoryid);
}
