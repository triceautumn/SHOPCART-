<%@ page language="java" import="java.util.*,com.myh.bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'myshopping.jsp' starting page</title>
    
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
  <%ArrayList<Book> bookList = (ArrayList<Book>)request.getAttribute("bookList"); 
  
  %>
    <center>
    	<h1>我的购物车</h1>
    	<a href='/shopCart/GoHallUI'>返回购物大厅</a><br>
    	<form action='/shopCart/ShoppingClServlet?type=update' method='post'>
    		<table border='1' style='border-collapse:collapse;width=700px;'>
    			<tr>
    				<th>id</th><th>书名</th><th>价格</th><th>出版社</th><th>数量</th><th>删除</th>
    			</tr>
    			<%for(int i=0;i<bookList.size();i++){ 
    			 Book book = bookList.get(i);
    			%>
    			<tr>
    				<th><%=book.getId()%><input type='hidden' name='bookIds' value='<%=book.getId() %>'></th><th><%=book.getName()%></th><th><%=book.getPrice() %></th><th><%=book.getPublishHouse()%></th><th><input type="text" id="bookNum" name="bookNum" value="<%=book.getShoppingNum()%>" /></th><th><a href='/shopCart/ShoppingClServlet?type=del&id=<%=book.getId()%>'>删除</a></th>
    			</tr>
    			<%} %>
    			<tr>
    				<th colspan='6'><input type='submit' value='update'/></th>
    			</tr>
    			<tr>
    				<td colspan='6'>购物车的总价格：${totalPrice}</td>
    			</tr>
    			<tr>
    				<td align='left' colspan='6'><a href='/shopCart/GoMyOrderServlet'>提交订单</a></td>
    			</tr>
    		</table>
    	</form>
    </center>
  </body>
</html>
