package org.jeecg.modules.competition.service.impl;

import org.jeecg.modules.competition.bean.entity.CompetitionPermission;
import org.jeecg.modules.competition.mapper.CompetitionPermissionMapper;
import org.jeecg.modules.competition.service.ICompetitionPermissionService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 大赛权限表
 * @Author: jeecg-boot
 * @Date:   2022-08-01
 * @Version: V1.0
 */
@Service
public class CompetitionPermissionServiceImpl extends ServiceImpl<CompetitionPermissionMapper, CompetitionPermission> implements ICompetitionPermissionService {
	
	@Autowired
	private CompetitionPermissionMapper competitionPermissionMapper;
	
	@Override
	public List<CompetitionPermission> selectByMainId(String mainId) {
		return competitionPermissionMapper.selectByMainId(mainId);
	}
}
