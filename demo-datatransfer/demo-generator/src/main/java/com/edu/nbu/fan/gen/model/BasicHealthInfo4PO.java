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
    tableName = "basic_health_info4"
)
@Getter
@Setter
public class BasicHealthInfo4PO {
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
   * 个人基本信息备注
   */
  @TransferColumn(
      tarColumnName = "personal_basic_info_remark",
      tarColumnValue = "personal_basic_info_remark"
  )
  private String personalBasicInfoRemark;

  /**
   * 饮食是否规律
   */
  @TransferColumn(
      tarColumnName = "is_dietary_pattern_regular",
      tarColumnValue = "is_dietary_pattern_regular"
  )
  private String isDietaryPatternRegular;

  /**
   * 饮水习惯 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "hydration_liquid_type",
      tarColumnValue = "hydration_liquid_type"
  )
  private String hydrationLiquidType;

  /**
   * 吸烟备注
   */
  @TransferColumn(
      tarColumnName = "smoking_remark",
      tarColumnValue = "smoking_remark"
  )
  private String smokingRemark;

  /**
   * 入睡时长 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "time_to_fall_asleep",
      tarColumnValue = "time_to_fall_asleep"
  )
  private String timeToFallAsleep;

  /**
   * 是否午睡
   */
  @TransferColumn(
      tarColumnName = "is_siesta_taking",
      tarColumnValue = "is_siesta_taking"
  )
  private String isSiestaTaking;

  /**
   * 监护人与本人关系代码 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "guardian_relationship",
      tarColumnValue = "guardian_relationship"
  )
  private String guardianRelationship;

  /**
   * 出生孕周(d)
   */
  @TransferColumn(
      tarColumnName = "birth_gestational_weeks",
      tarColumnValue = "birth_gestational_weeks"
  )
  private Integer birthGestationalWeeks;

  /**
   * 分娩方式代码 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "delivery_mode",
      tarColumnValue = "delivery_mode"
  )
  private String deliveryMode;

  /**
   * 出生体重(g)
   */
  @TransferColumn(
      tarColumnName = "birth_weight",
      tarColumnValue = "birth_weight"
  )
  private Double birthWeight;

  /**
   * 窒息标志
   */
  @TransferColumn(
      tarColumnName = "asphyxia_flag",
      tarColumnValue = "asphyxia_flag"
  )
  private String asphyxiaFlag;

  /**
   * 抬头月龄(月)
   */
  @TransferColumn(
      tarColumnName = "head_holding_up_age",
      tarColumnValue = "head_holding_up_age"
  )
  private Integer headHoldingUpAge;

  /**
   * 婴幼儿独坐月龄(月)
   */
  @TransferColumn(
      tarColumnName = "sitting_age",
      tarColumnValue = "sitting_age"
  )
  private Integer sittingAge;

  /**
   * 爬行月龄(月)
   */
  @TransferColumn(
      tarColumnName = "crawling_age",
      tarColumnValue = "crawling_age"
  )
  private Integer crawlingAge;

  /**
   * 站立月龄
   */
  @TransferColumn(
      tarColumnName = "standing_age",
      tarColumnValue = "standing_age"
  )
  private Integer standingAge;

  /**
   * 行走月龄
   */
  @TransferColumn(
      tarColumnName = "walking_age",
      tarColumnValue = "walking_age"
  )
  private Integer walkingAge;

  /**
   * 断母乳喂养月龄
   */
  @TransferColumn(
      tarColumnName = "breastfeeding_stop_age",
      tarColumnValue = "breastfeeding_stop_age"
  )
  private Integer breastfeedingStopAge;

  /**
   * 辅食添加月龄
   */
  @TransferColumn(
      tarColumnName = "solid_food_introduction_age",
      tarColumnValue = "solid_food_introduction_age"
  )
  private Integer solidFoodIntroductionAge;

  /**
   * 腹泻频率 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "diarrhea_attack_frequency",
      tarColumnValue = "diarrhea_attack_frequency"
  )
  private String diarrheaAttackFrequency;

  /**
   * 儿童大便性状代码 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "baby_stool_form_scale",
      tarColumnValue = "baby_stool_form_scale"
  )
  private String babyStoolFormScale;

  /**
   * 儿童饮品 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "child_hydration_liquid_type",
      tarColumnValue = "child_hydration_liquid_type"
  )
  private String childHydrationLiquidType;

  /**
   * 喂养方式类别代码 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "feeding_patterns",
      tarColumnValue = "feeding_patterns"
  )
  private String feedingPatterns;

  /**
   * 饮食备注
   */
  @TransferColumn(
      tarColumnName = "dietary_remark",
      tarColumnValue = "dietary_remark"
  )
  private String dietaryRemark;

  /**
   * 入睡时间 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "time_to_sleep",
      tarColumnValue = "time_to_sleep"
  )
  private String timeToSleep;

  /**
   * Apgar评分值(分)
   */
  @TransferColumn(
      tarColumnName = "apgar",
      tarColumnValue = "apgar"
  )
  private String apgar;

  /**
   * 饮酒种类代码 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "drinking_classification",
      tarColumnValue = ""
  )
  private String drinkingClassification;

  /**
   * 过敏史 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "allergies_history",
      tarColumnValue = ""
  )
  private String allergiesHistory;

  /**
   * 绝经年龄(岁)
   */
  @TransferColumn(
      tarColumnName = "menopause_date",
      tarColumnValue = "menopause_date"
  )
  private String menopauseDate;

  /**
   * 呼吸频率(次min)
   */
  @TransferColumn(
      tarColumnName = "respiratory_rate",
      tarColumnValue = "respiratory_rate"
  )
  private Integer respiratoryRate;

  /**
   * 厨房排风设施类别代码
   */
  @TransferColumn(
      tarColumnName = "kitchen_air_exaust_facilities_category",
      tarColumnValue = "kitchen_air_exaust_facilities_category"
  )
  private String kitchenAirExaustFacilitiesCategory;

  /**
   * 燃料类型类别代码
   */
  @TransferColumn(
      tarColumnName = "fuel_type",
      tarColumnValue = "fuel_type"
  )
  private String fuelType;
}
