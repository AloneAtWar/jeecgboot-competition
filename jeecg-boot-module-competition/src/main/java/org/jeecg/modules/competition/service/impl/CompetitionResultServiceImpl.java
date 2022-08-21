package org.jeecg.modules.competition.service.impl;
Updates were rejected because the remote contains work that you do
        hint: not have locally. This is usually caused by another repository pushing
        hint: to the same ref. You may want to first integrate the remote changes
        hint: (e.g., 'git pull ...') before pushing again.
        hint: See the 'Note about fast-forwards' in 'git push --help' for detail
import org.jeecg.modules.competition.bean.entity.CompetitionResult;
import org.jeecg.modules.competition.mapper.CompetitionResultMapper;
import org.jeecg.modules.competition.service.ICompetitionResultService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 大赛结果表
 * @Author: jeecg-boot
 * @Date:   2022-08-01
 * @Version: V1.0
 */
@Service
public class CompetitionResultServiceImpl extends ServiceImpl<CompetitionResultMapper, CompetitionResult> implements ICompetitionResultService {

}
