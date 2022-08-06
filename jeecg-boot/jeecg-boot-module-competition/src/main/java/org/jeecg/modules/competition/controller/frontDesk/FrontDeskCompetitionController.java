package org.jeecg.modules.competition.controller.frontDesk;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.competition.bean.resp.MyCompetitionResp;
import org.jeecg.modules.competition.bean.resp.SpecificCompetitionResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 所有角色的公用部分
@Api(tags = "大赛后台")
@RestController
@RequestMapping("/competition/")
@Slf4j
public class FrontDeskCompetitionController {
    @ApiOperation(value = "分页查询 与我有关的比赛")
    @GetMapping("/my")
    public Result<IPage<MyCompetitionResp>> getMyCompetition(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        //TODO 分页查询 与我有关的比赛
        return null;
    }


    @GetMapping("/special")
    public Result<SpecificCompetitionResp> getSpecialCompetition(@RequestParam("competition_id")String competitionId){
        //TODO 获取具体比赛具体信息
        return null;
    }




}
