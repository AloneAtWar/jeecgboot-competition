package org.jeecg.modules.competition.controller.frontDesk;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.competition.bean.entity.*;
import org.jeecg.modules.competition.bean.req.EnrollReq;
import org.jeecg.modules.competition.bean.req.SubmitWorkReq;
import org.jeecg.modules.competition.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

//参赛者有关的接口
@Api(tags = "大赛前台 - 参赛者有关")
@RestController
@RequestMapping("/competition/")
@Slf4j
public class ParticipantsController {
    @Autowired
    private ICompetitionService competitionService;
    @Autowired
    private ICompetitionPermissionService competitionPermissionService;
    @Autowired
    private ICompetitionSubmitService competitionSubmitService;
    @Autowired
    private ICompetitionResultService competitionResultService;
    @Autowired
    private ICompetitionEnrollService competitionEnrollService;

    @PostMapping("/enroll")
    @ApiOperation(value="报名参加比赛", notes="报名参加比赛")
    public Result enroll(@RequestBody EnrollReq enrollReq){
        CompetitionPermission permission = verification(enrollReq.getCompetitionId());
        if(permission!=null){
            return Result.error(403,"无法报名该比赛");
        }
        Competition competition = competitionService.getById(enrollReq.getCompetitionId());
        Date now = new Date();
        if (now.getTime()<competition.getStartTime().getTime()){
            return  Result.error(400,"比赛报名还未开始");
        }
        if(now.getTime()>competition.getEndTime().getTime()){
            return Result.error(400,"比赛报名已经截至");
        }
        CompetitionEnroll competitionEnroll = new CompetitionEnroll();
        BeanUtils.copyProperties(enrollReq,competitionEnroll);
        competitionEnroll.setCreateTime(now);
        competitionEnroll.setState(0);
        LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        competitionEnroll.setUserId(sysUser.getId());
        competitionEnrollService.save(competitionEnroll);
        permission = new CompetitionPermission();
        permission.setType(0);
        permission.setState(1);
        permission.setUserId(sysUser.getId());
        permission.setCompetitionId(enrollReq.getCompetitionId());
        competitionPermissionService.save(permission);
        return Result.ok();
    }

    @PostMapping("/competitionSubmit")
    @ApiOperation(value="提交作品", notes="提交作品")
    public Result submit(@RequestBody SubmitWorkReq submitWorkReq){
        CompetitionPermission permission = verification(submitWorkReq.getCompetitionId());
        if(permission==null || permission.getState()!=2){
            return Result.error(403,"无法提交作品");
        }
        CompetitionSubmit competitionSubmit = new CompetitionSubmit();
        competitionSubmit.setCreateTime(new Date());
        competitionSubmit.setIsSettlement(0);
        competitionSubmit.setUserId(permission.getUserId());
        BeanUtils.copyProperties(submitWorkReq,competitionSubmit);
        competitionSubmitService.save(competitionSubmit);
        permission.setState(3);
        competitionPermissionService.updateById(permission);
        return Result.ok();
    }

    @GetMapping("/score")
    @ApiOperation(value="获取自己的大赛得分", notes="获取自己的大赛得分")
    public Result<CompetitionResult> score(@RequestParam("competition_id")String competitionId){
        CompetitionPermission permission = verification(competitionId);
        if(permission==null || permission.getState()!=4){
            return Result.error(403,"无法获取作品分数");
        }
        QueryWrapper<CompetitionResult> wrapper = new QueryWrapper<CompetitionResult>().eq("competition_id", competitionId).eq("user_id", permission.getUserId());
        return Result.ok(competitionResultService.getOne(wrapper));
    }

    private CompetitionPermission verification(String competitionId){
        LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        QueryWrapper<CompetitionPermission> competitionPermissionQueryWrapper = new QueryWrapper<>();
        QueryWrapper<CompetitionPermission> userQuery = competitionPermissionQueryWrapper.eq("user_id", sysUser.getId()).eq("competition_id",competitionId);
        CompetitionPermission permission = competitionPermissionService.getOne(userQuery);
        if (permission == null || !CompetitionPermission.PARTICIPANTS_TYPE.equals(permission.getType())) {
            return null;
        }
        return permission;
    }
}
