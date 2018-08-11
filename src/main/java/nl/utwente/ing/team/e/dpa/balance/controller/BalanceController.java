package nl.utwente.ing.team.e.dpa.balance.controller;

import nl.utwente.ing.team.e.dpa.balance.BalanceInterval;
import nl.utwente.ing.team.e.dpa.transaction.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Martijn Noorlander
 * @since 11-8-2018.
 */
@RequestMapping(value = "/balance")
public interface BalanceController {

    @RequestMapping(value = "/history", method = GET)
    ResponseEntity<List<Transaction>> getBalanceHistory(@RequestParam(value = "interval",
            defaultValue = "0") BalanceInterval interval,
                                                      @RequestParam(value = "intervals",
                                                              defaultValue = "24") Integer intervals);
}
