package com.edu.nbu.fan.gen.model;

import com.edu.nbu.fan.gen.anno.Transfer;
import com.edu.nbu.fan.gen.anno.TransferColumn;
import com.edu.nbu.fan.gen.contants.TableType;
import java.lang.Double;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Transfer(
    sourceType = TableType.SOURCE,
    tableName = "health_record_basichealthinformation_df"
)
@Getter
@Setter
public class HealthRecordBasichealthinformationDfPO {
  @TransferColumn
  private LocalDateTime etlTime;

  @TransferColumn
  private String id;

  @TransferColumn
  private String peopleId;

  @TransferColumn
  private String expertId;

  @TransferColumn
  private String name;

  @TransferColumn
  private String gender;

  @TransferColumn
  private String dateOfBirth;

  @TransferColumn
  private String phoneNumber;

  @TransferColumn
  private String idCardNo;

  @TransferColumn
  private String provinceId;

  @TransferColumn
  private String provinceName;

  @TransferColumn
  private String cityId;

  @TransferColumn
  private String cityName;

  @TransferColumn
  private String countyId;

  @TransferColumn
  private String countyName;

  @TransferColumn
  private String townshipId;

  @TransferColumn
  private String townshipName;

  @TransferColumn
  private String villageId;

  @TransferColumn
  private String villageName;

  @TransferColumn
  private String address;

  @TransferColumn
  private Double height;

  @TransferColumn
  private Double weight;

  @TransferColumn
  private String isPregnant;

  @TransferColumn
  private String lastMenstrualPeriod;

  @TransferColumn
  private String expectedDateOfChildbirth;

  @TransferColumn
  private String urineConditions;

  @TransferColumn
  private String isVaccinated;

  @TransferColumn
  private String menarche;

  @TransferColumn
  private String ageOfMenarche;

  @TransferColumn
  private String educationLevelId;

  @TransferColumn
  private String educationLevelName;

  @TransferColumn
  private String occupation;

  @TransferColumn
  private String company;

  @TransferColumn
  private String martialStatusId;

  @TransferColumn
  private String martialStatusName;

  @TransferColumn
  private String religionIsNormal;

  @TransferColumn
  private String religionList;

  @TransferColumn
  private String medicareIsNormal;

  @TransferColumn
  private String medicareList;

  @TransferColumn
  private String emergencyContactPerson;

  @TransferColumn
  private String emergencyContactPersonPhone;

  @TransferColumn
  private String guardian;

  @TransferColumn
  private String guardianPhone;

  @TransferColumn
  private String pastIllnessIsNormal;

  @TransferColumn
  private String pastDiseases;

  @TransferColumn
  private String surgicalOrInjuryIsNormal;

  @TransferColumn
  private String surgicalOrInjurys;

  @TransferColumn
  private String familyHistoryIsNormal;

  @TransferColumn
  private String familyDiseases;

  @TransferColumn
  private String fertilityStatusId;

  @TransferColumn
  private String fertilityStatusName;

  @TransferColumn
  private String medicationSituation;

  @TransferColumn
  private String smokingStatusId;

  @TransferColumn
  private String smokingStatusName;

  @TransferColumn
  private String smokingTimeLength;

  @TransferColumn
  private String dailySmokeAmountId;

  @TransferColumn
  private String dailySmokeAmountName;

  @TransferColumn
  private String drinkingStatusId;

  @TransferColumn
  private String drinkingStatusName;

  @TransferColumn
  private String drinkingTimeLength;

  @TransferColumn
  private String drinkingFrequencyId;

  @TransferColumn
  private String drinkingFrequencyName;

  @TransferColumn
  private String drinkingSituation;

  @TransferColumn
  private String dietTasteIsNormal;

  @TransferColumn
  private String dietTasteList;

  @TransferColumn
  private String dietStructureId;

  @TransferColumn
  private String dietStructureName;

  @TransferColumn
  private String cookingWayIsNormal;

  @TransferColumn
  private String cookingWayList;

  @TransferColumn
  private String dietSituationIsNormal;

  @TransferColumn
  private String dietSituationList;

  @TransferColumn
  private String eatingOutId;

  @TransferColumn
  private String eatingOutName;

  @TransferColumn
  private String appetiteCondition;

  @TransferColumn
  private String sportFrequencyId;

  @TransferColumn
  private String sportFrequencyName;

  @TransferColumn
  private String sportTypeIsNormal;

  @TransferColumn
  private String sportTypeList;

  @TransferColumn
  private String sleepingSituationId;

  @TransferColumn
  private String sleepingSituationName;

  @TransferColumn
  private String sleepingPatterns;

  @TransferColumn
  private String sleepingProblem;

