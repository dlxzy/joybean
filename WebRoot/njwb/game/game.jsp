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

#auDiv{
	position: absolute;
	top:90px;
	left:20px;
	margin:10px auto;
}

#gameInfo {
	width:700px;
	margin:100px 20px;
	border-collapse: collapse;
}

#gameInfo tr {
	height: 30px;
	line-height: 30px;
	text-align: center;
}

#gameInfo tr td {
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
   	 			var gtNamestr = $("#gtNamestr").find("option:selected").text();
   	 			location.href="Game/searchGame.action?gNamestr="+gNamestr+"&&gtNamestr="+gtNamestr;
   	 	});
    	
        $("#add").click(function(){
    		location.href="Game/addBeforeGame.action";
    	});
         
        $("#update").click(function(){
        	var gId=$("input:checked").val();
        	if(gId==null){
        		alert("请选择要修改的数据");
        	}else{
    			location.href="Game/editBeforeGame.action?gId="+gId;
        	}	
    	});
        
    });
	</script>

  </head>
  
  <body>
	<div id="title">游戏列表</div>
	<div id="searchDiv">
	<span class="bgColor">游戏名称</span>&nbsp;&nbsp;<input type="text" id="gNamestr" name="gNamestr"/>&nbsp;&nbsp;      
	<span class="bgColor">游戏类别</span>&nbsp;&nbsp;	
	    <select name="gtNamestr" id="gtNamestr">
	    	<option></option>
			<c:forEach items="${gameTypeList}" var="gameType">
				<option>${gameType.gtName}</option>
			</c:forEach>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="查询" id="search"/><br/>
	</div>
	
	<div id="auDiv">
         <input type="button" value="新增" id="add"/>&nbsp;&nbsp;
         <input type="button" value="修改" id="update"/>	 
    </div>

	<table id="gameInfo">
		<tr id="titleRow">
			<td></td>
			<td>ID</td>
			<td>游戏名称</td>
			<td>游戏类别</td>
			<td>游戏图片</td>
			<td>状态</td>
			<td>乐豆价格</td>
			<td>话费价格</td>
			<td>创建时间</td>
			<td>更新时间</td>
		</tr>
		<c:forEach items="${gameWrapperList}" var="game">
			<tr>
				<td><input type="radio" name="list" value="${game.gId}"/></td>
				<td>${game.gId}</td>
				<td><a href="Game/queryGameByGName.action?gName=${game.gName}">${game.gName}</a></td>
				<td>${game.gameType.gtName}</td>
				<td><img src="${game.gPicture}"/></td>
				<td>
				    <c:if test="${game.gState==1}">商用</c:if>
					<c:if test="${game.gState==2}">下线</c:if>
				
				</td>
				<td>
					<c:choose>
						<c:when test="${game.gJoybeanPrice==0}">免费</c:when>
						<c:when test="${game.gJoybeanPrice!=0}">${game.gJoybeanPrice}</c:when>						
					</c:choose>
					
					
				</td>
				<td>
					<c:choose>
						<c:when test="${game.gPhonePrice==0}">免费</c:when>
						<c:when test="${game.gPhonePrice!=0}">${game.gPhonePrice}</c:when>	
					</c:choose>
										
				</td>
			   <td>
			       <fmt:formatDate value="${game.gCreateTime}" pattern="yyyy-MM-dd"/>
			   </td>
			   <td>
			       <fmt:formatDate value="${game.gUpdateTime}" pattern="yyyy-MM-dd"/>
			   </td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10">
				<a href="Game/queryAllByPage.action">首页</a>&nbsp;
				<a href="Game/queryAllByPage.action?pageNostr=${pageNo -1}">上一页</a>&nbsp;
				<a href="Game/queryAllByPage.action?pageNostr=${pageNo +1}">下一页</a>&nbsp;
				<a href="Game/queryAllByPage.action?pageNostr=${totalPage }">尾页</a>&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				当前第${pageNo }页/共${totalPage }页
			</td>
		</tr>
	</table>
	</body>
</html>
