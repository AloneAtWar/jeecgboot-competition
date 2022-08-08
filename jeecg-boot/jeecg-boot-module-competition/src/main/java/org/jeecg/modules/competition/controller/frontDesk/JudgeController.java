package org.jeecg.modules.competition.controller.frontDesk;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.competition.bean.entity.CompetitionEnroll;
import org.jeecg.modules.competition.bean.entity.CompetitionPermission;
import org.jeecg.modules.competition.bean.entity.CompetitionResult;
import org.jeecg.modules.competition.bean.entity.CompetitionSubmit;
import org.jeecg.modules.competition.service.ICompetitionPermissionService;
import org.jeecg.modules.competition.service.ICompetitionResultService;
import org.jeecg.modules.competition.service.ICompetitionService;
import org.jeecg.modules.competition.service.ICompetitionSubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(tags = "大赛后台-评委角色")
@RestController
@RequestMapping("/competition/")
@Slf4j
public class JudgeController {
    @Autowired
    private ICompetitionService competitionService;
    @Autowired
    private ICompetitionPermissionService competitionPermissionService;
    @Autowired
    private ICompetitionSubmitService competitionSubmitService;
    @Autowired
    private ICompetitionResultService competitionResultService;
    @GetMapping("/submit")
    @ApiOperation(value="获取大赛提交", notes="获取大赛提交")
    public Result<IPage<CompetitionSubmit>> getCompetitionSubmits(@RequestParam("competition_id") String competitionId, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                  @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        //TODO 获取所有提交信息
        if (verification(competitionId)==null){
            return Result.error(403,"无权限访问");
        }
        QueryWrapper<CompetitionSubmit> competitionSubmitQueryWrapper = new QueryWrapper<>();
        Page<CompetitionSubmit> page = new Page<CompetitionSubmit>(pageNo, pageSize);
        Page<CompetitionSubmit> pageList = competitionSubmitService.page(page, competitionSubmitQueryWrapper);
        return Result.OK(pageList);
    }

    @PostMapping("/score")
    @ApiOperation(value="为某大赛评分", notes="为某大赛评分")
    public Result score(@RequestParam("user_id")String userId,@RequestParam("competition_id") String competitionId,@RequestParam("score")Integer score) {
        CompetitionPermission permission = verification(competitionId);
        if (permission==null){
            return Result.error(403,"无权限访问");
        }
        QueryWrapper<CompetitionSubmit> competitionSubmitQueryWrapper = new QueryWrapper<CompetitionSubmit>().eq("is_settlement", "0").eq("user_id", userId).eq("competition_id", competitionId);
        CompetitionSubmit competitionSubmit = new CompetitionSubmit();
        competitionSubmit.setIsSettlement(1);
        boolean update = competitionSubmitService.update(competitionSubmit, competitionSubmitQueryWrapper);
        CompetitionResult competitionResult = new CompetitionResult();
        competitionResult.setCompetitionId(competitionId);
        competitionResult.setScore(score);
        competitionResult.setCreateTime(new Date());
        competitionResult.setUserId(userId);
        competitionResultService.save(competitionResult);
        permission.setState(CompetitionPermission.GET_SCORE_STATE);
        competitionPermissionService.updateById(permission);
        return Result.ok();
    }

    public CompetitionPermission verification(String competitionId){
        LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        QueryWrapper<CompetitionPermission> competitionPermissionQueryWrapper = new QueryWrapper<>();
        QueryWrapper<CompetitionPermission> userQuery = competitionPermissionQueryWrapper.eq("user_id", sysUser.getId()).eq("competition_id",competitionId);
        CompetitionPermission permission = competitionPermissionService.getOne(userQuery);
        if (permission == null || !CompetitionPermission.JUDGE_TYPE.equals(permission.getType())) {
            return null;
        }
        return permission;
    }


}
