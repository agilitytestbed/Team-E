package nl.utwente.ing.team.e.dpa.balance.service;

import nl.utwente.ing.team.e.dpa.balance.BalanceInterval;
import nl.utwente.ing.team.e.dpa.balance.history.BalanceHistory;
import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import nl.utwente.ing.team.e.dpa.transaction.Transaction;
import nl.utwente.ing.team.e.dpa.transaction.TransactionType;
import nl.utwente.ing.team.e.dpa.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Martijn Noorlander
 * @since 11-8-2018.
 */
@Service
public class BalanceServiceImpl implements BalanceService {

    private final TransactionService transactionService;

    @Autowired
    public BalanceServiceImpl(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public List<BalanceHistory> getHistory(Authenticated authenticated, BalanceInterval interval, Integer intervals) {
        List<BalanceHistory> histories = new ArrayList<>();
        Date beginDate = new Date(System.currentTimeMillis());
        for(int i = 0; i < intervals - 1; i++){
            beginDate = subtractInterval(beginDate, interval);
        }
        Date endDate = new Date(beginDate.getTime() - 1);
        beginDate = subtractInterval(beginDate, interval);

        double balance = 0;
        for(int i = 0; i < intervals; i++){
            double flow = 0;
            BalanceHistory history = new BalanceHistory();
            history.setOpen(balance);
            history.setLow(balance);
            history.setHigh(balance);
            history.setTimestamp(new Timestamp(beginDate.getTime()));
            List<Transaction> transactions = transactionService.getAllTransaction(authenticated, beginDate, endDate);
            for (Transaction transaction: transactions) {
                if(transaction.getType() == TransactionType.withdrawal){
                    balance = balance - transaction.getAmount();
                } else {
                    balance = balance + transaction.getAmount();
                }
                flow = flow + Math.abs(transaction.getAmount());
                if (balance < history.getLow()){
                    history.setLow(balance);
                }
                if (balance > history.getHigh()){
                    history.setHigh(balance);
                }
            }
            history.setVolume(flow);
            history.setClose(balance);
            histories.add(history);
            beginDate = addInterval(beginDate, interval);
            endDate = addInterval(endDate, interval);
        }
        return histories;
    }

    private Date subtractInterval(Date fromDate, BalanceInterval interval){
        LocalDateTime date = LocalDateTime.ofInstant(fromDate.toInstant(), ZoneId.systemDefault());
        LocalDateTime ret = null;
        switch(interval){
            case hour:
                ret = date.minusHours(1);
                break;
            case day:
                ret =  date.minusDays(1);
                break;
            case week:
                ret =  date.minusWeeks(1);
                break;
            case month:
                ret =  date.minusMonths(1);
                break;
            case year:
                ret =  date.minusYears(1);
                break;
        }
        return Date.from(ret.atZone(ZoneId.systemDefault()).toInstant());
    }

    private Date addInterval(Date fromDate, BalanceInterval interval){
        LocalDateTime date = LocalDateTime.ofInstant(fromDate.toInstant(), ZoneId.systemDefault());
        LocalDateTime ret = null;
        switch(interval){
            case hour:
                ret = date.plusHours(1);
                break;
            case day:
                ret =  date.plusDays(1);
                break;
            case week:
                ret =  date.plusWeeks(1);
                break;
            case month:
                ret =  date.plusMonths(1);
                break;
            case year:
                ret =  date.plusYears(1);
                break;
        }
        return Date.from(ret.atZone(ZoneId.systemDefault()).toInstant());
    }
}
