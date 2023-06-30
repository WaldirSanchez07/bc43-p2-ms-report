package com.nttdata.msreport.infrastructure.dao.repository;

import com.nttdata.msreport.infrastructure.dao.entity.AverageBalanceEntity;
import com.nttdata.msreport.infrastructure.dao.entity.BalanceEntity;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.time.LocalDateTime;

public interface BalanceRepositoryRM extends ReactiveMongoRepository<BalanceEntity, String> {

  @Query("{ 'accountId': ?0 }")
  Flowable<BalanceEntity> findAllBalances(ObjectId accountId);

  Maybe<BalanceEntity> findFirstByAccountIdOrderByDateDesc(ObjectId accountId);

  @Aggregation(pipeline = {
          "{ $match: { 'accountId': ?0, 'date': {$gte: ?1, $lte: ?2}}}",
          "{ $project: { 'amount': '$amount', 'date': { '$dateToString': { 'format': '%Y-%m-%d', 'date': '$date' } } }}",
          "{ $group: { '_id': '$date', 'average': { '$avg': '$amount' } }}",
          "{ $project: { '_id': 0, 'date': '$_id', 'average': 1 }}"
  })
  Flowable<AverageBalanceEntity> averageBalances(ObjectId accountId, LocalDateTime d1, LocalDateTime d2);

}
