package org.jeecg.modules.competition.controller.frontDesk;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.dto.message.MessageDTO;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.api.ISysBaseAPI;
import org.jeecg.common.system.vo.LoginUser;

import org.jeecg.modules.competition.bean.entity.Competition;
import org.jeecg.modules.competition.bean.entity.CompetitionEnroll;
import org.jeecg.modules.competition.bean.entity.CompetitionPermission;
import org.jeecg.modules.competition.service.ICompetitionEnrollService;
import org.jeecg.modules.competition.service.ICompetitionPermissionService;
import org.jeecg.modules.competition.service.ICompetitionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "大赛前台 - 管理员")
@RestController
@RequestMapping("/competition/")
@Slf4j
public class ManagerController {
    @Autowired
    private ISysBaseAPI sysBaseAPI;
    @Autowired
    private ICompetitionEnrollService enrollService;
    @Autowired
    private ICompetitionPermissionService competitionPermissionService;
    @Autowired
    private ICompetitionService competitionService;

    @GetMapping("/enroll")
    @ApiOperation(value="分页获取大赛报名申请", notes="分页获取大赛报名申请")
    public Result<IPage<CompetitionEnroll>> getCompetitionEnrolls(
            @RequestParam(name = "state") Integer state,
            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam("competitionID") String competitionId) {
        if (verification(competitionId) == null) {
            return Result.error(403, "无权限访问");
        }

        Page<CompetitionEnroll> page = new Page<>(pageNo, pageSize);
        List<CompetitionEnroll> competitionEnrollByCompetitionID = enrollService.getCompetitionEnrollByCompetitionID(page, competitionId, state);
        Page<CompetitionEnroll> pages = page.setRecords(competitionEnrollByCompetitionID);
        Result<IPage<CompetitionEnroll>> Success = Result.OK("成功", pages);
        return Success;
    }

    @PutMapping("/enroll")
    @ApiOperation(value="修改报名情况", notes="修改报名情况")
    public Result<Integer> updateEnroll(@RequestParam("enroll_id") String enrollId, @RequestParam("state") Integer state) {
        //TODO 更改报名状态
        if (state != 0 && state != 1) {
            return Result.error(400, "报名信息只能通过或未通过");
        }
        LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        CompetitionEnroll competitionEnroll = enrollService.getById(enrollId);
        if (verification(competitionEnroll.getCompetitionId()) == null) {
            return Result.error(403, "无权限访问");
        }
        if (competitionEnroll.getState() != 0) {
            return Result.error(400, "已审核");
        }
        Integer integer = enrollService.updateEnrollState(enrollId, state);
        // 批准通过
        if (state.equals(1)) {
            competitionPermissionService.UpdateStateByCompetitionAndUid(competitionEnroll.getCompetitionId(), competitionEnroll.getUserId(), 2);
            new Thread(() -> {//发送系统提示
                Competition competition = competitionService.getById(competitionEnroll.getCompetitionId());
                LoginUser userById = sysBaseAPI.getUserById(competitionEnroll.getUserId());
                log.info("发送报名通过消息给ID为" + competitionEnroll.getUserId() + "的用户");
                sysBaseAPI.sendSysAnnouncement(new MessageDTO("admin", userById.getUsername(), competition.getTitle() + "报名申请通过", "您参加" + competition.getTitle() + "已通过"));
            }).start();
        } else {
            competitionPermissionService.UpdateStateByCompetitionAndUid(competitionEnroll.getCompetitionId(), competitionEnroll.getUserId(), -1);
            new Thread(() -> {//发送系统提示
                Competition competition = competitionService.getById(competitionEnroll.getCompetitionId());
                LoginUser userById = sysBaseAPI.getUserById(competitionEnroll.getUserId());
                log.info("发送报名通过消息给ID为" + competitionEnroll.getUserId() + "的用户");
                sysBaseAPI.sendSysAnnouncement(new MessageDTO("admin", userById.getUsername(), competition.getTitle() + "报名申请未通过", "您参加" + competition.getTitle() + "未通过"));
            }).start();
        }
        return Result.OK();
    }


    public CompetitionPermission verification(String competitionId) {
        LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        QueryWrapper<CompetitionPermission> competitionPermissionQueryWrapper = new QueryWrapper<>();
        QueryWrapper<CompetitionPermission> userQuery = competitionPermissionQueryWrapper.eq("user_id", sysUser.getId()).eq("competition_id", competitionId);
        CompetitionPermission permission = competitionPermissionService.getOne(userQuery);
        if (permission == null || !CompetitionPermission.MANAGER_TYPE.equals(permission.getType())) {
            return null;
        }
        return permission;
    }

}
