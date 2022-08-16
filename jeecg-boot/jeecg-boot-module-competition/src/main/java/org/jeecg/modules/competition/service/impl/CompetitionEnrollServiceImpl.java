package org.jeecg.modules.competition.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.competition.bean.entity.CompetitionEnroll;
import org.jeecg.modules.competition.mapper.CompetitionEnrollMapper;
import org.jeecg.modules.competition.service.ICompetitionEnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: 大赛申请表
 * @Author: jeecg-boot
 * @Date:   2022-08-01
 * @Version: V1.0
 */
@Service
public class CompetitionEnrollServiceImpl extends ServiceImpl<CompetitionEnrollMapper, CompetitionEnroll> implements ICompetitionEnrollService {

    @Autowired
    private CompetitionEnrollMapper competitionEnrollMapper;
    @Override
    public List<CompetitionEnroll> getCompetitionEnrollByCompetitionID(Page<CompetitionEnroll> competitionEnrollPage,
                                                                           String competitionID, Integer state) {
        List<CompetitionEnroll> competitionEnrolls = competitionEnrollMapper.queryAllByCompetitionId(competitionEnrollPage, competitionID, state);
        return competitionEnrolls;
    }

    @Override
    public Integer updateEnrollState(String id, Integer state) {
        Integer integer = competitionEnrollMapper.updateStateById(id, state);
        return integer;
    }
}
