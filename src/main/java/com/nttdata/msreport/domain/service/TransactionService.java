package com.nttdata.msreport.domain.service;

import com.nttdata.msreport.domain.model.Transaction;
import io.reactivex.rxjava3.core.Flowable;
import org.bson.types.ObjectId;

public interface TransactionService {

  Flowable<Transaction> findTransactions(ObjectId accountId);
  Flowable<Transaction> findCommissionsCurrentMonth(ObjectId accountId);

}
