package org.jeecg.modules.competition.bean.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 大赛申请表
 * @Author: jeecg-boot
 * @Date:   2022-08-01
 * @Version: V1.0
 */
@Data
@TableName("competition_enroll")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="competition_enroll对象", description="大赛申请表")
public class CompetitionEnroll implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**用户*/
	@Excel(name = "用户", width = 15, dictTable = "sys_user", dicText = "username", dicCode = "id")
	@Dict(dictTable = "sys_user", dicText = "username", dicCode = "id")
    @ApiModelProperty(value = "用户")
    private java.lang.String userId;
	/**手机号*/
	@Excel(name = "手机号", width = 15)
    @ApiModelProperty(value = "手机号")
    private java.lang.String phone;
	/**报名大赛*/
	@Excel(name = "报名大赛", width = 15, dictTable = "competition", dicText = "name", dicCode = "id")
	@Dict(dictTable = "competition", dicText = "name", dicCode = "id")
    @ApiModelProperty(value = "报名大赛")
    private java.lang.String competitionId;
	/**学校*/
	@Excel(name = "学校", width = 15)
    @ApiModelProperty(value = "学校")
    private java.lang.String school;
	/**学历*/
	@Excel(name = "学历", width = 15)
    @ApiModelProperty(value = "学历")
    private java.lang.String education;
	/**专业*/
	@Excel(name = "专业", width = 15)
    @ApiModelProperty(value = "专业")
    private java.lang.String professional;
	/**状态*/
	@Excel(name = "状态", width = 15, dicCode = "competition_enroll_state")
	@Dict(dicCode = "competition_enroll_state")
    @ApiModelProperty(value = "状态")
    private java.lang.Integer state;
	/**理由*/
	@Excel(name = "理由", width = 15)
    @ApiModelProperty(value = "理由")
    private java.lang.String reason;
}
