package com.nttdata.msreport.domain.service;

import com.nttdata.msreport.domain.model.Account;
import io.reactivex.rxjava3.core.Flowable;
import org.bson.types.ObjectId;

public interface AccountService {

  Flowable<Account> findAllAccounts(ObjectId clientId);

}
