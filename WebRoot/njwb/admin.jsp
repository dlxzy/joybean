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
    <link rel="stylesheet" type="text/css" href="css/admin.css">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

<c:if test="${user==null}">
	<script type="text/javascript">
		alert("未登录，请先登录！");
		location.href ="njwb/login.jsp";
	</script>
</c:if>

   <script type="text/javascript">
   	$(function(){  		  
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
	    		管理员，欢迎使用乐豆后台管理系统！
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
	    				<div>
	    					<a href="User/queryAllByPage.action" id="userManager"  target="contentPage">用户管理</a>
	    				</div> 
	    			</li>
	    			<li class="menu">
	    				<div>
	    					<a href="GameType/queryAllByPage.action"  id="gameTypeManager"  target="contentPage">游戏类型</a>
	    				</div> 	    				
	    			</li>	
	    		    <li class="menu">
	    		    	<div>
	    		    		<a href="Game/queryAllByPage.action" id="gameManager"  target="contentPage">游戏列表</a>
	    		    	</div> 	    		    	
	    		    </li>
	    			<li class="menu"> 
	    				<div>
	    					<a href="ConvertRatio/queryAllByPage.action"  id="convertRatioManager"  target="contentPage">乐豆换算比例</a>
	    				</div>	    				
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
