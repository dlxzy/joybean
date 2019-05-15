package com.njwb.www.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.njwb.www.util.ErrorCode;
import com.njwb.www.util.StaticCode;
import com.njwb.www.exception.JoyBeanException;
import com.njwb.www.pojo.ExpendRecord;
import com.njwb.www.pojo.ExpendRecordWrapper;
import com.njwb.www.pojo.GameWrapper;
import com.njwb.www.pojo.User;
import com.njwb.www.service.ExpendRecordService;
import com.njwb.www.service.GameService;

@Controller
@RequestMapping("ExpendRecord")
public class ExpendRecordController {
	@Autowired
	private ExpendRecordService expendRecordService;

	@Autowired
	private GameService gameService;

	String code = StaticCode.EMPTYSTRING;
	/**
	 * 添加消费记录
	 * @param request
	 * @param erGId
	 * @param erPurchaseWays
	 * @param erUIdstr
	 * @return
	 */
	@RequestMapping("/addExpendRecord.action")
	public String addExpendRecord(HttpServletRequest request,int erGId,int erPurchaseWays,String erUIdstr){
		//通过游戏编号获得游戏的信息
		GameWrapper gameWrapper = gameService.selectGameWrapperByGId(erGId);
		String gtName = gameWrapper.getGameType().getGtName();
	
		int erUId = 0;//用户编号
		User user = (User)(request.getSession().getAttribute("user"));
		if(user==null){
			code = ErrorCode.EXPEND_RECORD_USER_NULL_ERROR;
			request.getSession().setAttribute("code",code);
	    	return "prompt/error";
		}
		
		//session获取用户编号
		if((StaticCode.EMPTYSTRING).equals(erUIdstr)||erUIdstr==null){
			erUId = user.getuId();
		}
			
		try {
			boolean f = expendRecordService.addExpendRecord(new ExpendRecord(erGId,erPurchaseWays,erUId));
			if(f==true){										
        		code = ErrorCode.EXPEND_RECORD_ADD_SUCCESS;
        		request.getSession().setAttribute("code",code);	
        		request.getSession().setAttribute("path","Game/downloadBeforeGame.action?gName="+gameWrapper.getgName());
        		return "prompt/success";
        	}else{
        		code = ErrorCode.EXPEND_RECORD_ADD_ERROR;		
        	} 
		
		} catch (JoyBeanException e) {
			code = e.getErrorCode();
		}
		request.getSession().setAttribute("code",code);
		request.getSession().setAttribute("path","Game/queryAllByGtName.action?gtName="+gtName);
    	return "prompt/error";
	}
	/**
	 * 分页显示
	 * @param model
	 * @param request
	 * @param response
	 * @param pageNostr
	 * @param erUIdstr
	 * @return
	 */
	@RequestMapping("/queryAllByPage.action")
	public String queryAllByErUIdByPage(Model model,HttpServletRequest request,HttpServletResponse response,String pageNostr,String erUIdstr){
	
		int pageNo = 0;
		int pageSize = StaticCode.PAGESIZE;
		int erUId = 0;
		
		if(pageNostr==null||pageNostr.equals(StaticCode.EMPTYSTRING)){
			pageNo = StaticCode.ONE;
		}else{
  			pageNo = Integer.parseInt(pageNostr);//显示第几页
  		}

		if((StaticCode.EMPTYSTRING).equals(erUIdstr)||erUIdstr==null){
			erUId = ((User)(request.getSession().getAttribute("user"))).getuId();
		}
		
  		//总条数业务层查询
		int totalCount = expendRecordService.selectCountByErUId(erUId);//总条数，业务层查询 
		int totalPage = totalCount/pageSize+((totalCount%pageSize==0)?0:1);
		
		//页数的判断，不能<=0 不能超过总页数
  		if(pageNo > totalPage){
  			pageNo = totalPage;//只显示尾页
  		}else if(pageNo <= StaticCode.ZERO){
  			pageNo = StaticCode.ONE;
  		}
		
  		Map<String,Object> map = new HashMap<String, Object>();
  		map.put("erUId",erUId);
  		map.put("pageNo",pageNo);
  		map.put("pageSize",pageSize);
		List<ExpendRecordWrapper> expendRecordWrapperList = expendRecordService.showAllByErUIdByPage(map);
		model.addAttribute("expendRecordWrapperList",expendRecordWrapperList);
		model.addAttribute("pageNo",pageNo);
		model.addAttribute("totalPage",totalPage);
  		
  		return "expendRecord/expendRecord";
		
	}
	/**
	 * 模糊查询
	 * @param model
	 * @param request
	 * @param response
	 * @param pageNostr
	 * @param gNamestr
	 * @param erPurchaseWaysstr
	 * @param erUIdstr
	 * @return
	 */
	@RequestMapping("/searchExpendRecord.action")
	public String searchExpendRecord(Model model,HttpServletRequest request,HttpServletResponse response,String pageNostr,String gNamestr,String erPurchaseWaysstr,String erUIdstr){
		
		int pageNo = 0;
		int pageSize = StaticCode.PAGESIZE;
		String gName = null;
		String erPurchaseWays = null;
		int erUId = 0;
		
		if(pageNostr==null||pageNostr.equals(StaticCode.EMPTYSTRING)){
			pageNo = StaticCode.ONE;
		}else{
  			pageNo = Integer.parseInt(pageNostr);//显示第几页
  		}
			
		if(gNamestr==null||gNamestr.equals(StaticCode.EMPTYSTRING)){
			gName = null;
		}else{
			gName = "%"+gNamestr+"%";
		}
		
		if(erPurchaseWaysstr.equals(StaticCode.SELECT)){
			erPurchaseWays = null;
		}else{
			erPurchaseWays = "%"+erPurchaseWaysstr+"%";
		}
		
		if((StaticCode.EMPTYSTRING).equals(erUIdstr)||erUIdstr==null){
			erUId = ((User)(request.getSession().getAttribute("user"))).getuId();
		}
		
		Map<String,Object> params = new HashMap<String,Object>(); 
		params.put("erUId",erUId);
		params.put("gName",gName);
		params.put("erPurchaseWays",erPurchaseWays);
		
  		//总条数业务层查询
		int totalCount = expendRecordService.selectCountByErUIdAndGNameAndErPurchaseWays(params);//总条数，业务层查询 
		int totalPage = totalCount/pageSize+((totalCount%pageSize==0)?0:1);
		
		//页数的判断，不能<=0 不能超过总页数
  		if(pageNo > totalPage){
  			pageNo = totalPage;//只显示尾页
  		}else if(pageNo <= StaticCode.ZERO){
  			pageNo = StaticCode.ONE;
  		}
		
  		Map<String,Object> map = new HashMap<String, Object>();
  		map.putAll(params);
  		map.put("pageNo",pageNo);
  		map.put("pageSize",pageSize);
		List<ExpendRecordWrapper> expendRecordWrapperList = expendRecordService.showAllByErUIdAndGNameAndErPurchaseWaysByPage(map);
		
		model.addAttribute("expendRecordWrapperList",expendRecordWrapperList);
		model.addAttribute("pageNo",pageNo);
		model.addAttribute("totalPage",totalPage);
  		model.addAttribute("gNamestr",gNamestr);
  		model.addAttribute("erPurchaseWaysstr",erPurchaseWaysstr);
  		model.addAttribute("erUIdstr",erUIdstr);
  		
  		return "expendRecord/expendRecordSearch";
		
	}
	
