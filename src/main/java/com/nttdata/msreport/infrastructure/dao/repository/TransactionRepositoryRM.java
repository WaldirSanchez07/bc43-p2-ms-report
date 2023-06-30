package com.nttdata.msreport.infrastructure.dao.repository;

import com.nttdata.msreport.domain.model.Transaction;
import com.nttdata.msreport.infrastructure.dao.entity.TransactionEntity;
import io.reactivex.rxjava3.core.Flowable;
import java.time.LocalDateTime;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionRepositoryRM extends ReactiveMongoRepository<TransactionEntity, String> {

  @Query("{$or: [{'accountId': ?0}, {'anotherAccountId': ?0}]}")
  Flowable<Transaction> findTransactions(ObjectId accountId);

  Flowable<Transaction> findByAccountIdAndTypeAndDateBetween(
          ObjectId accountId,
          String type,
          LocalDateTime startOfMonth,
          LocalDateTime startOfNextMonth
  );

}
