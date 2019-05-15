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
    
    <title>消费记录</title>
    
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

#searchDiv{
	position: absolute;
	left:20px;
	margin:10px auto;
}

#expendRecordInfo {
	width:700px;
	margin:100px 20px;
	border-collapse: collapse;
}

#expendRecordInfo tr {
	height: 30px;
	line-height: 30px;
	text-align: center;
}

#expendRecordInfo tr td {
	border: 4px solid #E3E3E3;
}

#titleRow {
	font-size: 16px;
	font-weight: bold;
}

.bgColor{
	background-color:#EDEFF0; 
}

input[type='text']{
	width:120px; 
}

input[type='button'] {
	width:80px;
	color:white;
	background-color: #2299EE;
}

img{
	width:40px;
	height:30px;
}
</style>
     <script type="text/javascript">
     $(function(){
    	$("#search").click(function(){
   	 			var gNamestr = $("#gNamestr").val();
   	 			var erPurchaseWaysstr = $("#erPurchaseWaysstr").find("option:selected").val();
   	 			location.href="ExpendRecord/searchExpendRecord.action?gNamestr="+gNamestr+"&&erPurchaseWaysstr="+erPurchaseWaysstr;
   	 	});
    	
       
        
    });
	</script>

  </head>
  
  <body>
	<div id="title">消费记录</div>
	<div id="searchDiv">
	<span class="bgColor">游戏名称</span>&nbsp;&nbsp;<input type="text" id="gNamestr" name="gNamestr"/>&nbsp;&nbsp;      
	<span class="bgColor">购买方式</span>&nbsp;&nbsp;	
	    <select name="erPurchaseWaysstr" id="erPurchaseWaysstr">
	    	<option>请选择</option>
	    	<option value="1">话费购买</option>
         	<option value="2">乐豆兑换</option>	
				</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="查询" id="search"/><br/>
	</div>

	<table id="expendRecordInfo">
		<tr id="titleRow">
			<td>ID</td>
			<td>游戏名称</td>
			<td>消费金额</td>
			<td>购买方式</td>
			<td>赠送乐豆</td>
			<td>购买时间</td>
		</tr>
		<c:forEach items="${expendRecordWrapperList}" var="expendRecordWrapper">
			<tr>
				<td>${expendRecordWrapper.erId}</td>
				<td>${expendRecordWrapper.game.gName}</td>
				<td>${expendRecordWrapper.erConsumeAmount}</td>
				<td>
				    <c:if test="${expendRecordWrapper.erPurchaseWays==1}">话费购买</c:if>
					<c:if test="${expendRecordWrapper.erPurchaseWays==2}">乐豆兑换</c:if>	
				</td>
				<td>${expendRecordWrapper.erGiftJoybeanAmount}</td>
			   <td>
			       <fmt:formatDate value="${expendRecordWrapper.erPurchaseTime}" pattern="yyyy-MM-dd"/>
			   </td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6">
				<a href="ExpendRecord/queryAllByPage.action">首页</a>&nbsp;
				<a href="ExpendRecord/queryAllByPage.action?pageNostr=${pageNo -1}">上一页</a>&nbsp;
				<a href="ExpendRecord/queryAllByPage.action?pageNostr=${pageNo +1}">下一页</a>&nbsp;
				<a href="ExpendRecord/queryAllByPage.action?pageNostr=${totalPage }">尾页</a>&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				当前第${pageNo }页/共${totalPage }页
			</td>
		</tr>
	</table>
	</body>
</html>
