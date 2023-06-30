package com.nttdata.msreport.infrastructure.repository;

import com.nttdata.msreport.domain.model.Account;
import com.nttdata.msreport.domain.repository.AccountRepository;
import com.nttdata.msreport.infrastructure.dao.repository.AccountRepositoryRM;
import com.nttdata.msreport.infrastructure.mapper.AccountMapper;
import io.reactivex.rxjava3.core.Flowable;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

  private final AccountRepositoryRM accountRepository;

  @Override
  public Flowable<Account> findAllAccounts(ObjectId clientId) {
    return accountRepository
            .findAllAccounts(clientId)
            .map(AccountMapper.INSTANCE::map);
  }

}
