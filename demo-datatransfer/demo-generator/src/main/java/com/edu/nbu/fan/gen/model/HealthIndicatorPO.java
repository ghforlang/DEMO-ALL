package com.edu.nbu.fan.gen.model;

import com.edu.nbu.fan.gen.anno.Transfer;
import com.edu.nbu.fan.gen.anno.TransferColumn;
import com.edu.nbu.fan.gen.contants.TableType;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Transfer(
    sourceType = TableType.TARGET,
    tableName = "health_indicator"
)
@Getter
@Setter
public class HealthIndicatorPO {
  /**
   * 自增主键（不允许业务上使用）
   */
  @TransferColumn(
      tarColumnName = "pk_id",
      tarColumnValue = ""
  )
  private Long pkId;

  /**
   * 用来业务上唯一识别该条数据
   */
  @TransferColumn(
      tarColumnName = "id",
      tarColumnValue = "biz_id"
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
   * 最后修改时间
   */
  @TransferColumn(
      tarColumnName = "gmt_modified",
      tarColumnValue = "modified_time"
  )
  private LocalDateTime gmtModified;

  /**
   * 逻辑删除时间
   */
  @TransferColumn(
      tarColumnName = "gmt_deleted",
      tarColumnValue = "'9999-12-3123:59:59'"
  )
  private LocalDateTime gmtDeleted;

  /**
   * 1 表示删除，0 表示未删除（该字段仅作为数据逻辑删除使用，不应在程序侧发生二次更新。）
   */
  @TransferColumn(
      tarColumnName = "is_deleted",
      tarColumnValue = "is_deleted"
  )
  private Integer isDeleted;

  /**
   * 患者主索引id
   */
  @TransferColumn(
      tarColumnName = "people_id",
      tarColumnValue = "people_id"
  )
  private Long peopleId;

  /**
   * 数据唯一标识，如果数据来自外部抽取或同步为source#外部id,否则为source#id
   */
  @TransferColumn(
      tarColumnName = "source_unique_key",
      tarColumnValue = "biz_id"
  )
  private String sourceUniqueKey;

  /**
   * 数据来源标识
   */
  @TransferColumn(
      tarColumnName = "source",
      tarColumnValue = "'hc_0'"
  )
  private String source;

  /**
   * 设备型号
   */
  @TransferColumn(
      tarColumnName = "device_model",
      tarColumnValue = "device_model"
  )
  private String deviceModel;

  /**
   * 蓝牙地址
   */
  @TransferColumn(
      tarColumnName = "bluetooth_addr",
      tarColumnValue = "bluetooth_addr"
  )
  private String bluetoothAddr;

  /**
   * 设备序列号
   */
  @TransferColumn(
      tarColumnName = "device_serial",
      tarColumnValue = "device_serial"
  )
  private String deviceSerial;

  /**
   * 测量地点
   */
  @TransferColumn(
      tarColumnName = "measure_address",
      tarColumnValue = "measure_address"
  )
  private String measureAddress;

  /**
   * 测量地点的经度
   */
  @TransferColumn(
      tarColumnName = "measure_longitude",
      tarColumnValue = "measure_longitude"
  )
  private Double measureLongitude;

  /**
   * 测量地点的维度
   */
  @TransferColumn(
      tarColumnName = "measure_latitude",
      tarColumnValue = "measure_latitude"
  )
  private Double measureLatitude;

  /**
   * 体温（摄氏度）
   */
  @TransferColumn(
      tarColumnName = "temperature",
      tarColumnValue = "temperature"
  )
  private Double temperature;

  /**
   * 体温状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "temperature_status",
      tarColumnValue = "temperature_status"
  )
  private Integer temperatureStatus;

  /**
   * 呼吸频率（次/min）
   */
  @TransferColumn(
      tarColumnName = "respiratory_rate",
      tarColumnValue = "respiratory_rate"
  )
  private Integer respiratoryRate;

  /**
   * 呼吸频率（次/min）状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "respiratory_rate_status",
      tarColumnValue = "respiratory_rate_status"
  )
  private Integer respiratoryRateStatus;

  /**
   * 血压测量时间标签
   */
  @TransferColumn(
      tarColumnName = "blood_pressure_measure_time_label",
      tarColumnValue = "blood_pressure_measure_time_label"
  )
  private Integer bloodPressureMeasureTimeLabel;

  /**
   * 收缩压(mmHg）
   */
  @TransferColumn(
      tarColumnName = "systolic_pressure",
      tarColumnValue = "systolic_pressure"
  )
  private Double systolicPressure;

  /**
   * 收缩压(mmHg）状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "systolic_pressure_status",
      tarColumnValue = "systolic_pressure_status"
  )
  private Integer systolicPressureStatus;

  /**
   * 舒张压(mmHg）
   */
  @TransferColumn(
      tarColumnName = "diastolic_pressure",
      tarColumnValue = "diastolic_pressure"
  )
  private Double diastolicPressure;

  /**
   * 舒张压(mmHg）状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "diastolic_pressure_status",
      tarColumnValue = "diastolic_pressure_status"
  )
  private Integer diastolicPressureStatus;

  /**
   * 脉搏（次/min）
   */
  @TransferColumn(
      tarColumnName = "pulse_rate",
      tarColumnValue = "pulse_rate"
  )
  private Integer pulseRate;

  /**
   * 脉搏（次/min）状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "pulse_rate_status",
      tarColumnValue = "pulserate_status"
  )
  private Integer pulseRateStatus;

  /**
   * 心率 （次/min）
   */
  @TransferColumn(
      tarColumnName = "heart_rate",
      tarColumnValue = "heart_rate"
  )
  private Integer heartRate;

  /**
   * 身高（cm）
   */
  @TransferColumn(
      tarColumnName = "height",
      tarColumnValue = "height"
  )
  private Double height;

  /**
   * 体重(kg）
   */
  @TransferColumn(
      tarColumnName = "weight",
      tarColumnValue = "weight"
  )
  private Double weight;

  /**
   * BMI指数 体质指数
   */
  @TransferColumn(
      tarColumnName = "body_mass_index",
      tarColumnValue = "body_mass_index"
  )
  private Double bodyMassIndex;

  /**
   * BMI指数 体质指数状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "body_mass_index_status",
      tarColumnValue = "body_mass_index_status"
  )
  private Integer bodyMassIndexStatus;

  /**
   * 血糖测量时间标签
   */
  @TransferColumn(
      tarColumnName = "measure_time_label",
      tarColumnValue = "measure_time_label"
  )
  private Integer measureTimeLabel;

  /**
   * 血糖
   */
  @TransferColumn(
      tarColumnName = "blood_sugar",
      tarColumnValue = "blood_sugar"
  )
  private Double bloodSugar;

  /**
   * 血糖状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "blood_sugar_status",
      tarColumnValue = "blood_sugar_status"
  )
  private Integer bloodSugarStatus;

  /**
   * 血氧饱和度（%）
   */
  @TransferColumn(
      tarColumnName = "oxygen_saturation",
      tarColumnValue = "oxygen_saturation"
  )
  private Integer oxygenSaturation;

  /**
   * 血氧饱和度（%）状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "oxygen_saturation_status",
      tarColumnValue = "oxygen_saturation_status"
  )
  private Integer oxygenSaturationStatus;

  /**
   * 腰围
   */
  @TransferColumn(
      tarColumnName = "waist",
      tarColumnValue = "waist"
  )
  private Double waist;

  /**
   * 体脂率
   */
  @TransferColumn(
      tarColumnName = "body_fat",
      tarColumnValue = "bodyfat"
  )
  private Integer bodyFat;

  /**
   * 体脂率%
   */
  @TransferColumn(
      tarColumnName = "body_fat_rate",
      tarColumnValue = "bodyfat_rate"
  )
  private Double bodyFatRate;

  @TransferColumn(
      tarColumnName = "biz_labels",
      tarColumnValue = "biz_labels_data"
  )
  private Long bizLabels;
}
