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
    tableName = "basic_health_info3"
)
@Getter
@Setter
public class BasicHealthInfo3PO {
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
      tarColumnValue = "id"
  )
  private Long id;

  /**
   * 创建时间
   */
  @TransferColumn(
      tarColumnName = "gmt_created",
      tarColumnValue = "NOW()"
  )
  private LocalDateTime gmtCreated;

  /**
   * 最后修改时间
   */
  @TransferColumn(
      tarColumnName = "gmt_modified",
      tarColumnValue = "NOW()"
  )
  private LocalDateTime gmtModified;

  /**
   * 逻辑删除时间
   */
  @TransferColumn(
      tarColumnName = "gmt_deleted",
      tarColumnValue = "gmt_deleted"
  )
  private LocalDateTime gmtDeleted;

  /**
   * 1 表示删除，0 表示未删除（该字段仅作为数据逻辑删除使用，不应在程序侧发生二次更新。）
   */
  @TransferColumn(
      tarColumnName = "is_deleted",
      tarColumnValue = "0"
  )
  private Integer isDeleted;

  /**
   * 来源标识
   */
  @TransferColumn(
      tarColumnName = "source",
      tarColumnValue = "source"
  )
  private String source;

  /**
   * 数据唯一标识，如果数据来自外部抽取或同步为source#外部id,否则为source#id
   */
  @TransferColumn(
      tarColumnName = "source_unique_key",
      tarColumnValue = "source_unique_key"
  )
  private String sourceUniqueKey;

  /**
   * 患者主索引id
   */
  @TransferColumn(
      tarColumnName = "people_id",
      tarColumnValue = "people_id"
  )
  private Long peopleId;

  /**
   * 早餐
   */
  @TransferColumn(
      tarColumnName = "breakfast",
      tarColumnValue = "breakfast"
  )
  private String breakfast;

  /**
   * 午餐
   */
  @TransferColumn(
      tarColumnName = "lunch",
      tarColumnValue = "lunch"
  )
  private String lunch;

  /**
   * 晚餐
   */
  @TransferColumn(
      tarColumnName = "dinner",
      tarColumnValue = "dinner"
  )
  private String dinner;

  /**
   * 是否加餐
   */
  @TransferColumn(
      tarColumnName = "is_snacks",
      tarColumnValue = "is_snacks"
  )
  private String isSnacks;

  /**
   * 身份证件类别代码 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "id_card_type",
      tarColumnValue = "id_card_type"
  )
  private String idCardType;

  /**
   * 年龄
   */
  @TransferColumn(
      tarColumnName = "age",
      tarColumnValue = "age"
  )
  private String age;

  /**
   * 国籍 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "citizenship",
      tarColumnValue = "citizenship"
  )
  private String citizenship;

  /**
   * 民族
   */
  @TransferColumn(
      tarColumnName = "nation",
      tarColumnValue = "nation"
  )
  private String nation;

  /**
   * 体温(℃)
   */
  @TransferColumn(
      tarColumnName = "temperature",
      tarColumnValue = "temperature"
  )
  private Double temperature;

  /**
   * 脉率(次min)
   */
  @TransferColumn(
      tarColumnName = "pulse_rate",
      tarColumnValue = ""
  )
  private Integer pulseRate;

  /**
   * 收缩压(mmHg）
   */
  @TransferColumn(
      tarColumnName = "systolic_pressure",
      tarColumnValue = "systolic_pressure"
  )
  private Double systolicPressure;

  /**
   * 舒张压(mmHg)
   */
  @TransferColumn(
      tarColumnName = "diastolic_pressure",
      tarColumnValue = "diastolic_pressure"
  )
  private Double diastolicPressure;

  /**
   * 体质指数
   */
  @TransferColumn(
      tarColumnName = "body_mass_index",
      tarColumnValue = "body_mass_index"
  )
  private Double bodyMassIndex;

  /**
   * 血氧饱和度
   */
  @TransferColumn(
      tarColumnName = "oxygen_saturation",
      tarColumnValue = "oxygen_saturation"
  )
  private Integer oxygenSaturation;

  /**
   * 餐后两小时血糖值(mmolL)
   */
  @TransferColumn(
      tarColumnName = "blood_glucose",
      tarColumnValue = "blood_glucose"
  )
  private Double bloodGlucose;

  /**
   * 个人史
   */
  @TransferColumn(
      tarColumnName = "personal_history",
      tarColumnValue = "personal_history"
  )
  private String personalHistory;

  /**
   * 戒酒时长
   */
  @TransferColumn(
      tarColumnName = "time_to_quit_drinking",
      tarColumnValue = ""
  )
  private Integer timeToQuitDrinking;

  /**
   * 戒烟时长
   */
  @TransferColumn(
      tarColumnName = "time_to_quit_smoking",
      tarColumnValue = ""
  )
  private Integer timeToQuitSmoking;

  /**
   * 职业病危害因素接触史
   */
  @TransferColumn(
      tarColumnName = "exposure_history_of_occupational_disease_hazards",
      tarColumnValue = "exposure_history_of_occupational_disease_hazards"
  )
  private String exposureHistoryOfOccupationalDiseaseHazards;

  /**
   * 从事职业工种描述
   */
  @TransferColumn(
      tarColumnName = "job_description",
      tarColumnValue = "job_description"
  )
  private String jobDescription;

  /**
   * 从业年龄
   */
  @TransferColumn(
      tarColumnName = "working_age",
      tarColumnValue = "working_age"
  )
  private Integer workingAge;

  /**
   * 职业防护措施
   */
  @TransferColumn(
      tarColumnName = "protective_measures",
      tarColumnValue = "protective_measures"
  )
  private String protectiveMeasures;

  /**
   * 职业病危害因素类别代码 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "occupational_hazard_factor_category_code",
      tarColumnValue = "occupational_hazard_factor_category_code"
  )
  private String occupationalHazardFactorCategoryCode;

  /**
   * 职业防护措施标志
   */
  @TransferColumn(
      tarColumnName = "protective_measures_status",
      tarColumnValue = "protective_measures_status"
  )
  private String protectiveMeasuresStatus;

  /**
   * 主要就诊医院
   */
  @TransferColumn(
      tarColumnName = "main_hospital",
      tarColumnValue = ""
  )
  private String mainHospital;

  /**
   * 个人习惯
   */
  @TransferColumn(
      tarColumnName = "personal_habit",
      tarColumnValue = ""
  )
  private String personalHabit;

  /**
   * 特殊人群标签 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "special_crowd_label",
      tarColumnValue = ""
  )
  private String specialCrowdLabel;

  /**
   * 饮酒备注
   */
  @TransferColumn(
      tarColumnName = "drinking_remark",
      tarColumnValue = "drinking_remark"
  )
  private String drinkingRemark;

  /**
   * 电子邮件地址
   */
  @TransferColumn(
      tarColumnName = "email",
      tarColumnValue = "email"
  )
  private String email;

  /**
   * 绝经标志
   */
  @TransferColumn(
      tarColumnName = "menopause",
      tarColumnValue = "menopause"
  )
  private String menopause;

  /**
   * 运动备注
   */
  @TransferColumn(
      tarColumnName = "sport_remark",
      tarColumnValue = "sport_remark"
  )
  private String sportRemark;
}
