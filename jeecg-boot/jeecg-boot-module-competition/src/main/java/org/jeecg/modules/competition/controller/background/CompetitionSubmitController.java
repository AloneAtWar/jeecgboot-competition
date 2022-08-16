package org.jeecg.modules.competition.controller.background;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.competition.bean.entity.CompetitionSubmit;
import org.jeecg.modules.competition.service.ICompetitionSubmitService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 大赛提交记录表
 * @Author: jeecg-boot
 * @Date:   2022-08-16
 * @Version: V1.0
 */
@Api(tags="大赛提交记录表")
@RestController
@RequestMapping("/competition/competitionSubmit")
@Slf4j
public class CompetitionSubmitController extends JeecgController<CompetitionSubmit, ICompetitionSubmitService> {
	@Autowired
	private ICompetitionSubmitService competitionSubmitService;
	
	/**
	 * 分页列表查询
	 *
	 * @param competitionSubmit
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "大赛提交记录表-分页列表查询")
	@ApiOperation(value="大赛提交记录表-分页列表查询", notes="大赛提交记录表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CompetitionSubmit>> queryPageList(CompetitionSubmit competitionSubmit,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CompetitionSubmit> queryWrapper = QueryGenerator.initQueryWrapper(competitionSubmit, req.getParameterMap());
		Page<CompetitionSubmit> page = new Page<CompetitionSubmit>(pageNo, pageSize);
		IPage<CompetitionSubmit> pageList = competitionSubmitService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param competitionSubmit
	 * @return
	 */
	@AutoLog(value = "大赛提交记录表-添加")
	@ApiOperation(value="大赛提交记录表-添加", notes="大赛提交记录表-添加")
	//@RequiresPermissions("org.jeecg.modules.demo:competition_submit:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CompetitionSubmit competitionSubmit) {
		competitionSubmitService.save(competitionSubmit);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param competitionSubmit
	 * @return
	 */
	@AutoLog(value = "大赛提交记录表-编辑")
	@ApiOperation(value="大赛提交记录表-编辑", notes="大赛提交记录表-编辑")
	//@RequiresPermissions("org.jeecg.modules.demo:competition_submit:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CompetitionSubmit competitionSubmit) {
		competitionSubmitService.updateById(competitionSubmit);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "大赛提交记录表-通过id删除")
	@ApiOperation(value="大赛提交记录表-通过id删除", notes="大赛提交记录表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules.demo:competition_submit:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		competitionSubmitService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "大赛提交记录表-批量删除")
	@ApiOperation(value="大赛提交记录表-批量删除", notes="大赛提交记录表-批量删除")
	//@RequiresPermissions("org.jeecg.modules.demo:competition_submit:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.competitionSubmitService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "大赛提交记录表-通过id查询")
	@ApiOperation(value="大赛提交记录表-通过id查询", notes="大赛提交记录表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CompetitionSubmit> queryById(@RequestParam(name="id",required=true) String id) {
		CompetitionSubmit competitionSubmit = competitionSubmitService.getById(id);
		if(competitionSubmit==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(competitionSubmit);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param competitionSubmit
    */
    //@RequiresPermissions("org.jeecg.modules.demo:competition_submit:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CompetitionSubmit competitionSubmit) {
        return super.exportXls(request, competitionSubmit, CompetitionSubmit.class, "大赛提交记录表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("competition_submit:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CompetitionSubmit.class);
    }

}