  @TransferColumn
  private String sleepingHoursId;

  @TransferColumn
  private String sleepingHoursCode;

  @TransferColumn
  private String isSnoring;

  @TransferColumn
  private String aboBloodTypeId;

  @TransferColumn
  private String aboBloodTypeName;

  @TransferColumn
  private String rhBloodTypeId;

  @TransferColumn
  private String rhBloodTypeName;

  @TransferColumn
  private String geneticHistoryIsNormal;

  @TransferColumn
  private String geneticHistoryCodedValues;

  @TransferColumn
  private String geneticHistoryContent;

  @TransferColumn
  private String presentIllnessIsNormal;

  @TransferColumn
  private String presentIllnessCodedValues;

  @TransferColumn
  private String presentIllnessContent;

  @TransferColumn
  private String createdTime;

  @TransferColumn
  private String modifiedTime;

  @TransferColumn
  private String emergencyContactRelationship;

  @TransferColumn
  private Double waistline;

  @TransferColumn
  private String familyComposition;

  @TransferColumn
  private String sportDuration;

  @TransferColumn
  private String sportTimeLength;

  @TransferColumn
  private String sportVenue;

  @TransferColumn
  private String waterIntake;

  @TransferColumn
  private String waterDrinkingCategory;

  @TransferColumn
  private String breakfast;

  @TransferColumn
  private String lunch;

  @TransferColumn
  private String dinner;

  @TransferColumn
  private Long isSnacks;

  @TransferColumn
  private String timeToQuitDrinking;

  @TransferColumn
  private String timeToQuitSmoking;

  @TransferColumn
  private Long exposureHistoryOfOccupationalDiseaseHazards;

  @TransferColumn
  private String jobDescription;

  @TransferColumn
  private String workingAge;

  @TransferColumn
  private String occupationalHazardFactorCategoryCode;

  @TransferColumn
  private String protectiveMeasuresStatus;

  @TransferColumn
  private String protectiveMeasures;

  @TransferColumn
  private String age;

  @TransferColumn
  private String citizenship;

  @TransferColumn
  private String nation;

  @TransferColumn
  private String email;

  @TransferColumn
  private Double temperature;

  @TransferColumn
  private String pulseRate;

  @TransferColumn
  private String respiratoryRate;

  @TransferColumn
  private Double systolicPressure;

  @TransferColumn
  private Double diastolicPressure;

  @TransferColumn
  private Double bodyMassIndex;

  @TransferColumn
  private String oxygenSaturation;

  @TransferColumn
  private Double bloodGlucose;

  @TransferColumn
  private String personalHistory;

  @TransferColumn
  private String drinkingRemark;

  @TransferColumn
  private Long menopause;

  @TransferColumn
  private String menopauseDate;

  @TransferColumn
  private String sportRemark;

  @TransferColumn
  private String personalBasicInfoRemark;

  @TransferColumn
  private String allergyHistory;

  @TransferColumn
  private Long isDietaryPatternRegular;

  @TransferColumn
  private String hydrationLiquidType;

  @TransferColumn
  private String smokingRemark;

  @TransferColumn
  private String timeToFallAsleep;

  @TransferColumn
  private Long isSiestaTaking;

  @TransferColumn
  private String guardianRelationship;

  @TransferColumn
  private String birthGestationalWeeks;

  @TransferColumn
  private String deliveryMode;

  @TransferColumn
  private String birthWeight;

  @TransferColumn
  private Long asphyxiaFlag;

  @TransferColumn
  private String headHoldingUpAge;

  @TransferColumn
  private String sittingAge;

  @TransferColumn
  private String crawlingAge;

  @TransferColumn
  private String standingAge;

  @TransferColumn
  private String walkingAge;

  @TransferColumn
  private String breastfeedingStopAge;

  @TransferColumn
  private String solidFoodIntroductionAge;

  @TransferColumn
  private String diarrheaAttackFrequency;

  @TransferColumn
  private String babyStoolFormScale;

  @TransferColumn
  private String childHydrationLiquidType;

  @TransferColumn
  private String feedingPatterns;

  @TransferColumn
  private String dietaryRemark;

  @TransferColumn
  private String timeToSleep;

  @TransferColumn
  private String apgar;

  @TransferColumn
  private String kitchenAirExaustFacilitiesCategory;

  @TransferColumn
  private String fuelType;

  @TransferColumn
  private String toiletCategory;

  @TransferColumn
  private String livestockBarCategory;

  @TransferColumn
  private String exposureHistory;

  @TransferColumn
  private String bloodTransfusionHistory;

  @TransferColumn
  private String dateId;

  @TransferColumn
  private String sourceUniqueKey;

  @TransferColumn
  private String idCardType;
}
