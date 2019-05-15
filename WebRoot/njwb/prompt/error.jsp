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
    
    <title>My JSP 'error.jsp' starting page</title>
    
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
	case "9001":
		alert("登录失败");
		location.href="${path}";
		break;
	case "9002":
		alert("注册失败");
		location.href="User/registerBeforeUser.action";
		break;
	case "9003":
		alert("用户状态(正常)修改失败");
		location.href="User/queryAllByPage.action";
		break;
	case "9004":
		alert("用户状态(暂停使用)修改失败");
		location.href="User/queryAllByPage.action";
		break;
	case "9005":
		alert("话费充值失败");
		location.href="User/queryUserBalanceByUId.action";
		break;
	case "9006":
		alert("乐豆兑换失败");
		location.href="User/queryUserBalanceByUId.action";
		break;
		
	case "9101":
		alert("游戏类型添加失败");
		location.href="njwb/gameType/gameTypeAdd.jsp";
		break;
	case "9102":
		alert("游戏类型修改失败");
		location.href="${path}";
		break;
		
	case "9201":
		alert("乐豆换算比例添加失败");
		location.href="${path}";
		break;
	case "9202":
		alert("乐豆换算比例删除失败");
		location.href="ConvertRatio/queryAllByPage.action";
		break;
	case "9203":
		alert("乐豆换算比例修改失败");
		location.href="${path}";
		break;
	
	case "9301":
		alert("游戏添加失败");
		location.href="${path}";
		break;
	case "9302":
		alert("游戏修改失败");
		location.href="${path}";
		break;
	case "9401":
		alert("游戏购买失败");
		location.href="${path}";
		break;
	case "9402":
		alert("游戏下载失败,该游戏还未购买");
		location.href="${path}";
		break;
		
	case "7001":
		alert("该用户账号不存在");
		location.href="${path}";
		break;
	case "7002":
		alert("用户账号不能为空");
		location.href="${path}";
		break;
	case "7003":
		alert("密码不能为空");
		location.href="${path}";
		break;
	case "7004":
		alert("验证码不能为空");
		location.href="${path}";
		break;
	case "7005":
		alert("密码错误");
		location.href="${path}";
		break;
	case "7006":
		alert("验证码错误");
		location.href="${path}";
		break;
	case "7007":
		alert("手机号码不能为空");
		location.href="${path}";
		break;
	case "7008":
		alert("该用户账号已存在");
		location.href="${path}";
		break;
	case "7009":
		alert("省份不能为空");
		location.href="${path}";
		break;
	case "7010":
		alert("无效操作，当前账号状态就是正常/暂停使用");
		location.href="User/queryAllByPage.action";
		break;
	case "7011":
		alert("手机号码应为11位数字");
		location.href="${path}";
		break;
	case "7012":
		alert("兑换乐豆失败，话费不足");
		location.href="User/queryUserBalanceByUId.action";
		break;
	case "7013":
		alert("充值话费金额不能为空");
		location.href="User/queryUserBalanceByUId.action";
		break;
	case "7014":
		alert("兑换乐豆数量不能为空");
		location.href="User/queryUserBalanceByUId.action";
		break;
	case "7015":
		alert("充值话费金额不能为非数字");
		location.href="User/queryUserBalanceByUId.action";
		break;
	case "7016":
		alert("兑换乐豆数量不能为非数字");
		location.href="User/queryUserBalanceByUId.action";
		break;
	case "7017":
		alert("充值话费金额不能小于0或者等于0");
		location.href="User/queryUserBalanceByUId.action";
		break;
	case "7018":
		alert("兑换乐豆数量不能小于0或者等于0");
		location.href="User/queryUserBalanceByUId.action";
		break;
	
	case "7101":
		alert("游戏类型名称不能为空");
		location.href="${path}";
		break;
	case "7102":
		alert("游戏类型名称不能重复");
		location.href="${path}";
		break;
	case "7103":
		alert("该游戏类型下仍有未下线游戏");
		location.href="${path}";
		break;
		
	case "7201":
		alert("省份名称不能为空");
		location.href="${path}";
		break;
	case "7202":
		alert("该省份已有乐豆换算比例");
		location.href="${path}";
		break;
	case "7203":
		alert("消费金额不能为空");
		location.href="${path}";
		break;
	case "7204":
		alert("消费金额不能为非数字");
		location.href="${path}";
		break;
	case "7205":
		alert("消费金额不能小于等于0");
		location.href="${path}";
		break;
	
	case "7301":
		alert("游戏名称不能为空");
		location.href="${path}";
		break;
	case "7302":
		alert("游戏类别不能为空");
		location.href="${path}";
		break;
	case "7303":
		alert("游戏详情不能为空");
		location.href="${path}";
		break;
	case "7304":
		alert("游戏图片不能为空");
		location.href="${path}";
		break;
	case "7305":
		alert("游戏乐豆价格不能为空");
		location.href="${path}";
		break;
	case "7306":
		alert("游戏话费价格不能为空");
		location.href="${path}";
		break;
	case "7307":
		alert("游戏名称不能重复");
		location.href="${path}";
		break;
	case "7308":
		alert("游戏乐豆价格不能为非数字");
		location.href="${path}";
		break;
	case "7309":
		alert("游戏话费价格不能为非数字");
		location.href="${path}";
		break;
		
	case "7401":
		alert("本账户已购买该游戏");
		location.href="${path}";
		break;
	case "7402":
		alert("该账号乐豆不足");
		location.href="${path}";
		break;
	case "7403":
		alert("该账号话费不足");
		location.href="${path}";
		break;
	case "7404":
		alert("用户未登录，请先登陆");
		top.location.href="njwb/login.jsp";
		break;
		
	}
</script>
  </head>
  <body>
    
  </body>
</html>
