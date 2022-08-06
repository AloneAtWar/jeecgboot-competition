package org.jeecg.modules.competition.service;

import org.jeecg.modules.competition.bean.entity.Competition;
import org.jeecg.modules.competition.bean.entity.CompetitionPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 大赛表
 * @Author: jeecg-boot
 * @Date:   2022-08-01
 * @Version: V1.0
 */
public interface ICompetitionService extends IService<Competition> {

	/**
	 * 添加一对多
	 *
	 * @param competition
	 * @param competitionPermissionList
	 */
	public void saveMain(Competition competition,List<CompetitionPermission> competitionPermissionList) ;
	
	/**
	 * 修改一对多
	 *
   * @param competition
   * @param competitionPermissionList
	 */
	public void updateMain(Competition competition,List<CompetitionPermission> competitionPermissionList);
	
	/**
	 * 删除一对多
	 *
	 * @param id
	 */
	public void delMain (String id);
	
	/**
	 * 批量删除一对多
	 *
	 * @param idList
	 */
	public void delBatchMain (Collection<? extends Serializable> idList);
	
}
