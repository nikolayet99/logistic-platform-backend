package nt.logisticplatform.repository;

import nt.logisticplatform.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface FinanceRepository extends JpaRepository<Bill, Long> {
    @Query(value = "SELECT SUM(b.price) FROM Bill b WHERE b.date_created BETWEEN ?1 AND ?2", nativeQuery = true)
    Double findTotalProfitByDateInterval(LocalDate startDate, LocalDate endDate);
}