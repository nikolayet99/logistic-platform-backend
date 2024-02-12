package nt.logisticplatform.service.impl;

import nt.logisticplatform.exception.ApiClientRuntimeException;
import nt.logisticplatform.model.Bill;
import nt.logisticplatform.model.Package;
import nt.logisticplatform.model.Profit;
import nt.logisticplatform.repository.FinanceRepository;
import nt.logisticplatform.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class FinanceServiceImpl implements FinanceService {
    @Autowired
    FinanceRepository financeRepository;

    @Override
    public Profit getTotalProfitByDateInterval(LocalDate startDate, LocalDate endDate) {
        Double totalProfitByDateInterval = financeRepository.findTotalProfitByDateInterval(startDate, endDate);
        return new Profit(totalProfitByDateInterval);
    }

    @Override
    public Bill addBill(Bill bill) {
        validateBill(bill);
        financeRepository.save(bill);
        return bill;
    }

    private void validateBill(Bill bill) {
        Package pack = bill.getPack();
        if (pack == null)
            throw new ApiClientRuntimeException("Invalid bill package provided.");

        BigDecimal price = bill.getPrice();
        if (price == null || price.compareTo(BigDecimal.valueOf(0.01)) < 0)
            throw new ApiClientRuntimeException("Invalid bill price provided.");
    }
}
