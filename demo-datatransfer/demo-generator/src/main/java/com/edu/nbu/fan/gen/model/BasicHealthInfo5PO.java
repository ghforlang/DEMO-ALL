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
    tableName = "basic_health_info5"
)
@Getter
@Setter
public class BasicHealthInfo5PO {
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
   * 厕所类别代码
   */
  @TransferColumn(
      tarColumnName = "toilet_category",
      tarColumnValue = "toilet_category"
  )
  private String toiletCategory;

  /**
   * 禽畜栏类别
   */
  @TransferColumn(
      tarColumnName = "livestock_bar_category",
      tarColumnValue = "livestock_bar_category"
  )
  private String livestockBarCategory;

  /**
   * 职业暴露史标志
   */
  @TransferColumn(
      tarColumnName = "exposure_history",
      tarColumnValue = "exposure_history"
  )
  private String exposureHistory;

  /**
   * 输血史
   */
  @TransferColumn(
      tarColumnName = "blood_transfusion_history",
      tarColumnValue = "blood_transfusion_history"
  )
  private String bloodTransfusionHistory;

  /**
   * 残疾情况代码 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "disability_code",
      tarColumnValue = ""
  )
  private String disabilityCode;

  /**
   * 港澳居民来往内地通行证
   */
  @TransferColumn(
      tarColumnName = "home_return_permit",
      tarColumnValue = ""
  )
  private String homeReturnPermit;

  /**
   * 身体活动强度分类代码 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "physical_activity_intensity",
      tarColumnValue = ""
  )
  private String physicalActivityIntensity;

  /**
   * 心率(次min)
   */
  @TransferColumn(
      tarColumnName = "heart_rate",
      tarColumnValue = ""
  )
  private Integer heartRate;

  /**
   * 环境危险因素暴露代码 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "env_danger_exposure_code",
      tarColumnValue = ""
  )
  private String envDangerExposureCode;

  /**
   * 避孕方式代码 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "contraception",
      tarColumnValue = ""
  )
  private String contraception;

  /**
   * 臀围(cm)
   */
  @TransferColumn(
      tarColumnName = "hiplines",
      tarColumnValue = ""
  )
  private Double hiplines;

  /**
   * 2级、3级高血压
   */
  @TransferColumn(
      tarColumnName = "hypertension",
      tarColumnValue = ""
  )
  private String hypertension;

  /**
   * 服用高血压药物
   */
  @TransferColumn(
      tarColumnName = "hypertension_drugs",
      tarColumnValue = ""
  )
  private String hypertensionDrugs;

  /**
   * 糖尿病下肢动脉病变
   */
  @TransferColumn(
      tarColumnName = "hypertension_lead",
      tarColumnValue = ""
  )
  private String hypertensionLead;

  /**
   * 糖尿病足
   */
  @TransferColumn(
      tarColumnName = "e14_500x050",
      tarColumnValue = ""
  )
  private String e14500x050;

  /**
   * 糖尿病性下肢溃疡
   */
  @TransferColumn(
      tarColumnName = "e14_500x043",
      tarColumnValue = ""
  )
  private String e14500x043;

  /**
   * 糖尿病性酮症酸中毒
   */
  @TransferColumn(
      tarColumnName = "e14_100x011",
      tarColumnValue = ""
  )
  private String e14100x011;

  /**
   * 糖尿病性肌无力综合征
   */
  @TransferColumn(
      tarColumnName = "e14_400x121",
      tarColumnValue = ""
  )
  private String e14400x121;

  /**
   * 糖尿病性低血糖症
   */
  @TransferColumn(
      tarColumnName = "e14_600x043",
      tarColumnValue = ""
  )
  private String e14600x043;

  /**
   * 糖尿病服药情况
   */
  @TransferColumn(
      tarColumnName = "diabetes_drugs",
      tarColumnValue = ""
  )
  private String diabetesDrugs;

  /**
   * 脑卒中
   */
  @TransferColumn(
      tarColumnName = "i64_x00",
      tarColumnValue = ""
  )
  private String i64X00;

  /**
   * 心力衰竭
   */
  @TransferColumn(
      tarColumnName = "i50_100x006",
      tarColumnValue = ""
  )
  private String i50100x006;

  /**
   * 充血性心力衰竭
   */
  @TransferColumn(
      tarColumnName = "i50_000",
      tarColumnValue = ""
  )
  private String i50000;

  /**
   * 射血分数<40%
   */
  @TransferColumn(
      tarColumnName = "lvef_less40",
      tarColumnValue = ""
  )
  private String lvefLess40;

  /**
   * 呼吸心跳骤停
   */
  @TransferColumn(
      tarColumnName = "i46_901",
      tarColumnValue = ""
  )
  private String i46901;

  /**
   * 急性心肌缺血
   */
  @TransferColumn(
      tarColumnName = "i24_900x001",
      tarColumnValue = ""
  )
  private String i24900x001;

  /**
   * 心肌梗死
   */
  @TransferColumn(
      tarColumnName = "i21_900x011",
      tarColumnValue = ""
  )
  private String i21900x011;

  /**
   * 哮喘恶化
   */
  @TransferColumn(
      tarColumnName = "asthma_exacerbations",
      tarColumnValue = ""
  )
  private String asthmaExacerbations;

  /**
   * 肝炎急性期
   */
  @TransferColumn(
      tarColumnName = "hepatitis_acute",
      tarColumnValue = ""
  )
  private String hepatitisAcute;

  /**
   * 肝癌恶化
   */
  @TransferColumn(
      tarColumnName = "liver_cancer_deterioration",
      tarColumnValue = ""
  )
  private String liverCancerDeterioration;

  /**
   * 肝癌终末期
   */
  @TransferColumn(
      tarColumnName = "liver_cancer_end_stage",
      tarColumnValue = ""
  )
  private String liverCancerEndStage;
}
