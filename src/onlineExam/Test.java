package onlineExam;

import java.io.IOException;
import java.util.*;

public class Test {

	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		// TODO Auto-generated method stub
		Question question;
		Set<Question> questionSet;
		int marks = 0;
		Question paperquestion;
		String StudentAnswer;
	
		ExamUtitlities examUtilities = new ExamUtitlities();
		
		int i = 1;
		int id = 1;
		
		questionSet = new HashSet<Question>();
		
		
		do {
			
			question = new Question();	//New Object should be created everytime, ow the same reference is added to the list/set
			Scanner scanner = new Scanner(System.in);
			question.setQuestionID("Q"+id++);
			System.out.println("Enter the question");
			question.setQuestion(scanner.nextLine());
			System.out.println("Enter option1");
			question.setOption1(scanner.nextLine());
			System.out.println("Enter option2");
			question.setOption2(scanner.nextLine());
			System.out.println("Enter option3");
			question.setOption3(scanner.nextLine());
			System.out.println("Enter option4");
			question.setOption4(scanner.nextLine());
			System.out.println("Enter answer");
			question.setAnswer(scanner.nextLine());
			
			questionSet.add(question);
			
			System.out.println("Do you want to continue? Press 1 for yes 0 for no");
			i = scanner.nextInt();
			
		}while(i==1);
		
		examUtilities.saveObject("char.txt",questionSet);
		examUtilities.readMyObject("char.txt");
		
		Iterator<Question> itr = questionSet.iterator();
		
		while(itr.hasNext()) {
			
			paperquestion = itr.next();
			System.out.println(paperquestion);
			System.out.println("Enter your answer");
			Scanner scanner = new Scanner(System.in);
			StudentAnswer = scanner.nextLine();

			System.out.println("Answer :"+paperquestion.getAnswer());
			if(question.getAnswer().equals(StudentAnswer)) {
				System.out.println("Correct Answer");
				marks++;
			}
			else if (StudentAnswer == null) {
				System.out.println("Question Unattempted");
			}
			else {
				System.out.println("Wrong Answer");
				marks--;
			}
			
		}
	}

}
