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
    tableName = "basic_health_info2"
)
@Getter
@Setter
public class BasicHealthInfo2PO {
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
   * 烹饪方式 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "cooking_way",
      tarColumnValue = ""
  )
  private String cookingWay;

  /**
   * 是否打鼾
   */
  @TransferColumn(
      tarColumnName = "is_snoring",
      tarColumnValue = "is_snoring"
  )
  private String isSnoring;

  /**
   * 饮食结构 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "diet_structure",
      tarColumnValue = ""
  )
  private String dietStructure;

  /**
   * 食欲 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "appetite_condition",
      tarColumnValue = "appetite_condition"
  )
  private String appetiteCondition;

  /**
   * 睡眠规律 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "sleeping_patterns",
      tarColumnValue = "sleeping_patterns"
  )
  private String sleepingPatterns;

  /**
   * 遗传病史 值域来源:疾病库
   */
  @TransferColumn(
      tarColumnName = "genetic_history",
      tarColumnValue = ""
  )
  private String geneticHistory;

  /**
   * 现病史 值域来源:疾病库
   */
  @TransferColumn(
      tarColumnName = "present_illness",
      tarColumnValue = ""
  )
  private String presentIllness;

  /**
   * 饮食情况 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "diet_situation",
      tarColumnValue = ""
  )
  private String dietSituation;

  /**
   * 运动频率 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "sport_frequency",
      tarColumnValue = "sport_frequency_name"
  )
  private String sportFrequency;

  /**
   * 睡眠情况 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "sleeping_situation",
      tarColumnValue = "sleeping_situation_name"
  )
  private String sleepingSituation;

  /**
   * 既往史 值域来源:疾病库
   */
  @TransferColumn(
      tarColumnName = "past_illness",
      tarColumnValue = "past_diseases"
  )
  private String pastIllness;

  /**
   * 睡眠问题 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "sleeping_problem",
      tarColumnValue = "sleeping_problem"
  )
  private String sleepingProblem;

  /**
   * 吸烟标识 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "smoking_status",
      tarColumnValue = "smoking_status_name"
  )
  private String smokingStatus;

  /**
   * 用药情况
   */
  @TransferColumn(
      tarColumnName = "medication_situation",
      tarColumnValue = "medication_situation"
  )
  private String medicationSituation;

  /**
   * 饮酒标识 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "drinking_status",
      tarColumnValue = "drinking_status_name"
  )
  private String drinkingStatus;

  /**
   * 烟龄(年)
   */
  @TransferColumn(
      tarColumnName = "smoking_time_length",
      tarColumnValue = "smoking_time_length"
  )
  private Double smokingTimeLength;

  /**
   * 睡眠时长 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "sleeping_hours",
      tarColumnValue = "sleeping_hours_code"
  )
  private String sleepingHours;

  /**
   * 日吸烟量 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "daily_smoke_amount",
      tarColumnValue = ""
  )
  private String dailySmokeAmount;

  /**
   * 在外就餐(每周) 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "eating_out",
      tarColumnValue = ""
  )
  private String eatingOut;

  /**
   * 饮酒年限(年)
   */
  @TransferColumn(
      tarColumnName = "drinking_time_length",
      tarColumnValue = "drinking_time_length"
  )
  private Double drinkingTimeLength;

  /**
   * 医疗保险 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "medicare",
      tarColumnValue = ""
  )
  private String medicare;

  /**
   * 运动类型 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "sport_type",
      tarColumnValue = ""
  )
  private String sportType;

  /**
   * 家庭成员
   */
  @TransferColumn(
      tarColumnName = "family_composition",
      tarColumnValue = "family_composition"
  )
  private String familyComposition;

  /**
   * 常住地址
   */
  @TransferColumn(
      tarColumnName = "permanent_addr",
      tarColumnValue = "address"
  )
  private String permanentAddr;

  /**
   * 紧急联系人-关系 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "emergency_contact_relationship",
      tarColumnValue = "emergency_contact_relationship"
  )
  private String emergencyContactRelationship;

  /**
   * 腰围(cm) 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "waistline",
      tarColumnValue = "waistline"
  )
  private Double waistline;

  /**
   * 次运动时长(min) 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "sport_duration",
      tarColumnValue = "sport_duration"
  )
  private String sportDuration;

  /**
   * 运动坚持时间 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "sport_time_length",
      tarColumnValue = "sport_time_length"
  )
  private String sportTimeLength;

  /**
   * 运动场所 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "sport_venue",
      tarColumnValue = "sport_venue"
  )
  private String sportVenue;

  /**
   * 每日饮水量代码 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "water_intake",
      tarColumnValue = "water_intake"
  )
  private String waterIntake;

  /**
   * 饮水类别代码 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "water_drinking_category",
      tarColumnValue = "water_drinking_category"
  )
  private String waterDrinkingCategory;
}
