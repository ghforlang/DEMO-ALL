package com.edu.nbu.cn.data.cleanout.model.ehr;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/14-10:55 上午
 * @since 1.0
 */
@Getter
@Setter
public class HealthIndicator {
    /**
     * 默认的删除时间
     */
    public static final LocalDateTime DEFAULT_DELETE_TIME = LocalDateTime.parse("9999-12-31T23:59:59.000");;

    /**
     * 表示记录未删除
     */
    public static final int IS_DELETED_FALSE = 0;

    /**
     * 表示记录已经被删除
     */
    public static final int IS_DELETED_TRUE = 1;

    /**
     * 自增主键（不允许业务上使用）
     */
    protected Long pkId;

    /**
     * 用来业务上唯一识别该条数据
     */
    protected String id;

    /**
     * 创建时间
     */
    protected LocalDateTime gmtCreated;

    /**
     * 最后修改时间
     */
    protected LocalDateTime gmtModified;

    /**
     * 逻辑删除时间
     */
    protected LocalDateTime gmtDeleted;

    /**
     * 1 表示删除，0 表示未删除（该字段仅作为数据逻辑删除使用，不应在程序侧发生二次更新。）
     */
    protected Integer isDeleted=IS_DELETED_FALSE;

    /**
     * 数据来源标识
     */
    private String source;

    /**
     * 数据唯一标识
     * 如果数据来自外部抽取或同步：source#外部id
     * 否则：source#id
     */
    private String sourceUniqueKey;

    /**
     * 自然人id
     */
    private Long peopleId;

    /**
     * 设备型号
     */
    private String deviceModel;

    /**
     * 蓝牙地址
     */
    private String bluetoothAddr;

    /**
     * 设备序列号
     */
    private String deviceSerial;

    /**
     * 测量地点
     */
    private String measureAddress;

    /**
     * 测量地点的经度
     */
    private Double measureLongitude;

    /**
     * 测量地点的维度
     */
    private Double measureLatitude;

    /**
     * 体温（摄氏度）
     */
    private Double temperature;

    /**
     * 体温状态 0-正常 1-偏高 2-偏低
     */
    private Integer temperatureStatus;

    /**
     * 呼吸频率（次/min）
     */
    private Integer respiratoryRate;

    /**
     * 呼吸频率（次/min）状态 0-正常 1-偏高 2-偏低
     */
    private Integer respiratoryRateStatus;

    /**
     * 血压测量时间标签
     */
    private Integer bloodPressureMeasureTimeLabel;

    /**
     * 收缩压(mmHg）
     */
    private Double systolicPressure;

    /**
     * 收缩压(mmHg）状态 0-正常 1-偏高 2-偏低
     */
    private Integer systolicPressureStatus;

    /**
     * 舒张压(mmHg）
     */
    private Double diastolicPressure;

    /**
     * 舒张压(mmHg）状态 0-正常 1-偏高 2-偏低
     */
    private Integer diastolicPressureStatus;

    /**
     * 脉搏（次/min）
     */
    private Integer pulseRate;

    /**
     * 脉搏（次/min）状态 0-正常 1-偏高 2-偏低
     */
    private Integer pulseRateStatus;

    /**
     * 心率 （次/min）
     */
    private Integer heartRate;

    /**
     * 身高（cm）
     */
    private Double height;

    /**
     * 体重(kg）
     */
    private Double weight;

    /**
     * BMI指数 体质指数
     */
    private Double bodyMassIndex;

    /**
     * BMI指数 体质指数状态 0-正常 1-偏高 2-偏低
     */
    private Integer bodyMassIndexStatus;

    /**
     * 血糖测量时间标签
     */
    private Integer measureTimeLabel;

    /**
     * 血糖
     */
    private Double bloodSugar;

    /**
     * 血糖状态 0-正常 1-偏高 2-偏低
     */
    private Integer bloodSugarStatus;

    /**
     * 血氧饱和度（%）
     */
    private Integer oxygenSaturation;

