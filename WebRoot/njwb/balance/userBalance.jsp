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
  
    <title>余额查询</title>
    
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

#userBalance{
	position:absolute;
	top:50px;
	left:50px; 
}

#userBalance td{
	margin-right:10px; 
}

.balance{
	width:100px;
	
}

.bgColor{
	background-color:#EDEFF0; 
}

#tip{
	font-size:10px;
	color:red; 
}
</style>
	<script type="text/javascript">
		$(function(){
	
			$("#addPhoneBalance").click(function(){
				var uPhone = $("#uPhone").val();
    			location.href="User/editPhoneBalance.action?uPhonestr="+uPhone;
    		});
			
			$("#addJoyBeanBalance").click(function(){
				var uJoyBean = $("#uJoyBean").val();
    			location.href="User/editJoyBeanBalance.action?uJoyBeanstr="+uJoyBean;
    		});
		});
	</script>

  </head>

  <body>
       <table id="userBalance">
			<tr>
				<td><span class="bgColor">话费余额</span></td>
				<td><input type="text" name="uPhoneBalancestr" class="balance" value="${user.uPhoneBalance}" readonly="readonly" style="color:grey"/></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td><input type="button" value="充值" id="addPhoneBalance"/></td>
				<td><input type="text" name="uPhone" class="balance" id="uPhone"/></td>
			</tr>
			<tr>
				<td><span class="bgColor">乐豆余额</span></td>
				<td><input type="text" name="uJoyBeanBalancestr" class="balance" value="${user.uJoyBeanBalance}" readonly="readonly" style="color:grey"/></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td><input type="button" value="兑换" id="addJoyBeanBalance"/></td>
				<td><input type="text" name="uJoyBean" class="balance" id="uJoyBean" /><span id="tip">1元可兑换2个乐豆</span></td>
			</tr>
       </table>  	
         	
         	     
			
  </body>
</html>
