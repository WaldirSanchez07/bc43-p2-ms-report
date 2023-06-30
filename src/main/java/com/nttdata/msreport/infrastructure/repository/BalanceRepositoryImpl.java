package com.nttdata.msreport.infrastructure.repository;

import com.nttdata.msreport.domain.model.AverageBalance;
import com.nttdata.msreport.domain.model.Balance;
import com.nttdata.msreport.domain.repository.BalanceRepository;
import com.nttdata.msreport.infrastructure.dao.repository.BalanceRepositoryRM;
import com.nttdata.msreport.infrastructure.mapper.AverageBalanceMapper;
import com.nttdata.msreport.infrastructure.mapper.BalanceMapper;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.YearMonth;

@Repository
@AllArgsConstructor
public class BalanceRepositoryImpl implements BalanceRepository {

  private final BalanceRepositoryRM balanceRepository;

  @Override
  public Flowable<AverageBalance> findAverageBalances(ObjectId accountId) {
    YearMonth currentYearMonth = YearMonth.now();
    LocalDateTime startOfMonth = currentYearMonth.atDay(1).atStartOfDay();

    YearMonth nextYearMonth = currentYearMonth.plusMonths(1);
    LocalDateTime startOfNextMonth = nextYearMonth.atDay(1).atStartOfDay();

    return balanceRepository
            .averageBalances(accountId, startOfMonth, startOfNextMonth)
            .map(AverageBalanceMapper.INSTANCE::map);
  }

  @Override
  public Maybe<Balance> findAvailableBalance(ObjectId accountId) {
    return balanceRepository
            .findFirstByAccountIdOrderByDateDesc(accountId)
            .map(BalanceMapper.INSTANCE::map);
  }

}
