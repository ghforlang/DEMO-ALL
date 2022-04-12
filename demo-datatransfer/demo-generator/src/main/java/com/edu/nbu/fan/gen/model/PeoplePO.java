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
    tableName = "people"
)
@Getter
@Setter
public class PeoplePO {
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
      tarColumnValue = "NOW()"
  )
  private LocalDateTime gmtCreated;

  /**
   * 修改时间
   */
  @TransferColumn(
      tarColumnName = "gmt_modified",
      tarColumnValue = "NOW()"
  )
  private LocalDateTime gmtModified;

  /**
   * 自然人id
   */
  @TransferColumn(
      tarColumnName = "biz_id",
      tarColumnValue = "bizid"
  )
  private Long bizId;

  /**
   * 姓名
   */
  @TransferColumn(
      tarColumnName = "name",
      tarColumnValue = "name"
  )
  private String name;

  /**
   * 性别:0-未知，1-男，2-女，9-未说明的性别
   */
  @TransferColumn(
      tarColumnName = "gender",
      tarColumnValue = "gender"
  )
  private Integer gender;

  /**
   * 身份证号
   */
  @TransferColumn(
      tarColumnName = "id_card_no",
      tarColumnValue = "idcardno"
  )
  private String idCardNo;

  /**
   * 居民户口本
   */
  @TransferColumn(
      tarColumnName = "household_register",
      tarColumnValue = "householdregister"
  )
  private String householdRegister;

  /**
   * 护照
   */
  @TransferColumn(
      tarColumnName = "passport",
      tarColumnValue = "passport"
  )
  private String passport;

  /**
   * 军官证
   */
  @TransferColumn(
      tarColumnName = "military_license",
      tarColumnValue = "militarylicense"
  )
  private String militaryLicense;

  /**
   * 驾驶证
   */
  @TransferColumn(
      tarColumnName = "driving_license",
      tarColumnValue = "drivinglicense"
  )
  private String drivingLicense;

  /**
   * 港澳通行证
   */
  @TransferColumn(
      tarColumnName = "hk_and_mo_pass",
      tarColumnValue = "hkandmopass"
  )
  private String hkAndMoPass;

  /**
   * 台湾通行证
   */
  @TransferColumn(
      tarColumnName = "taiwan_pass",
      tarColumnValue = "taiwanpass"
  )
  private String taiwanPass;

  /**
   * 港澳居民来往内地通行证，俗称回乡证
   */
  @TransferColumn(
      tarColumnName = "home_return_permit",
      tarColumnValue = "homereturnpermit"
  )
  private String homeReturnPermit;

  /**
   * 其他证件号
   */
  @TransferColumn(
      tarColumnName = "other_card_no",
      tarColumnValue = "othercardno"
  )
  private String otherCardNo;

  /**
   * 手机号
   */
  @TransferColumn(
      tarColumnName = "phone_number",
      tarColumnValue = "phonenumber"
  )
  private String phoneNumber;

  /**
   * 邮箱
   */
  @TransferColumn(
      tarColumnName = "email",
      tarColumnValue = "email"
  )
  private String email;

  /**
   * 生日
   */
  @TransferColumn(
      tarColumnName = "date_of_birth",
      tarColumnValue = "STR_TO_DATE( dateofbirth , '%W %M %d %H:%i:%S CST %Y') AS date"
  )
  private LocalDateTime dateOfBirth;

  /**
   * 国籍
   */
  @TransferColumn(
      tarColumnName = "citizenship",
      tarColumnValue = "citizenship"
  )
  private String citizenship;

  /**
   * 名族
   */
  @TransferColumn(
      tarColumnName = "nation",
      tarColumnValue = "nation"
  )
  private String nation;

  /**
   * 常住地类型
   */
  @TransferColumn(
      tarColumnName = "domicile",
      tarColumnValue = "domicile"
  )
  private Integer domicile;

  /**
   * 常住地址户籍标志
   */
  @TransferColumn(
      tarColumnName = "household_register_sign",
      tarColumnValue = "householdregistersign"
  )
  private Long householdRegisterSign;

  /**
   * 详细地址
   */
  @TransferColumn(
      tarColumnName = "address",
      tarColumnValue = "address"
  )
  private String address;

  /**
   * 省（自治区、直辖市）Id
   */
  @TransferColumn(
      tarColumnName = "province_id",
      tarColumnValue = "provinceid"
  )
  private Integer provinceId;

  /**
   * 省（自治区、直辖市）
   */
  @TransferColumn(
      tarColumnName = "province",
      tarColumnValue = "province"
  )
  private String province;

  /**
   * 市（地区、州）Id
   */
  @TransferColumn(
      tarColumnName = "city_id",
      tarColumnValue = "cityid"
  )
  private Integer cityId;

  /**
   * 市（地区、州）
   */
  @TransferColumn(
      tarColumnName = "city",
      tarColumnValue = "city"
  )
  private String city;

  /**
   * 县（区）Id
   */
  @TransferColumn(
      tarColumnName = "county_id",
      tarColumnValue = "countyid"
  )
  private Integer countyId;

  /**
   * 县（区）
   */
  @TransferColumn(
      tarColumnName = "county",
      tarColumnValue = "county"
  )
  private String county;

  /**
   * 乡（镇、街道办事处）
   */
  @TransferColumn(
      tarColumnName = "township",
      tarColumnValue = "township"
  )
  private String township;

  /**
   * 村(街、路、弄等)
   */
  @TransferColumn(
      tarColumnName = "village",
      tarColumnValue = "village"
  )
  private String village;

  /**
   * 门牌
   */
  @TransferColumn(
      tarColumnName = "doorplate",
      tarColumnValue = "doorplate"
  )
  private String doorplate;

  /**
   * 邮政编码
   */
  @TransferColumn(
      tarColumnName = "postal_code",
      tarColumnValue = "postalcode"
  )
  private String postalCode;

  /**
   * 出生证明
   */
  @TransferColumn(
      tarColumnName = "birth_certificate",
      tarColumnValue = "birthcertificate"
  )
  private String birthCertificate;

  /**
   * 居民健康卡号
   */
  @TransferColumn(
      tarColumnName = "health_card_no",
      tarColumnValue = "healthcardno"
  )
  private String healthCardNo;

  /**
   * 门诊卡号
   */
  @TransferColumn(
      tarColumnName = "outpatient_no",
      tarColumnValue = "outpatientno"
  )
  private String outpatientNo;

  /**
   * 住院号
   */
  @TransferColumn(
      tarColumnName = "inpatient_no",
      tarColumnValue = "inpatientno"
  )
  private String inpatientNo;

  /**
   * 医保卡号
   */
  @TransferColumn(
      tarColumnName = "mi_card",
      tarColumnValue = "micard"
  )
  private String miCard;

  /**
   * 医保区域编码，该字段仅提区域人口信息平台医保策略使用
   */
  @TransferColumn(
      tarColumnName = "pip_mi_area_code",
      tarColumnValue = "pipmiareacode"
  )
  private String pipMiAreaCode;

  /**
   * 乡（镇、街道办事处）Id
   */
  @TransferColumn(
      tarColumnName = "township_id",
      tarColumnValue = "townshipid"
  )
  private Integer townshipId;

  /**
   * 村(街、路、弄等)Id
   */
  @TransferColumn(
      tarColumnName = "village_id",
      tarColumnValue = "villageid"
  )
  private Integer villageId;
}
