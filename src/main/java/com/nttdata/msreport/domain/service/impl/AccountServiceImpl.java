package com.nttdata.msreport.domain.service.impl;

import com.nttdata.msreport.domain.model.Account;
import com.nttdata.msreport.domain.repository.AccountRepository;
import com.nttdata.msreport.domain.service.AccountService;
import io.reactivex.rxjava3.core.Flowable;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;

  @Override
  public Flowable<Account> findAllAccounts(ObjectId clientId) {
    return accountRepository.findAllAccounts(clientId);
  }

}
