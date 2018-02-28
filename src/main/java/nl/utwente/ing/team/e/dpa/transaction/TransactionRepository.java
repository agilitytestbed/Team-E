package nl.utwente.ing.team.e.dpa.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
