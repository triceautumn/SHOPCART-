<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    	<link rel='stylesheet' type='text/css' href='css/mycss.css'/>
  </head>
  
  <body>
   <center>
   <h1>登录界面</h1>
   <form action='/shopCart/GoHallUI' method="post">
   		<table border='1' style='border-collapse:collapse;width=700px;'>
   			<tr>
   				<th>用户名：</th><th><input type='text' id='username' name='username'/></th>
   			</tr>
   			<tr>
   				<th>密码：</th><th><input type="password" id="password" name="password"/></th>
   			</tr>
   			<tr>
   			    <th><input type='submit' value='提交'></th><th><input type='reset' value='重置'></th>
   			</tr>
   		</table>
   </form>
   </center>
  </body>
</html>
