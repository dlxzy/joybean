<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
  
    <title>游戏类型添加</title>
	
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<style type="text/css">
body{
	background-color: white;
}

#add{
	width:360px;
	border: 1px solid black;
	margin: 40px 40px;
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

#gameTypeAddTable{
	border-collapse: collapse;
}

#gameTypeAddTable td{
	text-align:center;
	width: 180px;
	height: 80px;
}

#gtName{
	width:160px;
}

.bt{
	width:120px;
	color:white;
	background-color: #2299EE; 
}
</style>	
  </head> 
  <body>
  	<div id="add">
  		<div id="title">新增游戏类型</div>
		<form action="GameType/addGameType.action" method="post">
			<table id = "gameTypeAddTable">
				<tr>
					<td><div class="lft">类型名称</div></td>
					<td><input type = "text" name="gtName" id="gtName"/></td>  			
				</tr>
				<tr>
					<td><div class="lft">状态</div></td>
					<td>
						<input type = "radio" name="gtState" value="1" checked="checked"/>商用
						<input type = "radio" name="gtState" value="2"/>下线
					</td>
				</tr>  
				<tr>
					<td>
						<input type = "submit" value="添加" class="bt"/>
					</td>
					<td>
						<a href="GameType/queryAllByPage.action" target="contentPage"><input type = "button" value="取消" class="bt"/></a>		
					</td>
				</tr>  	
			</table>   	
		</form>
	</div>
</body>
</html>
