package nl.utwente.ing.team.e.dpa.balance.service;

import nl.utwente.ing.team.e.dpa.balance.BalanceInterval;
import nl.utwente.ing.team.e.dpa.balance.history.BalanceHistory;
import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Martijn Noorlander
 * @since 11-8-2018.
 */
@Service
public interface BalanceService {

    /**
     * Get the history balance in intervals
     * @param authenticated <code>Session to get history for</code>
     * @param interval <code>BalanceInterval</code> type of interval
     * @param intervals int amount of intervals to show
     * @return <code>List</code> of <code>BalanceHistory</code> history
     */
    List<BalanceHistory> getHistory(Authenticated authenticated, BalanceInterval interval, Integer intervals);

}
