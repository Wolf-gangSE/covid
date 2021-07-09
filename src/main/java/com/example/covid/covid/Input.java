package com.example.covid.covid;

public class Input {
  private String country;
  private Integer cases;
  private Integer confirmed;
  private Integer deaths;
  private Integer recovered;
  private String updated_at;

  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }


  public Integer getCases() {
    return cases;
  }
  public void setCases(Integer cases) {
    this.cases = cases;
  }


  public Integer getConfirmed() {
    return confirmed;
  }
  public void setConfirmed(Integer confirmed) {
    this.confirmed = confirmed;
  }


  public Integer getDeaths() {
    return deaths;
  }
  public void setDeaths(Integer deaths) {
    this.deaths = deaths;
  }


  public Integer getRecovered() {
    return recovered;
  }
  public void setRecovered(Integer recovered) {
    this.recovered = recovered;
  }


  public String getUpdated_at() {
    return updated_at;
  }
  public void setUpdated_at(String updated_at) {
    this.updated_at = updated_at;
  }
}

