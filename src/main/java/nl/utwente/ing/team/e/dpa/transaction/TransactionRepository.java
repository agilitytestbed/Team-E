package nl.utwente.ing.team.e.dpa.transaction;

import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import nl.utwente.ing.team.e.dpa.transaction.category.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Repository for Transactions
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findAllByAuthenticated(Pageable pageable, Authenticated authenticated);

    List<Transaction> findAllByAuthenticated(Authenticated authenticated);

    Page<Transaction> findAllByAuthenticatedAndCategory(Pageable pageable, Authenticated authenticated,
                                                               Category category);

    List<Transaction> findALlByCategory(Category category);

    List<Transaction> findAllByAuthenticatedAndDateBetween(Authenticated authenticated, Date startdate, Date enddate);

    List<Transaction> findAllByAuthenticatedAndDateBefore(Authenticated authenticated, Date date);
}
