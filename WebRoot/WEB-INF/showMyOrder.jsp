<%@ page language="java" import="java.util.*,com.myh.bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showMyOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function goSubmitOrder()
		{
			window.location.href='/shopCart/SubmitOrderServlet';
		}
	</script>
  </head>
  
  <body>
  <h3>我的订单</h3>
  <h4>我的个人信息</h4>
  <table border='1' style='border-collapse:collapse;width=300px;'>
  	<tr>
  		<th colspan='2'>用户个人信息</th>
  	</tr>
  	<tr>
  		<td>用户名</td><td><%=((Users)session.getAttribute("user")).getName() %></td>
  	</tr>
  	<tr>
  		<td>电子邮件</td><td><%=((Users)session.getAttribute("user")).getEmail() %></td>
  	</tr>
  	<tr>
  		<td>用户级别</td><td><%=((Users)session.getAttribute("user")).getGrade() %></td>
  	</tr>
  	<tr>
  		<td>电话</td><td><%=((Users)session.getAttribute("user")).getTel()%></td>
  	</tr>
  </table>
  <h4>购买信息</h4>
  <table border='1' style='border-collapse:collapse;width=600px;'>
  	<tr>
  		<td>id</td><td>书名</td><td>价格</td><td>出版社</td><td>数量</td>
  	</tr>
  	<% ArrayList<Book> bookList = (ArrayList<Book>)request.getAttribute("bookList");
  	for(int i=0;i<bookList.size();i++){
  	 Book b = bookList.get(i); %>
   	<tr>
  		<td><%=b.getId() %></td><td><%=b.getName() %></td><td><%=b.getPrice() %></td><td><%=b.getPublishHouse() %></td><td><%=b.getNums() %></td>
  	</tr> 	 
  	 <% }%>
  	 <tr>
  	 	<td colspan='5' align='left'>总价格：${totalPrice}</td>
  	 </tr>
  </table>
  <input type='button' onclick='goSubmitOrder()' value='确认订单'/>
  </body>
</html>
