package com.njwb.www.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.njwb.www.util.ErrorCode;
import com.njwb.www.util.StaticCode;
import com.njwb.www.exception.JoyBeanException;
import com.njwb.www.pojo.ConvertRatio;
import com.njwb.www.pojo.ConvertRatioWrapper;
import com.njwb.www.pojo.Province;
import com.njwb.www.service.ConvertRatioService;
import com.njwb.www.service.ProvinceService;

@Controller
@RequestMapping("ConvertRatio")
public class ConvertRatioController {
	@Autowired
	private ConvertRatioService convertRatioService;
	@Autowired
	private ProvinceService provinceService;
	
	String code = StaticCode.EMPTYSTRING;
	/**
	 * 添加比例前取省份
	 * @param model
	 * @return
	 */
	@RequestMapping("/addBeforeConvertRatio.action")
	public String addBeforeConvertRatio(Model model){
		List<Province> provinceList = provinceService.showAllProvince();
		model.addAttribute("provinceList",provinceList);
		return "convertRatio/convertRatioAdd";
	}
	/**
	 * 添加比例
	 * @param model
	 * @param pDistrictName
	 * @param crConsumeAmountstr
	 * @return
	 */
	@RequestMapping("/addConvertRatio.action")
	public String addConvertRatio(Model model,String pDistrictName,String crConsumeAmountstr){
		if(pDistrictName==null||pDistrictName.isEmpty()){
    		code=ErrorCode.CONVERT_RATIO_PID_NULL_ERROR;		
    	}else if(crConsumeAmountstr==null||crConsumeAmountstr.isEmpty()){
    		code=ErrorCode.CONVERT_RATIO_CONSUME_AMOUNT_NULL_ERROR;		
    	}else{
    		try{
    			int crConsumeAmount =Integer.parseInt(crConsumeAmountstr);
    			int crPId = provinceService.selectProvinceByPDistrictName(pDistrictName).getpId();
        		ConvertRatio convertRatio = new ConvertRatio(crPId,crConsumeAmount);

        		boolean f = convertRatioService.addConvertRatio(convertRatio);
        		if(f==true){
    	        	model.addAttribute("code",ErrorCode.CONVERT_RATIO_ADD_SUCCESS);
    	        	return "prompt/success";
    	        }else{
    	        	code = ErrorCode.CONVERT_RATIO_ADD_ERROR;		
    	        }
        	} catch (JoyBeanException e) {	
        		code = e.getErrorCode();
    		}catch (NumberFormatException e) {
				code = ErrorCode.CONVERT_RATIO_CONSUME_AMOUNT_FORMAT_ERROR;
			}  		
    	}		
		model.addAttribute("code",code);
    	model.addAttribute("path","ConvertRatio/addBeforeConvertRatio.action");
    	return "prompt/error";
	}
	/**
	 * 删除比例
	 * @param model
	 * @param crId
	 * @return
	 */
	@RequestMapping("/deleteConvertRatio.action")
	public String deleteConvertRatio(Model model,int crId){
		boolean f = convertRatioService.delConvertRatioByCrId(crId);
		if(f==true){
			model.addAttribute("code",ErrorCode.CONVERT_RATIO_DEL_SUCCESS);
			return "prompt/success";
		}else{
			model.addAttribute("code",ErrorCode.CONVERT_RATIO_DEL_ERROR);
			return "prompt/error";
		}
	}
	/**
	 * 修改比例前取省份和比例
	 * @param model
	 * @param crId
	 * @return
	 */
	@RequestMapping("/editBeforeConvertRatio.action")
	public String editBeforeConvertRatio(Model model,int crId){
		ConvertRatio convertRatio = convertRatioService.selectConvertRatioByCrId(crId);
		String pDistrictName = provinceService.selectProvinceByPId(convertRatio.getCrPId()).getpDistrictName();
		List<Province> provinceList = provinceService.showAllProvince();
		model.addAttribute("provinceList",provinceList);
		model.addAttribute("convertRatio",convertRatio);
		model.addAttribute("pDistrictName",pDistrictName);
		return "convertRatio/convertRatioEdit";
	}
	/**
	 * 修改比例
	 * @param model
	 * @param crId
	 * @param crConsumeAmountstr
	 * @return
	 */
	@RequestMapping("/editConvertRatio.action")
	public String editConvertRatio(Model model,int crId,String crConsumeAmountstr){
		if(crConsumeAmountstr==null||crConsumeAmountstr.isEmpty()){
    		code=ErrorCode.CONVERT_RATIO_CONSUME_AMOUNT_NULL_ERROR;		
    	}else{
    		try{
    			int crConsumeAmount =Integer.parseInt(crConsumeAmountstr);
    			
        		ConvertRatio convertRatio = new ConvertRatio();
        		convertRatio.setCrId(crId);
        		convertRatio.setCrConsumeAmount(crConsumeAmount);

        		boolean f = convertRatioService.updateConvertRatioByCrId(convertRatio);
        		if(f==true){
    	        	model.addAttribute("code",ErrorCode.CONVERT_RATIO_EDIT_SUCCESS);
    	        	return "prompt/success";
    	        }else{
    	        	code = ErrorCode.CONVERT_RATIO_EDIT_ERROR;		
    	        } 
    		}catch (NumberFormatException e) {
				code = ErrorCode.CONVERT_RATIO_CONSUME_AMOUNT_FORMAT_ERROR;	
    		} catch (JoyBeanException e) {
    			code = e.getErrorCode();
			}
    	}		
		model.addAttribute("code",code);
    	model.addAttribute("path","ConvertRatio/editBeforeConvertRatio.action?crId="+crId);
    	return "prompt/error";		
	}
	/**
	 * 分页显示
	 * @param model
	 * @param pageNostr
	 * @return
	 */
	@RequestMapping("/queryAllByPage.action")
	public String queryAllConvertRatioWrapperByPage(Model model,String pageNostr){
	
		int pageNo = 0;
		int pageSize = StaticCode.PAGESIZE;
		
		if(pageNostr==null||pageNostr.equals(StaticCode.EMPTYSTRING)){
			pageNo = StaticCode.ONE;
		}else{
  			pageNo = Integer.parseInt(pageNostr);//显示第几页
  		}

  		//总条数业务层查询
		int totalCount = convertRatioService.selectCount();//总条数，业务层查询 
		int totalPage = totalCount/pageSize+((totalCount%pageSize==0)?0:1);
		
		//页数的判断，不能<=0 不能超过总页数
  		if(pageNo > totalPage){
  			pageNo = totalPage;//只显示尾页
  		}else if(pageNo <= StaticCode.ZERO){
  			pageNo = StaticCode.ONE;
  		}
		
  		Map<String,Object> map = new HashMap<String, Object>();
  		map.put("pageNo",pageNo);
  		map.put("pageSize",pageSize);
		List<ConvertRatioWrapper> convertRatioWrapperList = convertRatioService.showAllConvertRatioWrapperByPage(map);
		
		model.addAttribute("convertRatioWrapperList",convertRatioWrapperList);
		model.addAttribute("pageNo",pageNo);
		model.addAttribute("totalPage",totalPage);
  		
  		return "convertRatio/convertRatio";
		
	}
	/**
	 * 模糊查询
	 * @param model
	 * @param pageNostr
	 * @param pDistrictNamestr
	 * @return
	 */
	@RequestMapping("/searchConvertRatio.action")
	public String searchConvertRatio(Model model,String pageNostr,String pDistrictNamestr){
		//获得当前显示的页数
		
		int pageNo = 0;
		int pageSize = StaticCode.PAGESIZE;
		String pDistrictName = null;
		
		if(pageNostr==null||pageNostr.equals(StaticCode.EMPTYSTRING)){
			pageNo = StaticCode.ONE;
		}else{
  			pageNo = Integer.parseInt(pageNostr);//显示第几页
  		}
			
		if(pDistrictNamestr==null||pDistrictNamestr.equals(StaticCode.EMPTYSTRING)){
			pDistrictName = null;
		}else{
			pDistrictName = "%"+pDistrictNamestr+"%";
		}
  		//总条数业务层查询
		int totalCount = convertRatioService.selectCountByPDistrictName(pDistrictName);//总条数，业务层查询 
		int totalPage = totalCount/pageSize+((totalCount%pageSize==0)?0:1);
		
		//页数的判断，不能<=0 不能超过总页数
  		if(pageNo > totalPage){
  			pageNo = totalPage;//只显示尾页
  		}else if(pageNo <= StaticCode.ZERO){
  			pageNo = StaticCode.ONE;
  		}
		
  		Map<String,Object> map = new HashMap<String, Object>();
  		map.put("pDistrictName",pDistrictName);
  		map.put("pageNo",pageNo);
  		map.put("pageSize",pageSize);
		List<ConvertRatioWrapper> convertRatioWrapperList = convertRatioService.showAllByPDistrictNameByPage(map);
		
		model.addAttribute("convertRatioWrapperList",convertRatioWrapperList);
		model.addAttribute("pageNo",pageNo);
		model.addAttribute("totalPage",totalPage);
  		model.addAttribute("pDistrictNamestr",pDistrictNamestr);
  		
  		return "convertRatio/convertRatioSearch";
		
	}
}
