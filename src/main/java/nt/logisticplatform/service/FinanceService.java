package nt.logisticplatform.service;

import nt.logisticplatform.model.Bill;
import nt.logisticplatform.model.Profit;

import java.time.LocalDate;

public interface FinanceService {
    Profit getTotalProfitByDateInterval(LocalDate startDate, LocalDate endDate);

    Bill addBill(Bill bill);
}
