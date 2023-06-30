package com.nttdata.msreport.domain.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

  private String id;
  private String type;
  private String description;
  private ObjectId accountId;
  private ObjectId anotherAccountId;
  private Double amount;
  private LocalDateTime date;

}
