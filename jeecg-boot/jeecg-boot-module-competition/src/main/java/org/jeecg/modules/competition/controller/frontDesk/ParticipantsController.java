package org.jeecg.modules.competition.controller.frontDesk;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.competition.bean.entity.CompetitionResult;
import org.jeecg.modules.competition.bean.req.EnrollReq;
import org.jeecg.modules.competition.bean.req.SubmitWorkReq;
import org.springframework.web.bind.annotation.*;

//参赛者有关的接口
@Api(tags = "大赛前台")
@RestController
@RequestMapping("/competition/")
@Slf4j
public class ParticipantsController {
    @PostMapping("/enroll")
    public Result enroll(@RequestBody EnrollReq enrollReq){
        //TODO 参加比赛
        return null;
    }

    @PostMapping("/competitionSubmit")
    public Result submit(){
        //TODO 提交作品
        return Result.ok();
    }

    @GetMapping("/score")
    public Result<CompetitionResult> score(@RequestParam("competition_id")String competitionId){
        //TODO 获取分数
        return null;
    }
}
