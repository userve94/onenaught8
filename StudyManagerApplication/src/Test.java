
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.bean.Topic;
import com.util.DatabaseConnection;
import com.util.IStudyManagerUtility;
import com.util.Utility;

// 3-2-2020 ==> Now next i want to change the background color using the lookup table

public class Test {
	public static void main(String[] args) throws SQLException {
		
		IStudyManagerUtility utility = new Utility();
		Topic topic = new Topic();
		Set<Topic> topicSet = new TreeSet<Topic>(); // Here were making a set top store the row entries from my table
		
		Connection connection = DatabaseConnection.getConnection();
		
		topicSet = utility.getTopics(topic, connection);
		
		Iterator<Topic> iterator = topicSet.iterator();
		
		while(iterator.hasNext()) {
			Topic topic1 = (Topic)iterator.next();
//			System.out.println(topic1.getTopicId());
//			System.out.println(topic1.getTopicName());
//			System.out.println(topic1.getStatus());
//			topic.getSubjectId();
//			topic.getChapterId();
			System.out.println(topic1);
		}
		
//		Date deadline = utility.getDeadline(connection, "1");
//		
//		long daysLeft = utility.remainingDays(deadline);
//		System.out.println(daysLeft);
//		
//		// We are supposed to take the topic info from the user from here -- single responsibility principle, dependency inversion
//		System.out.println("Add a topic in the database");
//		
//		Scanner scanner = new Scanner(System.in);
//		
//		//WE are not going to ask for topic id to the user, were setting that value in the add method directly
//		
//		//get topic name from the user
//		System.out.println("Add topic name");
//		topic.setTopicName(scanner.nextLine());
//		System.out.println("Add subject id");// DOUBT ------------- Are we going to ask for subject id to the user?
//		topic.setSubjectId(scanner.next());
//		System.out.println("Add chapter id");// DOUBT ------------- Are we going to ask for chapter id to the user?
//		topic.setChapterId(scanner.next());
//		System.out.println("Importance");
//		topic.setImportance(scanner.next());
//		
//		int rows = utility.addTopics(topic, connection);
//	
//		System.out.println(rows);
		
//		currentDate = LocalDateTime.now().getDayOfYear();
//		System.out.println(currentDate);
//		Scanner scanner = new Scanner(System.in);
		
//		System.out.println("Enter sleeping Hours");
//		float sleepingHours = scanner.nextInt();
		
//		int noOfDays = deadline.toLocalDate().getDayOfYear() - currentDate.;
//		int noOfTopics = utility.getNoOfTopics(connection, topic.getSubjectId());
//		int noOfCompletedTopics = utility.getNoOfCompletedTopics(connection,topic.getSubjectId());
//		int noOfPendingTopics = noOfTopics - noOfCompletedTopics;
//		float noOfHours = noOfDays*(24-sleepingHours);
//		
//		System.out.println("Deadline : "+deadline);
		
//		System.out.println("Days in Hand : "+noOfDays);
		
//		System.out.println("Hours Remaining : "+noOfHours);
//		
//		System.out.println("Total no of topics : "+noOfTopics);
//		
//		System.out.println("Completed Topics : "+noOfCompletedTopics);
//		
//		System.out.println("Remaining Topics : "+noOfPendingTopics);
//		
//		System.out.println("Topics Per Hour : "+noOfPendingTopics/noOfHours);
//		
		
		
	}
}
