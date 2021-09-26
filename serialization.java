package com.phase1.project.simplilearn;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class serialization {
	public static void main(String[] args) {
		
		userinfo user_info= new userinfo("instagram", "sam", "sam@123", "sammy" );
		
		try {
			// create output file stream
			FileOutputStream file = new FileOutputStream("sam.txt");
			
			// create output object stream
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			// method for serialization 
			out.writeObject(user_info);
			
			
			
			out.close();
			file.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}

}
