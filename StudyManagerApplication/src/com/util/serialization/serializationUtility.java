package com.util.serialization;

import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Set;
import java.util.TreeSet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Topic;

public class serializationUtility implements ISerializeUtility{

	public Set<Topic> getTopicSet(Topic topic,Connection connection) throws SQLException {

		Statement statement = connection.createStatement();
		ResultSet resultset = statement.executeQuery("select * from topic");

		Set<Topic> setOfTopics = new TreeSet<Topic>();

		while(resultset.next()) {

			topic = new Topic();
			System.out.println();
			topic.setTopicId(resultset.getString("TOPIC_ID"));
			topic.setTopicName(resultset.getString("TOPIC_NAME"));
			//May contain null value can raise null pointer exception
			try {
				topic.setTopicStartTime(resultset.getTimestamp("START_TIME").toLocalDateTime());
				topic.setTopicEndTime(resultset.getTimestamp("END_TIME").toLocalDateTime());
				//				System.out.println((LocalDateTime.parse(resultset.getDate("START_TIME", Calendar.getInstance()).toString())));
				//				System.out.println((LocalDateTime.parse(resultset.getDate("START_TIME").toString())));
			}
			catch(NullPointerException npe ){
				npe.getMessage();
			}
			finally {
				topic.setStatus(resultset.getString("STATUS"));
				topic.setSubjectId(resultset.getString("SUBJECT_ID"));
				topic.setChapterId(resultset.getString("CHAPTER_ID"));
				topic.setImportance(resultset.getString("IMPORTANCE"));
				setOfTopics.add(topic);
			}


		}
		return setOfTopics;		
	}

	@Override
	public boolean saveTopics(String FileName, Set<Topic> setOfTopics) throws IOException {
		// TODO save this set of topics in a file 

		File file = new File(FileName);
		if(file.exists()) {
			try(FileOutputStream fos = new FileOutputStream(file)){
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(setOfTopics);
			oos.close();
			return true;
			}
		}
		else {
			file.createNewFile();
			try(FileOutputStream fos = new FileOutputStream(file)){
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(setOfTopics);
				oos.close();
			}
			return true;

		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Topic> readTopics(String FileName) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		File file = new File(FileName);
		if(file.exists()) {
			FileInputStream fis = new FileInputStream(file);
			try(ObjectInputStream ois = new ObjectInputStream(fis)){
				return (Set<Topic>)ois.readObject();
			}

		}
		return null;
	}

	@Override
	public int addrecord(Topic topic, Connection connection) throws SQLException {
		//????????????????????????? DOUBT -- what is the substitute for if else statement in the following code?
		//assert topic == null: "Topic is imported inside the method";
		// TODO Auto-generated method stub
		PreparedStatement ps = connection.prepareStatement("INSERT INTO TOPIC(TOPIC_ID,TOPIC_NAME,START_TIME,END_TIME,SUBJECT_ID,CHAPTER_ID,IMPORTANCE,STATUS,FLAG) VALUES (?,?,?,?,?,?,?,?,?)");
		//////////////////////////////////////////////////////////////////////////////1,2,3,4,5,6,7,8,9

		ps.setString(1, topic.getTopicId());
		ps.setString(2, topic.getTopicName());
		if(topic.getTopicStartTime() != null) {
			ps.setTimestamp(3,Timestamp.valueOf(topic.getTopicStartTime()));
		}
		else {
			ps.setString(3, null);
		}
		if(topic.getTopicEndTime() != null) {
			ps.setTimestamp(4, Timestamp.valueOf(topic.getTopicEndTime()));	
		}
		else {
			ps.setString(4, null);
		}
		
		ps.setString(5, topic.getSubjectId());
		ps.setString(6, topic.getChapterId());
		ps.setString(7,topic.getImportance());
		ps.setString(8, topic.getStatus());
		ps.setInt(9, topic.getFlag());

		return ps.executeUpdate();
	}
}