    /**
     * 血氧饱和度（%）状态 0-正常 1-偏高 2-偏低
     */
    private Integer oxygenSaturationStatus;

    /**
     * 腰围
     */
    private Double waist;

    /**
     * 体脂率
     */
    private Integer bodyFat;

    /**
     * 体脂率%
     */
    private Double bodyFatRate;

    /**
     * 体脂率%状态 0-正常 1-偏高 2-偏低
     */
    private Integer bodyFatRateStatus;

    /**
     * 尿酸
     */
    private Double uricAcid;

    /**
     * 尿酸 状态 0-正常 1-偏高 2-偏低
     */
    private Integer uricAcidStatus;

    /**
     * 总胆固醇
     */
    private Double totalCholesterol;

    /**
     * 总胆固醇
     */
    private Integer totalCholesterolStatus;

    /**
     * 每年急性增重次数
     */
    private Integer acuteWeightGainCountOfYear;

    /**
     * 每年急性增重程度：1、轻度；2、中度；3、重度；
     */
    private Integer acuteWeightGainDegreeOfYear;

    /**
     * mMRC呼吸困难评估：0-0级；1-1级；2-2级；3-3级；4-4级；
     */
    private Integer mmrc;

    /**
     * 肺功能fev1
     */
    private Double fev1;

    /**
     * 肺功能fvc
     */
    private Double fvc;

    /**
     * 头围
     */
    private Double headCircumference;

    /**
     * 肌肉含量
     */
    private Double muscleContent;

    /**
     * 肌肉含量状态 0-正常 1-偏高 2-偏低
     */
    private Integer muscleContentStatus;

    /**
     * 体水分率
     */
    private Double bodyWaterRate;

    /**
     * 体水分率状态 0-正常 1-偏高 2-偏低
     */
    private Integer bodyWaterRateStatus;

    /**
     * 内脏脂肪
     */
    private Integer visceralFat;

    /**
     * 内脏脂肪状态 0-正常 1-偏高 2-偏低
     */
    private Integer visceralFatStatus;

    /**
     * 血同型半胱氨酸 μmol/L
     */
    private Double homocysteine;

    /**
     * 血同型半胱氨酸 μmol/L状态 0-正常 1-偏高 2-偏低
     */
    private Integer homocysteineStatus;

    /**
     * 数据标签
     */
    private String label;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private String age;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 身份证件类别
     */
    private Integer idCardType;

    /**
     * 身份证件号码 数据元：DE02.01.030.00 字段说明：公安部公民唯一身份证件号码，优先填写 表示格式：S1 AN18
     */
    private String idCardNo;

    /**
     * 测量时间
     */
    private String measureTime;

    /**
     * 终端设备号 如：一体机的设备号，微医通的设备号
     */
    private String terminalUnit;

    /**
     * 业务标签
     */
    private String bizLabels;

    /**
     * 糖化血红蛋白 单位：%
     */
    private Double hbA1c;

    /**
     * 糖化血红蛋白状态 0-正常 1-偏高 2-偏低
     */
    private Integer hbA1cStatus;

    /**
     * 总胆固醇 单位：mmol/L
     */
    private Double tc;

    /**
     * 总胆固醇状态 0-正常 1-偏高 2-偏低
     */
    private Integer tcStatus;

    /**
     * 甘油三脂 单位：mmol/L
     */
    private String tg;

    /**
     * 甘油三脂状态 0-正常 1-偏高 2-偏低
     */
    private Integer tgStatus;

    /**
     * 高密度脂蛋白 单位：mmol/L
     */
    private Double hdl;

    /**
     * 高密度脂蛋白状态 0-正常 1-偏高 2-偏低
     */
    private Integer hdlStatus;

    /**
     * 低密度脂蛋白 单位：mmol/L
     */
    private Double ldl;

    /**
     * 低密度脂蛋白状态 0-正常 1-偏高 2-偏低
     */
    private Integer ldlStatus;

    // 临时字段，用做数据暂存
    private Long bizLabelsData;
}
