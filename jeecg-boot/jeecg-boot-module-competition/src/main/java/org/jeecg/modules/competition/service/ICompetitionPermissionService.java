package org.jeecg.modules.competition.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.competition.bean.entity.CompetitionPermission;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.List;

/**
 * @Description: 大赛权限表
 * @Author: jeecg-boot
 * @Date:   2022-08-01
 * @Version: V1.0
 */
public interface ICompetitionPermissionService extends IService<CompetitionPermission> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<CompetitionPermission>
	 */
	public List<CompetitionPermission> selectByMainId(String mainId);
	public Page<CompetitionPermission> selectMyCompetition(Page<CompetitionPermission> competitionPermissions,String user_id);
	public CompetitionPermission selectByUIDAndCompetitionId(String userID,String competitionId);
}
