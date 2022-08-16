package org.jeecg.modules.competition.controller.frontDesk;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.common.util.RedisUtil;
import org.jeecg.modules.competition.bean.entity.Competition;
import org.jeecg.modules.competition.bean.entity.CompetitionPermission;
import org.jeecg.modules.competition.bean.resp.MyCompetitionResp;
import org.jeecg.modules.competition.bean.resp.SpecificCompetitionResp;
import org.jeecg.modules.competition.service.ICompetitionPermissionService;
import org.jeecg.modules.competition.service.ICompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// 所有角色的公用部分
@Api(tags = "大赛后台")
@RestController
@RequestMapping("/competition/")
@Slf4j
public class FrontDeskCompetitionController {
    @Autowired
    private ICompetitionPermissionService iCompetitionPermissionService;
    @Autowired
    private ICompetitionService iCompetitionService;


    @ApiOperation(value = "分页查询 与我有关的比赛")
    @GetMapping("/my")
    public Result<IPage<MyCompetitionResp>> getMyCompetition(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                             @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        try {
            LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
            String id = sysUser.getId();
            Page<CompetitionPermission> competitionPermissionPage = new Page<>(pageNo, pageSize);
            Page<CompetitionPermission> competitionPermissionPage1 = iCompetitionPermissionService.selectMyCompetition(competitionPermissionPage, id);
            List<CompetitionPermission> records = competitionPermissionPage1.getRecords();
            List<MyCompetitionResp> myCompetitionResps = new ArrayList<>();
            for (CompetitionPermission record : records) {
                Competition byId = iCompetitionService.getById(record.getCompetitionId());
                MyCompetitionResp myCompetitionResp = makeMyCompetition(byId, record);
                myCompetitionResps.add(myCompetitionResp);
            }
            log.info("我的比赛:" + myCompetitionResps.toString());
            Page<MyCompetitionResp> competitionRespPage = new Page<>(pageNo, pageSize);
            Page<MyCompetitionResp> competitionRespPages = competitionRespPage.setRecords(myCompetitionResps);
            competitionRespPages.setTotal(competitionPermissionPage1.getTotal());
            Result<IPage<MyCompetitionResp>> MyCompetition = Result.OK("获取我的比赛", competitionRespPages);
            //TODO 分页查询 与我有关的比赛
            return MyCompetition;
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("访问我的详细比赛")
    @GetMapping("/special")
    public Result<SpecificCompetitionResp> getSpecialCompetition(@RequestParam("competition_id") String competitionId) {
        //TODO 获取具体比赛具体信息
        log.info("competitionId=" + competitionId);
        try {
            LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
            String uid = sysUser.getId();
            CompetitionPermission competitionPermission = iCompetitionPermissionService.selectByUIDAndCompetitionId(uid, competitionId);
            Competition byId = iCompetitionService.getById(competitionPermission.getCompetitionId());
            SpecificCompetitionResp specificCompetitionResp = makeSpecificCompetitionRespn(byId, competitionPermission);
            log.info(specificCompetitionResp.toString());
            Result<SpecificCompetitionResp> ok = Result.OK("访问id为" + competitionId + "的比赛成功", specificCompetitionResp);
            return ok;
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.error(e.getMessage());
        }
    }


    private MyCompetitionResp makeMyCompetition(Competition competition, CompetitionPermission record) {
        return new MyCompetitionResp(competition.getId(), competition.getName(), competition.getIntroduction(),
                competition.getTitle(), competition.getNeedVolunteers(),
                competition.getStartTime().toString(), competition.getEndTime().toString(), competition.getType(), competition.getPicture(), record.getState(), record.getType());

    }

    private SpecificCompetitionResp makeSpecificCompetitionRespn(Competition competition, CompetitionPermission record) {
        boolean needVlo = false;
        if (competition.getNeedVolunteers() != 0) {
            needVlo = true;
        }
        return new SpecificCompetitionResp(record.getType(), record.getState(),
                competition.getId(), competition.getCreateTime().toString(), competition.getIntroduction(), competition.getTitle()
                , competition.getPicture(), needVlo, competition.getDetailIntroduce(), competition.getProblem(), competition.getStartTime().toString()
                , competition.getEndTime().toString(), competition.getAward(), competition.getType());
    }


}
