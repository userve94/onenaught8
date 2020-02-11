package com.util.serialization;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import com.bean.Topic;

public interface ISerializeUtility {
	
	Set<Topic> getTopicSet(Topic topic,Connection connection) throws SQLException;
	boolean saveTopics(String FileName, Set<Topic> setOfTopics ) throws IOException;
	Set<Topic> readTopics(String FileName) throws IOException, ClassNotFoundException;
	int addrecord(Topic topic, Connection connection) throws SQLException;
	

}
