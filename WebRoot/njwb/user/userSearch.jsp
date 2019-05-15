<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
  
    <title>用户管理</title>
    
   	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    
    <!-- <link rel="stylesheet" type="text/css" href="css/gameType.css"> -->
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<style type="text/css">
body{
	background-color:white; 
}

#title {
	border: 1px solid black;
	width:120px;
	margin:10px 20px;
	text-align: center;
	font-size: 18px;
	font-weight: normal;
	line-height: 30px;
	height: 30px;
}

#userInfo {
	width:500px;
	margin:60px 20px;
	border-collapse: collapse;
}

#userInfo tr {
	height: 30px;
	line-height: 30px;
	text-align: center;
}

#userInfo tr td {
	border: 4px solid #E3E3E3;
}

#titleRow {
	font-size: 16px;
	font-weight: bold;
}

</style>

  </head>

  <body>
         	<div id="title">用户管理</div>
         	         	
         	<table id="userInfo">
         		<tr id="titleRow">
         			<td></td>
         			<td>ID</td>
         			<td>用户账号</td>
         			<td>姓名</td>
         			<td>手机号码</td>
         			<td>省份</td>
         			<td>状态</td>
         			<td>创建时间</td>
         		</tr>
         		<c:forEach items="${userWrapperList}" var="userWrapper">
         			<tr>
         				<td><input type="radio" name="list" value="${userWrapper.uId}"/></td>
         				<td>${userWrapper.uId}</td>
         				<td>${userWrapper.uAccount}</td>
         				<td>${userWrapper.uName}</td>
         				<td>${userWrapper.uPhoneNumber}</td>
         				<td>${userWrapper.province.pDistrictName}</td>
         				<td>
         					<c:if test="${userWrapper.uState==1}">正常</c:if>
         					<c:if test="${userWrapper.uState==2}">暂停使用</c:if>
         				</td>
         				<td>
         					<fmt:formatDate value="${userWrapper.uCreateTime}" pattern="yyyy-MM-dd"/> 
         				</td>
         				
         			</tr>
         		</c:forEach>
				<tr>
					<td colspan="8">
						<a href="User/searchUser.action?uAccountstr=${uAccountstr}&&uNamestr=${uNamestr}&&uPhoneNumberstr=${uPhoneNumberstr}">首页</a>&nbsp;
						<a href="User/searchUser.action?pageNostr=${pageNo -1}&&uAccountstr=${uAccountstr}&&uNamestr=${uNamestr}&&uPhoneNumberstr=${uPhoneNumberstr}">上一页</a>&nbsp;
						<a href="User/searchUser.action?pageNostr=${pageNo +1}&&uAccountstr=${uAccountstr}&&uNamestr=${uNamestr}&&uPhoneNumberstr=${uPhoneNumberstr}">下一页</a>&nbsp;
						<a href="User/searchUser.action?pageNostr=${totalPage }&&uAccountstr=${uAccountstr}&&uNamestr=${uNamestr}&&uPhoneNumberstr=${uPhoneNumberstr}">尾页</a>&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						当前第${pageNo }页/共${totalPage }页
					</td>
				</tr>
				<tr>
					<td colspan="8"><a href="User/queryAllByPage.action" target="contentPage"><input type = "button" value="返回" class="bt"/></a></td>
				</tr>    		         	
         </table>
  </body>
</html>
