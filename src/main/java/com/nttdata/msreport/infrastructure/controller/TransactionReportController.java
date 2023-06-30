package com.nttdata.msreport.infrastructure.controller;

import com.nttdata.msreport.application.dto.response.ObjectResponse;
import com.nttdata.msreport.application.service.impl.TransactionReportExternalServiceImpl;
import io.reactivex.rxjava3.core.Flowable;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/reports/transactions")
public class TransactionReportController {

  private final TransactionReportExternalServiceImpl reportService;

  @GetMapping(value = "/list", params = "accountId", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flowable<ObjectResponse> transactionsByProduct(@RequestParam String accountId) {
    ObjectId objectId = new ObjectId(accountId);
    return reportService.transactionsByProduct(objectId);
  }

  @GetMapping(value = "/commissions", params = "accountId", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flowable<ObjectResponse> commissionsByProduct(@RequestParam String accountId) {
    ObjectId objectId = new ObjectId(accountId);
    return reportService.commissionsByProduct(objectId);
  }

}
