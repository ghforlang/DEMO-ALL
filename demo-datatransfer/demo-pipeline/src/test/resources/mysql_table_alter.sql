-- df表新增source字段
-- 基本健康信息表
ALTER TABLE health_record_basichealthinformation_df_enc2 ADD COLUMN source VARCHAR(255)  COMMENT '数据source';
ALTER TABLE health_record_basichealthinformation_df_enc2 ADD COLUMN source_unique_key VARCHAR(255)  COMMENT 'source_unique_key';
ALTER TABLE health_record_basichealthinformation_df_enc2 ADD COLUMN id_card_type VARCHAR(255)  COMMENT '卡类型';
ALTER TABLE health_record_basichealthinformation_df_enc2 ADD COLUMN gmt_deleted timestamp(255)  COMMENT '删除时间';

-- df指标表
ALTER TABLE health_record_healthindicator_df ADD COLUMN biz_labels_data INTEGER(8)  COMMENT 'biz_lebel值';
-- df指标表 值填充 执行datacleanout中的bizLabelsTransfer.sql

ALTER TABLE health_record_people_df_12 MODIFY COLUMN dateofbirth DATE;



-- 更新df表值填充,值更新临时放这里
UPDATE health_record_basichealthinformation_df_enc2 SET source = 'hc_0';
UPDATE health_record_basichealthinformation_df_enc2 SET id_card_type = '{"code":1,"value":"居民身份证"}';
-- 注意，一旦id中途重新生成，这里的source_unique_key也需要重新生成
UPDATE health_record_basichealthinformation_df_enc2 SET source_unique_key = CONCAT(source,'#',id);
UPDATE health_record_basichealthinformation_df_enc2 SET gmt_deleted = '9999-12-31 23:59:59';
UPDATE health_record_people_df_12 SET dateofbirth = replace(dateofbirth,'CDT','CST') WHERE dateofbirth LIKE '%CDT%' ;

