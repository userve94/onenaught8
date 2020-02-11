import java.sql.Connection;

import com.beans.Book;
import com.util.DatabaseConnection;
import com.util.ILibraryUtil;
import com.util.Utility;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
		ILibraryUtil utility= new Utility();
		Connection connection = DatabaseConnection.getOracleConnection();
		
		Book book= new Book();
		book.setId("book1");
		book.setName("Rich Dad Poor Dad");
		book.setAuthors("Robert kiosaki");
		book.setStatus("available");
		System.out.println("adding book in database");
		int row =utility.addBook(book, connection);
		if(row==1) {
			System.out.println("Book is added Successfully!:"+book);
		}else {
			System.out.println("Book can not be added at this moment");
		}	
		connection.close();
		
}catch (Exception e) {
	// TODO: handle exception
}
		
	}

}
