<%@ page language="java" import="java.util.*,com.myh.bean.Book" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hall.jsp' starting page</title>
    
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
  <%
      ArrayList<Book> bookList = (ArrayList<Book>)request.getAttribute("bookList");
   %>
    <center>
    	<h1><font color='red'>欢迎访问购物大厅</font></h1>
    	<table border='1' style='border-collapse:collapse;width=700px;'>
    		<tr>
    			<th>书名</th><th>价格</th><th>出版社</th><th>库存</th><th>点击购买</th>
    		</tr>
    		<%for(int i=0;i<bookList.size();i++) {
    			Book book = bookList.get(i);
    		%>
    		<tr>
    			<th><%=book.getName() %></th><th><%=book.getPrice() %></th><th><%=book.getPublishHouse() %></th><th><%=book.getNums()%></th><th><a href="/shopCart/ShoppingClServlet?type=add&id=<%=book.getId()%>">购&nbsp;&nbsp;买</a></th>
    		</tr>
    		<%}%>
    		<tr>
    		<th colspan='6'><input type='button' value='查看购物车'/></th>
    		</tr>
    	</table>
    </center>
  </body>
</html>
