package com.nttdata.msreport.domain.repository;

import com.nttdata.msreport.domain.model.AverageBalance;
import com.nttdata.msreport.domain.model.Balance;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.bson.types.ObjectId;

public interface BalanceRepository {

  Flowable<AverageBalance> findAverageBalances(ObjectId accountId);
  Maybe<Balance> findAvailableBalance(ObjectId accountId);

}
