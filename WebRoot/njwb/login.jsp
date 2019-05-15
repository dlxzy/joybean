<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
	
		<title>用户登录</title>
		
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/reset.css">
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	
	<script type="text/javascript">
		function changeImg(){
			//设置img的src的属性,请求地址加时间戳，让请求地址每次都不一样。
			$("#codeImg").attr("src","User/getCodeImg.action?date="+new Date());
		}
		
		
		//保证页面加载完成
		$(function(){
			
			$("#uAccount").blur(function(){
				var uAccount = $("#uAccount").val();
				var uAccountInfo = $("#uAccountInfo");
				
				if(uAccount==""){
					uAccountInfo.html("用户名不能为空");
					uAccountInfo.css("font-size","10px");
					uAccountInfo.css("color","red");
				}else{
					uAccountInfo.html("");
				}
			});
			
			$("#uPassword").blur(function(){
				var uPassword = $("#uPassword").val();
				var uPasswordInfo = $("#uPasswordInfo");
				
				if(uPassword==""){
					uPasswordInfo.html("密码不能为空");
					uPasswordInfo.css("font-size","10px");
					uPasswordInfo.css("color","red");
				}else{
					uPasswordInfo.html("");
				}
				
			});
			
			
			$("#loginCode").blur(function(){
				var loginCode = $("#loginCode").val();
				var loginCodeInfo = $("#loginCodeInfo");
				
				if(loginCode==""){
					loginCodeInfo.html("验证码不能为空");
					loginCodeInfo.css("font-size","10px");
					loginCodeInfo.css("color","red");
				}else{
					loginCodeInfo.html("");
				}
				
			});
			
			$(".txt").blur(function(){
				var uAccount = $("#uAccount").val();
				var uPassword = $("#uPassword").val();
				var loginCode = $("#loginCode").val();
				var uAccountInfo = $("#uAccountInfo");
				var uPasswordInfo = $("#uPasswordInfo");
				var loginCodeInfo = $("#loginCodeInfo");
	
				if(uAccount!=""&&uPassword!=""&&loginCode!=""){
					$("#submit").click(function(){	
						
						var uRole = $("input[name='uRole']:checked").val();
						
						$.ajax({
						type:"POST",
						url:"User/login.action",
						data:"uAccount="+uAccount+"&&uPassword="+uPassword+"&&loginCode="+loginCode+"&&uRole="+uRole,
						dataType:"text",
						success:function(str){
							switch(str){
								case "0" : alert("登录（管理员）成功");
								location.href="njwb/admin.jsp";
								break;	
								case "1" : alert("登录（普通用户）成功");
								location.href="njwb/tourist.jsp";
								break;						
								case "2" : alert("验证码错误");
								location.href="njwb/login.jsp";
								break;
								case "3" : alert("密码错误");
								location.href="njwb/login.jsp";
								break;
								case "4" : alert("角色错误");
								location.href="njwb/login.jsp";
								break;
								case "5" : alert("该用户不存在");
								location.href="njwb/login.jsp";
								break;
								case "6" : alert("抱歉，该账号已被暂停使用，请与管理员联系");
								location.href="njwb/login.jsp";
								break;
								
							}
						}														
					});
				});			
			   }			
			});														
		});
		
		
	</script>
	
	</head>
	<body>
		<div id="login">
			<div id="title">
				用&nbsp;户&nbsp;登&nbsp;陆
			</div>
			
				<table id="loginTable">
					<tr>
						<td>
							<div class="left">
								用户账号
							</div>			
						</td>
						<td>
							<input type="text" name="uAccount" id="uAccount" class="txt"/>
						</td>
						<td><span id="uAccountInfo"></span></td>
					</tr>
					<tr>
						<td>
							<div class="left">密码</div>
						</td>
						<td>
							<input type="password" name="uPassword" id="uPassword" class="txt"/>
						</td>
						<td><span id="uPasswordInfo"></span></td>
					</tr>
					<tr>
						<td>
							<div class="left">验证码</div>
						</td>
						<td>
							<div id="txt">
								<input type="text" name="loginCode" id="loginCode" class="txt" style="width:80px;height:40px;"/>
							</div>			
							<div id="img">
								<img id="codeImg" onclick="changeImg()" title="看不清楚，换一张" style="width:90px;height:40px;" src="User/getCodeImg.action">
							</div>	
						</td>
						<td><span id="loginCodeInfo"></span></td>
					</tr>
					<tr>
						<td colspan="2">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="uRole" value="1" />管理员
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="uRole" value="2" checked="checked"/>普通用户
						</td>
					</tr>
					<tr>
						<td>
							<input type="button" value="登&nbsp;录" class="btn"  id="submit"/>
						</td>
						<td>
							<a href="User/registerBeforeUser.action"><input type="button" value="注&nbsp;册" class="btn"  id="register"/></a>
						</td>
					</tr>
				</table>

		</div>
	</body>
</html>
