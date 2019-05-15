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
}

img{
	width:170px;
	height:100px; 
}

.details{
	border:1px solid black; 
	width:180px;
	float:left;
	margin:10px 10px; 
	text-align:center; 
}


</style>	
	
</head>
<body>
	<c:forEach items="${gameWrapperList}" var="gameWrapper">
		<div class="details">
		<table>
			<tr>
				<td colspan="2"><img src="${gameWrapper.gPicture}"/></td>
			</tr>
			<tr>
				<td colspan="2"><a href="Game/downloadBeforeGame.action?gName=${gameWrapper.gName}" target="contentPage">${gameWrapper.gName}</a></td>
			</tr>
			<tr>
				<td>
					<c:choose>
						<c:when test="${gameWrapper.gJoybeanPrice==0}">免费</c:when>
						<c:when test="${gameWrapper.gJoybeanPrice!=0}">乐豆：${gameWrapper.gJoybeanPrice}个</c:when>	
					</c:choose>	
				</td>
				<td>
					<c:choose>
						<c:when test="${gameWrapper.gPhonePrice==0}">免费</c:when>
						<c:when test="${gameWrapper.gPhonePrice!=0}">话费：${gameWrapper.gPhonePrice}元</c:when>			
					</c:choose>									
				</td>
			</tr>			
			<tr>
				<td>
					<a href="ExpendRecord/addExpendRecord.action?erGId=${gameWrapper.gId}&&erPurchaseWays=2" >
					乐豆兑换
					</a>
				</td>
				<td>
					<a href="ExpendRecord/addExpendRecord.action?erGId=${gameWrapper.gId}&&erPurchaseWays=1" >
					话费购买
					</a>
				</td>
			</tr>		
		</table>	
	</div>
	</c:forEach>
</body>
</html>