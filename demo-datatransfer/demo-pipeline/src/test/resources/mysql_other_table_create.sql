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

 Date: 13/02/2022 14:54:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for health_indicator
-- ----------------------------
DROP TABLE IF EXISTS `health_indicator`;
CREATE TABLE `health_indicator` (
                                    `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键（不允许业务上使用）',
                                    `id` bigint(20) unsigned NOT NULL COMMENT '用来业务上唯一识别该条数据',
                                    `gmt_created` datetime NOT NULL COMMENT '创建时间',
                                    `gmt_modified` datetime NOT NULL COMMENT '最后修改时间',
                                    `gmt_deleted` datetime NOT NULL DEFAULT '9999-12-31 23:59:59' COMMENT '逻辑删除时间',
                                    `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1 表示删除，0 表示未删除（该字段仅作为数据逻辑删除使用，不应在程序侧发生二次更新。）',
                                    `people_id` bigint(20) unsigned NOT NULL COMMENT '患者主索引id',
                                    `source_unique_key` varchar(128) NOT NULL COMMENT '数据唯一标识，如果数据来自外部抽取或同步为source#外部id,否则为source#id',
                                    `source` varchar(128) DEFAULT NULL COMMENT '数据来源标识',
                                    `device_model` varchar(128) DEFAULT NULL COMMENT '设备型号',
                                    `bluetooth_addr` varchar(128) DEFAULT NULL COMMENT '蓝牙地址',
                                    `device_serial` varchar(128) DEFAULT NULL COMMENT '设备序列号',
                                    `measure_address` varchar(128) DEFAULT NULL COMMENT '测量地点',
                                    `measure_longitude` double DEFAULT NULL COMMENT '测量地点的经度',
                                    `measure_latitude` double DEFAULT NULL COMMENT '测量地点的维度',
                                    `temperature` double DEFAULT NULL COMMENT '体温（摄氏度）',
                                    `temperature_status` tinyint(4) DEFAULT NULL COMMENT '体温状态 0-正常 1-偏高 2-偏低',
                                    `respiratory_rate` int(11) DEFAULT NULL COMMENT '呼吸频率（次/min）',
                                    `respiratory_rate_status` tinyint(4) DEFAULT NULL COMMENT '呼吸频率（次/min）状态 0-正常 1-偏高 2-偏低',
                                    `blood_pressure_measure_time_label` int(11) DEFAULT NULL COMMENT '血压测量时间标签',
                                    `systolic_pressure` double DEFAULT NULL COMMENT '收缩压(mmHg）',
                                    `systolic_pressure_status` tinyint(4) DEFAULT NULL COMMENT '收缩压(mmHg）状态 0-正常 1-偏高 2-偏低',
                                    `diastolic_pressure` double DEFAULT NULL COMMENT '舒张压(mmHg）',
                                    `diastolic_pressure_status` tinyint(4) DEFAULT NULL COMMENT '舒张压(mmHg）状态 0-正常 1-偏高 2-偏低',
                                    `pulse_rate` int(11) DEFAULT NULL COMMENT '脉搏（次/min）',
                                    `pulse_rate_status` tinyint(4) DEFAULT NULL COMMENT '脉搏（次/min）状态 0-正常 1-偏高 2-偏低',
                                    `heart_rate` int(11) DEFAULT NULL COMMENT '心率 （次/min）',
                                    `height` double DEFAULT NULL COMMENT '身高（cm）',
                                    `weight` double DEFAULT NULL COMMENT '体重(kg）',
                                    `body_mass_index` double DEFAULT NULL COMMENT 'BMI指数 体质指数',
                                    `body_mass_index_status` tinyint(4) DEFAULT NULL COMMENT 'BMI指数 体质指数状态 0-正常 1-偏高 2-偏低',
                                    `measure_time_label` int(11) DEFAULT NULL COMMENT '血糖测量时间标签',
                                    `blood_sugar` double DEFAULT NULL COMMENT '血糖',
                                    `blood_sugar_status` tinyint(4) DEFAULT NULL COMMENT '血糖状态 0-正常 1-偏高 2-偏低',
                                    `oxygen_saturation` int(11) DEFAULT NULL COMMENT '血氧饱和度（%）',
                                    `oxygen_saturation_status` tinyint(4) DEFAULT NULL COMMENT '血氧饱和度（%）状态 0-正常 1-偏高 2-偏低',
                                    `waist` double DEFAULT NULL COMMENT '腰围',
                                    `body_fat` int(11) DEFAULT NULL COMMENT '体脂率',
                                    `body_fat_rate` double DEFAULT NULL COMMENT '体脂率%',
                                    `biz_labels` bit(32) DEFAULT NULL,
                                    PRIMARY KEY (`pk_id`),
                                    UNIQUE KEY `uniq_id` (`id`),
                                    UNIQUE KEY `uniq_sourceUniqueKey_gmtDeleted` (`source_unique_key`,`gmt_deleted`),
                                    KEY `idx_gmtCreated` (`gmt_created`),
                                    KEY `idx_gmtModified` (`gmt_modified`),
                                    KEY `idx_peopleId` (`people_id`),
                                    KEY `idx_source` (`source`)
) ENGINE=InnoDB AUTO_INCREMENT=440 DEFAULT CHARSET=utf8mb4 COMMENT='null';

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

 Date: 13/02/2022 14:54:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for health_indicator2
