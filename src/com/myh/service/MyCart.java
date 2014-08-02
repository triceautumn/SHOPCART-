package com.myh.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.myh.bean.Book;

public class MyCart 
{
	HashMap<String,Book> hm = new HashMap<String,Book>();
	public void addBook(String id, Book book)
	{
		if(hm.keySet().contains(id))
		{
			Book b = hm.get(id);
			b.setShoppingNum(b.getShoppingNum()+1);	
			hm.put(id,b);
		}
		else
		{
			book.setShoppingNum(1);
			hm.put(id, book);
		}	
	}
	public void delBook(String id)
	{
		hm.remove(id);
	}
	public void updateBook(String id ,int num)
	{
		Book b = hm.get(id);
		b.setShoppingNum(num);
		hm.put(id, b);
	}
	public float getTotalPrice()
	{
		 float rel = 0;
		Iterator<String> iter = hm.keySet().iterator();
		while(iter.hasNext())
		{
			Book book = hm.get(iter.next());
			rel += (book.getPrice()*book.getShoppingNum());
		}
		return rel;
	}
	public ArrayList<Book> showMyCart()
	{
		ArrayList<Book> bookList = new ArrayList<Book>();
		Iterator<String> iter = hm.keySet().iterator();
		while(iter.hasNext())
		{
			String id = iter.next();
			Book book = hm.get(id);
			bookList.add(book);
		}
		return bookList;
	}
	public void clearBook()
	{
		hm.clear();
	}
}
