<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	var result = "${code}"
	switch(result){
	case "0001":
		alert("登录成功");
		location.href="${path}";
		break;
	case "0002":
		alert("注册成功");
		location.href="njwb/login.jsp";
		break;
	case "0003":
		alert("用户状态(恢复使用)修改成功");
		location.href="User/queryAllByPage.action";
		break;
	case "0004":
		alert("用户状态(暂停使用)修改成功");
		location.href="User/queryAllByPage.action";
		break;
	case "0005":
		alert("话费充值成功");
		location.href="User/queryUserBalanceByUId.action";
		break;
	case "0006":
		alert("乐豆兑换成功");
		location.href="User/queryUserBalanceByUId.action";
		break;
		
	case "0101":
		alert("游戏类型添加成功");
		location.href="GameType/queryAllByPage.action";
		break;
	case "0102":
		alert("游戏类型修改成功");
		location.href="GameType/queryAllByPage.action";
		break;
		
	case "0201":
		alert("乐豆换算比例添加成功");
		location.href="ConvertRatio/queryAllByPage.action";
		break;
	case "0202":
		alert("乐豆换算比例删除成功");
		location.href="ConvertRatio/queryAllByPage.action";
		break;
	case "0203":
		alert("乐豆换算比例修改成功");
		location.href="ConvertRatio/queryAllByPage.action";
		break;
	
	case "0301":
		alert("游戏添加成功");
		location.href="Game/queryAllByPage.action";
		break;
	case "0302":
		alert("游戏修改成功");
		location.href="Game/queryAllByPage.action";
		break;
		
	case "0401":
		alert("游戏购买成功");
		location.href="${path}";
		break;
	case "0402":
		alert("游戏已购买，下载成功");
		location.href="${path}";
		break;
	}

</script>
  </head>
  <body>
    
  </body>
</html>
