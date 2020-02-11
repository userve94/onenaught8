package onlineExam;

import java.io.Serializable;

public class Question implements Serializable{

	private String questionID;
	private String question;

	private String option1;
	private String option2;

	private String option3;
	private String option4;

	private String answer;

	public String getQuestionID() {
		return questionID;
	}

	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", question=" + question + ", option1=" + option1 + ", option2="
				+ option2 + ", option3=" + option3 + ", option4=" + option4 + "]";
	}

//	@Override
//	public String toString() {
//		return "Question [questionID=" + questionID + ", question=" + question + ", option1=" + option1 + ", option2="
//				+ option2 + ", option3=" + option3 + ", option4=" + option4 + ", answer=" + answer
//				+ ", getQuestionID()=" + getQuestionID() + ", getQuestion()=" + getQuestion() + ", getOption1()="
//				+ getOption1() + ", getOption2()=" + getOption2() + ", getOption3()=" + getOption3() + ", getOption4()="
//				+ getOption4() + ", getAnswer()=" + getAnswer() + ", getClass()=" + getClass() + ", hashCode()="
//				+ hashCode() + ", toString()=" + super.toString() + "]";
//	}
	
	

}

