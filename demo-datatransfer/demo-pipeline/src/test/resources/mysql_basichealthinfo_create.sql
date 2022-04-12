/*
 Navicat Premium Data Transfer

 Source Server         : 医院内网-mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 192.168.1.149:3308
 Source Schema         : region_phr_data_service

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 13/02/2022 14:49:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for basic_health_info
-- ----------------------------
DROP TABLE IF EXISTS `basic_health_info`;
CREATE TABLE `basic_health_info` (
                                     `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键（不允许业务上使用）',
                                     `id` bigint(20) unsigned NOT NULL COMMENT '用来业务上唯一识别该条数据',
                                     `gmt_created` datetime NOT NULL COMMENT '创建时间',
                                     `gmt_modified` datetime NOT NULL COMMENT '最后修改时间',
                                     `gmt_deleted` datetime NOT NULL DEFAULT '9999-12-31 23:59:59' COMMENT '逻辑删除时间',
                                     `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1 表示删除，0 表示未删除（该字段仅作为数据逻辑删除使用，不应在程序侧发生二次更新。）',
                                     `source` varchar(64) NOT NULL COMMENT '来源标识',
                                     `source_unique_key` varchar(128) NOT NULL COMMENT '数据唯一标识，如果数据来自外部抽取或同步为source#外部id,否则为source#id',
                                     `people_id` bigint(20) unsigned NOT NULL COMMENT '患者主索引id',
                                     `name` varchar(128) DEFAULT NULL COMMENT '姓名',
                                     `phone_number` varchar(128) DEFAULT NULL COMMENT '手机号',
                                     `date_of_birth` varchar(128) DEFAULT NULL COMMENT '生日',
                                     `id_card_no` varchar(128) DEFAULT NULL COMMENT '证件号',
                                     `weight` double DEFAULT NULL COMMENT '体重(Kg)',
                                     `abo_blood_type` varchar(512) DEFAULT NULL COMMENT 'ABO血型 值域来源:标准值域',
                                     `occupation` varchar(128) DEFAULT NULL COMMENT '职业',
                                     `height` double DEFAULT NULL COMMENT '身高(cm)',
                                     `rh_blood_type` varchar(512) DEFAULT NULL COMMENT 'Rh阴性 值域来源:标准值域',
                                     `is_vaccinated` varchar(128) DEFAULT NULL COMMENT '预防接种',
                                     `education_level` varchar(512) DEFAULT NULL COMMENT '学历 值域来源:标准值域',
                                     `last_menstrual_period` varchar(128) DEFAULT NULL COMMENT '末次月经时间',
                                     `urine_conditions` varchar(512) DEFAULT NULL COMMENT '大小便情况 值域来源:标准值域',
                                     `martial_status` varchar(512) DEFAULT NULL COMMENT '婚姻状况 值域来源:标准值域',
                                     `expected_date_of_childbirth` varchar(128) DEFAULT NULL COMMENT '预产期',
                                     `company` varchar(128) DEFAULT NULL COMMENT '工作单位',
                                     `gender` int(11) DEFAULT NULL COMMENT '性别',
                                     `menarche` varchar(128) DEFAULT NULL COMMENT '月经初潮',
                                     `age_of_menarche` int(11) DEFAULT NULL COMMENT '月经初潮年龄',
                                     `is_pregnant` varchar(128) DEFAULT NULL COMMENT '妊娠状态 值域来源:标准值域',
                                     `family_history` varchar(512) DEFAULT NULL COMMENT '家族史 值域来源:疾病库',
                                     `emergency_contact_person_phone` varchar(128) DEFAULT NULL COMMENT '紧急联系人电话',
                                     `fertility_status` varchar(512) DEFAULT NULL COMMENT '生育情况 值域来源:标准值域',
                                     `emergency_contact_person` varchar(128) DEFAULT NULL COMMENT '紧急联系人',
                                     `guardian_phone` varchar(128) DEFAULT NULL COMMENT '监护人手机号',
                                     `religion` varchar(512) DEFAULT NULL COMMENT '宗教信仰 值域来源:标准值域',
                                     `guardian` varchar(128) DEFAULT NULL COMMENT '监护人',
                                     `drinking_frequency` varchar(512) DEFAULT NULL COMMENT '饮酒频率 值域来源:标准值域',
                                     `surgical_or_injury_history` varchar(512) DEFAULT NULL COMMENT '手术或外伤史 值域来源:疾病库',
                                     `diet_taste` varchar(512) DEFAULT NULL COMMENT '饮食口味 值域来源:标准值域',
                                     `drinking_situation` varchar(512) DEFAULT NULL COMMENT '饮酒情况 值域来源:标准值域',
                                     PRIMARY KEY (`pk_id`),
                                     UNIQUE KEY `uniq_id` (`id`),
                                     UNIQUE KEY `uniq_sourceUniqueKey_gmtDeleted` (`source_unique_key`,`gmt_deleted`),
                                     KEY `idx_gmtCreated` (`gmt_created`),
                                     KEY `idx_gmtModified` (`gmt_modified`),
                                     KEY `idx_peopleId` (`people_id`),
                                     KEY `idx_source` (`source`)
) ENGINE=InnoDB AUTO_INCREMENT=6268 DEFAULT CHARSET=utf8mb4 COMMENT='基本健康信息';

SET FOREIGN_KEY_CHECKS = 1;


/*
 Navicat Premium Data Transfer

 Source Server         : 医院内网-mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 192.168.1.149:3308
 Source Schema         : region_phr_data_service

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 13/02/2022 14:49:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for basic_health_info2
-- ----------------------------
DROP TABLE IF EXISTS `basic_health_info2`;
CREATE TABLE `basic_health_info2` (
                                      `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键（不允许业务上使用）',
                                      `id` bigint(20) unsigned NOT NULL COMMENT '用来业务上唯一识别该条数据',
                                      `gmt_created` datetime NOT NULL COMMENT '创建时间',
                                      `gmt_modified` datetime NOT NULL COMMENT '最后修改时间',
                                      `gmt_deleted` datetime NOT NULL DEFAULT '9999-12-31 23:59:59' COMMENT '逻辑删除时间',
                                      `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1 表示删除，0 表示未删除（该字段仅作为数据逻辑删除使用，不应在程序侧发生二次更新。）',
                                      `source` varchar(64) NOT NULL COMMENT '来源标识',
                                      `source_unique_key` varchar(128) NOT NULL COMMENT '数据唯一标识，如果数据来自外部抽取或同步为source#外部id,否则为source#id',
                                      `people_id` bigint(20) unsigned NOT NULL COMMENT '患者主索引id',
                                      `cooking_way` varchar(512) DEFAULT NULL COMMENT '烹饪方式 值域来源:标准值域',
                                      `is_snoring` varchar(128) DEFAULT NULL COMMENT '是否打鼾',
                                      `diet_structure` varchar(512) DEFAULT NULL COMMENT '饮食结构 值域来源:标准值域',
                                      `appetite_condition` varchar(512) DEFAULT NULL COMMENT '食欲 值域来源:标准值域',
                                      `sleeping_patterns` varchar(512) DEFAULT NULL COMMENT '睡眠规律 值域来源:标准值域',
                                      `genetic_history` varchar(512) DEFAULT NULL COMMENT '遗传病史 值域来源:疾病库',
                                      `present_illness` varchar(512) DEFAULT NULL COMMENT '现病史 值域来源:疾病库',
                                      `diet_situation` varchar(512) DEFAULT NULL COMMENT '饮食情况 值域来源:标准值域',
                                      `sport_frequency` varchar(512) DEFAULT NULL COMMENT '运动频率 值域来源:标准值域',
                                      `sleeping_situation` varchar(512) DEFAULT NULL COMMENT '睡眠情况 值域来源:标准值域',
                                      `past_illness` varchar(512) DEFAULT NULL COMMENT '既往史 值域来源:疾病库',
                                      `sleeping_problem` varchar(512) DEFAULT NULL COMMENT '睡眠问题 值域来源:标准值域',
                                      `smoking_status` varchar(512) DEFAULT NULL COMMENT '吸烟标识 值域来源:标准值域',
                                      `medication_situation` varchar(2000) DEFAULT NULL COMMENT '用药情况',
                                      `drinking_status` varchar(512) DEFAULT NULL COMMENT '饮酒标识 值域来源:标准值域',
                                      `smoking_time_length` double DEFAULT NULL COMMENT '烟龄(年)',
                                      `sleeping_hours` varchar(512) DEFAULT NULL COMMENT '睡眠时长 值域来源:标准值域',
                                      `daily_smoke_amount` varchar(512) DEFAULT NULL COMMENT '日吸烟量 值域来源:标准值域',
                                      `eating_out` varchar(512) DEFAULT NULL COMMENT '在外就餐(每周) 值域来源:标准值域',
                                      `drinking_time_length` double DEFAULT NULL COMMENT '饮酒年限(年)',
                                      `medicare` varchar(512) DEFAULT NULL COMMENT '医疗保险 值域来源:标准值域',
                                      `sport_type` varchar(512) DEFAULT NULL COMMENT '运动类型 值域来源:标准值域',
                                      `family_composition` varchar(512) DEFAULT NULL COMMENT '家庭成员',
                                      `permanent_addr` varchar(512) DEFAULT NULL COMMENT '常住地址',
                                      `emergency_contact_relationship` varchar(512) DEFAULT NULL COMMENT '紧急联系人-关系 值域来源:标准值域',
                                      `waistline` double DEFAULT NULL COMMENT '腰围(cm) 值域来源:标准值域',
                                      `sport_duration` varchar(512) DEFAULT NULL COMMENT '次运动时长(min) 值域来源:标准值域',
                                      `sport_time_length` varchar(512) DEFAULT NULL COMMENT '运动坚持时间 值域来源:标准值域',
                                      `sport_venue` varchar(512) DEFAULT NULL COMMENT '运动场所 值域来源:标准值域',
                                      `water_intake` varchar(512) DEFAULT NULL COMMENT '每日饮水量代码 值域来源:标准值域',
                                      `water_drinking_category` varchar(512) DEFAULT NULL COMMENT '饮水类别代码 值域来源:标准值域',
                                      PRIMARY KEY (`pk_id`),
                                      UNIQUE KEY `uniq_id` (`id`),
                                      UNIQUE KEY `uniq_sourceUniqueKey_gmtDeleted` (`source_unique_key`,`gmt_deleted`),
                                      KEY `idx_gmtCreated` (`gmt_created`),
                                      KEY `idx_gmtModified` (`gmt_modified`),
                                      KEY `idx_peopleId` (`people_id`),
                                      KEY `idx_source` (`source`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COMMENT='基本健康信息';

SET FOREIGN_KEY_CHECKS = 1;


/*
 Navicat Premium Data Transfer

 Source Server         : 医院内网-mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 192.168.1.149:3308
 Source Schema         : region_phr_data_service

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 13/02/2022 14:49:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for basic_health_info3
-- ----------------------------
DROP TABLE IF EXISTS `basic_health_info3`;
CREATE TABLE `basic_health_info3` (
                                      `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键（不允许业务上使用）',
                                      `id` bigint(20) unsigned NOT NULL COMMENT '用来业务上唯一识别该条数据',
                                      `gmt_created` datetime NOT NULL COMMENT '创建时间',
                                      `gmt_modified` datetime NOT NULL COMMENT '最后修改时间',
                                      `gmt_deleted` datetime NOT NULL DEFAULT '9999-12-31 23:59:59' COMMENT '逻辑删除时间',
                                      `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1 表示删除，0 表示未删除（该字段仅作为数据逻辑删除使用，不应在程序侧发生二次更新。）',
                                      `source` varchar(64) NOT NULL COMMENT '来源标识',
                                      `source_unique_key` varchar(128) NOT NULL COMMENT '数据唯一标识，如果数据来自外部抽取或同步为source#外部id,否则为source#id',
                                      `people_id` bigint(20) unsigned NOT NULL COMMENT '患者主索引id',
                                      `breakfast` varchar(128) DEFAULT NULL COMMENT '早餐',
                                      `lunch` varchar(128) DEFAULT NULL COMMENT '午餐',
                                      `dinner` varchar(128) DEFAULT NULL COMMENT '晚餐',
                                      `is_snacks` varchar(128) DEFAULT NULL COMMENT '是否加餐',
                                      `id_card_type` varchar(512) DEFAULT NULL COMMENT '身份证件类别代码 值域来源:标准值域',
                                      `age` varchar(128) DEFAULT NULL COMMENT '年龄',
                                      `citizenship` varchar(512) DEFAULT NULL COMMENT '国籍 值域来源:标准值域',
                                      `nation` varchar(512) DEFAULT NULL COMMENT '民族',
                                      `temperature` double DEFAULT NULL COMMENT '体温(℃)',
                                      `pulse_rate` int(11) DEFAULT NULL COMMENT '脉率(次min)',
                                      `systolic_pressure` double DEFAULT NULL COMMENT '收缩压(mmHg）',
                                      `diastolic_pressure` double DEFAULT NULL COMMENT '舒张压(mmHg)',
                                      `body_mass_index` double DEFAULT NULL COMMENT '体质指数',
                                      `oxygen_saturation` int(11) DEFAULT NULL COMMENT '血氧饱和度',
                                      `blood_glucose` double DEFAULT NULL COMMENT '餐后两小时血糖值(mmolL)',
                                      `personal_history` varchar(128) DEFAULT NULL COMMENT '个人史',
                                      `time_to_quit_drinking` int(11) DEFAULT NULL COMMENT '戒酒时长',
                                      `time_to_quit_smoking` int(11) DEFAULT NULL COMMENT '戒烟时长',
                                      `exposure_history_of_occupational_disease_hazards` varchar(128) DEFAULT NULL COMMENT '职业病危害因素接触史',
                                      `job_description` varchar(128) DEFAULT NULL COMMENT '从事职业工种描述',
                                      `working_age` int(11) DEFAULT NULL COMMENT '从业年龄',
                                      `protective_measures` varchar(128) DEFAULT NULL COMMENT '职业防护措施',
                                      `occupational_hazard_factor_category_code` varchar(512) DEFAULT NULL COMMENT '职业病危害因素类别代码 值域来源:标准值域',
                                      `protective_measures_status` varchar(128) DEFAULT NULL COMMENT '职业防护措施标志',
                                      `main_hospital` varchar(512) DEFAULT NULL COMMENT '主要就诊医院',
                                      `personal_habit` varchar(512) DEFAULT NULL COMMENT '个人习惯',
                                      `special_crowd_label` varchar(512) DEFAULT NULL COMMENT '特殊人群标签 值域来源:标准值域',
                                      `drinking_remark` varchar(128) DEFAULT NULL COMMENT '饮酒备注',
                                      `email` varchar(128) DEFAULT NULL COMMENT '电子邮件地址',
                                      `menopause` varchar(128) DEFAULT NULL COMMENT '绝经标志',
                                      `sport_remark` varchar(128) DEFAULT NULL COMMENT '运动备注',
                                      PRIMARY KEY (`pk_id`),
                                      UNIQUE KEY `uniq_id` (`id`),
                                      UNIQUE KEY `uniq_sourceUniqueKey_gmtDeleted` (`source_unique_key`,`gmt_deleted`),
                                      KEY `idx_gmtCreated` (`gmt_created`),
                                      KEY `idx_gmtModified` (`gmt_modified`),
                                      KEY `idx_peopleId` (`people_id`),
                                      KEY `idx_source` (`source`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COMMENT='基本健康信息';

SET FOREIGN_KEY_CHECKS = 1;


/*
 Navicat Premium Data Transfer

 Source Server         : 医院内网-mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 192.168.1.149:3308
 Source Schema         : region_phr_data_service

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 13/02/2022 14:49:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for basic_health_info4
-- ----------------------------
DROP TABLE IF EXISTS `basic_health_info4`;
CREATE TABLE `basic_health_info4` (
                                      `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键（不允许业务上使用）',
                                      `id` bigint(20) unsigned NOT NULL COMMENT '用来业务上唯一识别该条数据',
                                      `gmt_created` datetime NOT NULL COMMENT '创建时间',
                                      `gmt_modified` datetime NOT NULL COMMENT '最后修改时间',
                                      `gmt_deleted` datetime NOT NULL DEFAULT '9999-12-31 23:59:59' COMMENT '逻辑删除时间',
                                      `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1 表示删除，0 表示未删除（该字段仅作为数据逻辑删除使用，不应在程序侧发生二次更新。）',
                                      `source` varchar(64) NOT NULL COMMENT '来源标识',
                                      `source_unique_key` varchar(128) NOT NULL COMMENT '数据唯一标识，如果数据来自外部抽取或同步为source#外部id,否则为source#id',
                                      `people_id` bigint(20) unsigned NOT NULL COMMENT '患者主索引id',
                                      `personal_basic_info_remark` varchar(128) DEFAULT NULL COMMENT '个人基本信息备注',
                                      `is_dietary_pattern_regular` varchar(128) DEFAULT NULL COMMENT '饮食是否规律',
                                      `hydration_liquid_type` varchar(512) DEFAULT NULL COMMENT '饮水习惯 值域来源:标准值域',
                                      `smoking_remark` varchar(128) DEFAULT NULL COMMENT '吸烟备注',
                                      `time_to_fall_asleep` varchar(512) DEFAULT NULL COMMENT '入睡时长 值域来源:标准值域',
                                      `is_siesta_taking` varchar(128) DEFAULT NULL COMMENT '是否午睡',
                                      `guardian_relationship` varchar(512) DEFAULT NULL COMMENT '监护人与本人关系代码 值域来源:标准值域',
                                      `birth_gestational_weeks` int(11) DEFAULT NULL COMMENT '出生孕周(d)',
                                      `delivery_mode` varchar(512) DEFAULT NULL COMMENT '分娩方式代码 值域来源:标准值域',
                                      `birth_weight` double DEFAULT NULL COMMENT '出生体重(g)',
                                      `asphyxia_flag` varchar(128) DEFAULT NULL COMMENT '窒息标志',
                                      `head_holding_up_age` int(11) DEFAULT NULL COMMENT '抬头月龄(月)',
                                      `sitting_age` int(11) DEFAULT NULL COMMENT '婴幼儿独坐月龄(月)',
                                      `crawling_age` int(11) DEFAULT NULL COMMENT '爬行月龄(月)',
                                      `standing_age` int(11) DEFAULT NULL COMMENT '站立月龄',
                                      `walking_age` int(11) DEFAULT NULL COMMENT '行走月龄',
                                      `breastfeeding_stop_age` int(11) DEFAULT NULL COMMENT '断母乳喂养月龄',
                                      `solid_food_introduction_age` int(11) DEFAULT NULL COMMENT '辅食添加月龄',
                                      `diarrhea_attack_frequency` varchar(512) DEFAULT NULL COMMENT '腹泻频率 值域来源:标准值域',
                                      `baby_stool_form_scale` varchar(512) DEFAULT NULL COMMENT '儿童大便性状代码 值域来源:标准值域',
                                      `child_hydration_liquid_type` varchar(512) DEFAULT NULL COMMENT '儿童饮品 值域来源:标准值域',
                                      `feeding_patterns` varchar(512) DEFAULT NULL COMMENT '喂养方式类别代码 值域来源:标准值域',
                                      `dietary_remark` varchar(128) DEFAULT NULL COMMENT '饮食备注',
                                      `time_to_sleep` varchar(512) DEFAULT NULL COMMENT '入睡时间 值域来源:标准值域',
                                      `apgar` varchar(128) DEFAULT NULL COMMENT 'Apgar评分值(分)',
                                      `drinking_classification` varchar(512) DEFAULT NULL COMMENT '饮酒种类代码 值域来源:标准值域',
                                      `allergies_history` varchar(512) DEFAULT NULL COMMENT '过敏史 值域来源:标准值域',
                                      `menopause_date` varchar(128) DEFAULT NULL COMMENT '绝经年龄(岁)',
                                      `respiratory_rate` int(11) DEFAULT NULL COMMENT '呼吸频率(次min)',
                                      `kitchen_air_exaust_facilities_category` varchar(512) DEFAULT NULL COMMENT '厨房排风设施类别代码',
                                      `fuel_type` varchar(512) DEFAULT NULL COMMENT '燃料类型类别代码',
                                      PRIMARY KEY (`pk_id`),
                                      UNIQUE KEY `uniq_id` (`id`),
                                      UNIQUE KEY `uniq_sourceUniqueKey_gmtDeleted` (`source_unique_key`,`gmt_deleted`),
                                      KEY `idx_gmtCreated` (`gmt_created`),
                                      KEY `idx_gmtModified` (`gmt_modified`),
                                      KEY `idx_peopleId` (`people_id`),
                                      KEY `idx_source` (`source`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COMMENT='基本健康信息';

SET FOREIGN_KEY_CHECKS = 1;



/*
 Navicat Premium Data Transfer

 Source Server         : 医院内网-mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 192.168.1.149:3308
 Source Schema         : region_phr_data_service

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 13/02/2022 14:50:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for basic_health_info5
-- ----------------------------
DROP TABLE IF EXISTS `basic_health_info5`;
CREATE TABLE `basic_health_info5` (
                                      `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键（不允许业务上使用）',
                                      `id` bigint(20) unsigned NOT NULL COMMENT '用来业务上唯一识别该条数据',
                                      `gmt_created` datetime NOT NULL COMMENT '创建时间',
                                      `gmt_modified` datetime NOT NULL COMMENT '最后修改时间',
                                      `gmt_deleted` datetime NOT NULL DEFAULT '9999-12-31 23:59:59' COMMENT '逻辑删除时间',
                                      `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1 表示删除，0 表示未删除（该字段仅作为数据逻辑删除使用，不应在程序侧发生二次更新。）',
                                      `source` varchar(64) NOT NULL COMMENT '来源标识',
                                      `source_unique_key` varchar(128) NOT NULL COMMENT '数据唯一标识，如果数据来自外部抽取或同步为source#外部id,否则为source#id',
                                      `people_id` bigint(20) unsigned NOT NULL COMMENT '患者主索引id',
                                      `toilet_category` varchar(512) DEFAULT NULL COMMENT '厕所类别代码',
                                      `livestock_bar_category` varchar(512) DEFAULT NULL COMMENT '禽畜栏类别',
                                      `exposure_history` varchar(512) DEFAULT NULL COMMENT '职业暴露史标志',
                                      `blood_transfusion_history` varchar(128) DEFAULT NULL COMMENT '输血史',
                                      `disability_code` varchar(512) DEFAULT NULL COMMENT '残疾情况代码 值域来源:标准值域',
                                      `home_return_permit` varchar(128) DEFAULT NULL COMMENT '港澳居民来往内地通行证',
                                      `physical_activity_intensity` varchar(512) DEFAULT NULL COMMENT '身体活动强度分类代码 值域来源:标准值域',
                                      `heart_rate` int(11) DEFAULT NULL COMMENT '心率(次min)',
                                      `env_danger_exposure_code` varchar(512) DEFAULT NULL COMMENT '环境危险因素暴露代码 值域来源:标准值域',
                                      `contraception` varchar(512) DEFAULT NULL COMMENT '避孕方式代码 值域来源:标准值域',
                                      `hiplines` double DEFAULT NULL COMMENT '臀围(cm)',
                                      `hypertension` varchar(128) DEFAULT NULL COMMENT '2级、3级高血压',
                                      `hypertension_drugs` varchar(512) DEFAULT NULL COMMENT '服用高血压药物',
                                      `hypertension_lead` varchar(128) DEFAULT NULL COMMENT '糖尿病下肢动脉病变',
                                      `e14_500x050` varchar(128) DEFAULT NULL COMMENT '糖尿病足',
                                      `e14_500x043` varchar(128) DEFAULT NULL COMMENT '糖尿病性下肢溃疡',
                                      `e14_100x011` varchar(128) DEFAULT NULL COMMENT '糖尿病性酮症酸中毒',
                                      `e14_400x121` varchar(128) DEFAULT NULL COMMENT '糖尿病性肌无力综合征',
                                      `e14_600x043` varchar(128) DEFAULT NULL COMMENT '糖尿病性低血糖症',
                                      `diabetes_drugs` varchar(512) DEFAULT NULL COMMENT '糖尿病服药情况',
                                      `i64_x00` varchar(128) DEFAULT NULL COMMENT '脑卒中',
                                      `i50_100x006` varchar(128) DEFAULT NULL COMMENT '心力衰竭',
                                      `i50_000` varchar(128) DEFAULT NULL COMMENT '充血性心力衰竭',
                                      `lvef_less40` varchar(128) DEFAULT NULL COMMENT '射血分数<40%',
                                      `i46_901` varchar(128) DEFAULT NULL COMMENT '呼吸心跳骤停',
                                      `i24_900x001` varchar(128) DEFAULT NULL COMMENT '急性心肌缺血',
                                      `i21_900x011` varchar(128) DEFAULT NULL COMMENT '心肌梗死',
                                      `asthma_exacerbations` varchar(128) DEFAULT NULL COMMENT '哮喘恶化',
                                      `hepatitis_acute` varchar(128) DEFAULT NULL COMMENT '肝炎急性期',
                                      `liver_cancer_deterioration` varchar(128) DEFAULT NULL COMMENT '肝癌恶化',
                                      `liver_cancer_end_stage` varchar(128) DEFAULT NULL COMMENT '肝癌终末期',
                                      PRIMARY KEY (`pk_id`),
                                      UNIQUE KEY `uniq_id` (`id`),
                                      UNIQUE KEY `uniq_sourceUniqueKey_gmtDeleted` (`source_unique_key`,`gmt_deleted`),
                                      KEY `idx_gmtCreated` (`gmt_created`),
                                      KEY `idx_gmtModified` (`gmt_modified`),
                                      KEY `idx_peopleId` (`people_id`),
                                      KEY `idx_source` (`source`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COMMENT='基本健康信息';

SET FOREIGN_KEY_CHECKS = 1;


/*
 Navicat Premium Data Transfer

 Source Server         : 医院内网-mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 192.168.1.149:3308
 Source Schema         : region_phr_data_service

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 13/02/2022 14:50:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for basic_health_info6
-- ----------------------------
DROP TABLE IF EXISTS `basic_health_info6`;
CREATE TABLE `basic_health_info6` (
                                      `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键（不允许业务上使用）',
                                      `id` bigint(20) unsigned NOT NULL COMMENT '用来业务上唯一识别该条数据',
                                      `gmt_created` datetime NOT NULL COMMENT '创建时间',
                                      `gmt_modified` datetime NOT NULL COMMENT '最后修改时间',
                                      `gmt_deleted` datetime NOT NULL DEFAULT '9999-12-31 23:59:59' COMMENT '逻辑删除时间',
                                      `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1 表示删除，0 表示未删除（该字段仅作为数据逻辑删除使用，不应在程序侧发生二次更新。）',
                                      `source` varchar(64) NOT NULL COMMENT '来源标识',
                                      `source_unique_key` varchar(128) NOT NULL COMMENT '数据唯一标识，如果数据来自外部抽取或同步为source#外部id,否则为source#id',
                                      `people_id` bigint(20) unsigned NOT NULL COMMENT '患者主索引id',
                                      `k72_903` varchar(128) DEFAULT NULL COMMENT '肝性脑病',
                                      `k74_607` varchar(128) DEFAULT NULL COMMENT '肝硬化失代偿期',
                                      `k70_000` varchar(128) DEFAULT NULL COMMENT '酒精性脂肪肝',
                                      `parkinson_staging` varchar(512) DEFAULT NULL COMMENT '帕金森分期 值域来源:标准值域',
                                      `g20_x00x005__f02_3` varchar(128) DEFAULT NULL COMMENT '帕金森病性痴呆[震颤麻痹性痴呆]',
                                      `late_parkinson` varchar(128) DEFAULT NULL COMMENT '帕金森后期',
                                      `hemophilia_muscle_bleeding` varchar(128) DEFAULT NULL COMMENT '血友病肌肉出血',
                                      `complex_arrhythmias_at_rest` varchar(128) DEFAULT NULL COMMENT '安静状态下复杂的心律失常',
                                      `r50_900x002` varchar(128) DEFAULT NULL COMMENT '高热',
                                      `lung_deterioration` varchar(128) DEFAULT NULL COMMENT '肺部疾病恶化',
                                      `chemo_radio_therapy` varchar(128) DEFAULT NULL COMMENT '放化疗',
                                      `chemo_radio_therapy_symptoms` varchar(512) DEFAULT NULL COMMENT '放化疗后症状',
                                      `abnormal_posture` varchar(128) DEFAULT NULL COMMENT '异常体态',
                                      `paralysis_or_amputation` varchar(128) DEFAULT NULL COMMENT '瘫痪或截肢',
                                      `joint_disease` varchar(128) DEFAULT NULL COMMENT '关节病变',
                                      `work_intensity` varchar(512) DEFAULT NULL COMMENT '工作强度 值域来源:标准值域',
                                      `full_term_births` int(11) DEFAULT NULL COMMENT '足月生产数',
                                      `daily_exercise` varchar(128) DEFAULT NULL COMMENT '每日运动(步)',
                                      `daily_staple_food` varchar(128) DEFAULT NULL COMMENT '每日主食(顿)',
                                      `exercise_time` varchar(512) DEFAULT NULL COMMENT '运动时间 枚举：不固定、空腹、餐后',
                                      `premature_births` int(11) DEFAULT NULL COMMENT '早产数',
                                      `abortions` int(11) DEFAULT NULL COMMENT '流产数',
                                      `survival` int(11) DEFAULT NULL COMMENT '存活数',
                                      `taking_medicine` varchar(512) DEFAULT NULL COMMENT '服用的药物 值域来源:标准值域',
                                      `exercise_or_not` varchar(128) DEFAULT NULL COMMENT '是否运动锻炼',
                                      `weekly_work_days` varchar(512) DEFAULT NULL COMMENT '每周工作几天 值域来源:标准值域',
                                      `daily_working_hours` varchar(512) DEFAULT NULL COMMENT '每日工作时长(h) 值域来源:标准值域',
                                      `sitting_time` varchar(512) DEFAULT NULL COMMENT '坐着的时间 值域来源:标准值域',
                                      `mental_disorders` varchar(512) DEFAULT NULL COMMENT '精神异常症状 值域来源:标准值域',
                                      `factors_affecting_sleep` varchar(512) DEFAULT NULL COMMENT '影响睡眠的因素 值域来源:标准值域',
                                      `dietary_pattern_regular` varchar(512) DEFAULT NULL COMMENT '饮食规律 值域来源:标准值域',
                                      PRIMARY KEY (`pk_id`),
                                      UNIQUE KEY `uniq_id` (`id`),
                                      UNIQUE KEY `uniq_sourceUniqueKey_gmtDeleted` (`source_unique_key`,`gmt_deleted`),
                                      KEY `idx_gmtCreated` (`gmt_created`),
                                      KEY `idx_gmtModified` (`gmt_modified`),
                                      KEY `idx_peopleId` (`people_id`),
                                      KEY `idx_source` (`source`)
) ENGINE=InnoDB AUTO_INCREMENT=6268 DEFAULT CHARSET=utf8mb4 COMMENT='基本健康信息';

SET FOREIGN_KEY_CHECKS = 1;


/*
 Navicat Premium Data Transfer

 Source Server         : 医院内网-mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 192.168.1.149:3308
 Source Schema         : region_phr_data_service

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 13/02/2022 14:50:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for basic_health_info7
-- ----------------------------
DROP TABLE IF EXISTS `basic_health_info7`;
CREATE TABLE `basic_health_info7` (
                                      `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键（不允许业务上使用）',
                                      `id` bigint(20) unsigned NOT NULL COMMENT '用来业务上唯一识别该条数据',
                                      `gmt_created` datetime NOT NULL COMMENT '创建时间',
                                      `gmt_modified` datetime NOT NULL COMMENT '最后修改时间',
                                      `gmt_deleted` datetime NOT NULL DEFAULT '9999-12-31 23:59:59' COMMENT '逻辑删除时间',
                                      `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1 表示删除，0 表示未删除（该字段仅作为数据逻辑删除使用，不应在程序侧发生二次更新。）',
                                      `source` varchar(64) NOT NULL COMMENT '来源标识',
                                      `source_unique_key` varchar(128) NOT NULL COMMENT '数据唯一标识，如果数据来自外部抽取或同步为source#外部id,否则为source#id',
                                      `people_id` bigint(20) unsigned NOT NULL COMMENT '患者主索引id',
                                      `midnight_snack` varchar(512) DEFAULT NULL COMMENT '夜宵 值域来源:标准值域',
                                      `overeating` varchar(128) DEFAULT NULL COMMENT '暴饮暴食',
                                      `dinner_party` varchar(512) DEFAULT NULL COMMENT '聚会应酬 值域来源:标准值域',
                                      `food_preference` varchar(512) DEFAULT NULL COMMENT '饮食喜好 值域来源:标准值域',
                                      `staple_food` varchar(512) DEFAULT NULL COMMENT '主食 值域来源:标准值域',
                                      `drink_milk` varchar(512) DEFAULT NULL COMMENT '喝牛奶 值域来源:标准值域',
                                      `eat_eggs` varchar(512) DEFAULT NULL COMMENT '吃鸡蛋 值域来源:标准值域',
                                      `eat_bean_products` varchar(512) DEFAULT NULL COMMENT '吃豆制品 值域来源:标准值域',
                                      `eat_vegetable` varchar(512) DEFAULT NULL COMMENT '吃蔬菜 值域来源:标准值域',
                                      `eat_meat` varchar(512) DEFAULT NULL COMMENT '吃肉 值域来源:标准值域',
                                      `eat_fat` varchar(512) DEFAULT NULL COMMENT '吃肥肉 值域来源:标准值域',
                                      `eat_viscera` varchar(512) DEFAULT NULL COMMENT '吃内脏 值域来源:标准值域',
                                      `eat_seafood` varchar(512) DEFAULT NULL COMMENT '吃海鲜 值域来源:标准值域',
                                      `drink_coffee` varchar(512) DEFAULT NULL COMMENT '喝咖啡 值域来源:标准值域',
                                      `drink_sugary_drinks` varchar(512) DEFAULT NULL COMMENT '喝含糖饮料 值域来源:标准值域',
                                      `frequency_of_physical_examination` varchar(512) DEFAULT NULL COMMENT '体检频率 值域来源:标准值域',
                                      `learn_health_care` varchar(128) DEFAULT NULL COMMENT '学习保健知识 值域来源:标准值域',
                                      `learn_health_care_ways` varchar(512) DEFAULT NULL COMMENT '学习保健知识途径 值域来源:标准值域',
                                      `fasten_seat_belt` varchar(512) DEFAULT NULL COMMENT '系安全带 值域来源:标准值域',
                                      `observe_excrement` varchar(512) DEFAULT NULL COMMENT '观察排泄物 值域来源:标准值域',
                                      `monitor_blood_pressure` varchar(512) DEFAULT NULL COMMENT '监测血压 值域来源:标准值域',
                                      `bring_emergency_medicine` varchar(512) DEFAULT NULL COMMENT '携带急救药品 值域来源:标准值域',
                                      `bask_in_the_sun` varchar(512) DEFAULT NULL COMMENT '晒太阳 值域来源:标准值域',
                                      `blood_pressure_cognition` varchar(512) DEFAULT NULL COMMENT '血压认知 值域来源:标准值域',
                                      `temperature_cognition` varchar(512) DEFAULT NULL COMMENT '体温认知 值域来源:标准值域',
                                      `pulse_cognition` varchar(512) DEFAULT NULL COMMENT '脉搏认知 值域来源:标准值域',
                                      `salinity_cognition` varchar(512) DEFAULT NULL COMMENT '食盐量认知 值域来源:标准值域',
                                      `bmi_cognition` varchar(512) DEFAULT NULL COMMENT '体质指数认知 值域来源:标准值域',
                                      `male_waist_cognition` varchar(512) DEFAULT NULL COMMENT '男性腰围认知 值域来源:标准值域',
                                      `female_waist_cognition` varchar(512) DEFAULT NULL COMMENT '女性腰围认知 值域来源:标准值域',
                                      `blood_sugar_cognition` varchar(512) DEFAULT NULL COMMENT '血糖认知 值域来源:标准值域',
                                      PRIMARY KEY (`pk_id`),
                                      UNIQUE KEY `uniq_id` (`id`),
                                      UNIQUE KEY `uniq_sourceUniqueKey_gmtDeleted` (`source_unique_key`,`gmt_deleted`),
                                      KEY `idx_gmtCreated` (`gmt_created`),
                                      KEY `idx_gmtModified` (`gmt_modified`),
                                      KEY `idx_peopleId` (`people_id`),
                                      KEY `idx_source` (`source`)
) ENGINE=InnoDB AUTO_INCREMENT=6268 DEFAULT CHARSET=utf8mb4 COMMENT='基本健康信息';

SET FOREIGN_KEY_CHECKS = 1;


/*
 Navicat Premium Data Transfer

 Source Server         : 医院内网-mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 192.168.1.149:3308
 Source Schema         : region_phr_data_service

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 13/02/2022 14:50:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for basic_health_info8
-- ----------------------------
DROP TABLE IF EXISTS `basic_health_info8`;
CREATE TABLE `basic_health_info8` (
                                      `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键（不允许业务上使用）',
                                      `id` bigint(20) unsigned NOT NULL COMMENT '用来业务上唯一识别该条数据',
                                      `gmt_created` datetime NOT NULL COMMENT '创建时间',
                                      `gmt_modified` datetime NOT NULL COMMENT '最后修改时间',
                                      `gmt_deleted` datetime NOT NULL DEFAULT '9999-12-31 23:59:59' COMMENT '逻辑删除时间',
                                      `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1 表示删除，0 表示未删除（该字段仅作为数据逻辑删除使用，不应在程序侧发生二次更新。）',
                                      `source` varchar(64) NOT NULL COMMENT '来源标识',
                                      `source_unique_key` varchar(128) NOT NULL COMMENT '数据唯一标识，如果数据来自外部抽取或同步为source#外部id,否则为source#id',
                                      `people_id` bigint(20) unsigned NOT NULL COMMENT '患者主索引id',
                                      `triglyceride_cognition` varchar(512) DEFAULT NULL COMMENT '甘油三酯认知 值域来源:标准值域',
                                      `cholesterol_cognition` varchar(512) DEFAULT NULL COMMENT '总胆固醇认知 值域来源:标准值域',
                                      `physical_conditions` varchar(128) DEFAULT NULL COMMENT '身体状况 值域来源:标准值域',
                                      `eat_fruit` varchar(512) DEFAULT NULL COMMENT '吃水果 值域来源:标准值域',
                                      `payment_method` varchar(512) DEFAULT NULL COMMENT '医疗费用支付方式代码 值域来源:标准值域',
                                      `blood_transfusion_flag` varchar(128) DEFAULT NULL COMMENT '输血史标志',
                                      `body_fat_rate` double DEFAULT NULL COMMENT '体脂率%',
                                      `muscle_content` double DEFAULT NULL COMMENT '肌肉含量',
                                      `body_water_rate` double DEFAULT NULL COMMENT '体水分率',
                                      `visceral_fat` double DEFAULT NULL COMMENT '内脏脂肪',
                                      `diabetes_type` varchar(512) DEFAULT NULL COMMENT '糖尿病类型 枚举：1型糖尿病、2型糖尿病、妊娠糖尿病、其他',
                                      `diabetes_diagnosis_time` varchar(128) DEFAULT NULL COMMENT '糖尿病确诊时间',
                                      `diabetes_symptoms` varchar(512) DEFAULT NULL COMMENT '糖尿病症状',
                                      `is_ever_hypoglycemia` varchar(128) DEFAULT NULL COMMENT '是否发生过低血糖',
                                      `nearly_month_hypoglycemia` double DEFAULT NULL COMMENT '近一个月发生过低血糖(数值)',
                                      `deal_with_hypoglycemia` varchar(128) DEFAULT NULL COMMENT '发生低血糖时如何处理',
                                      `complication` varchar(512) DEFAULT NULL COMMENT '合并症/并发症',
                                      `hypertension_type` varchar(512) DEFAULT NULL COMMENT '高血压类型 高血压1级、高血压2级、高血压3级',
                                      `hypertension_diagnosis_time` varchar(128) DEFAULT NULL COMMENT '高血压确诊时间',
                                      `is_early_cardiovascular_disease` varchar(128) DEFAULT NULL COMMENT '是否有早发心血管疾病家族史',
                                      `hyperlipidemia_diagnosis_time` varchar(128) DEFAULT NULL COMMENT '高血脂确诊时间',
                                      `hyperlipidemia_symptoms` varchar(512) DEFAULT NULL COMMENT '高血脂症状',
                                      `high_uric_acid_diagnosis_time` varchar(128) DEFAULT NULL COMMENT '高尿酸确诊时间',
                                      `uric_acid` double DEFAULT NULL COMMENT '尿酸(数值)',
                                      `uric_acid_check_time` varchar(128) DEFAULT NULL COMMENT '尿酸检查时间',
                                      `uric_acid_past_max` double DEFAULT NULL COMMENT '既往尿酸最高值(数值)',
                                      `is_taking_uric_acid_drug` varchar(128) DEFAULT NULL COMMENT '是否服用降尿酸药物',
                                      `high_weight_diagnosis_time` varchar(128) DEFAULT NULL COMMENT '高体重确诊时间',
                                      `weight_loss_medication_or_surgery` varchar(512) DEFAULT NULL COMMENT '曾经进行减肥药物或手术治疗 从没有、过去进行过目前没有、目前正在进行',
                                      `weight_loss_history` varchar(512) DEFAULT NULL COMMENT '减肥历史时长 小于3个月、3-6个月、6-12个月、1-2年、2年以上',
                                      `weight_loss_success` varchar(512) DEFAULT NULL COMMENT '减肥是否成功 未成功、已成功-小于6个月、已成功-6-18个月、已成功-大于18个月',
                                      `current_medicines` varchar(2000) DEFAULT NULL COMMENT '当前用药',
                                      PRIMARY KEY (`pk_id`),
                                      UNIQUE KEY `uniq_id` (`id`),
                                      UNIQUE KEY `uniq_sourceUniqueKey_gmtDeleted` (`source_unique_key`,`gmt_deleted`),
                                      KEY `idx_gmtCreated` (`gmt_created`),
                                      KEY `idx_gmtModified` (`gmt_modified`),
                                      KEY `idx_peopleId` (`people_id`),
                                      KEY `idx_source` (`source`)
) ENGINE=InnoDB AUTO_INCREMENT=6268 DEFAULT CHARSET=utf8mb4 COMMENT='基本健康信息';

SET FOREIGN_KEY_CHECKS = 1;

