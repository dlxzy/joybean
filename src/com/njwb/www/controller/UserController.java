package com.njwb.www.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.njwb.www.util.MakeCertPic;
import com.njwb.www.util.ErrorCode;
import com.njwb.www.util.StaticCode;
import com.njwb.www.exception.JoyBeanException;
import com.njwb.www.pojo.User;
import com.njwb.www.pojo.UserWrapper;
import com.njwb.www.pojo.Province;
import com.njwb.www.service.UserService;
import com.njwb.www.service.ProvinceService;

@Controller
@RequestMapping("User")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProvinceService provinceService;
	
	String code = StaticCode.EMPTYSTRING;
	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/getCodeImg.action")
	public void getCodeImg(HttpServletRequest request, HttpServletResponse response) throws IOException{

		OutputStream os = response.getOutputStream();//获得响应的输出流
		//生成图形验证码
		String loginCode = MakeCertPic.getCertPic(0,0,os);//将图片输出到响应流中
		//字符串验证码添加到attribute中
		request.getSession().setAttribute("loginCode",loginCode);
		//不需要任何跳转，因为还是在login.jsp中
		System.out.println("获得验证码:"+loginCode);
	}
	/**
	 * 登陆
	 * @param request
	 * @param response
	 * @param uAccount
	 * @param uPassword
	 * @param loginCode
	 * @throws ParseException
	 */
	@RequestMapping("/login.action")
	public void login(HttpServletRequest request,HttpServletResponse response,String uAccount,String uPassword,String loginCode,int uRole) throws ParseException{

     	System.out.println("自己输入的验证码："+loginCode);
     	String lCode = (String) request.getSession().getAttribute("loginCode");
     	System.out.println("自己生成的验证码："+lCode);     
     	
     	String result=StaticCode.EMPTYSTRING;
     	
     	System.out.println("------------------------------"+uRole+"--------------------------");
     	//判断用户名是否为空、密码是否为空、验证码是否正确
     	
    	if(lCode.equalsIgnoreCase(loginCode)==false){
    		result="2";   		
    	}else{
    		try {	
				boolean f = userService.login(uAccount,uPassword,uRole);
    			if(f){		
    				//登录成功
    				User user = userService.selectUserByUAccount(uAccount);
    				if(user.getuState()==1){
    					//将user保存为属性，留待下级页面使用
        				request.getSession().setAttribute("user",user);			

        				if(user.getuRole()==1){
        					result = "0";
        				}else{
        					result = "1";
        				}       								
    				}else{
    					result = "6";    				} 				
    			}else{
    				if(uRole!=userService.selectUserByUAccount(uAccount).getuRole()){
    					result = "4";
    				}else{
    					result = "3";
    				}			
    			}
    		} catch (JoyBeanException e) {
    			result = "5";		
    		}
    	}
     	
     	try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
	}
	/**
	 * 退出
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("exit.action")
	public String exit(HttpServletRequest request, HttpServletResponse response){
		request.getSession().removeAttribute("user");
		System.out.println(request.getSession().getAttribute("user"));
		return "redirect:/njwb/login.jsp";
	}
	/**
	 * 注册前取省份
	 * @param model
	 * @return
	 */
	@RequestMapping("/registerBeforeUser.action")
	public String registerBeforeUser(Model model){
		List<Province> provinceList = provinceService.showAllProvince();
		model.addAttribute("provinceList",provinceList);
		return "register";
	}
	/**
	 * 注册
	 * @param model
	 * @param uAccount
	 * @param uPassword
	 * @param uName
	 * @param uPhoneNumber
	 * @param pDistrictName
	 * @return
	 */
	@RequestMapping("/registerUser.action")
	public String registerUser(Model model,String uAccount,String uPassword,String uName,String uPhoneNumber,String pDistrictName){
		if(pDistrictName==null||pDistrictName.isEmpty()){
    		code=ErrorCode.USER_PID_NULL_ERROR;		
    	}else if(uAccount==null||uAccount.isEmpty()){
    		code=ErrorCode.USER_ACCOUNT_NULL_ERROR;		
    	}else if(uPassword==null||uPassword.isEmpty()){
    		code=ErrorCode.USER_PASSWORD_NULL_ERROR;		
    	}else if(uPhoneNumber==null||uPhoneNumber.isEmpty()){
    		code=ErrorCode.USER_PHONENUMBER_NULL_ERROR;		
    	}else if(uPhoneNumber.matches("[0-9]{11}")==false){
    		code=ErrorCode.USER_PHONENUMBER_FORMAT_ERROR;		
    	}else{
    		try{
    			int uPId = provinceService.selectProvinceByPDistrictName(pDistrictName).getpId();
        		User user = new User(uAccount,uPassword,uName,uPhoneNumber,uPId);        		

        		boolean f = userService.addUser(user);
        		if(f==true){
    	        	model.addAttribute("code",ErrorCode.USER_ADD_SUCCESS);
    	        	return "prompt/success";
    	        }else{
    	        	code = ErrorCode.USER_ADD_ERROR;		
    	        }
        	} catch (JoyBeanException e) {	
        		code = e.getErrorCode();
    		} 		
    	}		
		model.addAttribute("code",code);
    	model.addAttribute("path","User/registerBeforeUser.action");
    	return "prompt/error";
	}
	
	/**
	 * 用户状态修改为正常
	 * @param model
	 * @param uId
	 * @return
	 */
	@RequestMapping("/editUstateNormal.action")
	public String editUstateNormal(Model model,int uId){
		User user = userService.selectUserByUId(uId);
		if(user.getuState()==StaticCode.NORMAL){
			model.addAttribute("code",ErrorCode.USER_STATE_ERROR);
			return "prompt/error";
		}else{
			boolean f = userService.updateUStateByUId(new User(uId,StaticCode.NORMAL));
			if(f==true){
				model.addAttribute("code",ErrorCode.USER_STATE_NORMAL_EDIT_SUCCESS);
				return "prompt/success";
			}else{
				model.addAttribute("code",ErrorCode.USER_STATE_NORMAL_EDIT_ERROR);
				return "prompt/error";
			}		
		}
		
	}
	/**
	 * 用户状态修改为暂停使用
	 * @param model
	 * @param uId
	 * @return
	 */
	@RequestMapping("/editUstateSuspend.action")
	public String editUstateSuspend(Model model,int uId){
		User user = userService.selectUserByUId(uId);
		if(user.getuState()==StaticCode.SUSPEND){
			model.addAttribute("code",ErrorCode.USER_STATE_ERROR);
			return "prompt/error";
		}else{
			boolean f = userService.updateUStateByUId(new User(uId,StaticCode.SUSPEND));
			if(f==true){
				model.addAttribute("code",ErrorCode.USER_STATE_SUSPEND_EDIT_SUCCESS);
				return "prompt/success";
			}else{
				model.addAttribute("code",ErrorCode.USER_STATE_SUSPEND_EDIT_ERROR);
				return "prompt/error";
			}
		}
	}
	/**
	 * 分页显示
	 * @param model
	 * @param pageNostr
	 * @return
	 */
	@RequestMapping("/queryAllByPage.action")
	public String queryAllUserWrapperByPage(Model model,String pageNostr){
	
		int pageNo = 0;
		int pageSize = StaticCode.PAGESIZE;
		
		if(pageNostr==null||pageNostr.equals(StaticCode.EMPTYSTRING)){
			pageNo = StaticCode.ONE;
		}else{
  			pageNo = Integer.parseInt(pageNostr);//显示第几页
  		}

  		//总条数业务层查询
		int totalCount = userService.selectCount();//总条数，业务层查询 
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
		List<UserWrapper> userWrapperList = userService.showAllUserWrapperByPage(map);
		
		model.addAttribute("userWrapperList",userWrapperList);
		model.addAttribute("pageNo",pageNo);
		model.addAttribute("totalPage",totalPage);
  		
  		return "user/user";
		
	}
	/**
	 * 模糊查询
	 * @param model
	 * @param pageNostr
	 * @param uAccountstr
	 * @param uNamestr
	 * @param uPhoneNumberstr
	 * @return
	 */
	@RequestMapping("/searchUser.action")
	public String searchUser(Model model,String pageNostr,String uAccountstr,String uNamestr,String uPhoneNumberstr){
		//获得当前显示的页数
		System.out.println("+++++++++++++++++++++"+uPhoneNumberstr);
		int pageNo = 0;
		int pageSize = StaticCode.PAGESIZE;
		String uAccount = null;
		String uName = null;
		String uPhoneNumber = null;
		
		if(pageNostr==null||pageNostr.equals(StaticCode.EMPTYSTRING)){
			pageNo = StaticCode.ONE;
		}else{
  			pageNo = Integer.parseInt(pageNostr);//显示第几页
  		}
			
		if(uNamestr==null||uNamestr.equals(StaticCode.EMPTYSTRING)){
			uName = null;
		}else{
			uName = "%"+uNamestr+"%";
		}
		
		if(uAccountstr==null||uAccountstr.equals(StaticCode.EMPTYSTRING)){
			uAccount = null;
		}else{
			uAccount = "%"+uAccountstr+"%";
		}
		
		if(uPhoneNumberstr==null||uPhoneNumberstr.equals(StaticCode.EMPTYSTRING)){
			uPhoneNumber = null;
		}else{
			uPhoneNumber = "%"+uPhoneNumberstr+"%";
		}
		Map<String,Object> params = new HashMap<String,Object>(); 
		params.put("uAccount",uAccount);
		params.put("uName",uName);
		params.put("uPhoneNumber",uPhoneNumber);
		
  		//总条数业务层查询
		int totalCount = userService.selectCountByUAccountAndUNameAndUPhoneNumber(params);//总条数，业务层查询 
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
		List<UserWrapper> userWrapperList = userService.showAllByUAccountAndUNameAndUPhoneNumberByPage(map);
		
		model.addAttribute("userWrapperList",userWrapperList);
		model.addAttribute("pageNo",pageNo);
		model.addAttribute("totalPage",totalPage);
  		model.addAttribute("uAccountstr",uAccountstr);
  		model.addAttribute("uNamestr",uNamestr);
  		model.addAttribute("uPhoneNumberstr",uPhoneNumberstr);
  		
  		return "user/userSearch";
		
	}
	/**
	 * 查询账号余额
	 * @param model
	 * @param request
	 * @param uIdstr
	 * @return
	 */
	@RequestMapping("/queryUserBalanceByUId.action")
	public String queryUserBalanceByUId(Model model,HttpServletRequest request,String uIdstr){
		
		int uId = 0;
		if((StaticCode.EMPTYSTRING).equals(uIdstr)||uIdstr==null){
			uId = ((User)(request.getSession().getAttribute("user"))).getuId();
		}	
		User user = userService.selectUserByUId(uId);
		model.addAttribute("user",user);
		return "balance/userBalance";
		
	}
	
	
	@RequestMapping("/editPhoneBalance.action")
	public String editPhoneBalanceByUId(Model model,HttpServletRequest request,String uIdstr,String uPhonestr){
		if(uPhonestr==null||(StaticCode.EMPTYSTRING).equals(uPhonestr)){
			code = ErrorCode.USER_PHONE_NULL_ERROR;
		}else{
			try{
				int uPhone = Integer.parseInt(uPhonestr);
				if(uPhone<=0){
					code = ErrorCode.USER_PHONE_LESS_THAN_ZERO_ERROR;
				}else{
					int uId = 0;
					if((StaticCode.EMPTYSTRING).equals(uIdstr)||uIdstr==null){
						uId = ((User)(request.getSession().getAttribute("user"))).getuId();
					}	
					User user = userService.selectUserByUId(uId);
					Map<String,Object> params = new HashMap<String,Object>();
					params.put("uPhoneBalance",user.getuPhoneBalance()+uPhone);
					params.put("uId",uId);
					boolean f = userService.updatePhoneBalanceByUId(params);
					if(f==true){
						code = ErrorCode.USER_PHONEBALANCE_EDIT_SUCCESS;
			    		request.getSession().setAttribute("code",code);	
			    		return "prompt/success";
					}else{
						code = ErrorCode.USER_PHONEBALANCE_EDIT_ERROR;
					}
				}			
			}catch (NumberFormatException e) {
				code = ErrorCode.USER_PHONE_FORMAT_ERROR;
			}		
		}
		
		request.getSession().setAttribute("code",code);	
		return "prompt/error";
		

		
	}
	
	@RequestMapping("/editJoyBeanBalance.action")
	public String editJoyBeanBalanceByUId(Model model,HttpServletRequest request,String uIdstr,String uJoyBeanstr){
		
		if(uJoyBeanstr==null||(StaticCode.EMPTYSTRING).equals(uJoyBeanstr)){
			code = ErrorCode.USER_JOYBEAN_NULL_ERROR;
		}else{
			try{
				int uJoyBean = Integer.parseInt(uJoyBeanstr);
				if(uJoyBean<=0){
					code = ErrorCode.USER_JOYBEAN_LESS_THAN_ZERO_ERROR;
				}else{
					int uId = 0;
					if((StaticCode.EMPTYSTRING).equals(uIdstr)||uIdstr==null){
						uId = ((User)(request.getSession().getAttribute("user"))).getuId();
					}	
					User user = userService.selectUserByUId(uId);
					int uPhoneBalance = user.getuPhoneBalance();
					int phoneBalance = 0;
					if(uJoyBean%StaticCode.DEFAULTEXCHANGERATIO==0){
						phoneBalance = (uJoyBean/StaticCode.DEFAULTEXCHANGERATIO);
					}else{
						phoneBalance = (uJoyBean/StaticCode.DEFAULTEXCHANGERATIO)+1;
					}
					if(uPhoneBalance>=phoneBalance){
						boolean f = userService.updateUserBalanceByUId(new User(uId, uPhoneBalance-phoneBalance,user.getuJoyBeanBalance()+uJoyBean));
						if(f==true){
							code = ErrorCode.USER_JOYBEANBALANCE_EDIT_SUCCESS;
				    		request.getSession().setAttribute("code",code);	
				    		
				    		return "prompt/success";
						}else{
							code = ErrorCode.USER_JOYBEANBALANCE_EDIT_ERROR;	
						}
					}else{
						code = ErrorCode.USER_PHONE_NOT_ENOUGH_ERROR;			
					}
				}			
			}catch (NumberFormatException e) {
				code = ErrorCode.USER_JOYBEAN_FORMAT_ERROR;
			}		
		}
		
		request.getSession().setAttribute("code",code);	
		return "prompt/error";
		
	}
	
	
	
}
