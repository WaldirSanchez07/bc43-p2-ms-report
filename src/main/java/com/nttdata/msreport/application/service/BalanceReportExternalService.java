package com.nttdata.msreport.application.service;

import com.nttdata.msreport.application.dto.response.ObjectResponse;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.bson.types.ObjectId;

public interface BalanceReportExternalService {

  Maybe<ObjectResponse> balanceAvailableByProduct(ObjectId accountId);
  Flowable<ObjectResponse> averageBalancesByProduct(ObjectId clientId);

}
