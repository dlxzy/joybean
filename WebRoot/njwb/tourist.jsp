<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
  
    <title>主界面</title>
    
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/tourist.css">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

<c:if test="${user==null}">
	<script type="text/javascript">
		alert("未登录，请先登录！");
		location.href ="njwb/login.jsp";
	</script>
</c:if>

   <script type="text/javascript">
   	$(function(){  
   		$("li[class='menu'] span").click(function(){
   		  			  //this代表的是span
   		  			  $(this).siblings(".hide").slideToggle();  		  		
   		  });  
   		
   		
   		  $(".exit").click(function(){
   			  var result = confirm("确认要退出系统吗?");
   			  if(result==true){
   				  location.href="User/exit.action";
   			  }
   		  });
 		  
   	});
   
   	setInterval("document.getElementById('dateDiv').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
   </script> 
  </head>
  
  <body>
  	<div id = "mainDiv">
	  	<div id = "header">
	  		<div id = "userDiv" class="lft">	  
	    	    ${user.uName}   	    
	    	</div>
	    	<div id = "logoDiv" class="lft">
	    		用户，欢迎使用乐豆后台管理系统！
	    	</div>
	    	<div id = "dateDiv" class="lft">
	    		
	    	</div>
	    	<div id = "exitDiv" class="rft">	  
	    	    <a href="javascript:;" class="exit"><span>退出</span></a>	    	    
	    	</div>
	    </div> 
	    <div id = "contentDiv">
	    	<div id = "content-left" class="lft">
	    		<ul>    		
	    			<li class="menu">	    				
	    				<a href="GameType/queryAllByGtState.action" id="gameCenter"  target="contentPage">游戏中心</a>	    				 
	    			</li>
	    			<li class="menu">
	    				<span>个人中心</span>
	    				<ul class="hide">	    					
	    					<li class="menu-sub"><a href="ExpendRecord/queryAllByPage.action" id="expendRecordManager" target="contentPage">消费记录查询</a></li>	    					    					
	    					<li class="menu-sub"><a href="User/queryUserBalanceByUId.action" id="balanceManager" target="contentPage">余额查询</a></li>    					
	    				</ul>	    				
	    			</li>			    
	    		</ul>	
	    	</div>	    	
	    	<div id = "content-right" class="lft">
	    		<iframe src="" name="contentPage" scrolling="yes" frameborder="0" width="788px" height="470px">
	    		</iframe>
	    	</div>
	    </div>	    
	    <div id = "footer">
	    	
	    </div>
  	
  	</div>
   
  </body>
</html>
