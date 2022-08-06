package org.jeecg.modules.competition.bean.resp;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

/**
 * MyCompetitionResp
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-06T14:21:21.719+08:00[Asia/Shanghai]")

public class MyCompetitionResp   {
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

  @JsonProperty("my_state")
  private String myState;

  @JsonProperty("my_type")
  private String myType;

  public MyCompetitionResp id(String id) {
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

  public MyCompetitionResp name(String name) {
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

  public MyCompetitionResp introduction(String introduction) {
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

  public MyCompetitionResp title(String title) {
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

  public MyCompetitionResp needVolunteers(Integer needVolunteers) {
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

  public MyCompetitionResp startTime(String startTime) {
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

  public MyCompetitionResp endTime(String endTime) {
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

  public MyCompetitionResp type(Integer type) {
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

  public MyCompetitionResp picture(String picture) {
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

  public MyCompetitionResp myState(String myState) {
    this.myState = myState;
    return this;
  }

  /**
   * 0代表特殊身份 1代表报名未得到审核 2代表报名得到确定但未上传作品 3代表报名得到确认已上传作品 4代表得到评分
   * @return myState
  */
  @ApiModelProperty(required = true, value = "0代表特殊身份 1代表报名未得到审核 2代表报名得到确定但未上传作品 3代表报名得到确认已上传作品 4代表得到评分")
  @NotNull


  public String getMyState() {
    return myState;
  }

  public void setMyState(String myState) {
    this.myState = myState;
  }

  public MyCompetitionResp myType(String myType) {
    this.myType = myType;
    return this;
  }

  /**
   * 0代表已报名 1代表管理员 2代表评委 3代表志愿者
   * @return myType
  */
  @ApiModelProperty(required = true, value = "0代表已报名 1代表管理员 2代表评委 3代表志愿者")
  @NotNull


  public String getMyType() {
    return myType;
  }

  public void setMyType(String myType) {
    this.myType = myType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MyCompetitionResp myCompetitionResp = (MyCompetitionResp) o;
    return Objects.equals(this.id, myCompetitionResp.id) &&
        Objects.equals(this.name, myCompetitionResp.name) &&
        Objects.equals(this.introduction, myCompetitionResp.introduction) &&
        Objects.equals(this.title, myCompetitionResp.title) &&
        Objects.equals(this.needVolunteers, myCompetitionResp.needVolunteers) &&
        Objects.equals(this.startTime, myCompetitionResp.startTime) &&
        Objects.equals(this.endTime, myCompetitionResp.endTime) &&
        Objects.equals(this.type, myCompetitionResp.type) &&
        Objects.equals(this.picture, myCompetitionResp.picture) &&
        Objects.equals(this.myState, myCompetitionResp.myState) &&
        Objects.equals(this.myType, myCompetitionResp.myType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, introduction, title, needVolunteers, startTime, endTime, type, picture, myState, myType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MyCompetitionResp {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    introduction: ").append(toIndentedString(introduction)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    needVolunteers: ").append(toIndentedString(needVolunteers)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    picture: ").append(toIndentedString(picture)).append("\n");
    sb.append("    myState: ").append(toIndentedString(myState)).append("\n");
    sb.append("    myType: ").append(toIndentedString(myType)).append("\n");
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

