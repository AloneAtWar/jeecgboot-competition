package org.jeecg.modules.competition.controller.background;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.competition.bean.entity.CompetitionEnroll;
import org.jeecg.modules.competition.service.ICompetitionEnrollService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

/**
* @Description: 大赛申请表
* @Author: jeecg-boot
* @Date:   2022-08-01
* @Version: V1.0
*/
@Api(tags="大赛申请表")
@RestController
@RequestMapping("/competition/competitionEnroll")
@Slf4j
public class CompetitionEnrollController extends JeecgController<CompetitionEnroll, ICompetitionEnrollService> {
   @Autowired
   private ICompetitionEnrollService competitionEnrollService;

   /**
    * 分页列表查询
    *
    * @param competitionEnroll
    * @param pageNo
    * @param pageSize
    * @param req
    * @return
    */
   //@AutoLog(value = "大赛申请表-分页列表查询")
   @ApiOperation(value="大赛申请表-分页列表查询", notes="大赛申请表-分页列表查询")
   @GetMapping(value = "/list")
   public Result<IPage<CompetitionEnroll>> queryPageList(CompetitionEnroll competitionEnroll,
                                  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
                                  HttpServletRequest req) {
       QueryWrapper<CompetitionEnroll> queryWrapper = QueryGenerator.initQueryWrapper(competitionEnroll, req.getParameterMap());
       Page<CompetitionEnroll> page = new Page<CompetitionEnroll>(pageNo, pageSize);
       IPage<CompetitionEnroll> pageList = competitionEnrollService.page(page, queryWrapper);
       return Result.OK(pageList);
   }

   /**
    *   添加
    *
    * @param competitionEnroll
    * @return
    */
   @AutoLog(value = "大赛申请表-添加")
   @ApiOperation(value="大赛申请表-添加", notes="大赛申请表-添加")
   //@RequiresPermissions("org.jeecg.modules.demo:competition_enroll:add")
   @PostMapping(value = "/add")
   public Result<String> add(@RequestBody CompetitionEnroll competitionEnroll) {
       competitionEnrollService.save(competitionEnroll);
       return Result.OK("添加成功！");
   }

   /**
    *  编辑
    *
    * @param competitionEnroll
    * @return
    */
   @AutoLog(value = "大赛申请表-编辑")
   @ApiOperation(value="大赛申请表-编辑", notes="大赛申请表-编辑")
   //@RequiresPermissions("org.jeecg.modules.demo:competition_enroll:edit")
   @RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
   public Result<String> edit(@RequestBody CompetitionEnroll competitionEnroll) {
       competitionEnrollService.updateById(competitionEnroll);
       return Result.OK("编辑成功!");
   }

   /**
    *   通过id删除
    *
    * @param id
    * @return
    */
   @AutoLog(value = "大赛申请表-通过id删除")
   @ApiOperation(value="大赛申请表-通过id删除", notes="大赛申请表-通过id删除")
   //@RequiresPermissions("org.jeecg.modules.demo:competition_enroll:delete")
   @DeleteMapping(value = "/delete")
   public Result<String> delete(@RequestParam(name="id",required=true) String id) {
       competitionEnrollService.removeById(id);
       return Result.OK("删除成功!");
   }

   /**
    *  批量删除
    *
    * @param ids
    * @return
    */
   @AutoLog(value = "大赛申请表-批量删除")
   @ApiOperation(value="大赛申请表-批量删除", notes="大赛申请表-批量删除")
   //@RequiresPermissions("org.jeecg.modules.demo:competition_enroll:deleteBatch")
   @DeleteMapping(value = "/deleteBatch")
   public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
       this.competitionEnrollService.removeByIds(Arrays.asList(ids.split(",")));
       return Result.OK("批量删除成功!");
   }

   /**
    * 通过id查询
    *
    * @param id
    * @return
    */
   //@AutoLog(value = "大赛申请表-通过id查询")
   @ApiOperation(value="大赛申请表-通过id查询", notes="大赛申请表-通过id查询")
   @GetMapping(value = "/queryById")
   public Result<CompetitionEnroll> queryById(@RequestParam(name="id",required=true) String id) {
       CompetitionEnroll competitionEnroll = competitionEnrollService.getById(id);
       if(competitionEnroll==null) {
           return Result.error("未找到对应数据");
       }
       return Result.OK(competitionEnroll);
   }

   /**
   * 导出excel
   *
   * @param request
   * @param competitionEnroll
   */
   //@RequiresPermissions("org.jeecg.modules.demo:competition_enroll:exportXls")
   @RequestMapping(value = "/exportXls")
   public ModelAndView exportXls(HttpServletRequest request, CompetitionEnroll competitionEnroll) {
       return super.exportXls(request, competitionEnroll, CompetitionEnroll.class, "大赛申请表");
   }

   /**
     * 通过excel导入数据
   *
   * @param request
   * @param response
   * @return
   */
   //@RequiresPermissions("competition_enroll:importExcel")
   @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
   public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
       return super.importExcel(request, response, CompetitionEnroll.class);
   }

}
