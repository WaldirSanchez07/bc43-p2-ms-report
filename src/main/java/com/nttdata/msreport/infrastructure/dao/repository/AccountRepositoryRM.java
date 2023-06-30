package com.nttdata.msreport.infrastructure.dao.repository;

import com.nttdata.msreport.infrastructure.dao.entity.AccountEntity;
import io.reactivex.rxjava3.core.Flowable;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AccountRepositoryRM extends ReactiveMongoRepository<AccountEntity, String> {

  @Query("{ 'clientId': ?0 }")
  Flowable<AccountEntity> findAllAccounts(ObjectId clientId);

}
