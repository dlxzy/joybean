<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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


   <script type="text/javascript">
   		setInterval("document.getElementById('dateDiv').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
   
   </script> 
  </head>
  
  <body>
  	<div id = "mainDiv">
	  	<div id = "header">
	  		<div id = "logoDiv" class="lft">
	    		乐豆系统欢迎您！
	    	</div>
	  		<div id = "userDiv" class="lft">	  
	    	    请<a href="njwb/login.jsp">登陆</a>或<a href="User/registerBeforeUser.action">注册</a>！   	    
	    	</div>    	
	    	<div id = "dateDiv" class="lft">
	    		
	    	</div>
	    </div> 
	    <div id = "contentDiv">
	    	<div id = "content-left" class="lft">
	    		<ul>    		
	    			<li class="menu">
	    				<div>
	    					<a href="GameType/queryAllByGtState.action" id="gameCenter"  target="contentPage">游戏中心</a>
	    				</div> 
	    			</li>
	    			<li class="menu">
	    				<div>
	    					<a id="personalCenter"  target="contentPage">个人中心</a>
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
