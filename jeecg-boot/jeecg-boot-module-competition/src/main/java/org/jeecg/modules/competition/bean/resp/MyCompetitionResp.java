package org.jeecg.modules.competition.bean.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * MyCompetitionResp
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-06T14:21:21.719+08:00[Asia/Shanghai]")
@AllArgsConstructor
@Data
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
  private Integer myState;

  @JsonProperty("my_type")
  private Integer myType;

  public MyCompetitionResp id(String id) {
    this.id = id;
    return this;
  }


}

