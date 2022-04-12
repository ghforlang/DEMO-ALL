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
    tableName = "basic_health_info6"
)
@Getter
@Setter
public class BasicHealthInfo6PO {
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
   * 肝性脑病
   */
  @TransferColumn(
      tarColumnName = "k72_903",
      tarColumnValue = ""
  )
  private String k72903;

  /**
   * 肝硬化失代偿期
   */
  @TransferColumn(
      tarColumnName = "k74_607",
      tarColumnValue = ""
  )
  private String k74607;

  /**
   * 酒精性脂肪肝
   */
  @TransferColumn(
      tarColumnName = "k70_000",
      tarColumnValue = ""
  )
  private String k70000;

  /**
   * 帕金森分期 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "parkinson_staging",
      tarColumnValue = ""
  )
  private String parkinsonStaging;

  /**
   * 帕金森病性痴呆[震颤麻痹性痴呆]
   */
  @TransferColumn(
      tarColumnName = "g20_x00x005__f02_3",
      tarColumnValue = ""
  )
  private String g20X00x005F023;

  /**
   * 帕金森后期
   */
  @TransferColumn(
      tarColumnName = "late_parkinson",
      tarColumnValue = ""
  )
  private String lateParkinson;

  /**
   * 血友病肌肉出血
   */
  @TransferColumn(
      tarColumnName = "hemophilia_muscle_bleeding",
      tarColumnValue = ""
  )
  private String hemophiliaMuscleBleeding;

  /**
   * 安静状态下复杂的心律失常
   */
  @TransferColumn(
      tarColumnName = "complex_arrhythmias_at_rest",
      tarColumnValue = ""
  )
  private String complexArrhythmiasAtRest;

  /**
   * 高热
   */
  @TransferColumn(
      tarColumnName = "r50_900x002",
      tarColumnValue = ""
  )
  private String r50900x002;

  /**
   * 肺部疾病恶化
   */
  @TransferColumn(
      tarColumnName = "lung_deterioration",
      tarColumnValue = ""
  )
  private String lungDeterioration;

  /**
   * 放化疗
   */
  @TransferColumn(
      tarColumnName = "chemo_radio_therapy",
      tarColumnValue = ""
  )
  private String chemoRadioTherapy;

  /**
   * 放化疗后症状
   */
  @TransferColumn(
      tarColumnName = "chemo_radio_therapy_symptoms",
      tarColumnValue = ""
  )
  private String chemoRadioTherapySymptoms;

  /**
   * 异常体态
   */
  @TransferColumn(
      tarColumnName = "abnormal_posture",
      tarColumnValue = ""
  )
  private String abnormalPosture;

  /**
   * 瘫痪或截肢
   */
  @TransferColumn(
      tarColumnName = "paralysis_or_amputation",
      tarColumnValue = ""
  )
  private String paralysisOrAmputation;

  /**
   * 关节病变
   */
  @TransferColumn(
      tarColumnName = "joint_disease",
      tarColumnValue = ""
  )
  private String jointDisease;

  /**
   * 工作强度 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "work_intensity",
      tarColumnValue = ""
  )
  private String workIntensity;

  /**
   * 足月生产数
   */
  @TransferColumn(
      tarColumnName = "full_term_births",
      tarColumnValue = ""
  )
  private Integer fullTermBirths;

  /**
   * 每日运动(步)
   */
  @TransferColumn(
      tarColumnName = "daily_exercise",
      tarColumnValue = ""
  )
  private String dailyExercise;

  /**
   * 每日主食(顿)
   */
  @TransferColumn(
      tarColumnName = "daily_staple_food",
      tarColumnValue = ""
  )
  private String dailyStapleFood;

  /**
   * 运动时间 枚举：不固定、空腹、餐后
   */
  @TransferColumn(
      tarColumnName = "exercise_time",
      tarColumnValue = ""
  )
  private String exerciseTime;

  /**
   * 早产数
   */
  @TransferColumn(
      tarColumnName = "premature_births",
      tarColumnValue = ""
  )
  private Integer prematureBirths;

  /**
   * 流产数
   */
  @TransferColumn(
      tarColumnName = "abortions",
      tarColumnValue = ""
  )
  private Integer abortions;

  /**
   * 存活数
   */
  @TransferColumn(
      tarColumnName = "survival",
      tarColumnValue = ""
  )
  private Integer survival;

  /**
   * 服用的药物 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "taking_medicine",
      tarColumnValue = ""
  )
  private String takingMedicine;

  /**
   * 是否运动锻炼
   */
  @TransferColumn(
      tarColumnName = "exercise_or_not",
      tarColumnValue = ""
  )
  private String exerciseOrNot;

  /**
   * 每周工作几天 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "weekly_work_days",
      tarColumnValue = ""
  )
  private String weeklyWorkDays;

  /**
   * 每日工作时长(h) 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "daily_working_hours",
      tarColumnValue = ""
  )
  private String dailyWorkingHours;

  /**
   * 坐着的时间 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "sitting_time",
      tarColumnValue = ""
  )
  private String sittingTime;

  /**
   * 精神异常症状 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "mental_disorders",
      tarColumnValue = ""
  )
  private String mentalDisorders;

  /**
   * 影响睡眠的因素 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "factors_affecting_sleep",
      tarColumnValue = ""
  )
  private String factorsAffectingSleep;

  /**
   * 饮食规律 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "dietary_pattern_regular",
      tarColumnValue = ""
  )
  private String dietaryPatternRegular;
}
