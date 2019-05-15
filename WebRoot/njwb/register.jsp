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
	
		<title>用户注册</title>
		
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/reset.css">
		<link rel="stylesheet" type="text/css" href="css/register.css">
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
		$(function(){
			$("form").submit(function(){
				var uPassword = $("#uPassword").val();
				var newUPassword = $("#newUPassword").val();
				if(uPassword!=newUPassword){
					alert("密码与再次确认密码不一定,请重新填写");
					return false;
				}else{
					return true;
				}
    		});
			
			
		});
	</script>	
	</head>
	<body>
		<div id="register">
			<div id="title">用&nbsp;户&nbsp;注&nbsp;册</div>
			<form action="User/registerUser.action">
				<table id="registerTable">
					<tr>
						<td>
							<div class="left">用户账号</div>			
						</td>
						<td>
							<input type="text" name="uAccount" id="uAccount"/>
						</td>
					</tr>
					<tr>
						<td><div class="left">密码</div></td>
						<td>
							<input type="text" name="uPassword" id="uPassword"/>
						</td>
					</tr>
					<tr>
						<td><div class="left">再次确认密码</div></td>
						<td>
							<input type="text" name="newUPassword" id="newUPassword"/>
						</td>
					</tr>
					<tr>
						<td><div class="left">姓名</div></td>
						<td>
							<input type="text" name="uName" id="uName"/>
						</td>
					</tr>
					<tr>
						<td><div class="left">手机号码</div></td>
						<td>
							<input type="text" name="uPhoneNumber" id="uPhoneNumber"/>
						</td>
					</tr>
					<tr>
						<td><div class="left">省份</div></td>
						<td>
							<select name="pDistrictName" id="pDistrictName">
         					<option></option>
         					<c:forEach items="${provinceList}" var="province">
         					<option>${province.pDistrictName}</option>
         					</c:forEach>	
         					</select> 
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="提&nbsp;交" class="btn"  id="submit"/>
						</td>
						<td>
							<a href="njwb/login.jsp"><input type="button" value="取&nbsp;消" class="btn"  id="cancel"/></a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
