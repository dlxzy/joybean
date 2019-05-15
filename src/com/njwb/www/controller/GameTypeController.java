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
import com.njwb.www.pojo.GameType;
import com.njwb.www.service.GameTypeService;

@Controller
@RequestMapping("GameType")
public class GameTypeController {
	@Autowired
	private GameTypeService gameTypeService;
	
	String code = StaticCode.EMPTYSTRING;
	/**
	 * 添加游戏类型
	 * @param request
	 * @param response
	 * @param gameType
	 * @return
	 */
	@RequestMapping("/addGameType.action")
	public String addGameType(HttpServletRequest request, HttpServletResponse response,GameType gameType){
		if(gameType.getGtName()==null||gameType.getGtName().isEmpty()){
    		code=ErrorCode.GAME_TYPE_NAME_NULL_ERROR;		
    	}else{
    		try {
    			boolean f = gameTypeService.addGameType(gameType);
    			if(f==true){
	        		code = ErrorCode.GAME_TYPE_ADD_SUCCESS;
	        		request.getSession().setAttribute("code",code);	
	        		return "prompt/success";
	        	}else{
	        		code = ErrorCode.GAME_TYPE_ADD_ERROR;		
	        	} 
    		} catch (JoyBeanException e) {	
    			code = e.getErrorCode();
    		}
    	}		
		request.getSession().setAttribute("code",code);
    	request.getSession().setAttribute("path","njwb/gameType/gameTypeAdd.jsp");
    	return "prompt/error";
	}
	/**
	 * 修改游戏类型前取游戏类型对象
	 * @param request
	 * @param response
	 * @param gtId
	 * @return
	 */
	@RequestMapping("/editBeforeGameType.action")
	public String editBeforeGameType(HttpServletRequest request, HttpServletResponse response,int gtId){
		GameType gameType = gameTypeService.selectGameTypeByGtId(gtId);
		request.setAttribute("gameType",gameType);
		return "gameType/gameTypeEdit";
	}
	/**
	 * 修改游戏类型
	 * @param request
	 * @param response
	 * @param gameType
	 * @return
	 */
	@RequestMapping("/editGameType.action")
	public String editGameType(HttpServletRequest request, HttpServletResponse response,GameType gameType){
		if(gameType.getGtName()==null||gameType.getGtName().isEmpty()){
    		code=ErrorCode.GAME_TYPE_NAME_NULL_ERROR;		
    	}else{
    		try {
    			boolean f = gameTypeService.updateGameTypeByGtId(gameType);
    			if(f==true){
	        		code = ErrorCode.GAME_TYPE_EDIT_SUCCESS;
	        		request.getSession().setAttribute("code",code);	
	        		return "prompt/success";
	        	}else{
	        		code = ErrorCode.GAME_TYPE_EDIT_ERROR;		
	        	} 
    		} catch (JoyBeanException e) {	
    			code = e.getErrorCode();
    		}
    	}		
		request.getSession().setAttribute("code",code);
    	request.getSession().setAttribute("path","GameType/editBeforeGameType.action?gtId="+gameType.getGtId());
    	return "prompt/error";
	}
	/**
	 * 分页显示
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/queryAllByPage.action")
	public String queryAllGameTypeByPage(HttpServletRequest request, HttpServletResponse response){
		//获得当前显示的页数
		String pageNostr = request.getParameter("pageNo");
		
		int pageNo = 0;
		int pageSize = StaticCode.PAGESIZE;
		
		if(pageNostr==null||pageNostr.equals(StaticCode.EMPTYSTRING)){
			pageNo = StaticCode.ONE;
		}else{
  			pageNo = Integer.parseInt(pageNostr);//显示第几页
  		}
		
  		//总条数业务层查询
		int totalCount = gameTypeService.selectCount();//总条数，业务层查询 

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
		List<GameType> gtlist = gameTypeService.showAllGameTypeByPage(map);
		
		request.setAttribute("gameTypeList",gtlist);
		request.setAttribute("pageNo",pageNo);
  		request.setAttribute("totalPage", totalPage);
  		
  		return "gameType/gameType";
  		
	}
	/**
	 * 游客界面显示所有商用的游戏类型
	 * @param model
	 * @return
	 */
	@RequestMapping("queryAllByGtState")
	public String queryAllByGtState(Model model){
		List<GameType> gameTypeList = gameTypeService.showAllByGtState(1);
		model.addAttribute("gameTypeList",gameTypeList);
		return "tourist/gamePage";
	}
	/**
	 * 模糊查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/searchGameType.action")
	public String searchGameType(HttpServletRequest request, HttpServletResponse response){
		//获得当前显示的页数
		String pageNostr = request.getParameter("pageNo");
		String gtNamestr = request.getParameter("gtName");
		String gtStatestr = request.getParameter("gtState");
		
		int pageNo = 0;
		int pageSize = StaticCode.PAGESIZE;
		String gtName;
		String gtState;
		
		if(pageNostr==null||pageNostr.equals(StaticCode.EMPTYSTRING)){
			pageNo = StaticCode.ONE;
		}else{
  			pageNo = Integer.parseInt(pageNostr);//显示第几页
  		}
		
		if(gtNamestr==null||gtNamestr.equals(StaticCode.EMPTYSTRING)){
			gtName = null;
		}else{
			gtName = "%"+gtNamestr+"%";
		}
		
		if(gtStatestr==null||gtStatestr.equals(StaticCode.EMPTYSTRING)){
			gtState = null;
		}else{
			gtState = "%"+Integer.parseInt(gtStatestr)+"%";
		}
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("gtName", gtName);
		params.put("gtState", gtState);
		
  		//总条数业务层查询
		int totalCount = gameTypeService.selectCountByGtNameAndGtState(params);//总条数，业务层查询 

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
		List<GameType> gtlist = gameTypeService.showAllByGtNameAndGtStateByPage(map);
		
		request.setAttribute("gameTypeList",gtlist);
		request.setAttribute("pageNo",pageNo);
  		request.setAttribute("totalPage", totalPage);
  		request.setAttribute("gtName",gtNamestr);
  		request.setAttribute("gtState",gtStatestr);
  			
  		return "gameType/gameTypeSearch";
  		
	}

}
