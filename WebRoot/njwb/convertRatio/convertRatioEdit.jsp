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
  
    <title>乐豆换算比例添加</title>
	
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

#tip{
	width:340px;
	text-align: center;
	background-color: #EDEFF0; 
	margin-left:10px; 
}

.lft{
	background-color: #EDEFF0; 
	margin:0px 10px;
}

#convertRatioAddTable{
	border-collapse: collapse;
}

#convertRatioAddTable td{
	text-align:center;
	width: 180px;
	height: 60px;
}

#crConsumeAmountstr{
	width:120px;
}

.bt{
	width:120px;
	color:white;
	background-color: #2299EE; 
}
</style>
	<script type="text/javascript">
	$(function(){
		$("#pDistrictName").attr("disabled","disabled").css("background-color","#EEEEEE;");
	});
	</script>	
  </head> 
  <body>
  	<div id="add">
  		<div id="title">修改乐豆比例</div>
		<form action="ConvertRatio/editConvertRatio.action?crId=${convertRatio.crId}" method="post">
			<table id = "convertRatioAddTable">
				<tr>
					<td><div class="lft">省份</div></td>
					<td>
						<select name="pDistrictName" id="pDistrictName">
         					<option></option>
         					<c:forEach items="${provinceList}" var="province">
         					<option value="${province.pDistrictName}" <c:if test="${province.pDistrictName eq pDistrictName}">selected</c:if>>${province.pDistrictName}</option>
         					</c:forEach>	
         				</select> 
					</td>  			
				</tr>
				<tr>
					<td colspan="2">
						<div id="tip">请输入赠送一个乐豆需要消费的话费：</div>
					</td>
				</tr>
				<tr>
					<td><div class="lft">消费金额</div></td>
					<td>
						<input type="text" name="crConsumeAmountstr" id="crConsumeAmountstr" value="${convertRatio.crConsumeAmount}">					
					</td>
				</tr>  
				<tr>
					<td>
						<input type = "submit" value="添加" class="bt"/>
					</td>
					<td>
						<a href="ConvertRatio/queryAllByPage.action" target="contentPage"><input type = "button" value="取消" class="bt"/></a>		
					</td>
				</tr>  	
			</table>   	
		</form>
	</div>
</body>
</html>
