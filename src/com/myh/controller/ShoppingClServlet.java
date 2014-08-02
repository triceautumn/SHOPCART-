package com.myh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myh.bean.Book;
import com.myh.service.BookService;
import com.myh.service.MyCart;

public class ShoppingClServlet extends HttpServlet {

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
			throws ServletException, IOException 
			{

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		if("add".equals(type))
		{
			String id = request.getParameter("id");
			MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
			BookService bookService = new BookService();
			Book book = bookService.getBookById(id);
			myCart.addBook(id, book);
			ArrayList<Book> bookList = myCart.showMyCart();
			request.setAttribute("bookList",bookList);
			request.setAttribute("totalPrice",myCart.getTotalPrice());
			request.getRequestDispatcher("/WEB-INF/myshopping.jsp").forward(request, response);
		}
		else  if("del".equals(type))
		{
			String id = request.getParameter("id");
			MyCart myCart = (MyCart)request.getSession().getAttribute("myCart");
			myCart.delBook(id);
			ArrayList<Book> bookList = myCart.showMyCart();
			request.setAttribute("bookList",bookList);
			request.setAttribute("totalPrice",myCart.getTotalPrice());
			request.getRequestDispatcher("/WEB-INF/myshopping.jsp").forward(request, response);
		}
		else if("update".equals(type))
		{
			String[] bookIds = request.getParameterValues("bookIds");
			String[] bookNums = request.getParameterValues("bookNum");
			MyCart myCart = (MyCart)request.getSession().getAttribute("myCart");
			for(int i=0;i<bookIds.length;i++)
			{
				myCart.updateBook(bookIds[i],Integer.parseInt(bookNums[i]));
			}
			ArrayList<Book> bookList = myCart.showMyCart();
			request.setAttribute("bookList",bookList);
			request.setAttribute("totalPrice",myCart.getTotalPrice());
			request.getRequestDispatcher("/WEB-INF/myshopping.jsp").forward(request, response);
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

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		this.doGet(request, response);
		PrintWriter out = response.getWriter();
		
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
