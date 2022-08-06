package org.jeecg.modules.competition.bean.req;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EnrollReq
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-06T14:21:21.719+08:00[Asia/Shanghai]")

public class EnrollReq   {
  @JsonProperty("competition_id")
  private String competitionId;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("school")
  private String school;

  @JsonProperty("education")
  private String education;

  @JsonProperty("professional")
  private String professional;

  @JsonProperty("reason")
  private String reason;

  public EnrollReq competitionId(String competitionId) {
    this.competitionId = competitionId;
    return this;
  }

  /**
   * Get competitionId
   * @return competitionId
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCompetitionId() {
    return competitionId;
  }

  public void setCompetitionId(String competitionId) {
    this.competitionId = competitionId;
  }

  public EnrollReq phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public EnrollReq school(String school) {
    this.school = school;
    return this;
  }

  /**
   * Get school
   * @return school
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public EnrollReq education(String education) {
    this.education = education;
    return this;
  }

  /**
   * Get education
   * @return education
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public EnrollReq professional(String professional) {
    this.professional = professional;
    return this;
  }

  /**
   * Get professional
   * @return professional
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getProfessional() {
    return professional;
  }

  public void setProfessional(String professional) {
    this.professional = professional;
  }

  public EnrollReq reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * Get reason
   * @return reason
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnrollReq enrollReq = (EnrollReq) o;
    return Objects.equals(this.competitionId, enrollReq.competitionId) &&
        Objects.equals(this.phone, enrollReq.phone) &&
        Objects.equals(this.school, enrollReq.school) &&
        Objects.equals(this.education, enrollReq.education) &&
        Objects.equals(this.professional, enrollReq.professional) &&
        Objects.equals(this.reason, enrollReq.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(competitionId, phone, school, education, professional, reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnrollReq {\n");
    
    sb.append("    competitionId: ").append(toIndentedString(competitionId)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    school: ").append(toIndentedString(school)).append("\n");
    sb.append("    education: ").append(toIndentedString(education)).append("\n");
    sb.append("    professional: ").append(toIndentedString(professional)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

