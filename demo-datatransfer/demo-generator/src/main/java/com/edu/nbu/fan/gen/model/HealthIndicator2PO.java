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
    tableName = "health_indicator2"
)
@Getter
@Setter
public class HealthIndicator2PO {
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
   * 体脂率%状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "body_fat_rate_status",
      tarColumnValue = "bodyfat_rate_status"
  )
  private Integer bodyFatRateStatus;

  /**
   * 尿酸
   */
  @TransferColumn(
      tarColumnName = "uric_acid",
      tarColumnValue = "uricacid"
  )
  private Double uricAcid;

  /**
   * 尿酸 状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "uric_acid_status",
      tarColumnValue = "uricacid_status"
  )
  private Integer uricAcidStatus;

  /**
   * 总胆固醇
   */
  @TransferColumn(
      tarColumnName = "total_cholesterol",
      tarColumnValue = "total_cholesterol"
  )
  private Double totalCholesterol;

  /**
   * 总胆固醇
   */
  @TransferColumn(
      tarColumnName = "total_cholesterol_status",
      tarColumnValue = "total_cholesterol_status"
  )
  private Integer totalCholesterolStatus;

  /**
   * 每年急性增重次数
   */
  @TransferColumn(
      tarColumnName = "acute_weight_gain_count_of_year",
      tarColumnValue = "acute_weightgain_count_of_year"
  )
  private Integer acuteWeightGainCountOfYear;

  /**
   * 每年急性增重程度：1、轻度；2、中度；3、重度；
   */
  @TransferColumn(
      tarColumnName = "acute_weight_gain_degree_of_year",
      tarColumnValue = "acute_weightgain_degree_of_year"
  )
  private Integer acuteWeightGainDegreeOfYear;

  /**
   * mMRC呼吸困难评估：0-0级；1-1级；2-2级；3-3级；4-4级；
   */
  @TransferColumn(
      tarColumnName = "mmrc",
      tarColumnValue = "mmrc"
  )
  private Integer mmrc;

  /**
   * 肺功能fev1
   */
  @TransferColumn(
      tarColumnName = "fev1",
      tarColumnValue = "fev1"
  )
  private Double fev1;

  /**
   * 肺功能fvc
   */
  @TransferColumn(
      tarColumnName = "fvc",
      tarColumnValue = "fvc"
  )
  private Double fvc;

  /**
   * 头围
   */
  @TransferColumn(
      tarColumnName = "head_circumference",
      tarColumnValue = "head_circumference"
  )
  private Double headCircumference;

  /**
   * 肌肉含量
   */
  @TransferColumn(
      tarColumnName = "muscle_content",
      tarColumnValue = "muscle_content"
  )
  private Double muscleContent;

  /**
   * 肌肉含量状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "muscle_content_status",
      tarColumnValue = "muscle_content_status"
  )
  private Integer muscleContentStatus;

  /**
   * 体水分率
   */
  @TransferColumn(
      tarColumnName = "body_water_rate",
      tarColumnValue = "body_water_rate"
  )
  private Double bodyWaterRate;

  /**
   * 体水分率状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "body_water_rate_status",
      tarColumnValue = "body_water_rate_status"
  )
  private Integer bodyWaterRateStatus;

  /**
   * 内脏脂肪
   */
  @TransferColumn(
      tarColumnName = "visceral_fat",
      tarColumnValue = "visceral_fat"
  )
  private Integer visceralFat;

  /**
   * 内脏脂肪状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "visceral_fat_status",
      tarColumnValue = "visceral_fat_status"
  )
  private Integer visceralFatStatus;

  /**
   * 血同型半胱氨酸 μmol/L
   */
  @TransferColumn(
      tarColumnName = "homocysteine",
      tarColumnValue = "homocysteine"
  )
  private Double homocysteine;

  /**
   * 血同型半胱氨酸 μmol/L状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "homocysteine_status",
      tarColumnValue = "homocysteine_status"
  )
  private Integer homocysteineStatus;

  /**
   * 数据标签
   */
  @TransferColumn(
      tarColumnName = "label",
      tarColumnValue = "label"
  )
  private String label;

  /**
   * 姓名
   */
  @TransferColumn(
      tarColumnName = "name",
      tarColumnValue = "name"
  )
  private String name;

  /**
   * 年龄
   */
  @TransferColumn(
      tarColumnName = "age",
      tarColumnValue = "age"
  )
  private String age;

  /**
   * 性别
   */
  @TransferColumn(
      tarColumnName = "gender",
      tarColumnValue = "gender"
  )
  private Integer gender;

  /**
   * 身份证件类别
   */
  @TransferColumn(
      tarColumnName = "id_card_type",
      tarColumnValue = "id_card_type"
  )
  private Integer idCardType;

  /**
   * 身份证件号码 数据元：DE02.01.030.00 字段说明：公安部公民唯一身份证件号码，优先填写 表示格式：S1 AN18
   */
  @TransferColumn(
      tarColumnName = "id_card_no",
      tarColumnValue = "id_card_no"
  )
  private String idCardNo;

  /**
   * 测量时间
   */
  @TransferColumn(
      tarColumnName = "measure_time",
      tarColumnValue = "measure_time"
  )
  private String measureTime;

  /**
   * 终端设备号 如：一体机的设备号，微医通的设备号
   */
  @TransferColumn(
      tarColumnName = "terminal_unit",
      tarColumnValue = "terminal_unit"
  )
  private String terminalUnit;

  /**
   * 业务标签
   */
  @TransferColumn(
      tarColumnName = "biz_labels",
      tarColumnValue = "biz_labels"
  )
  private String bizLabels;

  /**
   * 糖化血红蛋白 单位：%
   */
  @TransferColumn(
      tarColumnName = "hb_a1c",
      tarColumnValue = ""
  )
  private Double hbA1c;

  /**
   * 糖化血红蛋白状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "hb_a1c_status",
      tarColumnValue = ""
  )
  private Integer hbA1cStatus;

  /**
   * 总胆固醇 单位：mmol/L
   */
  @TransferColumn(
      tarColumnName = "tc",
      tarColumnValue = ""
  )
  private Double tc;

  /**
   * 总胆固醇状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "tc_status",
      tarColumnValue = ""
  )
  private Integer tcStatus;

  /**
   * 甘油三脂 单位：mmol/L
   */
  @TransferColumn(
      tarColumnName = "tg",
      tarColumnValue = ""
  )
  private String tg;

  /**
   * 甘油三脂状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "tg_status",
      tarColumnValue = ""
  )
  private Integer tgStatus;

  /**
   * 高密度脂蛋白 单位：mmol/L
   */
  @TransferColumn(
      tarColumnName = "hdl",
      tarColumnValue = ""
  )
  private Double hdl;

  /**
   * 高密度脂蛋白状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "hdl_status",
      tarColumnValue = ""
  )
  private Integer hdlStatus;

  /**
   * 低密度脂蛋白 单位：mmol/L
   */
  @TransferColumn(
      tarColumnName = "ldl",
      tarColumnValue = ""
  )
  private Double ldl;

  /**
   * 低密度脂蛋白状态 0-正常 1-偏高 2-偏低
   */
  @TransferColumn(
      tarColumnName = "ldl_status",
      tarColumnValue = ""
  )
  private Integer ldlStatus;
}
