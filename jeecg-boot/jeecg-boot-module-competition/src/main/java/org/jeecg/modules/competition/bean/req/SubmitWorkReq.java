package org.jeecg.modules.competition.bean.req;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SubmitWorkReq
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-06T14:21:21.719+08:00[Asia/Shanghai]")

public class SubmitWorkReq   {
  @JsonProperty("data")
  private String data;

  @JsonProperty("file_url")
  private String fileUrl;

  @JsonProperty("competition_id")
  private String competitionId;

  public SubmitWorkReq data(String data) {
    this.data = data;
    return this;
  }

  /**
   * 作品的文字部分
   * @return data
  */
  @ApiModelProperty(required = true, value = "作品的文字部分")
  @NotNull


  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public SubmitWorkReq fileUrl(String fileUrl) {
    this.fileUrl = fileUrl;
    return this;
  }

  /**
   * 作品的文件部分
   * @return fileUrl
  */
  @ApiModelProperty(required = true, value = "作品的文件部分")
  @NotNull


  public String getFileUrl() {
    return fileUrl;
  }

  public void setFileUrl(String fileUrl) {
    this.fileUrl = fileUrl;
  }

  public SubmitWorkReq competitionId(String competitionId) {
    this.competitionId = competitionId;
    return this;
  }

  /**
   * 比赛的ID
   * @return competitionId
  */
  @ApiModelProperty(required = true, value = "比赛的ID")
  @NotNull


  public String getCompetitionId() {
    return competitionId;
  }

  public void setCompetitionId(String competitionId) {
    this.competitionId = competitionId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubmitWorkReq submitWorkReq = (SubmitWorkReq) o;
    return Objects.equals(this.data, submitWorkReq.data) &&
        Objects.equals(this.fileUrl, submitWorkReq.fileUrl) &&
        Objects.equals(this.competitionId, submitWorkReq.competitionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, fileUrl, competitionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubmitWorkReq {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    fileUrl: ").append(toIndentedString(fileUrl)).append("\n");
    sb.append("    competitionId: ").append(toIndentedString(competitionId)).append("\n");
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

