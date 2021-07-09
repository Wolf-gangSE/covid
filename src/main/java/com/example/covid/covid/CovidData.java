package com.example.covid.covid;

public class CovidData {
  private Integer uid;
  private String uf;
  private String state;
  private Integer cases;
  private Integer deaths;
  private Integer suspects;
  private Integer refuses;
  private String datetime;

   public Integer getUid() {
     return uid;
   }
   public void setUid(Integer uid) {
     this.uid = uid;
   }

   public String getUf() {
     return uf;
   }
   public void setUf(String uf) {
     this.uf = uf;
   }

   public String getState() {
     return state;
   }
   public void setState(String state) {
     this.state = state;
   }

   public Integer getCases() {
    return cases;
  }
  public void setCases(Integer cases) {
    this.cases = cases;
  }

   public Integer getDeaths() {
     return deaths;
   }
   public void setDeaths(Integer deaths) {
     this.deaths = deaths;
   }

   public Integer getSuspects() {
     return suspects;
   }
   public void setSuspects(Integer suspects) {
     this.suspects = suspects;
   }

   public Integer getRefuses() {
     return refuses;
   }
   public void setRefuses(Integer refuses) {
     this.refuses = refuses;
   }

   public String getDatetime() {

     return datetime;
   }
   public void setDatetime(String datetime) {
     this.datetime = datetime;
   }

}
