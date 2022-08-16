package org.jeecg.modules.competition.controller.frontDesk;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.checkerframework.checker.units.qual.A;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.common.util.RedisUtil;
import org.jeecg.modules.competition.bean.entity.CompetitionEnroll;
import org.jeecg.modules.competition.bean.entity.CompetitionPermission;
import org.jeecg.modules.competition.service.ICompetitionEnrollService;
import org.jeecg.modules.competition.service.ICompetitionPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "大赛后台")
@RestController
@RequestMapping("/competition/")
@Slf4j
public class ManagerController {
    @Autowired
    private ICompetitionEnrollService enrollService;
    @Autowired
    private ICompetitionPermissionService service;
    @Autowired
    private RedisUtil redisUtil;
    @GetMapping("/enroll")
    public Result<IPage<CompetitionEnroll>> getCompetitionEnrolls(
            @RequestParam(name = "state" ) Integer state,
            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam("competitionID")String competitionId){
        LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        try {
            //TODO 分页获取报名信息
            String uid = sysUser.getId();
            if (HavePermission(uid,competitionId)) {
                Page<CompetitionEnroll> page=new Page<>(pageNo,pageSize);
                List<CompetitionEnroll> competitionEnrollByCompetitionID = enrollService.getCompetitionEnrollByCompetitionID(page, competitionId, state);
                Page<CompetitionEnroll> pages = page.setRecords(competitionEnrollByCompetitionID);
                Result<IPage<CompetitionEnroll>> Success = Result.OK("成功", pages);
                return Success;
            }
            return Result.OK("访问分页报名信息失败:无权限",null);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    @PutMapping("/enroll")
    public Result<Integer> updateEnroll(@RequestParam("enroll_id")String enrollId,@RequestParam("state")Integer state){
        //TODO 更改报名状态
        try {
            if (HavePermission(enrollId)) {
                Integer integer = enrollService.updateEnrollState(enrollId, state);
                Result<Integer> ok = Result.OK("修改报名信息成功", integer);
                return ok;
            }
            return Result.OK("修改失败:无访问权限",null);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.error(e.getMessage());
        }
    }
    private boolean HavePermission(String UID,String competitionId){
        CompetitionPermission competitionPermission = service.selectByUIDAndCompetitionId(UID, competitionId);
        if (competitionPermission.getState()==1){
            return true;
        }
        return false;
    }
    private boolean HavePermission(String enrollId){
        CompetitionEnroll byId = enrollService.getById(enrollId);
        String UID=byId.getUserId();
        String competitionId = byId.getCompetitionId();
        return HavePermission(UID,competitionId);
    }


}
