import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 健康数据业务标签枚举
 *
 * <p>该枚举项定义需向档案开发申请
 *
 * @author fengwk
 * @since 2020-10-14 11:23
 */
public enum HealthDataBizLabelEnum {

    TEMPERATURE("t", "体温（摄氏度）", "temperature"),
    RESPIRATORY_RATE("rr", "呼吸频率（次/min）", "respiratoryRate"),
    BLOOD_PRESSURE("bp", "血压(mmHg)", "bloodPressure"),
    PULSE_RATE("pr", "脉搏（次/min）", "pulseRate"),
    HEART_RATE("hr", "心率 （次/min）", "heartRate"),
    HEIGHT("h", "身高（cm）", "height"),
    WEIGHT("we", "体重(kg）", "weight"),
    BODY_MASS_INDEX("bmi", "BMI", "bodyMassIndex"),
    BLOOD_SUGAR("bs", "血糖", "bloodSugar"),
    OXYGEN_SATURATION("os", "血氧饱和度（%）", "oxygenSaturation"),
    WAIST("wa", "腰围(cm)", "waist"),
    BODY_FAT("bf", "体脂率", "bodyFat"),
    URIC_ACID("ua", "尿酸", "uricAcid"),
    TOTAL_CHOLESTEROL("tc", "总胆固醇", "totalCholesterol"),
    ACUTE_WEIGHT_GAIN("awg", "每年急性增重", "acuteWeightGainOfYear"),
    MMRC("mmrc", "呼吸困难评估", "mmrc"),
    F("f", "肺功能", "pulmonaryFunction"),
    HEAD_CIRCUMFERENCE("hc", "头围（cm）", "headCircumference"),
    HUMAN_FAT("hf", "人体脂肪", "humanFat"),
    URINALYSIS("u", "尿检", "urinalysis"),
    HBA1C("hb", "糖化血红蛋白", "hba1c"),
    BLOOD_FAT("bloodFat", "血脂", "bloodFat"),
    HOMOCYSTEINE("hcy", "同型半胱氨酸", "homocysteine"),
    ;

    /**
     * 标签值
     */
    private final String label;

    /**
     * 名称（HealthIndicatorEnum.indicatorName）
     */
    private final String name;

    /**
     * 描述
     */
    private final String desc;


    HealthDataBizLabelEnum(String label, String desc, String name) {
        this.label = label;
        this.desc = desc;
        this.name = name;
    }

    public static final Map<String, HealthDataBizLabelEnum> NAME_MAP = new ConcurrentHashMap<String, HealthDataBizLabelEnum>(
            HealthDataBizLabelEnum.values().length);
    public static final Map<String, String> NAME_LABEL_MAP = new ConcurrentHashMap<String, String>(
            HealthDataBizLabelEnum.values().length);

    static {
        /**
         * 将所有的实体类放入到map中,提供查询.
         */
        for (HealthDataBizLabelEnum type : EnumSet.allOf(HealthDataBizLabelEnum.class)) {
            NAME_MAP.put(type.getName(), type);
        }

        for (HealthDataBizLabelEnum type : EnumSet.allOf(HealthDataBizLabelEnum.class)) {
            NAME_LABEL_MAP.put(type.getName(), type.getLabel());
        }
    }

    public static HealthDataBizLabelEnum of(String label) {
        if (label == null) {
            return null;
        }
        for (HealthDataBizLabelEnum e : HealthDataBizLabelEnum.values()) {
            if (label.equals(e.getLabel())) {
                return e;
            }
        }
        return null;
    }

    public static HealthDataBizLabelEnum getByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        return NAME_MAP.get(name);
    }

    public static List<String> listByName(final List<String> names) {
        if (CollectionUtils.isEmpty(names)) {
            return Collections.EMPTY_LIST;
        }

        List<String> labels = new ArrayList<String>(names.size());
        for (String name : names) {
            if (NAME_MAP.containsKey(name)) {
                labels.add(NAME_MAP.get(name).getLabel());
            }
        }
        return labels;
    }

    public static boolean contains(String label) {
        return of(label) != null;
    }

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
