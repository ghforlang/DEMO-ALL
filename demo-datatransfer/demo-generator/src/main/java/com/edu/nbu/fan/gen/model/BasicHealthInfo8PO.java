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
    tableName = "basic_health_info8"
)
@Getter
@Setter
public class BasicHealthInfo8PO {
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
   * 甘油三酯认知 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "triglyceride_cognition",
      tarColumnValue = ""
  )
  private String triglycerideCognition;

  /**
   * 总胆固醇认知 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "cholesterol_cognition",
      tarColumnValue = ""
  )
  private String cholesterolCognition;

  /**
   * 身体状况 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "physical_conditions",
      tarColumnValue = ""
  )
  private String physicalConditions;

  /**
   * 吃水果 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "eat_fruit",
      tarColumnValue = ""
  )
  private String eatFruit;

  /**
   * 医疗费用支付方式代码 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "payment_method",
      tarColumnValue = ""
  )
  private String paymentMethod;

  /**
   * 输血史标志
   */
  @TransferColumn(
      tarColumnName = "blood_transfusion_flag",
      tarColumnValue = ""
  )
  private String bloodTransfusionFlag;

  /**
   * 体脂率%
   */
  @TransferColumn(
      tarColumnName = "body_fat_rate",
      tarColumnValue = ""
  )
  private Double bodyFatRate;

  /**
   * 肌肉含量
   */
  @TransferColumn(
      tarColumnName = "muscle_content",
      tarColumnValue = ""
  )
  private Double muscleContent;

  /**
   * 体水分率
   */
  @TransferColumn(
      tarColumnName = "body_water_rate",
      tarColumnValue = ""
  )
  private Double bodyWaterRate;

  /**
   * 内脏脂肪
   */
  @TransferColumn(
      tarColumnName = "visceral_fat",
      tarColumnValue = ""
  )
  private Double visceralFat;

  /**
   * 糖尿病类型 枚举：1型糖尿病、2型糖尿病、妊娠糖尿病、其他
   */
  @TransferColumn(
      tarColumnName = "diabetes_type",
      tarColumnValue = ""
  )
  private String diabetesType;

  /**
   * 糖尿病确诊时间
   */
  @TransferColumn(
      tarColumnName = "diabetes_diagnosis_time",
      tarColumnValue = ""
  )
  private String diabetesDiagnosisTime;

  /**
   * 糖尿病症状
   */
  @TransferColumn(
      tarColumnName = "diabetes_symptoms",
      tarColumnValue = ""
  )
  private String diabetesSymptoms;

  /**
   * 是否发生过低血糖
   */
  @TransferColumn(
      tarColumnName = "is_ever_hypoglycemia",
      tarColumnValue = ""
  )
  private String isEverHypoglycemia;

  /**
   * 近一个月发生过低血糖(数值)
   */
  @TransferColumn(
      tarColumnName = "nearly_month_hypoglycemia",
      tarColumnValue = ""
  )
  private Double nearlyMonthHypoglycemia;

  /**
   * 发生低血糖时如何处理
   */
  @TransferColumn(
      tarColumnName = "deal_with_hypoglycemia",
      tarColumnValue = ""
  )
  private String dealWithHypoglycemia;

  /**
   * 合并症/并发症
   */
  @TransferColumn(
      tarColumnName = "complication",
      tarColumnValue = ""
  )
  private String complication;

  /**
   * 高血压类型 高血压1级、高血压2级、高血压3级
   */
  @TransferColumn(
      tarColumnName = "hypertension_type",
      tarColumnValue = ""
  )
  private String hypertensionType;

  /**
   * 高血压确诊时间
   */
  @TransferColumn(
      tarColumnName = "hypertension_diagnosis_time",
      tarColumnValue = ""
  )
  private String hypertensionDiagnosisTime;

  /**
   * 是否有早发心血管疾病家族史
   */
  @TransferColumn(
      tarColumnName = "is_early_cardiovascular_disease",
      tarColumnValue = ""
  )
  private String isEarlyCardiovascularDisease;

  /**
   * 高血脂确诊时间
   */
  @TransferColumn(
      tarColumnName = "hyperlipidemia_diagnosis_time",
      tarColumnValue = ""
  )
  private String hyperlipidemiaDiagnosisTime;

  /**
   * 高血脂症状
   */
  @TransferColumn(
      tarColumnName = "hyperlipidemia_symptoms",
      tarColumnValue = ""
  )
  private String hyperlipidemiaSymptoms;

  /**
   * 高尿酸确诊时间
   */
  @TransferColumn(
      tarColumnName = "high_uric_acid_diagnosis_time",
      tarColumnValue = ""
  )
  private String highUricAcidDiagnosisTime;

  /**
   * 尿酸(数值)
   */
  @TransferColumn(
      tarColumnName = "uric_acid",
      tarColumnValue = ""
  )
  private Double uricAcid;

  /**
   * 尿酸检查时间
   */
  @TransferColumn(
      tarColumnName = "uric_acid_check_time",
      tarColumnValue = ""
  )
  private String uricAcidCheckTime;

  /**
   * 既往尿酸最高值(数值)
   */
  @TransferColumn(
      tarColumnName = "uric_acid_past_max",
      tarColumnValue = ""
  )
  private Double uricAcidPastMax;

  /**
   * 是否服用降尿酸药物
   */
  @TransferColumn(
      tarColumnName = "is_taking_uric_acid_drug",
      tarColumnValue = ""
  )
  private String isTakingUricAcidDrug;

  /**
   * 高体重确诊时间
   */
  @TransferColumn(
      tarColumnName = "high_weight_diagnosis_time",
      tarColumnValue = ""
  )
  private String highWeightDiagnosisTime;

  /**
   * 曾经进行减肥药物或手术治疗 从没有、过去进行过目前没有、目前正在进行
   */
  @TransferColumn(
      tarColumnName = "weight_loss_medication_or_surgery",
      tarColumnValue = ""
  )
  private String weightLossMedicationOrSurgery;

  /**
   * 减肥历史时长 小于3个月、3-6个月、6-12个月、1-2年、2年以上
   */
  @TransferColumn(
      tarColumnName = "weight_loss_history",
      tarColumnValue = ""
  )
  private String weightLossHistory;

  /**
   * 减肥是否成功 未成功、已成功-小于6个月、已成功-6-18个月、已成功-大于18个月
   */
  @TransferColumn(
      tarColumnName = "weight_loss_success",
      tarColumnValue = ""
  )
  private String weightLossSuccess;

  /**
   * 当前用药
   */
  @TransferColumn(
      tarColumnName = "current_medicines",
      tarColumnValue = ""
  )
  private String currentMedicines;
}
