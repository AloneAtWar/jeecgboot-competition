package org.jeecg.modules.competition.bean.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
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
 * @Description: 大赛提交记录表
 * @Author: jeecg-boot
 * @Date:   2022-08-21
 * @Version: V1.0
 */
@Data
@TableName("competition_submit")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="competition_submit对象", description="大赛提交记录表")
public class CompetitionSubmit implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
	/**用户*/
	@Excel(name = "用户", width = 15, dictTable = "sys_user", dicText = "username", dicCode = "id")
	@Dict(dictTable = "sys_user", dicText = "username", dicCode = "id")
    @ApiModelProperty(value = "用户")
    private String userId;
	/**大赛*/
	@Excel(name = "大赛", width = 15, dictTable = "competition", dicText = "name", dicCode = "id")
	@Dict(dictTable = "competition", dicText = "name", dicCode = "id")
    @ApiModelProperty(value = "大赛")
    private String competitionId;
	/**提交时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "提交时间")
    private Date createTime;
	/**文字部分*/
	@Excel(name = "文字部分", width = 15)
    @ApiModelProperty(value = "文字部分")
    private String data;
	/**文件地址*/
	@Excel(name = "文件地址", width = 15)
    @ApiModelProperty(value = "文件地址")
    private String fileUrl;
	/**是否已经结算*/
	@Excel(name = "是否已经结算", width = 15, dicCode = "yn")
	@Dict(dicCode = "yn")
    @ApiModelProperty(value = "是否已经结算")
    private Integer isSettlement;
}
