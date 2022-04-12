package com.edu.nbu.fan.gen.model;

import com.edu.nbu.fan.gen.anno.Transfer;
import com.edu.nbu.fan.gen.anno.TransferColumn;
import com.edu.nbu.fan.gen.contants.TableType;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Transfer(
    sourceType = TableType.TARGET,
    tableName = "people_atomic_info"
)
@Getter
@Setter
public class PeopleAtomicInfoPO {
  /**
   * 主键
   */
  @TransferColumn(
      tarColumnName = "id",
      tarColumnValue = ""
  )
  private Long id;

  /**
   * 创建时间
   */
  @TransferColumn(
      tarColumnName = "gmt_created",
      tarColumnValue = "created_time"
  )
  private LocalDateTime gmtCreated;

  /**
   * 修改时间
   */
  @TransferColumn(
      tarColumnName = "gmt_modified",
      tarColumnValue = "modified_time"
  )
  private LocalDateTime gmtModified;

  /**
   * 自然人id
   */
  @TransferColumn(
      tarColumnName = "people_id",
      tarColumnValue = "people_id"
  )
  private Long peopleId;

  /**
   * 原子策略code
   */
  @TransferColumn(
      tarColumnName = "atomic_code",
      tarColumnValue = "atomic_code"
  )
  private String atomicCode;

  /**
   * 原子信息内容
   */
  @TransferColumn(
      tarColumnName = "atomic_value",
      tarColumnValue = "atomic_value"
  )
  private String atomicValue;
}
