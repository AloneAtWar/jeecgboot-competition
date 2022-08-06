package org.jeecg.modules.competition.controller.frontDesk;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.competition.bean.entity.CompetitionSubmit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "大赛后台")
@RestController
@RequestMapping("/competition/")
@Slf4j
public class JudgeController {
    @GetMapping("/submit")
    public Result<IPage<CompetitionSubmit>> getCompetitionSubmits(@RequestParam("competition_id")String competitionId){
        //TODO 获取所有提交信息
        return null;
    }

    @GetMapping("/score")
    public Result score(){
        //TODO 评分
        return null;
    }

}
