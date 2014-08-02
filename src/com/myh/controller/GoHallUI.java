package com.myh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myh.bean.Book;
import com.myh.bean.Users;
import com.myh.service.BookService;
import com.myh.service.MyCart;
import com.myh.service.UserService;

public class GoHallUI extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Users user = (Users)request.getSession().getAttribute("user"); 
		if(null != user)
		{
			BookService bookService = new BookService();
			ArrayList<Book> bookList = bookService.getAllBook();
			request.setAttribute("bookList",bookList);
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);
		}
		else
		{
			Users users = new Users();
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			users.setName(name);
			users.setPassword(password);
			UserService userService = new UserService();
			Users u = userService.checkUser(users);
			if(!(null == u.getName()))
			{
				
				MyCart myCart = new MyCart();
				request.getSession().setAttribute("user", u); 
				request.getSession().setAttribute("myCart", myCart);
				BookService bookService = new BookService();
				ArrayList<Book> bookList = bookService.getAllBook();
				request.setAttribute("bookList",bookList);
				request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);
			}
			else 
			{
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
				
			}
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		this.doGet(request, response);
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
