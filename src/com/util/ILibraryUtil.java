package com.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.beans.Book;

public interface ILibraryUtil {

	
	
	int addBook(Book book,Connection connection)throws SQLException;
	int deletBook(String bookId);
	Book issueBook(String book);
	Book returnBook(String book);
	Book searchBookByName(String name);
	
}
