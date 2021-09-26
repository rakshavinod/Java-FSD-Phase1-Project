package com.phase1.project.simplilearn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import com.phase1.project1.simplilearn.user;
import com.phase1.project1.simplilearn.userinfo;

public class deserialization {
		
	    //input data
		private static Scanner keyboard;
		private static Scanner input;
		private static Scanner lockerInput;
		//output data 
		private static PrintWriter output;
		private static PrintWriter lockerOutput;
		//model to store data.
		private static user user;
		private static userinfo userinfo;
		
		
		public static void main(String[] args) {
			welcomeScreen();
			signInOptions();

		}
		public static void signInOptions() {
			System.out.println("1 . Registration ");
			System.out.println("2 . Login ");
			int option = keyboard.nextInt();
			switch(option) {
				case 1 : 
					registerUser();
					break;
				case 2 :
					loginUser();
					break;
				default :
					System.out.println("Please select 1 Or 2");
					break;
			}
			keyboard.close();
			input.close();
		}
		
		public static void lockerOptions(String inpUsername) {
			System.out.println("1 . Fetch Stored Information ");
			System.out.println("2 . Store Information ");
			int option = keyboard.nextInt();
			switch(option) {
				case 1 : 
					fetchCredentials(inpUsername);
					break;
				case 2 :
					storeCredentials(inpUsername);
					break;
				default :
					System.out.println("Please select 1 Or 2");
					break;
			}
			lockerInput.close();
		}
		
		public static void registerUser() {

			System.out.println("*   WELCOME TO REGISTRATION PAGE	*");
			
			System.out.println("Enter the Username :");
			String user_name = keyboard.next();
			user.setUsername(user_name);
			
			System.out.println("Enter Password :");
			String password = keyboard.next();
			user.setPassword(password);
			
			output.println(user.getUsername());
			output.println(user.getPassword());
			
			System.out.println("User Registration is Sucessful !");
			output.close();
			
		}
		public static void loginUser() {
		
			System.out.println("*   WELCOME TO LOGIN PAGE	 *");
		
			System.out.println("Enter the Username :");
			String inpUsername = keyboard.next();
			boolean found = false;
			while(input.hasNext() && !found) {
				if(input.next().equals(inpUsername)) {
					System.out.println("Enter Password :");
					String inpPassword = keyboard.next();
					if(input.next().equals(inpPassword)) {
						System.out.println("Login Successful ! 200OK");
						found = true;
						lockerOptions(inpUsername);
						break;
					}
				}
			}
			if(!found) {
				System.out.println("User Not Found : Login Failure");
			}
			
		}
		
		public static void welcomeScreen() {
	
			System.out.println("*   Welcome To LockMe Website	*");
			
		}
		//store information
		public static void storeCredentials(String userloggedIn) {
			
			System.out.println("*   Welcome to the locker to store all the information	 *");
			
			userinfo.setUserLoggedIn(userloggedIn);
			
			System.out.println("Enter Site Name :");
			String siteName = keyboard.next();
			userinfo.setSiteName(siteName);
			
			System.out.println("Enter Username :");
			String user_name = keyboard.next();
			userinfo.setUsername(user_name);
			
			System.out.println("Enter Password :");
			String password = keyboard.next();
			userinfo.setPassword(password);
			
			lockerOutput.println(userinfo.getUserLoggedIn());
			lockerOutput.println(userinfo.getSiteName());
			lockerOutput.println(userinfo.getUsername());
			lockerOutput.println(userinfo.getPassword());
		
			lockerOutput.close();		
		}
		
		//fetch the information
		public static void fetchCredentials(String inpUsername) {
	
			System.out.println("*   Welcome to the Locker 	 *");
		
			System.out.println(inpUsername);
			
			
			while(lockerInput.hasNext()) {
//				System.out.println(lockerInput.hasNext());
				if(lockerInput.next().equals(inpUsername)) {
					System.out.println("Site Name: "+lockerInput.next());
					System.out.println("User Name: "+lockerInput.next());
					System.out.println("User Password: "+lockerInput.next());
				}
			}
			
		

		try {
			// create file input stream
			FileInputStream file  = new FileInputStream("sam.txt");
			
			//create object inout strea
			ObjectInputStream inp = new ObjectInputStream(file);
			
			// method for de-seralization.
			userinfo user_info = (userinfo)inp.readObject();
}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

	}
}

