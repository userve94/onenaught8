package com.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Set;

import com.bean.Topic;

public interface IStudyManagerUtility {
	
	public Date getDeadline(Connection connection,String Subject_Id) throws SQLException;
	public long remainingDays(Date deadline);
	public int addTopics(Topic topic, Connection connection);
	public Set<Topic> getTopics(Topic topic, Connection connection) throws SQLException;
//	public int getNoOfTopics(Connection connection,String Subject_Id);
//	public int getNoOfCompletedTopics(Connection connection,String Subject_Id);
//	
}

