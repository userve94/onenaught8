package com.util.serialization;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;

import com.bean.Topic;
import com.util.DatabaseConnection;

public class serializationTest {

	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
		// TODO retrieve the topic Set from database 
		Topic topic = new Topic();
		Connection connection = DatabaseConnection.getConnection();

		serializationUtility util = new serializationUtility();
		
		// save into a file
		
//		if(util.saveTopics("Topics.txt", util.getTopicSet(topic, connection)))
//			System.out.println("File updated successfully!!");

		// read from a file
		Iterator<Topic> iterator = util.readTopics("Topics.txt").iterator();
		
		while(iterator.hasNext()) {
			
			topic = iterator.next();
			util.addrecord(topic, connection);
			System.out.println("Record Updated Successfully");
			// ITerate the set
			topic = iterator.next();
			System.out.println(topic);
		}
//			System.out.println("File updated successfully!!");
	}

}
