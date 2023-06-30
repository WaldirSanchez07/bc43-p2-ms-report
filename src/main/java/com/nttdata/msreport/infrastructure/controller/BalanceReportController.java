package com.nttdata.msreport.infrastructure.controller;

import com.nttdata.msreport.application.dto.response.ObjectResponse;
import com.nttdata.msreport.application.service.BalanceReportExternalService;
import com.nttdata.msreport.infrastructure.repository.BalanceRepositoryImpl;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/reports/balances")
public class BalanceReportController {

  private final BalanceReportExternalService reportService;
  private final BalanceRepositoryImpl test;

  @GetMapping(value = "/available", params = "accountId", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Maybe<ObjectResponse> balanceAvailable(@RequestParam String accountId) {
    ObjectId objectId = new ObjectId(accountId);
    return reportService.balanceAvailableByProduct(objectId);
  }

  @GetMapping(value = "/average", params = "accountId", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flowable<ObjectResponse> averageBalances(@RequestParam String accountId) {
    ObjectId objectId = new ObjectId(accountId);
    return reportService.averageBalancesByProduct(objectId);
  }

}