	/**
	 * 下载游戏（判断是否存在消费记录）
	 * @param model
	 * @param request
	 * @param gId
	 * @param erUIdstr
	 * @return
	 */
	@RequestMapping("/downloadGame.action")
	public String downloadGame(Model model,HttpServletRequest request,int gId,String erUIdstr){
		int erUId = 0;
		GameWrapper gameWrapper = gameService.selectGameWrapperByGId(gId);
		User user = (User)(request.getSession().getAttribute("user"));
		if(user==null){
			code = ErrorCode.EXPEND_RECORD_USER_NULL_ERROR;
			request.getSession().setAttribute("code",code);
	    	return "prompt/error";
		}
		if((StaticCode.EMPTYSTRING).equals(erUIdstr)||erUIdstr==null){
			erUId = user.getuId();
		}
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("erUId",erUId);
		params.put("erGId",gId);
		ExpendRecordWrapper expendRecordWrapper = expendRecordService.selectExpendRecordWrapperByErUIdAndErGId(params);
		
		if(expendRecordWrapper==null){	
			code = ErrorCode.EXPEND_RECORD_DOWNLOAD_GAME_ERROR;
    		request.setAttribute("code",code);	
    		request.setAttribute("path","Game/queryAllByGtName.action?gtName="+gameWrapper.getGameType().getGtName());
    		return "prompt/error";
		}else{
			code = ErrorCode.EXPEND_RECORD_DOWNLOAD_GAME_SUCCESS;
    		request.setAttribute("code",code);	
    		request.setAttribute("path","Game/queryAllByGtName.action?gtName="+gameWrapper.getGameType().getGtName());
    		return "prompt/success";
		}
		
		
	}
}
