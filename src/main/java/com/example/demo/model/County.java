package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class County {

  @Id //her definerer vi vores primary key
  @Column(name="countycode") //grunden til at vi skriver "(name="countrycode")" er for at ændre i, hvordan den kommer til at se ud.
  //hvis ikke vi skrev noget kom den til at se sådan her ud: country_code. Det er kun kosmetisk.
  private String countyCode;
  private String name;
  private String href;

  public String getCountyCode() {
    return countyCode;
  }

  public void setCountyCode(String countyCode) {
    this.countyCode = countyCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }
}
