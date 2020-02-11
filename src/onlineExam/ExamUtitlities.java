package onlineExam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ExamUtitlities {

	//lazy initalization
	Question question;
	Set<Question> questionSet;
	
	public boolean saveObject(String fileName, Set<Question> questionSet) throws IOException{
		
		File file = new File(fileName);
		
		if(file.exists()) {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(questionSet);
			oos.close();
			fos.close();

			return true;
		}
		else {
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(questionSet);
			oos.close();
			fos.close();

			return true;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public Set<Question> readMyObject(String fileName) throws ClassNotFoundException, IOException {
		
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		return (Set<Question>) ois.readObject();
		
	}

	
}
