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
  
    <title>游戏类型</title>
    
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
	width:100px;
	margin:10px 20px;
	text-align: center;
	font-size: 18px;
	font-weight: normal;
	line-height: 30px;
	height: 30px;
}

#gameTypeInfo {
	width:500px;
	margin:60px 20px;
	border-collapse: collapse;
}

#gameTypeInfo tr {
	height: 30px;
	line-height: 30px;
	text-align: center;
}

#gameTypeInfo tr td {
	border: 4px solid #E3E3E3;
}

#titleRow {
	font-size: 16px;
	font-weight: bold;
}

</style>


  </head>

  <body>
         	<div id="title">游戏类型</div>
     
         	<table id="gameTypeInfo">
         		<tr id="titleRow">
         			<td></td>
         			<td>ID</td>
         			<td>类型名称</td>
         			<td>状态</td>
         			<td>创建时间</td>
         			<td>更新时间</td>
         		</tr>
         		<c:forEach items="${gameTypeList}" var="gameType">
         			<tr>
         				<td><input type="radio" name="list" value="${gameType.gtId}"/></td>
         				<td>${gameType.gtId}</td>
         				<td>${gameType.gtName}</td>
         				<td>
         					<c:if test="${gameType.gtState==1}">商用</c:if>
         					<c:if test="${gameType.gtState==2}">下线</c:if>
         				</td>
         				<td>
         					<fmt:formatDate value="${gameType.gtCreateTime}" pattern="yyyy-MM-dd"/> 
         				</td>
         				<td>
         					<fmt:formatDate value="${gameType.gtUpdateTime}" pattern="yyyy-MM-dd"/>	
         				</td>
         			</tr>
         		</c:forEach>
				<tr>
					<td colspan="6">
						<a href="GameType/searchGameType.action?gtName=${gtName}&&gtState=${gtState}">首页</a>&nbsp;
						<a href="GameType/searchGameType.action?pageNo=${pageNo -1}&&gtName=${gtName}&&gtState=${gtState}">上一页</a>&nbsp;
						<a href="GameType/searchGameType.action?pageNo=${pageNo +1}&&gtName=${gtName}&&gtState=${gtState}">下一页</a>&nbsp;
						<a href="GameType/searchGameType.action?pageNo=${totalPage }&&gtName=${gtName}&&gtState=${gtState}">尾页</a>&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						当前第${pageNo }页/共${totalPage }页
					</td>
				</tr>
				<tr>
					<td colspan="6"><a href="GameType/queryAllByPage.action" target="contentPage"><input type = "button" value="返回" class="bt"/></a></td>
				</tr>    		         	
         </table>
  </body>
</html>
