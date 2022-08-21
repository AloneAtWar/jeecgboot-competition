package org.jeecg.modules.competition.controller.background;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecg.modules.competition.bean.entity.Competition;
import org.jeecg.modules.competition.bean.entity.CompetitionPermission;
import org.jeecg.modules.competition.service.ICompetitionService;
import org.jeecg.modules.competition.vo.CompetitionPage;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.vo.LoginUser;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.competition.service.ICompetitionPermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

/**
* @Description: 大赛表
* @Author: jeecg-boot
* @Date:   2022-08-01
* @Version: V1.0
*/
@Api(tags="大赛表")
@RestController
@RequestMapping("/competition/competition")
@Slf4j
public class CompetitionController {
   @Autowired
   private ICompetitionService competitionService;
   @Autowired
   private ICompetitionPermissionService competitionPermissionService;

   /**
    * 分页列表查询
    *
    * @param competition
    * @param pageNo
    * @param pageSize
    * @param req
    * @return
    */
   //@AutoLog(value = "大赛表-分页列表查询")
   @ApiOperation(value="大赛表-分页列表查询", notes="大赛表-分页列表查询")
   @GetMapping(value = "/list")
   public Result<IPage<Competition>> queryPageList(Competition competition,
                                                   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                                   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
                                                   HttpServletRequest req) {
       QueryWrapper<Competition> queryWrapper = QueryGenerator.initQueryWrapper(competition, req.getParameterMap());
       Page<Competition> page = new Page<Competition>(pageNo, pageSize);
       IPage<Competition> pageList = competitionService.page(page, queryWrapper);
       return Result.OK(pageList);
   }

   /**
    *   添加
    *
    * @param competitionPage
    * @return
    */
   @AutoLog(value = "大赛表-添加")
   @ApiOperation(value="大赛表-添加", notes="大赛表-添加")
   @PostMapping(value = "/add")
   public Result<String> add(@RequestBody CompetitionPage competitionPage) {
       Competition competition = new Competition();
       BeanUtils.copyProperties(competitionPage, competition);
       competitionService.saveMain(competition, competitionPage.getCompetitionPermissionList());
       return Result.OK("添加成功！");
   }

   /**
    *  编辑
    *
    * @param competitionPage
    * @return
    */
   @AutoLog(value = "大赛表-编辑")
   @ApiOperation(value="大赛表-编辑", notes="大赛表-编辑")
   @RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
   public Result<String> edit(@RequestBody CompetitionPage competitionPage) {
       Competition competition = new Competition();
       BeanUtils.copyProperties(competitionPage, competition);
       Competition competitionEntity = competitionService.getById(competition.getId());
       if(competitionEntity==null) {
           return Result.error("未找到对应数据");
       }
       competitionService.updateMain(competition, competitionPage.getCompetitionPermissionList());
       return Result.OK("编辑成功!");
   }

   /**
    *   通过id删除
    *
    * @param id
    * @return
    */
   @AutoLog(value = "大赛表-通过id删除")
   @ApiOperation(value="大赛表-通过id删除", notes="大赛表-通过id删除")
   @DeleteMapping(value = "/delete")
   public Result<String> delete(@RequestParam(name="id",required=true) String id) {
       competitionService.delMain(id);
       return Result.OK("删除成功!");
   }

   /**
    *  批量删除
    *
    * @param ids
    * @return
    */
   @AutoLog(value = "大赛表-批量删除")
   @ApiOperation(value="大赛表-批量删除", notes="大赛表-批量删除")
   @DeleteMapping(value = "/deleteBatch")
   public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
       this.competitionService.delBatchMain(Arrays.asList(ids.split(",")));
       return Result.OK("批量删除成功！");
   }

   /**
    * 通过id查询
    *
    * @param id
    * @return
    */
   //@AutoLog(value = "大赛表-通过id查询")
   @ApiOperation(value="大赛表-通过id查询", notes="大赛表-通过id查询")
   @GetMapping(value = "/queryById")
   public Result<Competition> queryById(@RequestParam(name="id",required=true) String id) {
       Competition competition = competitionService.getById(id);
       if(competition==null) {
           return Result.error("未找到对应数据");
       }
       return Result.OK(competition);

   }

   /**
    * 通过id查询
    *
    * @param id
    * @return
    */
   //@AutoLog(value = "大赛权限表通过主表ID查询")
   @ApiOperation(value="大赛权限表主表ID查询", notes="大赛权限表-通主表ID查询")
   @GetMapping(value = "/queryCompetitionPermissionByMainId")
   public Result<List<CompetitionPermission>> queryCompetitionPermissionListByMainId(@RequestParam(name="id",required=true) String id) {
       List<CompetitionPermission> competitionPermissionList = competitionPermissionService.selectByMainId(id);
       return Result.OK(competitionPermissionList);
   }

   /**
   * 导出excel
   *
   * @param request
   * @param competition
   */
   @RequestMapping(value = "/exportXls")
   public ModelAndView exportXls(HttpServletRequest request, Competition competition) {
     // Step.1 组装查询条件查询数据
     QueryWrapper<Competition> queryWrapper = QueryGenerator.initQueryWrapper(competition, request.getParameterMap());
     LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();

     //配置选中数据查询条件
     String selections = request.getParameter("selections");
     if(oConvertUtils.isNotEmpty(selections)) {
        List<String> selectionList = Arrays.asList(selections.split(","));
        queryWrapper.in("id",selectionList);
     }
     //Step.2 获取导出数据
     List<Competition> competitionList = competitionService.list(queryWrapper);

     // Step.3 组装pageList
     List<CompetitionPage> pageList = new ArrayList<CompetitionPage>();
     for (Competition main : competitionList) {
         CompetitionPage vo = new CompetitionPage();
         BeanUtils.copyProperties(main, vo);
         List<CompetitionPermission> competitionPermissionList = competitionPermissionService.selectByMainId(main.getId());
         vo.setCompetitionPermissionList(competitionPermissionList);
         pageList.add(vo);
     }

     // Step.4 AutoPoi 导出Excel
     ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
     mv.addObject(NormalExcelConstants.FILE_NAME, "大赛表列表");
     mv.addObject(NormalExcelConstants.CLASS, CompetitionPage.class);
     mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("大赛表数据", "导出人:"+sysUser.getRealname(), "大赛表"));
     mv.addObject(NormalExcelConstants.DATA_LIST, pageList);
     return mv;
   }

   /**
   * 通过excel导入数据
   *
   * @param request
   * @param response
   * @return
   */
   @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
   public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
     MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
     Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
     for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
         // 获取上传文件对象
         MultipartFile file = entity.getValue();
         ImportParams params = new ImportParams();
         params.setTitleRows(2);
         params.setHeadRows(1);
         params.setNeedSave(true);
         try {
             List<CompetitionPage> list = ExcelImportUtil.importExcel(file.getInputStream(), CompetitionPage.class, params);
             for (CompetitionPage page : list) {
                 Competition po = new Competition();
                 BeanUtils.copyProperties(page, po);
                 competitionService.saveMain(po, page.getCompetitionPermissionList());
             }
             return Result.OK("文件导入成功！数据行数:" + list.size());
         } catch (Exception e) {
             log.error(e.getMessage(),e);
             return Result.error("文件导入失败:"+e.getMessage());
         } finally {
             try {
                 file.getInputStream().close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }
     return Result.OK("文件导入失败！");
   }

}