-- ----------------------------
DROP TABLE IF EXISTS `health_indicator2`;
CREATE TABLE `health_indicator2` (
                                     `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键（不允许业务上使用）',
                                     `id` bigint(20) unsigned NOT NULL COMMENT '用来业务上唯一识别该条数据',
                                     `gmt_created` datetime NOT NULL COMMENT '创建时间',
                                     `gmt_modified` datetime NOT NULL COMMENT '最后修改时间',
                                     `gmt_deleted` datetime NOT NULL DEFAULT '9999-12-31 23:59:59' COMMENT '逻辑删除时间',
                                     `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1 表示删除，0 表示未删除（该字段仅作为数据逻辑删除使用，不应在程序侧发生二次更新。）',
                                     `people_id` bigint(20) unsigned NOT NULL COMMENT '患者主索引id',
                                     `source_unique_key` varchar(128) NOT NULL COMMENT '数据唯一标识，如果数据来自外部抽取或同步为source#外部id,否则为source#id',
                                     `source` varchar(128) DEFAULT NULL COMMENT '数据来源标识',
                                     `body_fat_rate_status` tinyint(4) DEFAULT NULL COMMENT '体脂率%状态 0-正常 1-偏高 2-偏低',
                                     `uric_acid` double DEFAULT NULL COMMENT '尿酸',
                                     `uric_acid_status` tinyint(4) DEFAULT NULL COMMENT '尿酸 状态 0-正常 1-偏高 2-偏低',
                                     `total_cholesterol` double DEFAULT NULL COMMENT '总胆固醇',
                                     `total_cholesterol_status` tinyint(4) DEFAULT NULL COMMENT '总胆固醇',
                                     `acute_weight_gain_count_of_year` int(11) DEFAULT NULL COMMENT '每年急性增重次数',
                                     `acute_weight_gain_degree_of_year` int(11) DEFAULT NULL COMMENT '每年急性增重程度：1、轻度；2、中度；3、重度；',
                                     `mmrc` int(11) DEFAULT NULL COMMENT 'mMRC呼吸困难评估：0-0级；1-1级；2-2级；3-3级；4-4级；',
                                     `fev1` double DEFAULT NULL COMMENT '肺功能fev1',
                                     `fvc` double DEFAULT NULL COMMENT '肺功能fvc',
                                     `head_circumference` double DEFAULT NULL COMMENT '头围',
                                     `muscle_content` double DEFAULT NULL COMMENT '肌肉含量',
                                     `muscle_content_status` tinyint(4) DEFAULT NULL COMMENT '肌肉含量状态 0-正常 1-偏高 2-偏低',
                                     `body_water_rate` double DEFAULT NULL COMMENT '体水分率',
                                     `body_water_rate_status` tinyint(4) DEFAULT NULL COMMENT '体水分率状态 0-正常 1-偏高 2-偏低',
                                     `visceral_fat` int(11) DEFAULT NULL COMMENT '内脏脂肪',
                                     `visceral_fat_status` tinyint(4) DEFAULT NULL COMMENT '内脏脂肪状态 0-正常 1-偏高 2-偏低',
                                     `homocysteine` double DEFAULT NULL COMMENT '血同型半胱氨酸 μmol/L',
                                     `homocysteine_status` tinyint(4) DEFAULT NULL COMMENT '血同型半胱氨酸 μmol/L状态 0-正常 1-偏高 2-偏低',
                                     `label` varchar(128) DEFAULT NULL COMMENT '数据标签',
                                     `name` varchar(128) DEFAULT NULL COMMENT '姓名',
                                     `age` varchar(128) DEFAULT NULL COMMENT '年龄',
                                     `gender` int(11) DEFAULT NULL COMMENT '性别',
                                     `id_card_type` int(11) DEFAULT NULL COMMENT '身份证件类别',
                                     `id_card_no` varchar(128) DEFAULT NULL COMMENT '身份证件号码 数据元：DE02.01.030.00 字段说明：公安部公民唯一身份证件号码，优先填写 表示格式：S1 AN18',
                                     `measure_time` varchar(128) DEFAULT NULL COMMENT '测量时间',
                                     `terminal_unit` varchar(128) DEFAULT NULL COMMENT '终端设备号 如：一体机的设备号，微医通的设备号',
                                     `biz_labels` text COMMENT '业务标签',
                                     `hb_a1c` double DEFAULT NULL COMMENT '糖化血红蛋白 单位：%',
                                     `hb_a1c_status` tinyint(4) DEFAULT NULL COMMENT '糖化血红蛋白状态 0-正常 1-偏高 2-偏低',
                                     `tc` double DEFAULT NULL COMMENT '总胆固醇 单位：mmol/L',
                                     `tc_status` tinyint(4) DEFAULT NULL COMMENT '总胆固醇状态 0-正常 1-偏高 2-偏低',
                                     `tg` varchar(128) DEFAULT NULL COMMENT '甘油三脂 单位：mmol/L',
                                     `tg_status` tinyint(4) DEFAULT NULL COMMENT '甘油三脂状态 0-正常 1-偏高 2-偏低',
                                     `hdl` double DEFAULT NULL COMMENT '高密度脂蛋白 单位：mmol/L',
                                     `hdl_status` tinyint(4) DEFAULT NULL COMMENT '高密度脂蛋白状态 0-正常 1-偏高 2-偏低',
                                     `ldl` double DEFAULT NULL COMMENT '低密度脂蛋白 单位：mmol/L',
                                     `ldl_status` tinyint(4) DEFAULT NULL COMMENT '低密度脂蛋白状态 0-正常 1-偏高 2-偏低',
                                     PRIMARY KEY (`pk_id`),
                                     UNIQUE KEY `uniq_id` (`id`),
                                     UNIQUE KEY `uniq_sourceUniqueKey_gmtDeleted` (`source_unique_key`,`gmt_deleted`),
                                     KEY `idx_gmtCreated` (`gmt_created`),
                                     KEY `idx_gmtModified` (`gmt_modified`),
                                     KEY `idx_peopleId` (`people_id`),
                                     KEY `idx_source` (`source`)
) ENGINE=InnoDB AUTO_INCREMENT=6043 DEFAULT CHARSET=utf8mb4 COMMENT='null';

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 08/04/2022 17:51:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for people
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
                          `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                          `gmt_created` datetime NOT NULL COMMENT '创建时间',
                          `gmt_modified` datetime NOT NULL COMMENT '修改时间',
                          `biz_id` bigint(20) unsigned NOT NULL COMMENT '自然人id',
                          `name` varchar(64) DEFAULT NULL COMMENT '姓名',
                          `gender` tinyint(3) unsigned DEFAULT NULL COMMENT '性别:0-未知，1-男，2-女，9-未说明的性别',
                          `id_card_no` varchar(32) DEFAULT NULL COMMENT '身份证号',
                          `household_register` varchar(32) DEFAULT NULL COMMENT '居民户口本',
                          `passport` varchar(32) DEFAULT NULL COMMENT '护照',
                          `military_license` varchar(32) DEFAULT NULL COMMENT '军官证',
                          `driving_license` varchar(32) DEFAULT NULL COMMENT '驾驶证',
                          `hk_and_mo_pass` varchar(32) DEFAULT NULL COMMENT '港澳通行证',
                          `taiwan_pass` varchar(32) DEFAULT NULL COMMENT '台湾通行证',
                          `home_return_permit` varchar(32) DEFAULT NULL COMMENT '港澳居民来往内地通行证，俗称回乡证',
                          `other_card_no` varchar(32) DEFAULT NULL COMMENT '其他证件号',
                          `phone_number` varchar(32) DEFAULT NULL COMMENT '手机号',
                          `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
                          `date_of_birth` date DEFAULT NULL COMMENT '生日',
                          `citizenship` varchar(32) DEFAULT NULL COMMENT '国籍',
                          `nation` varchar(16) DEFAULT NULL COMMENT '名族',
                          `domicile` tinyint(3) unsigned DEFAULT NULL COMMENT '常住地类型',
                          `household_register_sign` tinyint(1) DEFAULT NULL COMMENT '常住地址户籍标志',
                          `address` varchar(128) DEFAULT NULL COMMENT '详细地址',
                          `province_id` int(11) DEFAULT NULL COMMENT '省（自治区、直辖市）Id',
                          `province` varchar(32) DEFAULT NULL COMMENT '省（自治区、直辖市）',
                          `city_id` int(11) DEFAULT NULL COMMENT '市（地区、州）Id',
                          `city` varchar(32) DEFAULT NULL COMMENT '市（地区、州）',
                          `county_id` int(11) DEFAULT NULL COMMENT '县（区）Id',
                          `county` varchar(32) DEFAULT NULL COMMENT '县（区）',
                          `township` varchar(32) DEFAULT NULL COMMENT '乡（镇、街道办事处）',
                          `village` varchar(32) DEFAULT NULL COMMENT '村(街、路、弄等)',
                          `doorplate` varchar(32) DEFAULT NULL COMMENT '门牌',
                          `postal_code` varchar(16) DEFAULT NULL COMMENT '邮政编码',
                          `birth_certificate` varchar(32) DEFAULT NULL COMMENT '出生证明',
                          `health_card_no` varchar(64) DEFAULT NULL COMMENT '居民健康卡号',
                          `outpatient_no` varchar(64) DEFAULT NULL COMMENT '门诊卡号',
                          `inpatient_no` varchar(64) DEFAULT NULL COMMENT '住院号',
                          `mi_card` varchar(32) DEFAULT NULL COMMENT '医保卡号',
                          `pip_mi_area_code` varchar(32) DEFAULT NULL COMMENT '医保区域编码，该字段仅提区域人口信息平台医保策略使用',
                          `township_id` int(11) DEFAULT NULL COMMENT '乡（镇、街道办事处）Id',
                          `village_id` int(11) DEFAULT NULL COMMENT '村(街、路、弄等)Id',
                          PRIMARY KEY (`id`) USING BTREE,
                          UNIQUE KEY `uniq_biz_id` (`biz_id`) USING BTREE,
                          KEY `idx_gmtModified` (`gmt_modified`) USING BTREE,
                          KEY `idx_name_bizId` (`name`,`biz_id`) USING BTREE,
                          KEY `idx_idCardNo_bizId` (`id_card_no`,`biz_id`) USING BTREE,
                          KEY `idx_gender_bizId` (`gender`,`biz_id`) USING BTREE,
                          KEY `idx_gmtCreated_bizId` (`gmt_created`,`biz_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=906343 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='自然人表';

SET FOREIGN_KEY_CHECKS = 1;



/*
 Navicat Premium Data Transfer

 Source Server         : 济南中心医院内网
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 192.168.2.112:3308
 Source Schema         : phc_empi

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 15/02/2022 17:54:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for people_atomic_info
-- ----------------------------
DROP TABLE IF EXISTS `people_atomic_info`;
CREATE TABLE `people_atomic_info` (
                                      `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                                      `gmt_created` datetime NOT NULL COMMENT '创建时间',
                                      `gmt_modified` datetime NOT NULL COMMENT '修改时间',
                                      `people_id` bigint(20) unsigned NOT NULL COMMENT '自然人id',
                                      `atomic_code` varchar(64) NOT NULL COMMENT '原子策略code',
                                      `atomic_value` varchar(128) NOT NULL COMMENT '原子信息内容',
                                      PRIMARY KEY (`id`) USING BTREE,
                                      UNIQUE KEY `uniq_atomicCode_atomicValue` (`atomic_code`,`atomic_value`) USING BTREE,
                                      KEY `idx_gmtModified` (`gmt_modified`) USING BTREE,
                                      KEY `idx_peopleId` (`people_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3823472 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='自然人原子信息表';

SET FOREIGN_KEY_CHECKS = 1;

