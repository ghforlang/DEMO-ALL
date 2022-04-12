package com.edu.nbu.fan.gen.model;

import com.edu.nbu.fan.gen.anno.Transfer;
import com.edu.nbu.fan.gen.anno.TransferColumn;
import com.edu.nbu.fan.gen.contants.TableType;
import java.lang.String;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Transfer(
    sourceType = TableType.SOURCE,
    tableName = "health_record_peopleatomicinfo_df"
)
@Getter
@Setter
public class HealthRecordPeopleatomicinfoDfPO {
  @TransferColumn
  private LocalDateTime etlTime;

  @TransferColumn
  private String id;

  @TransferColumn
  private String peopleId;

  @TransferColumn
  private String atomicCode;

  @TransferColumn
  private String atomicValue;

  @TransferColumn
  private String createdTime;

  @TransferColumn
  private String modifiedTime;

  @TransferColumn
  private String dateId;
}
