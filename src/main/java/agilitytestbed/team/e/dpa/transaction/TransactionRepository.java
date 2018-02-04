package agilitytestbed.team.e.dpa.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
