package org.jeecg.modules.competition.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.lettuce.core.dynamic.annotation.Param;
import org.jeecg.modules.competition.bean.entity.CompetitionEnroll;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Description: 大赛申请表
 * @Author: jeecg-boot
 * @Date:   2022-08-01
 * @Version: V1.0
 */
public interface CompetitionEnrollMapper extends BaseMapper<CompetitionEnroll> {
    public List<CompetitionEnroll> queryAllByCompetitionId(Page<CompetitionEnroll> competitionEnrollPage , @Param("competitionID") String competitionID, @Param("state") Integer state);
    public Integer updateStateById(@Param("id")String id,@Param("state")Integer state);
}
