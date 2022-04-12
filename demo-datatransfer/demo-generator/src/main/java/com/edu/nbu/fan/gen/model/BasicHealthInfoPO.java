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
    tableName = "basic_health_info"
)
@Getter
@Setter
public class BasicHealthInfoPO {
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
   * 姓名
   */
  @TransferColumn(
      tarColumnName = "name",
      tarColumnValue = "name"
  )
  private String name;

  /**
   * 手机号
   */
  @TransferColumn(
      tarColumnName = "phone_number",
      tarColumnValue = "enc_phone_number"
  )
  private String phoneNumber;

  /**
   * 生日
   */
  @TransferColumn(
      tarColumnName = "date_of_birth",
      tarColumnValue = "date_of_birth"
  )
  private String dateOfBirth;

  /**
   * 证件号
   */
  @TransferColumn(
      tarColumnName = "id_card_no",
      tarColumnValue = "enc_id_card_no"
  )
  private String idCardNo;

  /**
   * 体重(Kg)
   */
  @TransferColumn(
      tarColumnName = "weight",
      tarColumnValue = "weight"
  )
  private Double weight;

  /**
   * ABO血型 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "abo_blood_type",
      tarColumnValue = "abo_blood_type_name"
  )
  private String aboBloodType;

  /**
   * 职业
   */
  @TransferColumn(
      tarColumnName = "occupation",
      tarColumnValue = "occupation"
  )
  private String occupation;

  /**
   * 身高(cm)
   */
  @TransferColumn(
      tarColumnName = "height",
      tarColumnValue = "height"
  )
  private Double height;

  /**
   * Rh阴性 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "rh_blood_type",
      tarColumnValue = "rh_blood_type_name"
  )
  private String rhBloodType;

  /**
   * 预防接种
   */
  @TransferColumn(
      tarColumnName = "is_vaccinated",
      tarColumnValue = "is_vaccinated"
  )
  private String isVaccinated;

  /**
   * 学历 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "education_level",
      tarColumnValue = "education_level_name"
  )
  private String educationLevel;

  /**
   * 末次月经时间
   */
  @TransferColumn(
      tarColumnName = "last_menstrual_period",
      tarColumnValue = "last_menstrual_period"
  )
  private String lastMenstrualPeriod;

  /**
   * 大小便情况 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "urine_conditions",
      tarColumnValue = "urine_conditions"
  )
  private String urineConditions;

  /**
   * 婚姻状况 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "martial_status",
      tarColumnValue = "martial_status_name"
  )
  private String martialStatus;

  /**
   * 预产期
   */
  @TransferColumn(
      tarColumnName = "expected_date_of_childbirth",
      tarColumnValue = "expected_date_of_childbirth"
  )
  private String expectedDateOfChildbirth;

  /**
   * 工作单位
   */
  @TransferColumn(
      tarColumnName = "company",
      tarColumnValue = "company"
  )
  private String company;

  /**
   * 性别
   */
  @TransferColumn(
      tarColumnName = "gender",
      tarColumnValue = "gender"
  )
  private Integer gender;

  /**
   * 月经初潮
   */
  @TransferColumn(
      tarColumnName = "menarche",
      tarColumnValue = "menarche"
  )
  private String menarche;

  /**
   * 月经初潮年龄
   */
  @TransferColumn(
      tarColumnName = "age_of_menarche",
      tarColumnValue = "age_of_menarche"
  )
  private Integer ageOfMenarche;

  /**
   * 妊娠状态 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "is_pregnant",
      tarColumnValue = "is_pregnant"
  )
  private String isPregnant;

  /**
   * 家族史 值域来源:疾病库
   */
  @TransferColumn(
      tarColumnName = "family_history",
      tarColumnValue = "family_diseases"
  )
  private String familyHistory;

  /**
   * 紧急联系人电话
   */
  @TransferColumn(
      tarColumnName = "emergency_contact_person_phone",
      tarColumnValue = "emergency_contact_person_phone"
  )
  private String emergencyContactPersonPhone;

  /**
   * 生育情况 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "fertility_status",
      tarColumnValue = "fertility_status_name"
  )
  private String fertilityStatus;

  /**
   * 紧急联系人
   */
  @TransferColumn(
      tarColumnName = "emergency_contact_person",
      tarColumnValue = "emergency_contact_person"
  )
  private String emergencyContactPerson;

  /**
   * 监护人手机号
   */
  @TransferColumn(
      tarColumnName = "guardian_phone",
      tarColumnValue = "guardian_phone"
  )
  private String guardianPhone;

  /**
   * 宗教信仰 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "religion",
      tarColumnValue = ""
  )
  private String religion;

  /**
   * 监护人
   */
  @TransferColumn(
      tarColumnName = "guardian",
      tarColumnValue = "guardian"
  )
  private String guardian;

  /**
   * 饮酒频率 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "drinking_frequency",
      tarColumnValue = ""
  )
  private String drinkingFrequency;

  /**
   * 手术或外伤史 值域来源:疾病库
   */
  @TransferColumn(
      tarColumnName = "surgical_or_injury_history",
      tarColumnValue = ""
  )
  private String surgicalOrInjuryHistory;

  /**
   * 饮食口味 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "diet_taste",
      tarColumnValue = "diet_taste_list"
  )
  private String dietTaste;

  /**
   * 饮酒情况 值域来源:标准值域
   */
  @TransferColumn(
      tarColumnName = "drinking_situation",
      tarColumnValue = "drinking_situation"
  )
  private String drinkingSituation;
}
