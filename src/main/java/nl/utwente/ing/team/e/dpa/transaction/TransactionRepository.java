package nl.utwente.ing.team.e.dpa.transaction;

import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import nl.utwente.ing.team.e.dpa.transaction.category.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Transactions
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    public Page<Transaction> findAllByAuthenticated(Pageable pageable, Authenticated authenticated);

    public Page<Transaction> findAllByAuthenticatedAndCategory(Pageable pageable, Authenticated authenticated,
                                                               Category category);

    public List<Transaction> findALlByCategory(Category category);
}
