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
    tableName = "health_record_hba1c_df"
)
@Getter
@Setter
public class HealthRecordHba1cDfPO {
  @TransferColumn
  private LocalDateTime etlTime;

  @TransferColumn
  private String id;

  @TransferColumn
  private String bizId;

  @TransferColumn
  private String peopleId;

  @TransferColumn
  private String sourceUniqueKey;

  @TransferColumn
  private String source;

  @TransferColumn
  private String sourceCreatedTime;

  @TransferColumn
  private String sourceModifiedTime;

  @TransferColumn
  private String createdTime;

  @TransferColumn
  private String modifiedTime;

  @TransferColumn
  private String isDeleted;

  @TransferColumn
  private String name;

  @TransferColumn
  private String age;

  @TransferColumn
  private String gender;

  @TransferColumn
  private String measureTime;

  @TransferColumn
  private String hbA1c;

  @TransferColumn
  private String hbA1cStatus;

  @TransferColumn
  private String label;

  @TransferColumn
  private String dateId;
}
