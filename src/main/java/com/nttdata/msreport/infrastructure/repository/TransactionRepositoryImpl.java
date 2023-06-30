package com.nttdata.msreport.infrastructure.repository;

import com.nttdata.msreport.domain.model.Transaction;
import com.nttdata.msreport.domain.repository.TransactionRepository;
import com.nttdata.msreport.infrastructure.dao.repository.TransactionRepositoryRM;
import io.reactivex.rxjava3.core.Flowable;
import java.time.LocalDateTime;
import java.time.YearMonth;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {

  private final TransactionRepositoryRM transactionRepository;

  @Override
  public Flowable<Transaction> findTransactions(ObjectId accountId) {
    return transactionRepository.findTransactions(accountId);
  }

  @Override
  public Flowable<Transaction> findCommissionsCurrentMonth(ObjectId accountId) {
    YearMonth currentYearMonth = YearMonth.now();
    LocalDateTime startOfMonth = currentYearMonth.atDay(1).atStartOfDay();

    YearMonth nextYearMonth = currentYearMonth.plusMonths(1);
    LocalDateTime startOfNextMonth = nextYearMonth.atDay(1).atStartOfDay();

    return transactionRepository
            .findByAccountIdAndTypeAndDateBetween(
                    accountId,
                    "Comision",
                    startOfMonth,
                    startOfNextMonth
            );
  }

}
