package nl.utwente.ing.team.e.dpa.transaction.service;

import nl.utwente.ing.team.e.dpa.framework.exception.NotFoundException;
import nl.utwente.ing.team.e.dpa.framework.exception.UnauthorizedException;
import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import nl.utwente.ing.team.e.dpa.transaction.dto.NewTransactionDto;
import nl.utwente.ing.team.e.dpa.transaction.Transaction;
import nl.utwente.ing.team.e.dpa.transaction.TransactionRepository;
import nl.utwente.ing.team.e.dpa.transaction.category.Category;
import nl.utwente.ing.team.e.dpa.transaction.category.service.CategoryService;
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
        if(!transaction.getAuthenticated().equals(authenticated)){
            throw new UnauthorizedException("Transaction does not belong to this user");
        }
        throw new NotFoundException("The transaction with id: " + id + " was not found");
    }

    @Override
    public Transaction addTransaction(NewTransactionDto newTransaction, Authenticated authenticated) {
        Transaction transaction;
        if (newTransaction.getCategory() == null) {
            transaction = new Transaction(authenticated, newTransaction.getDate(), newTransaction.getAmount(),
                    newTransaction.getExternalIban(), newTransaction.getType());
        } else {
            Category category = categoryService.find(newTransaction.getCategory());
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
            return;
        }
        throw new IllegalStateException("This transaction does not belong to this user");
    }

    @Override
    public Page<Transaction> getTransactions(int offset, int limit, String category, Authenticated authenticated) {
        if (category == null) {
            return transactionRepository.findAllByAuthenticated(new PageRequest(offset, limit),
                    authenticated);
        }
        Category categoryObj = categoryService.findByName(category);
        return transactionRepository.findAllByAuthenticatedAndCategory(new PageRequest(offset, limit),
                authenticated, categoryObj);
    }

    @Override
    public Transaction updateTransaction(Long id, NewTransactionDto newTransactionDto) {
        Transaction transaction = transactionRepository.findOne(id);
        if(transaction == null){
            throw new NotFoundException("The transaction with id: " + id + " was not found");
        }
        transaction.update(newTransactionDto);
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction assignCategory(Long id, Long categoryid) {
        Transaction transaction = transactionRepository.findOne(id);
        Category category = categoryService.find(categoryid);
        transaction.setCategory(category);
        transaction = transactionRepository.save(transaction);
        return transaction;
    }
}
