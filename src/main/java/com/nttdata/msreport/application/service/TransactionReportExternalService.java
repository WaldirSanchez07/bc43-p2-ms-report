package com.nttdata.msreport.application.service;

import com.nttdata.msreport.application.dto.response.ObjectResponse;
import io.reactivex.rxjava3.core.Flowable;
import org.bson.types.ObjectId;

public interface TransactionReportExternalService {

  Flowable<ObjectResponse> transactionsByProduct(ObjectId accountId);
  Flowable<ObjectResponse> commissionsByProduct(ObjectId accountId);

}
