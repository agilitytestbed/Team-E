package nl.utwente.ing.team.e.dpa.balance.controller;

import nl.utwente.ing.team.e.dpa.balance.BalanceInterval;
import nl.utwente.ing.team.e.dpa.balance.history.BalanceHistory;
import nl.utwente.ing.team.e.dpa.balance.service.BalanceService;
import nl.utwente.ing.team.e.dpa.framework.BaseUtility;
import nl.utwente.ing.team.e.dpa.transaction.Transaction;
import nl.utwente.ing.team.e.dpa.transaction.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Frank van Mourik
 */
@RestController
public class BalanceControllerImpl extends BaseUtility implements BalanceController{

    private final BalanceService balanceService;

    @Autowired
    public BalanceControllerImpl(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @Override
    public ResponseEntity<List<BalanceHistory>> getBalanceHistory(@RequestParam(value = "interval",
            defaultValue = "0") BalanceInterval interval, @RequestParam(value = "intervals",
            defaultValue = "24") Integer intervals) {
        return new ResponseEntity<>(balanceService.getHistory(getCurrent(), interval, intervals), HttpStatus.OK);
    }


}
