package com.edu.nbu.fan.gen.model;

import com.edu.nbu.fan.gen.anno.Transfer;
import com.edu.nbu.fan.gen.anno.TransferColumn;
import com.edu.nbu.fan.gen.contants.TableType;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Transfer(
    sourceType = TableType.SOURCE,
    tableName = "health_record_healthindicator_df"
)
@Getter
@Setter
public class HealthRecordHealthindicatorDfPO {
  @TransferColumn
  private LocalDateTime etlTime;

  @TransferColumn
  private String id;

  @TransferColumn
  private String bizId;

  @TransferColumn
  private String peopleId;

  @TransferColumn
  private String name;

  @TransferColumn
  private String gender;

  @TransferColumn
  private String age;

  @TransferColumn
  private String deviceModel;

  @TransferColumn
  private String deviceSerial;

  @TransferColumn
  private String bluetoothAddr;

  @TransferColumn
  private String measureTime;

  @TransferColumn
  private String measureTimeLabel;

  @TransferColumn
  private String measureAddress;

  @TransferColumn
  private Float measureLongitude;

  @TransferColumn
  private Float measureLatitude;

  @TransferColumn
  private String sourceId;

  @TransferColumn
  private Float temperature;

  @TransferColumn
  private String temperatureStatus;

  @TransferColumn
  private String respiratoryRate;

  @TransferColumn
  private Float systolicPressure;

  @TransferColumn
  private String systolicPressureStatus;

  @TransferColumn
  private Float diastolicPressure;

  @TransferColumn
  private String diastolicPressureStatus;

  @TransferColumn
  private String pulseRate;

  @TransferColumn
  private String heartRate;

  @TransferColumn
  private Float height;

  @TransferColumn
  private Float weight;

  @TransferColumn
  private Float bodyMassIndex;

  @TransferColumn
  private String bodyMassIndexStatus;

  @TransferColumn
  private Float bloodSugar;

  @TransferColumn
  private Float bloodSugarStatus;

  @TransferColumn
  private String oxygenSaturation;

  @TransferColumn
  private String oxygenSaturationStatus;

  @TransferColumn
  private Float waist;

  @TransferColumn
  private String createdTime;

  @TransferColumn
  private String modifiedTime;

  @TransferColumn
  private String label;

  @TransferColumn
  private String respiratoryRateStatus;

  @TransferColumn
  private String bloodPressureMeasureTimeLabel;

  @TransferColumn
  private String pulserateStatus;

  @TransferColumn
  private String bodyfat;

  @TransferColumn
  private String bodyfatRate;

  @TransferColumn
  private String bodyfatRateStatus;

  @TransferColumn
  private String uricacid;

  @TransferColumn
  private String uricacidStatus;

  @TransferColumn
  private String totalCholesterol;

  @TransferColumn
  private String totalCholesterolStatus;

  @TransferColumn
  private String acuteWeightgainCountOfYear;

  @TransferColumn
  private String acuteWeightgainDegreeOfYear;

  @TransferColumn
  private String mmrc;

  @TransferColumn
  private String fev1;

  @TransferColumn
  private String fvc;

  @TransferColumn
  private String headCircumference;

  @TransferColumn
  private String muscleContent;

  @TransferColumn
  private String muscleContentStatus;

  @TransferColumn
  private String bodyWaterRate;

  @TransferColumn
  private String bodyWaterRateStatus;

  @TransferColumn
  private String visceralFat;

  @TransferColumn
  private String visceralFatStatus;

  @TransferColumn
  private String patientId;

  @TransferColumn
  private String idCardType;

  @TransferColumn
  private String idCardNo;

  @TransferColumn
  private String terminalUnit;

  @TransferColumn
  private String bizLabels;

  @TransferColumn
  private String sourceUniquekey;

  @TransferColumn
  private String source;

  @TransferColumn
  private String sourceCreatedTime;

  @TransferColumn
  private String sourceModifiedTime;

  @TransferColumn
  private String isDeleted;

  @TransferColumn
  private String dateId;

  @TransferColumn
  private Integer bizLabelsData;
}
