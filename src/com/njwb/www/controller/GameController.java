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

import com.njwb.www.pojo.User;
import com.njwb.www.util.ErrorCode;
import com.njwb.www.util.StaticCode;
import com.njwb.www.exception.JoyBeanException;
import com.njwb.www.pojo.Game;
import com.njwb.www.pojo.GameType;
import com.njwb.www.pojo.GameWrapper;
import com.njwb.www.service.GameService;
import com.njwb.www.service.GameTypeService;

@Controller
@RequestMapping("Game")
public class GameController {
	@Autowired
	private GameService gameService;
	@Autowired
	private GameTypeService gameTypeService;
	
	String code = StaticCode.EMPTYSTRING;
	/**
	 * 添加游戏前取游戏类型（商用）
	 * @param model
	 * @return
	 */
	@RequestMapping("/addBeforeGame.action")
	public String addBeforeGame(Model model){
		List<GameType> gameTypeList = gameTypeService.showAllByGtState(StaticCode.COMMERCIAL);
		model.addAttribute("gameTypeList",gameTypeList);
		return "game/gameAdd";
	}
	/**
	 * 添加游戏
	 * @param request
	 * @param response
	 * @param gName
	 * @param gDetails
	 * @param gState
	 * @param gPicturestr
	 * @param gtName
	 * @param gJoybeanPricestr
	 * @param gPhonePricestr
	 * @param gCrIdstr
	 * @return
	 */
	@RequestMapping("/addGame.action")
	public String addGame(HttpServletRequest request,HttpServletResponse response,String gName,String gDetails,int gState,String gPicturestr,String gtName,String gJoybeanPricestr,String gPhonePricestr,String gCrIdstr){
		if(gName==null||gName.isEmpty()){
    		code=ErrorCode.GAME_NAME_NULL_ERROR;		
    	}else if(gtName==null||gtName.isEmpty()){
    		code=ErrorCode.GAME_GGTID_NULL_ERROR;		
    	}else if(gDetails==null||gDetails.isEmpty()){
    		code=ErrorCode.GAME_DETAILS_NULL_ERROR;		
    	}else if(gPicturestr==null||gPicturestr.isEmpty()){
    		code=ErrorCode.GAME_PICTURE_NULL_ERROR;		
    	}else if(gJoybeanPricestr==null||gJoybeanPricestr.isEmpty()){
    		code=ErrorCode.GAME_JOYBEANPRICE_NULL_ERROR;		
    	}else if(gPhonePricestr==null||gPhonePricestr.isEmpty()){
    		code=ErrorCode.GAME_PHONEPRICE_NULL_ERROR;		
    	}else{
    		int gJoybeanPrice = 0;
    		int gPhonePrice = 0;
    		int gCrId = 0;
    		String gPicture = StaticCode.PICTUREPATH+gPicturestr;
    		try {
    			gJoybeanPrice =Integer.parseInt(gJoybeanPricestr);
    		}catch (NumberFormatException e1) {
    			code = ErrorCode.GAME_JOYBEANPRICE_FORMAT_ERROR;
    			request.getSession().setAttribute("code",code);
    	    	request.getSession().setAttribute("path","Game/addBeforeGame.action");
    	    	return "prompt/error";
    		}
    		try {
    			 gPhonePrice =Integer.parseInt(gPhonePricestr);
    		}catch (NumberFormatException e2) {
    			code = ErrorCode.GAME_PHONEPRICE_FORMAT_ERROR;
    			request.getSession().setAttribute("code",code);
    	    	request.getSession().setAttribute("path","Game/addBeforeGame.action");
    	    	return "prompt/error";
    		}
    		
    		if((StaticCode.EMPTYSTRING).equals(gCrIdstr)||gCrIdstr==null){
    			gCrId = ((User)(request.getSession().getAttribute("user"))).getuId();
    		}
    		
    		int gGTId = gameTypeService.selectGameTypeByGtName(gtName).getGtId();
    		
    		try {
    			boolean f = gameService.addGame(new Game(gName,gGTId,gPicture,gState,gDetails,gJoybeanPrice,gPhonePrice,gCrId,gCrId));
    			if(f==true){
	        		code = ErrorCode.GAME_ADD_SUCCESS;
	        		request.getSession().setAttribute("code",code);	
	        		return "prompt/success";
	        	}else{
	        		code = ErrorCode.GAME_ADD_ERROR;		
	        	} 
    		} catch (JoyBeanException e) {	
    			code = e.getErrorCode();
    		}
    	}		
		request.getSession().setAttribute("code",code);
    	request.getSession().setAttribute("path","Game/addBeforeGame.action");
    	return "prompt/error";
	}
	/**
	 * 修改游戏前取游戏类型（商用）和所选中的游戏
	 * @param model
	 * @param gId
	 * @return
	 */
	@RequestMapping("/editBeforeGame.action")
	public String editBeforeGame(Model model,int gId){
		GameWrapper gameWrapper = gameService.selectGameWrapperByGId(gId);	
		List<GameType> gameTypeList = gameTypeService.showAllByGtState(StaticCode.COMMERCIAL);
		model.addAttribute("gameWrapper",gameWrapper);
		model.addAttribute("gameTypeList",gameTypeList);
		return "game/gameEdit";
	}
	/**
	 * 修改游戏
	 * @param request
	 * @param response
	 * @param gId
	 * @param gName
	 * @param gDetails
	 * @param gState
	 * @param gPicturestr
	 * @param gtName
	 * @param gJoybeanPricestr
	 * @param gPhonePricestr
	 * @param gUpIdstr
	 * @return
	 */
	@RequestMapping("/editGame.action")
	public String editGame(HttpServletRequest request,HttpServletResponse response,int gId,String gName,String gDetails,int gState,String gPicturestr,String gtName,String gJoybeanPricestr,String gPhonePricestr,String gUpIdstr){
		
		if(gName==null||gName.isEmpty()){
    		code=ErrorCode.GAME_NAME_NULL_ERROR;		
    	}else if(gtName==null||gtName.isEmpty()){
    		code=ErrorCode.GAME_GGTID_NULL_ERROR;		
    	}else if(gDetails==null||gDetails.isEmpty()){
    		code=ErrorCode.GAME_DETAILS_NULL_ERROR;		
    	}else if(gJoybeanPricestr==null||gJoybeanPricestr.isEmpty()){
    		code=ErrorCode.GAME_JOYBEANPRICE_NULL_ERROR;		
    	}else if(gPhonePricestr==null||gPhonePricestr.isEmpty()){
    		code=ErrorCode.GAME_PHONEPRICE_NULL_ERROR;		
    	}else{
    		int gJoybeanPrice = 0;
    		int gPhonePrice = 0;
    		int gUpId = 0;
    		String gPicture = null;
    		if(gPicturestr==null||gPicturestr.isEmpty()){
    			gPicture = null;
    		}else{
    			gPicture = StaticCode.PICTUREPATH+gPicturestr;
    		} 		
    		try {
    			gJoybeanPrice =Integer.parseInt(gJoybeanPricestr);
    		}catch (NumberFormatException e1) {
    			code = ErrorCode.GAME_JOYBEANPRICE_FORMAT_ERROR;
    			request.getSession().setAttribute("code",code);
    	    	request.getSession().setAttribute("path","Game/editBeforeGame.action?gId="+gId);
    	    	return "prompt/error";
    		}
    		try {
    			 gPhonePrice =Integer.parseInt(gPhonePricestr);
    		}catch (NumberFormatException e2) {
    			code = ErrorCode.GAME_PHONEPRICE_FORMAT_ERROR;
    			request.getSession().setAttribute("code",code);
    	    	request.getSession().setAttribute("path","Game/editBeforeGame.action?gId="+gId);
    	    	return "prompt/error";
    		}
    		
    		if((StaticCode.EMPTYSTRING).equals(gUpIdstr)||gUpIdstr==null){
    			gUpId = ((User)(request.getSession().getAttribute("user"))).getuId();
    		}
    		
    		int gGTId = gameTypeService.selectGameTypeByGtName(gtName).getGtId();
    		try {
    			System.out.println(new Game(gId,gName,gGTId,gPicture,gState,gDetails,gJoybeanPrice,gPhonePrice,gUpId).toString());
    			boolean f = gameService.updateGameByGId(new Game(gId,gName,gGTId,gPicture,gState,gDetails,gJoybeanPrice,gPhonePrice,gUpId));
    			if(f==true){
	        		code = ErrorCode.GAME_EDIT_SUCCESS;
	        		request.getSession().setAttribute("code",code);	
	        		return "prompt/success";
	        	}else{
	        		code = ErrorCode.GAME_EDIT_ERROR;		
	        	} 
    		} catch (JoyBeanException e) {	
    			code = e.getErrorCode();
    		}
    	}		
		request.getSession().setAttribute("code",code);
    	request.getSession().setAttribute("path","Game/editBeforeGame.action?gId="+gId);
    	return "prompt/error";
	}
	/**
	 * 分页显示
	 * @param model
	 * @param pageNostr
	 * @return
	 */
	@RequestMapping("/queryAllByPage.action")
	public String queryAllGameWrapperByPage(Model model,String pageNostr){
	
		int pageNo = 0;
		int pageSize = StaticCode.PAGESIZE;
		
		if(pageNostr==null||pageNostr.equals(StaticCode.EMPTYSTRING)){
			pageNo = StaticCode.ONE;
		}else{
  			pageNo = Integer.parseInt(pageNostr);//显示第几页
  		}

  		//总条数业务层查询
		int totalCount = gameService.selectCount();//总条数，业务层查询 
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
		List<GameWrapper> gameWrapperList = gameService.showAllGameWrapperByPage(map);
		List<GameType> gameTypeList = gameTypeService.showAllGameType();
		
		model.addAttribute("gameWrapperList",gameWrapperList);
		model.addAttribute("gameTypeList",gameTypeList);
		model.addAttribute("pageNo",pageNo);
		model.addAttribute("totalPage",totalPage);
  		
  		return "game/game";
		
	}
	/**
	 * 查看游戏详情前取对应游戏对象
	 * @param model
	 * @param gName
	 * @return
	 */
	@RequestMapping("/queryGameByGName.action")
	public String queryGameByGName(Model model,String gName){
		GameWrapper gameWrapper = gameService.selectGameWrapperByGName(gName);	
		
		model.addAttribute("gameWrapper",gameWrapper);

		return "game/gameDetails";
	}
	/**
	 * 游客界面下载游戏前取游戏对象
	 * @param model
	 * @param gName
	 * @return
	 */
	@RequestMapping("/downloadBeforeGame.action")
	public String downloadBeforeGame(Model model,String gName){
		GameWrapper gameWrapper = gameService.selectGameWrapperByGName(gName);	
		
		model.addAttribute("gameWrapper",gameWrapper);

		return "tourist/gameDownload";
	}
	/**
	 * 游客界面，各商用游戏类型所对应的商用游戏
	 * @param model
	 * @param gtName
	 * @return
	 */
	@RequestMapping("/queryAllByGtName.action")
	public String queryAllGameWrapperByGtName(Model model,String gtName){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("gtName",gtName);
		params.put("gState",StaticCode.COMMERCIAL);
		List<GameWrapper> gameWrapperList = gameService.showAllByGtNameAndGState(params);	
		
		model.addAttribute("gameWrapperList",gameWrapperList);
		return "tourist/gameDetails";
	}
	/**
	 * 模糊查询
	 * @param model
	 * @param pageNostr
	 * @param gNamestr
	 * @param gtNamestr
	 * @return
	 */
	@RequestMapping("/searchGame.action")
	public String searchGame(Model model,String pageNostr,String gNamestr,String gtNamestr){
		//获得当前显示的页数
		
		int pageNo = 0;
		int pageSize = StaticCode.PAGESIZE;
		
		String gName = null;
		String gtName = null;
		
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
		
		
		if(gtNamestr==null||gtNamestr.equals(StaticCode.EMPTYSTRING)){
			gtName = null;
		}else{
			gtName = "%"+gtNamestr+"%";
		}
		
	
		Map<String,Object> params = new HashMap<String,Object>(); 
		params.put("gName",gName);
		params.put("gtName",gtName);

  		//总条数业务层查询
		int totalCount = gameService.selectCountByGNameAndGTName(params);//总条数，业务层查询 
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
		List<GameWrapper> gameWrapperList = gameService.showAllByGNameAndGTNameByPage(map);
		
		model.addAttribute("gameWrapperList",gameWrapperList);
		model.addAttribute("pageNostr",pageNo);
		model.addAttribute("totalPage",totalPage);
  		model.addAttribute("gNamestr",gNamestr);
  		model.addAttribute("gtNamestr",gtNamestr);
  		
  		return "game/gameSearch";
		
	}

}
