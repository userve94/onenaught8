package com.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

import com.bean.Topic;

public class Utility implements IStudyManagerUtility{

	@Override
	public Set<Topic> getTopics(Topic topic, Connection connection) throws SQLException{

		Set<Topic> topicSet = new TreeSet<Topic>();
		String status = "pending"; // Set status here
		// TODO get records of topic table and return the set
		// Dont copy lines as it is from earlier code it leads to unnecessary errors
		// instead write them again
		PreparedStatement ps = connection.prepareStatement("select * from topic ");

//		ps.setString(1, status);

		ResultSet resultSet = ps.executeQuery();
		System.out.println("Size of resultSet : "+resultSet.getFetchSize());
		
		// ???????????????????????????? Doubt - why am i getting only 3 rows out of four rows from the database??
		while(resultSet.next()) {
			try {
				topic = new Topic();
				topic.setTopicId(resultSet.getString("topic_id"));
				topic.setTopicName(resultSet.getString("topic_name"));
				topic.setSubjectId(resultSet.getString("subject_id"));
				topic.setChapterId(resultSet.getString("chapter_id"));// when you copy as it is change both subject to chapter
				topic.setImportance(resultSet.getString("Importance"));
				topic.setStatus(status);
				topic.setFlag(1);

				topicSet.add(topic);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Size of topic set: "+ topicSet.size());
		return topicSet;
	}


	@Override
	public Date getDeadline(Connection connection,String Subject_Id) throws SQLException {
		Date deadline = null;
		PreparedStatement ps = connection.prepareStatement("select deadline from subject where subject_id = ?");
		ps.setString(1, Subject_Id);
		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			deadline = rs.getDate(1);//.toLocalDate().getDayOfYear();
		}
		return deadline;
	}

	@Override
	public long remainingDays(Date deadline) {
		// here we cannot use date.getDays, getMonths, getHours methods of date class because of incorrect date computation
		return Duration.between(LocalDateTime.now(), LocalDateTime.now()).toDays();
	}

	@Override
	public int addTopics(Topic topic, Connection connection) {
		// TODO add topics to the database
		// Don't create a new topic object here!
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("INSERT INTO TOPIC(topic_id,topic_name,subject_id,chapter_id,importance,status) VALUES (?,?,?,?,?,?)");
			// the nos given below are the positions of question marks in the query and NOT column ids in the database
			ps.setString(1,"4");
			ps.setString(2, topic.getTopicName());
			ps.setString(3, topic.getSubjectId());
			ps.setString(4, topic.getChapterId());
			ps.setString(5, topic.getImportance());
			ps.setString(6,"pending");

			int row = ps.executeUpdate();

			return row;
		} catch ( SQLException e) {//There are several child exceptions of sqlexception namely
			//if the connection is not setup --> that is application specific exception
			// SQL exceptions can be constriant types of exceptions/ not null, etc 
			// we can try to catch these in the try catch block
			// on personal project level we can add create table query but in the actual development scenario this is not allowed!!!!
			e.printStackTrace();
		}
		//////////////////////////////////////////////////////////////////////////////1/2/3/4/5/6/9
		return 0;
	}



	//
	//	@Override
	//	public int getNoOfTopics(Connection connection,String Subject_Id) {
	//		
	//		try {
	//			PreparedStatement ps = connection.prepareStatement("select count(topic_Id) from topic where subject_id = ?");
	//			ps.setString(1, Subject_Id);
	//			ResultSet rs = ps.
	//
	//			while(rs.next()) {
	//				local
	//				return rs.getInt(1);//.toLocalDate().getDayOfYear();
	//			}
	//		}catch (Exception e) {
	//			// TODO: handle exception
	//			e.printStackTrace();
	//		}
	//		return 0;
	//	}
	//	@Override
	//	public int getNoOfCompletedTopics(Connection connection, String Subject_Id) {
	//		try {
	//			PreparedStatement ps = connection.prepareStatement("select count(topic_Id) from topic where status = 'completed'");
	//			ps.setString(1, Subject_Id);
	//			ResultSet rs = ps.executeQuery();
	//
	//			while(rs.next()) {
	//				return rs.getInt(1);//.toLocalDate().getDayOfYear();
	//			}
	//		}catch (Exception e) {
	//			// TODO: handle exception
	//			e.printStackTrace();
	//		}
	//		return 0;
	//	}

}
