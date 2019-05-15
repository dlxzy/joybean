<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>游戏</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<style type="text/css">
body{
	background-color:white; 
}

input[type='button'] {
	width:80px;
	margin-right:10px;
	color:black;
	background-color: #EDEFF0;
}

#gamePage{
	width:760px;
	height:410px;
}

</style>
     <script type="text/javascript">
   
	</script>

  </head>
  
  <body>
		<c:forEach items="${gameTypeList}" var="gameType">
			<a target="gamePage" href="Game/queryAllByGtName.action?gtName=${gameType.gtName}">
				<input type="button" value="${gameType.gtName}"/>
			</a>
		</c:forEach>
		
		<div>
			<iframe src="" name="gamePage" scrolling="yes" frameborder="0" id="gamePage" ></iframe>
		</div>
  </body>
</html>
