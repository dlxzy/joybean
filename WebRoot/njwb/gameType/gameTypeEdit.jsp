<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
  
    <title>游戏类型修改</title>
	
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<style type="text/css">
body{
	background-color: white;
}

#edit{
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

#gameTypeEditTable{
	border-collapse: collapse;
}

#gameTypeEditTable td{
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
	<script type="text/javascript">
	$(function(){
		if("${gameType.gtState}"== 1){
			$("input[name=gtState]:eq(0)").attr("checked",'checked');
		}else{
			$("input[name=gtState]:eq(1)").attr("checked",'checked');
		}
	});
	
	</script>
  </head> 
  <body>
  	<div id="edit">
  		<div id="title">修改游戏类型</div>
		<form action="GameType/editGameType.action" method="post">
			<table id = "gameTypeEditTable">
				<tr>
					<td colspan="2"><input type="text" name="gtId" id="gtId" readonly="readonly" style="color:grey" value="${gameType.gtId }"/></td>
				</tr>
				<tr>
					<td><div class="lft">类型名称</div></td>
					<td><input type ="text" name="gtName" id="gtName" value="${gameType.gtName }"/></td>  			
				</tr>
				<tr>
					<td><div class="lft">状态</div></td>
					<td>
						<input type = "radio" name="gtState" value="1">商用
						<input type = "radio" name="gtState" value="2">下线
					</td>
				</tr>  
				<tr>
					<td>
						<input type = "submit" value="修改" class="bt"/>
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
