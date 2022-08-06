package org.jeecg.modules.competition.bean.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 大赛权限表
 * @Author: jeecg-boot
 * @Date:   2022-08-01
 * @Version: V1.0
 */
@ApiModel(value="competition_permission对象", description="大赛权限表")
@Data
@TableName("competition_permission")
public class CompetitionPermission implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**用户*/
	@Excel(name = "用户", width = 15, dictTable = "sys_user", dicText = "username", dicCode = "id")
    @ApiModelProperty(value = "用户")
    private java.lang.String userId;
	/**大赛*/
    @ApiModelProperty(value = "大赛")
    private java.lang.String competitionId;
	/**状态*/
	@Excel(name = "状态", width = 15)
    @ApiModelProperty(value = "状态")
    private java.lang.Integer state;
	/**类型*/
	@Excel(name = "类型", width = 15, dicCode = "	competition_permissions_type")
    @ApiModelProperty(value = "类型")
    private java.lang.Integer type;
}
