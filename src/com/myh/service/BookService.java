package com.myh.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.myh.bean.Book;
public class BookService 
{
	public Book getBookById(String id)
	{
		Book book = new Book();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:oraclestu", "puborcl", "admin");
			String sql ="select * from tbl_book where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
			rs = ps.executeQuery();
			while(rs.next())
			{
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublishHouse(rs.getString("publishhouse"));
				book.setPrice(rs.getFloat("price"));
				book.setNums(rs.getInt("nums"));
			}
			if(null != rs)
			{
				rs.close();
			}
			if(null != ps)
			{
				ps.close();
			}
			if(null != conn)
			{
				conn.close();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return book;
	}
	public ArrayList<Book> getAllBook()
	{
		ArrayList<Book> bookList = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:oraclestu", "puborcl", "admin");
			String sql ="select * from tbl_book";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublishHouse(rs.getString("publishhouse"));
				book.setPrice(rs.getFloat("price"));
				book.setNums(rs.getInt("nums"));
				bookList.add(book);
			}
			if(null != rs)
			{
				rs.close();
			}
			if(null != ps)
			{
				ps.close();
			}
			if(null != conn)
			{
				conn.close();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return bookList;
	}
	public static void main(String[] args) 
	{
		BookService bookService = new BookService();
		System.out.println((bookService.getAllBook()).size());
		
	}
}
