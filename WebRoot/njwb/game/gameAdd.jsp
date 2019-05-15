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

#add{
	width:500px;
	border: 1px solid black;
	margin: 20px 20px;
}

#title{
	border: 1px solid black;
	text-align: center;
	font-size: 18px;
	font-weight: normal;
	line-height: 40px;
	height:40px;
	margin:20px 10px;
}

.lft{
	background-color: #EDEFF0; 
	margin:0px 10px;
}

#gameAddTable{
	border-collapse: collapse;
}

#gameAddTable td{
	text-align:center;
	width: 180px;
	height:30px;
}

.gameInput{
	width:180px;
}

.bt{
	width:120px;
	color:white;
	background-color: #2299EE; 
}
</style>	
	<script type="text/javascript">
	$(function(){
		
		$("#gPicture").change(function(){
			var picPath='img/'+$("#gPicture").val();
			$("#pic").attr("src",picPath);
			$("#pic").css("width","160px");
			$("#pic").css("height","80px"); 
		});

	})
	</script>

</head>
<body>
	<div id="add">
		<div id="title">新增游戏</div>
		<form action="Game/addGame.action" method="post">
		<table id = "gameAddTable">
			<tr>
				<td><div class="lft">游戏名称</div></td>
				<td>
					<input type="text" name="gName" id="gName" class="gameInput"/>
				</td>
			</tr>
			<tr>
				<td><div class="lft">游戏状态</div></td>
				<td>
					<input type="radio" name="gState" value="1" checked="checked"/>商用
					<input type="radio" name="gState" value="2" />下线
				</td>
			</tr>
			<tr>
				<td ><div class="lft">游戏类别</div></td>
				<td>
					<select id="gtName" name="gtName" class="gameInput">
						<c:forEach items="${gameTypeList}" var="gameType">
							<option>${gameType.gtName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td><div class="lft">游戏详情</div></td>
				<td>
					<textarea name="gDetails" id="gDetails" class="gameInput"></textarea>
				</td>
			</tr>
			<tr>
				<td><div class="lft">乐豆价格</div></td>
				<td>
					<input type="text" name="gJoybeanPricestr" id="gJoybeanPricestr" class="gameInput"/>
				</td>
			</tr>
			<tr>
				<td><div class="lft">话费价格</div></td>
				<td>
					<input type="text" name="gPhonePricestr" id="gPhonePricestr" class="gameInput"/>
				</td>
			</tr>
			<tr>
				<td><div class="lft">游戏图片</div></td>
				<td>
					<img name="pic" id="pic"/>
				</td>
				<td><input type="file" name="gPicturestr" id="gPicture" class="gameInput"/></td>
		
			</tr>
	
			<tr>
				<td >
					<input type = "submit" value="添加" class="bt"/>
				</td>
				<td>
					<a href="Game/queryAllByPage.action" target="contentPage"><input type = "button" value="取消" class="bt"/></a>
				</td>
				<td></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>