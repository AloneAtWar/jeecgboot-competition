package org.jeecg.modules.competition.vo;

import java.util.List;

import org.jeecg.modules.competition.bean.entity.CompetitionPermission;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 大赛表
 * @Author: jeecg-boot
 * @Date:   2022-08-01
 * @Version: V1.0
 */
@Data
@ApiModel(value="competitionPage对象", description="大赛表")
public class CompetitionPage {

	/**主键*/
	@ApiModelProperty(value = "主键")
    private String id;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**名称*/
	@Excel(name = "名称", width = 15)
	@ApiModelProperty(value = "名称")
    private String name;
	/**图片*/
	@Excel(name = "图片", width = 15)
	@ApiModelProperty(value = "图片")
    private String picture;
	/**简介*/
	@Excel(name = "简介", width = 15)
	@ApiModelProperty(value = "简介")
    private String introduction;
	/**标题*/
	@Excel(name = "标题", width = 15)
	@ApiModelProperty(value = "标题")
    private String title;
	/**是否需要志愿者*/
	@Excel(name = "是否需要志愿者", width = 15, dicCode = "yn")
    @Dict(dicCode = "yn")
	@ApiModelProperty(value = "是否需要志愿者")
    private Integer needVolunteers;
	/**赛事详细介绍*/
	@Excel(name = "赛事详细介绍", width = 15)
	@ApiModelProperty(value = "赛事详细介绍")
    private String detailIntroduce;
	/**赛题详细*/
	@Excel(name = "赛题详细", width = 15)
	@ApiModelProperty(value = "赛题详细")
    private String problem;
	/**开始时间*/
	@Excel(name = "开始时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "开始时间")
    private java.util.Date startTime;
	/**结束时间*/
	@Excel(name = "结束时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "结束时间")
    private java.util.Date endTime;
	/**赛事类型*/
	@Excel(name = "赛事类型", width = 15, dicCode = "competitionType")
    @Dict(dicCode = "competitionType")
	@ApiModelProperty(value = "赛事类型")
    private Integer type;

	@ExcelCollection(name="大赛权限表")
	@ApiModelProperty(value = "大赛权限表")
	private List<CompetitionPermission> competitionPermissionList;

}
