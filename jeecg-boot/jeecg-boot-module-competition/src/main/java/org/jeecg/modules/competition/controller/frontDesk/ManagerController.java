package org.jeecg.modules.competition.controller.frontDesk;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.competition.bean.entity.CompetitionEnroll;
import org.springframework.web.bind.annotation.*;

@Api(tags = "大赛后台")
@RestController
@RequestMapping("/competition/")
@Slf4j
public class ManagerController {
    @GetMapping("/enroll")
    public Result<IPage<CompetitionEnroll>> getCompetitionEnrolls(@RequestParam("competition_id")String competitionId){
        //TODO 分页获取报名信息
        return null;
    }

    @PutMapping("/enroll")
    public Result updateEnroll(@RequestParam("enroll_id")String enrollId,@RequestParam("state")Integer state){
        //TODO 更改报名状态
        return null;
    }
}
