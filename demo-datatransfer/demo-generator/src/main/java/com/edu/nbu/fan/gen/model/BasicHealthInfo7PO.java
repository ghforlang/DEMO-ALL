package com.edu.nbu.fan.gen.model;

import com.edu.nbu.fan.gen.anno.Transfer;
import com.edu.nbu.fan.gen.anno.TransferColumn;
import com.edu.nbu.fan.gen.contants.TableType;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Transfer(
    sourceType = TableType.TARGET,
    tableName = "basic_health_info7"
)
@Getter
@Setter
public class BasicHealthInfo7PO {
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
   * 夜宵 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "midnight_snack",
      tarColumnValue = ""
  )
  private String midnightSnack;

  /**
   * 暴饮暴食
   */
  @TransferColumn(
      tarColumnName = "overeating",
      tarColumnValue = ""
  )
  private String overeating;

  /**
   * 聚会应酬 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "dinner_party",
      tarColumnValue = ""
  )
  private String dinnerParty;

  /**
   * 饮食喜好 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "food_preference",
      tarColumnValue = ""
  )
  private String foodPreference;

  /**
   * 主食 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "staple_food",
      tarColumnValue = ""
  )
  private String stapleFood;

  /**
   * 喝牛奶 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "drink_milk",
      tarColumnValue = ""
  )
  private String drinkMilk;

  /**
   * 吃鸡蛋 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "eat_eggs",
      tarColumnValue = ""
  )
  private String eatEggs;

  /**
   * 吃豆制品 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "eat_bean_products",
      tarColumnValue = ""
  )
  private String eatBeanProducts;

  /**
   * 吃蔬菜 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "eat_vegetable",
      tarColumnValue = ""
  )
  private String eatVegetable;

  /**
   * 吃肉 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "eat_meat",
      tarColumnValue = ""
  )
  private String eatMeat;

  /**
   * 吃肥肉 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "eat_fat",
      tarColumnValue = ""
  )
  private String eatFat;

  /**
   * 吃内脏 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "eat_viscera",
      tarColumnValue = ""
  )
  private String eatViscera;

  /**
   * 吃海鲜 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "eat_seafood",
      tarColumnValue = ""
  )
  private String eatSeafood;

  /**
   * 喝咖啡 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "drink_coffee",
      tarColumnValue = ""
  )
  private String drinkCoffee;

  /**
   * 喝含糖饮料 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "drink_sugary_drinks",
      tarColumnValue = ""
  )
  private String drinkSugaryDrinks;

  /**
   * 体检频率 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "frequency_of_physical_examination",
      tarColumnValue = ""
  )
  private String frequencyOfPhysicalExamination;

  /**
   * 学习保健知识 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "learn_health_care",
      tarColumnValue = ""
  )
  private String learnHealthCare;

  /**
   * 学习保健知识途径 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "learn_health_care_ways",
      tarColumnValue = ""
  )
  private String learnHealthCareWays;

  /**
   * 系安全带 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "fasten_seat_belt",
      tarColumnValue = ""
  )
  private String fastenSeatBelt;

  /**
   * 观察排泄物 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "observe_excrement",
      tarColumnValue = ""
  )
  private String observeExcrement;

  /**
   * 监测血压 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "monitor_blood_pressure",
      tarColumnValue = ""
  )
  private String monitorBloodPressure;

  /**
   * 携带急救药品 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "bring_emergency_medicine",
      tarColumnValue = ""
  )
  private String bringEmergencyMedicine;

  /**
   * 晒太阳 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "bask_in_the_sun",
      tarColumnValue = ""
  )
  private String baskInTheSun;

  /**
   * 血压认知 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "blood_pressure_cognition",
      tarColumnValue = ""
  )
  private String bloodPressureCognition;

  /**
   * 体温认知 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "temperature_cognition",
      tarColumnValue = ""
  )
  private String temperatureCognition;

  /**
   * 脉搏认知 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "pulse_cognition",
      tarColumnValue = ""
  )
  private String pulseCognition;

  /**
   * 食盐量认知 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "salinity_cognition",
      tarColumnValue = ""
  )
  private String salinityCognition;

  /**
   * 体质指数认知 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "bmi_cognition",
      tarColumnValue = ""
  )
  private String bmiCognition;

  /**
   * 男性腰围认知 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "male_waist_cognition",
      tarColumnValue = ""
  )
  private String maleWaistCognition;

  /**
   * 女性腰围认知 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "female_waist_cognition",
      tarColumnValue = ""
  )
  private String femaleWaistCognition;

  /**
   * 血糖认知 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "blood_sugar_cognition",
      tarColumnValue = ""
  )
  private String bloodSugarCognition;
}
