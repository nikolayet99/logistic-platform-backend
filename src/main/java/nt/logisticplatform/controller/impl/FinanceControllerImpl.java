package nt.logisticplatform.controller.impl;

import nt.logisticplatform.controller.FinanceController;
import nt.logisticplatform.model.Profit;
import nt.logisticplatform.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class FinanceControllerImpl implements FinanceController {
    @Autowired
    private FinanceService financeService;

    @Override
    public Profit getTotalProfitByDateInterval(LocalDate startDate, LocalDate endDate) {
        return financeService.getTotalProfitByDateInterval(startDate, endDate);
    }
}
