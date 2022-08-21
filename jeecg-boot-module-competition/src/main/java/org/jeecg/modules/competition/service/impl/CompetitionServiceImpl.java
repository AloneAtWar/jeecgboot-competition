package org.jeecg.modules.competition.service.impl;

import org.jeecg.modules.competition.bean.entity.Competition;
import org.jeecg.modules.competition.bean.entity.CompetitionPermission;
import org.jeecg.modules.competition.mapper.CompetitionMapper;
import org.jeecg.modules.competition.mapper.CompetitionPermissionMapper;
import org.jeecg.modules.competition.service.ICompetitionService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Collection;

/**
 * @Description: 大赛表
 * @Author: jeecg-boot
 * @Date:   2022-08-01
 * @Version: V1.0
 */
@Service
public class CompetitionServiceImpl extends ServiceImpl<CompetitionMapper, Competition> implements ICompetitionService {

	@Autowired
	private CompetitionMapper competitionMapper;
	@Autowired
	private CompetitionPermissionMapper competitionPermissionMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveMain(Competition competition, List<CompetitionPermission> competitionPermissionList) {
		competitionMapper.insert(competition);
		if(competitionPermissionList!=null && competitionPermissionList.size()>0) {
			for(CompetitionPermission entity:competitionPermissionList) {
				//外键设置
				entity.setCompetitionId(competition.getId());
				competitionPermissionMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateMain(Competition competition,List<CompetitionPermission> competitionPermissionList) {
		competitionMapper.updateById(competition);
		
		//1.先删除子表数据
		competitionPermissionMapper.deleteByMainId(competition.getId());
		
		//2.子表数据重新插入
		if(competitionPermissionList!=null && competitionPermissionList.size()>0) {
			for(CompetitionPermission entity:competitionPermissionList) {
				//外键设置
				entity.setCompetitionId(competition.getId());
				competitionPermissionMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delMain(String id) {
		competitionPermissionMapper.deleteByMainId(id);
		competitionMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			competitionPermissionMapper.deleteByMainId(id.toString());
			competitionMapper.deleteById(id);
		}
	}
	
}
