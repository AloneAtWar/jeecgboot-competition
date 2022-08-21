package org.jeecg.modules.competition.bean.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * SimpleCompetitionResp
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-06T14:21:21.719+08:00[Asia/Shanghai]")

public class SimpleCompetitionResp   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("introduction")
  private String introduction;

  @JsonProperty("title")
  private String title;

  @JsonProperty("need_volunteers")
  private Integer needVolunteers;

  @JsonProperty("start_time")
  private String startTime;

  @JsonProperty("end_time")
  private String endTime;

  @JsonProperty("type")
  private Integer type;

  @JsonProperty("picture")
  private String picture;

  public SimpleCompetitionResp id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public SimpleCompetitionResp name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SimpleCompetitionResp introduction(String introduction) {
    this.introduction = introduction;
    return this;
  }

  /**
   * Get introduction
   * @return introduction
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

  public SimpleCompetitionResp title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public SimpleCompetitionResp needVolunteers(Integer needVolunteers) {
    this.needVolunteers = needVolunteers;
    return this;
  }

  /**
   * Get needVolunteers
   * @return needVolunteers
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getNeedVolunteers() {
    return needVolunteers;
  }

  public void setNeedVolunteers(Integer needVolunteers) {
    this.needVolunteers = needVolunteers;
  }

  public SimpleCompetitionResp startTime(String startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Get startTime
   * @return startTime
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public SimpleCompetitionResp endTime(String endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * Get endTime
   * @return endTime
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public SimpleCompetitionResp type(Integer type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public SimpleCompetitionResp picture(String picture) {
    this.picture = picture;
    return this;
  }

  /**
   * Get picture
   * @return picture
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SimpleCompetitionResp simpleCompetitionResp = (SimpleCompetitionResp) o;
    return Objects.equals(this.id, simpleCompetitionResp.id) &&
        Objects.equals(this.name, simpleCompetitionResp.name) &&
        Objects.equals(this.introduction, simpleCompetitionResp.introduction) &&
        Objects.equals(this.title, simpleCompetitionResp.title) &&
        Objects.equals(this.needVolunteers, simpleCompetitionResp.needVolunteers) &&
        Objects.equals(this.startTime, simpleCompetitionResp.startTime) &&
        Objects.equals(this.endTime, simpleCompetitionResp.endTime) &&
        Objects.equals(this.type, simpleCompetitionResp.type) &&
        Objects.equals(this.picture, simpleCompetitionResp.picture);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, introduction, title, needVolunteers, startTime, endTime, type, picture);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SimpleCompetitionResp {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    introduction: ").append(toIndentedString(introduction)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    needVolunteers: ").append(toIndentedString(needVolunteers)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    picture: ").append(toIndentedString(picture)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

