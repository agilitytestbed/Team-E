package nl.utwente.ing.team.e.dpa.transaction;

import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import nl.utwente.ing.team.e.dpa.transaction.category.Category;
import nl.utwente.ing.team.e.dpa.transaction.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Martijn Noorlander
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryService categoryService;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, CategoryService categoryService) {
        this.transactionRepository = transactionRepository;
        this.categoryService = categoryService;
    }

    @Override
    public Transaction getTransaction(Long id, Authenticated authenticated) {
        Transaction transaction = transactionRepository.findOne(id);
        if (transaction != null && transaction.getAuthenticated().equals(authenticated)) {
            return transaction;
        }
        throw new IllegalStateException();
    }

    @Override
    public Transaction addTransaction(NewTransactionDto newTransaction, Authenticated authenticated) {
        Transaction transaction;
        if (newTransaction.getCategory() == null) {
            transaction = new Transaction(authenticated, newTransaction.getDate(), newTransaction.getAmount(),
                    newTransaction.getExternalIban(), newTransaction.getType());
        } else {
            // TODO: Get category
            Category category = null;
            transaction = new Transaction(authenticated, newTransaction.getDate(), newTransaction.getAmount(),
                    newTransaction.getExternalIban(), newTransaction.getType(), category);
        }
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long id, Authenticated authenticated) {
        Transaction transaction = transactionRepository.findOne(id);
        if(transaction.getAuthenticated().equals(authenticated)) {
            transactionRepository.delete(id);
        }
        throw new IllegalStateException("This transaction does not belong to this user");
    }

    @Override
    public Page<Transaction> getTransactions(int offset, int limit, String category, Authenticated authenticated) {
        if (category == null) {
            return transactionRepository.findAllByAuthenticated(new PageRequest(offset, limit),
                    authenticated);
        }
        Category categoryObj = null;
        return transactionRepository.findAllByAuthenticatedAndCategory(new PageRequest(offset, limit),
                authenticated, categoryObj);
    }

    @Override
    public Transaction updateTransaction(Long id, NewTransactionDto newTransactionDto) {
        return null;
    }

    @Override
    public Transaction assignCategory(Long id, Long categoryid) {
        Transaction transaction = transactionRepository.findOne(id);
        Category category = null;
        transaction.setCategory(category);
        return transactionRepository.save(transaction);
    }
}
