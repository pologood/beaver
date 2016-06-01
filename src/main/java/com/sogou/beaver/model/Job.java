package com.sogou.beaver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Tao Li on 2016/6/1.
 */
public class Job {
  private long id;
  private String userId;
  private String state;
  private String startTime;
  private String endTime;
  private String queryTerm;
  private String executionPlan;
  private String host;
  private String reportURL;

  public Job() {
    // Jackson deserialization
  }

  @JsonProperty
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @JsonProperty
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  @JsonProperty
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @JsonProperty
  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  @JsonProperty
  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  @JsonProperty
  public String getQueryTerm() {
    return queryTerm;
  }

  public void setQueryTerm(String queryTerm) {
    this.queryTerm = queryTerm;
  }

  @JsonProperty
  public String getExecutionPlan() {
    return executionPlan;
  }

  public void setExecutionPlan(String executionPlan) {
    this.executionPlan = executionPlan;
  }

  @JsonProperty
  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  @JsonProperty
  public String getReportURL() {
    return reportURL;
  }

  public void setReportURL(String reportURL) {
    this.reportURL = reportURL;
  }
}
