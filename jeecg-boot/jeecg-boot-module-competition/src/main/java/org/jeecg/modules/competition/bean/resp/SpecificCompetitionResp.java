package org.jeecg.modules.competition.bean.resp;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

/**
 * SpecificCompetitionResp
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-06T14:21:21.719+08:00[Asia/Shanghai]")

public class SpecificCompetitionResp   {
  @JsonProperty("my_type")
  private Integer myType;

  @JsonProperty("my_state")
  private Integer myState;

  @JsonProperty("id")
  private String id;

  @JsonProperty("create_time")
  private String createTime;

  @JsonProperty("introduction")
  private String introduction;

  @JsonProperty("title")
  private String title;

  @JsonProperty("picture")
  private String picture;

  @JsonProperty("need_volunteers")
  private Boolean needVolunteers;

  @JsonProperty("detail_introduce")
  private String detailIntroduce;

  @JsonProperty("problem")
  private String problem;

  @JsonProperty("start_time")
  private String startTime;

  @JsonProperty("end_time")
  private String endTime;

  @JsonProperty("award")
  private String award;

  @JsonProperty("type")
  private Integer type;

  public SpecificCompetitionResp myType(Integer myType) {
    this.myType = myType;
    return this;
  }

  /**
   * 0代表特殊身份 1代表报名未得到审核 2代表报名得到确定但未上传作品 3代表报名得到确认已上传作品 4代表得到评分
   * @return myType
  */
  @ApiModelProperty(required = true, value = "0代表特殊身份 1代表报名未得到审核 2代表报名得到确定但未上传作品 3代表报名得到确认已上传作品 4代表得到评分")
  @NotNull


  public Integer getMyType() {
    return myType;
  }

  public void setMyType(Integer myType) {
    this.myType = myType;
  }

  public SpecificCompetitionResp myState(Integer myState) {
    this.myState = myState;
    return this;
  }

  /**
   * 0代表已报名 1代表管理员 2代表评委 3代表志愿者
   * @return myState
  */
  @ApiModelProperty(required = true, value = "0代表已报名 1代表管理员 2代表评委 3代表志愿者")
  @NotNull


  public Integer getMyState() {
    return myState;
  }

  public void setMyState(Integer myState) {
    this.myState = myState;
  }

  public SpecificCompetitionResp id(String id) {
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

  public SpecificCompetitionResp createTime(String createTime) {
    this.createTime = createTime;
    return this;
  }

  /**
   * Get createTime
   * @return createTime
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public SpecificCompetitionResp introduction(String introduction) {
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

  public SpecificCompetitionResp title(String title) {
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

  public SpecificCompetitionResp picture(String picture) {
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

  public SpecificCompetitionResp needVolunteers(Boolean needVolunteers) {
    this.needVolunteers = needVolunteers;
    return this;
  }

  /**
   * Get needVolunteers
   * @return needVolunteers
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean getNeedVolunteers() {
    return needVolunteers;
  }

  public void setNeedVolunteers(Boolean needVolunteers) {
    this.needVolunteers = needVolunteers;
  }

  public SpecificCompetitionResp detailIntroduce(String detailIntroduce) {
    this.detailIntroduce = detailIntroduce;
    return this;
  }

  /**
   * Get detailIntroduce
   * @return detailIntroduce
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getDetailIntroduce() {
    return detailIntroduce;
  }

  public void setDetailIntroduce(String detailIntroduce) {
    this.detailIntroduce = detailIntroduce;
  }

  public SpecificCompetitionResp problem(String problem) {
    this.problem = problem;
    return this;
  }

  /**
   * Get problem
   * @return problem
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getProblem() {
    return problem;
  }

  public void setProblem(String problem) {
    this.problem = problem;
  }

  public SpecificCompetitionResp startTime(String startTime) {
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

  public SpecificCompetitionResp endTime(String endTime) {
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

  public SpecificCompetitionResp award(String award) {
    this.award = award;
    return this;
  }

  /**
   * Get award
   * @return award
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAward() {
    return award;
  }

  public void setAward(String award) {
    this.award = award;
  }

  public SpecificCompetitionResp type(Integer type) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecificCompetitionResp specificCompetitionResp = (SpecificCompetitionResp) o;
    return Objects.equals(this.myType, specificCompetitionResp.myType) &&
        Objects.equals(this.myState, specificCompetitionResp.myState) &&
        Objects.equals(this.id, specificCompetitionResp.id) &&
        Objects.equals(this.createTime, specificCompetitionResp.createTime) &&
        Objects.equals(this.introduction, specificCompetitionResp.introduction) &&
        Objects.equals(this.title, specificCompetitionResp.title) &&
        Objects.equals(this.picture, specificCompetitionResp.picture) &&
        Objects.equals(this.needVolunteers, specificCompetitionResp.needVolunteers) &&
        Objects.equals(this.detailIntroduce, specificCompetitionResp.detailIntroduce) &&
        Objects.equals(this.problem, specificCompetitionResp.problem) &&
        Objects.equals(this.startTime, specificCompetitionResp.startTime) &&
        Objects.equals(this.endTime, specificCompetitionResp.endTime) &&
        Objects.equals(this.award, specificCompetitionResp.award) &&
        Objects.equals(this.type, specificCompetitionResp.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(myType, myState, id, createTime, introduction, title, picture, needVolunteers, detailIntroduce, problem, startTime, endTime, award, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecificCompetitionResp {\n");
    
    sb.append("    myType: ").append(toIndentedString(myType)).append("\n");
    sb.append("    myState: ").append(toIndentedString(myState)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    introduction: ").append(toIndentedString(introduction)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    picture: ").append(toIndentedString(picture)).append("\n");
    sb.append("    needVolunteers: ").append(toIndentedString(needVolunteers)).append("\n");
    sb.append("    detailIntroduce: ").append(toIndentedString(detailIntroduce)).append("\n");
    sb.append("    problem: ").append(toIndentedString(problem)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    award: ").append(toIndentedString(award)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

