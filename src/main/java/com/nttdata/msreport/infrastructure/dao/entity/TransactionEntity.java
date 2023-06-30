package com.nttdata.msreport.infrastructure.dao.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "transactions")
public class TransactionEntity {

  private String id;
  private String type;
  private String description;
  private ObjectId accountId;
  private ObjectId anotherAccountId;
  private Double amount;
  private LocalDateTime date;

}
