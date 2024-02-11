package nt.logisticplatform.controller;

import io.swagger.v3.oas.annotations.Operation;
import nt.logisticplatform.model.Profit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@RequestMapping("/api/finance")
public interface FinanceController {
    @GetMapping("/totalprofit")
    @Operation(tags = {"Finance"}, summary = "Get total profit")
    Profit getTotalProfitByDateInterval(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate);
}
