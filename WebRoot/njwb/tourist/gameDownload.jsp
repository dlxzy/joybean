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
    
    <title>游戏添加</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript" src="<%=path %>/js/jquery-1.8.3.min.js"></script>
<style type="text/css">
body{
	background-color: white;
	padding:20px 100px;
}

#details{
	border: 1px solid black;
	width:400px;
	height:400px; 
}

#img{
	border: 1px solid black;
	width:200px;
	height:140px; 
	float:left; 
}

img{
	width:200px;
	height:140px; 
}

#gName{
	border: 1px solid black;
	width:186px;
	height:30px; 
	text-align:center;
}

#price{
	border: 1px solid black;
	width:186px;
	height:30px; 
	text-align:center;
}

#updateTime{
	border: 1px solid black;
	width:186px;
	height:30px; 
	font-size:12px;
	text-align:center;
}

#introduce{
	border: 1px solid black;
	width:393px;
	height:200px; 
}

#download{
	width:99.5%;
	height:40px;
	color:white;
	background-color: #2299EE;
}

</style>	
	
</head>
<body>
	<div id="details">
		<table>
			<tr>
				<td rowspan="4"><div id="img"><img src="${gameWrapper.gPicture}"/></div></td>
			</tr>
			<tr>
				<td><div id="gName">${gameWrapper.gName}</div></td>
			</tr>
			<tr>
				<td><div id="price">乐豆：${gameWrapper.gJoybeanPrice}&nbsp;&nbsp;话费：${gameWrapper.gPhonePrice}</div></td>
			</tr>
			<tr>
				<td><div id="updateTime"> 最后更新：<fmt:formatDate value="${gameWrapper.gUpdateTime}" pattern="yyyy-MM-dd HH:ss:mm"/></div></td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="introduce">
						游戏介绍：${gameWrapper.gDetails}
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="ExpendRecord/downloadGame.action?gId=${gameWrapper.gId}"><input type="button" value="下载" id="download"></a>
				</td>
			</tr>
		</table>
		
		
	</div>
</body>
</html>