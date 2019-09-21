package org.jeecg.modules.demo.pet.controller;

import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.pet.entity.PetDog;
import org.jeecg.modules.demo.pet.entity.PetCat;
import org.jeecg.modules.demo.pet.entity.PetOwners;
import org.jeecg.modules.demo.pet.vo.PetOwnersPage;
import org.jeecg.modules.demo.pet.service.IPetOwnersService;
import org.jeecg.modules.demo.pet.service.IPetDogService;
import org.jeecg.modules.demo.pet.service.IPetCatService;
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
import com.alibaba.fastjson.JSON;

 /**
 * @Description: 宠物主人
 * @Author: jeecg-boot
 * @Date:   2019-09-21
 * @Version: V1.0
 */
@RestController
@RequestMapping("/pet/petOwners")
@Slf4j
public class PetOwnersController {
	@Autowired
	private IPetOwnersService petOwnersService;
	@Autowired
	private IPetDogService petDogService;
	@Autowired
	private IPetCatService petCatService;
	
	/**
	  * 分页列表查询
	 * @param petOwners
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@GetMapping(value = "/list")
	public Result<IPage<PetOwners>> queryPageList(PetOwners petOwners,
									  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
									  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
									  HttpServletRequest req) {
		Result<IPage<PetOwners>> result = new Result<IPage<PetOwners>>();
		QueryWrapper<PetOwners> queryWrapper = QueryGenerator.initQueryWrapper(petOwners, req.getParameterMap());
		Page<PetOwners> page = new Page<PetOwners>(pageNo, pageSize);
		IPage<PetOwners> pageList = petOwnersService.page(page, queryWrapper);
		result.setSuccess(true);
		result.setResult(pageList);
		return result;
	}
	
	/**
	  *   添加
	 * @param petOwnersPage
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<PetOwners> add(@RequestBody PetOwnersPage petOwnersPage) {
		Result<PetOwners> result = new Result<PetOwners>();
		try {
			PetOwners petOwners = new PetOwners();
			BeanUtils.copyProperties(petOwnersPage, petOwners);
			
			petOwnersService.saveMain(petOwners, petOwnersPage.getPetDogList(),petOwnersPage.getPetCatList());
			result.success("添加成功！");
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			result.error500("操作失败");
		}
		return result;
	}
	
	/**
	  *  编辑
	 * @param petOwnersPage
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<PetOwners> edit(@RequestBody PetOwnersPage petOwnersPage) {
		Result<PetOwners> result = new Result<PetOwners>();
		PetOwners petOwners = new PetOwners();
		BeanUtils.copyProperties(petOwnersPage, petOwners);
		PetOwners petOwnersEntity = petOwnersService.getById(petOwners.getId());
		if(petOwnersEntity==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = petOwnersService.updateById(petOwners);
			petOwnersService.updateMain(petOwners, petOwnersPage.getPetDogList(),petOwnersPage.getPetCatList());
			result.success("修改成功!");
		}
		
		return result;
	}
	
	/**
	  *   通过id删除
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		try {
			petOwnersService.delMain(id);
		} catch (Exception e) {
			log.error("删除失败",e.getMessage());
			return Result.error("删除失败!");
		}
		return Result.ok("删除成功!");
	}
	
	/**
	  *  批量删除
	 * @param ids
	 * @return
	 */
	@DeleteMapping(value = "/deleteBatch")
	public Result<PetOwners> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<PetOwners> result = new Result<PetOwners>();
		if(ids==null || "".equals(ids.trim())) {
			result.error500("参数不识别！");
		}else {
			this.petOwnersService.delBatchMain(Arrays.asList(ids.split(",")));
			result.success("删除成功!");
		}
		return result;
	}
	
	/**
	  * 通过id查询
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/queryById")
	public Result<PetOwners> queryById(@RequestParam(name="id",required=true) String id) {
		Result<PetOwners> result = new Result<PetOwners>();
		PetOwners petOwners = petOwnersService.getById(id);
		if(petOwners==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(petOwners);
			result.setSuccess(true);
		}
		return result;
	}
	
	/**
	  * 通过id查询
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/queryPetDogByMainId")
	public Result<List<PetDog>> queryPetDogListByMainId(@RequestParam(name="id",required=true) String id) {
		Result<List<PetDog>> result = new Result<List<PetDog>>();
		List<PetDog> petDogList = petDogService.selectByMainId(id);
		result.setResult(petDogList);
		result.setSuccess(true);
		return result;
	}
	/**
	  * 通过id查询
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/queryPetCatByMainId")
	public Result<List<PetCat>> queryPetCatListByMainId(@RequestParam(name="id",required=true) String id) {
		Result<List<PetCat>> result = new Result<List<PetCat>>();
		List<PetCat> petCatList = petCatService.selectByMainId(id);
		result.setResult(petCatList);
		result.setSuccess(true);
		return result;
	}

  /**
      * 导出excel
   *
   * @param request
   * @param response
   */
  @RequestMapping(value = "/exportXls")
  public ModelAndView exportXls(HttpServletRequest request, PetOwners petOwners) {
      // Step.1 组装查询条件查询数据
      QueryWrapper<PetOwners> queryWrapper = QueryGenerator.initQueryWrapper(petOwners, request.getParameterMap());
      List<PetOwners> queryList = petOwnersService.list(queryWrapper);
      // 过滤选中数据
      String selections = request.getParameter("selections");
      List<PetOwners> petOwnersList = new ArrayList<PetOwners>();
      if(oConvertUtils.isEmpty(selections)) {
    	  petOwnersList = queryList;
      }else {
    	  List<String> selectionList = Arrays.asList(selections.split(","));
    	  petOwnersList = queryList.stream().filter(item -> selectionList.contains(item.getId())).collect(Collectors.toList());
      }
	  // Step.2 组装pageList
      List<PetOwnersPage> pageList = new ArrayList<PetOwnersPage>();
      for (PetOwners main : petOwnersList) {
          PetOwnersPage vo = new PetOwnersPage();
          BeanUtils.copyProperties(main, vo);
          List<PetDog> petDogList = petDogService.selectByMainId(main.getId());
          vo.setPetDogList(petDogList);
          List<PetCat> petCatList = petCatService.selectByMainId(main.getId());
          vo.setPetCatList(petCatList);
          pageList.add(vo);
      }
      // Step.3 AutoPoi 导出Excel
      ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
      mv.addObject(NormalExcelConstants.FILE_NAME, "宠物主人列表");
      mv.addObject(NormalExcelConstants.CLASS, PetOwnersPage.class);
      mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("宠物主人列表数据", "导出人:Jeecg", "导出信息"));
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
          MultipartFile file = entity.getValue();// 获取上传文件对象
          ImportParams params = new ImportParams();
          params.setTitleRows(2);
          params.setHeadRows(1);
          params.setNeedSave(true);
          try {
              List<PetOwnersPage> list = ExcelImportUtil.importExcel(file.getInputStream(), PetOwnersPage.class, params);
              for (PetOwnersPage page : list) {
                  PetOwners po = new PetOwners();
                  BeanUtils.copyProperties(page, po);
                  petOwnersService.saveMain(po, page.getPetDogList(),page.getPetCatList());
              }
              return Result.ok("文件导入成功！数据行数:" + list.size());
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
      return Result.ok("文件导入失败！");
  }

}
