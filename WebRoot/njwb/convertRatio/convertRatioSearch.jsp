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
  
    <title>乐豆换算比例</title>
    
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

#convertRatioInfo {
	width:500px;
	margin:60px 20px;
	border-collapse: collapse;
}

#convertRatioInfo tr {
	height: 30px;
	line-height: 30px;
	text-align: center;
}

#convertRatioInfo tr td {
	border: 4px solid #E3E3E3;
}

#titleRow {
	font-size: 16px;
	font-weight: bold;
}

</style>

  </head>

  <body>
         	<div id="title">乐豆换算比例</div>

         	<table id="convertRatioInfo">
         		<tr id="titleRow">
         			<td></td>
         			<td>ID</td>
         			<td>省份</td>
         			<td>消费金额</td>
         			<td>创建时间</td>
         			<td>更新时间</td>
         		</tr>
         		<c:forEach items="${convertRatioWrapperList}" var="convertRatioWrapper">
         			<tr>
         				<td><input type="radio" name="list" value="${convertRatioWrapper.crId}"/></td>
         				<td>${convertRatioWrapper.crId}</td>
         				<td>${convertRatioWrapper.province.pDistrictName}</td>
         				<td>${convertRatioWrapper.crConsumeAmount}</td>
         				<td>
         					<fmt:formatDate value="${convertRatioWrapper.crCreateTime}" pattern="yyyy-MM-dd"/> 
         				</td>
         				<td>
         					<fmt:formatDate value="${convertRatioWrapper.crUpdateTime}" pattern="yyyy-MM-dd"/>	
         				</td>
         			</tr>
         		</c:forEach>
				<tr>
					<td colspan="6">
						<a href="ConvertRatio/searchConvertRatio.action?pDistrictNamestr=${pDistrictNamestr}">首页</a>&nbsp;
						<a href="ConvertRatio/searchConvertRatio.action?pageNostr=${pageNo -1}&&pDistrictNamestr=${pDistrictNamestr}">上一页</a>&nbsp;
						<a href="ConvertRatio/searchConvertRatio.action?pageNostr=${pageNo +1}&&pDistrictNamestr=${pDistrictNamestr}">下一页</a>&nbsp;
						<a href="ConvertRatio/searchConvertRatio.action?pageNostr=${totalPage }&&pDistrictNamestr=${pDistrictNamestr}">尾页</a>&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						当前第${pageNo }页/共${totalPage }页
					</td>
				</tr>
				<tr>
					<td colspan="6"><a href="ConvertRatio/queryAllByPage.action" target="contentPage"><input type = "button" value="返回" class="bt"/></a></td>
				</tr>     		         	
         </table>
  </body>
</html>
