package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.beans.Book;

public class Utility implements ILibraryUtil{

	@Override
	public int addBook(Book book, Connection connection) throws SQLException {
		// adding book in data base 
		System.out.println("Book in add method :"+book);
		assert (book==null):"addBook method got all objects ";
		PreparedStatement ps= connection.prepareStatement("insert into Book values (?,?,?,?)");
		//////////////////////////////////1,2,3,4
		ps.setString(1, book.getId());
		ps.setString(2, book.getName());
		ps.setString(4, book.getStatus());
		ps.setString(3, book.getAuthors());
		
		ps.execute();
		System.out.println("Query fired");
		
		
		return 1;
	}

	@Override
	public int deletBook(String bookId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Book issueBook(String book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book returnBook(String book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book searchBookByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
