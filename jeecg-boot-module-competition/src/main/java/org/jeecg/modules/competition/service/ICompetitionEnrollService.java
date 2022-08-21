package org.jeecg.modules.competition.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.competition.bean.entity.CompetitionEnroll;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: 大赛申请表
 * @Author: jeecg-boot
 * @Date:   2022-08-01
 * @Version: V1.0
 */
public interface ICompetitionEnrollService extends IService<CompetitionEnroll> {
    public List<CompetitionEnroll> getCompetitionEnrollByCompetitionID(Page<CompetitionEnroll> competitionEnrollPage,
                                                                           String competitionID, Integer state);
    public Integer updateEnrollState(String id,Integer state);
}
