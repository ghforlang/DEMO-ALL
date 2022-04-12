package com.edu.nbu.fan.gen.model;

import com.edu.nbu.fan.gen.anno.Transfer;
import com.edu.nbu.fan.gen.anno.TransferColumn;
import com.edu.nbu.fan.gen.contants.TableType;
import java.lang.String;
import lombok.Getter;
import lombok.Setter;

@Transfer(
    sourceType = TableType.SOURCE,
    tableName = "jnzxyy_health_record_people_20220217_new"
)
@Getter
@Setter
public class JnzxyyHealthRecordPeople20220217NewPO {
  @TransferColumn
  private String id;

  @TransferColumn
  private String gmtcreated;

  @TransferColumn
  private String gmtmodified;

  @TransferColumn
  private String bizid;

  @TransferColumn
  private String name;

  @TransferColumn
  private String gender;

  @TransferColumn
  private String idcardno;

  @TransferColumn
  private String householdregister;

  @TransferColumn
  private String passport;

  @TransferColumn
  private String militarylicense;

  @TransferColumn
  private String drivinglicense;

  @TransferColumn
  private String hkandmopass;

  @TransferColumn
  private String taiwanpass;

  @TransferColumn
  private String homereturnpermit;

  @TransferColumn
  private String othercardno;

  @TransferColumn
  private String phonenumber;

  @TransferColumn
  private String email;

  @TransferColumn
  private String dateofbirth;

  @TransferColumn
  private String citizenship;

  @TransferColumn
  private String nation;

  @TransferColumn
  private String domicile;

  @TransferColumn
  private String householdregistersign;

  @TransferColumn
  private String address;

  @TransferColumn
  private String provinceid;

  @TransferColumn
  private String province;

  @TransferColumn
  private String cityid;

  @TransferColumn
  private String city;

  @TransferColumn
  private String countyid;

  @TransferColumn
  private String county;

  @TransferColumn
  private String township;

  @TransferColumn
  private String village;

  @TransferColumn
  private String doorplate;

  @TransferColumn
  private String postalcode;

  @TransferColumn
  private String birthcertificate;

  @TransferColumn
  private String healthcardno;

  @TransferColumn
  private String outpatientno;

  @TransferColumn
  private String inpatientno;

  @TransferColumn
  private String micard;

  @TransferColumn
  private String pipmiareacode;

  @TransferColumn
  private String townshipid;

  @TransferColumn
  private String villageid;
}
