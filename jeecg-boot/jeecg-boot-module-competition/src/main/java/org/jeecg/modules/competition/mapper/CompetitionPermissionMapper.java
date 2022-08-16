package org.jeecg.modules.competition.mapper;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.competition.bean.entity.CompetitionPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;


/**
 * @Description: 大赛权限表
 * @Author: jeecg-boot
 * @Date:   2022-08-01
 * @Version: V1.0
 */
public interface CompetitionPermissionMapper extends BaseMapper<CompetitionPermission> {

	/**
	 * 通过主表id删除子表数据
	 *
	 * @param mainId 主表id
	 * @return boolean
	 */
	public boolean deleteByMainId(@Param("mainId") String mainId);

  /**
   * 通过主表id查询子表数据
   *
   * @param mainId 主表id
   * @return List<CompetitionPermission>
   */
	public List<CompetitionPermission> selectByMainId(@Param("mainId") String mainId);

	public List<CompetitionPermission> queryCompetitionIdByUserId(Page<CompetitionPermission> competitionPermissions, String user_id);

	public CompetitionPermission queryCompetitionIdByUserId(@Param("user_id") String user_id, @Param("competitionId") String competitionId);

}
