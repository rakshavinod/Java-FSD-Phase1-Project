package com.phase1.project.simplilearn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.phase1.project1.simplilearn.user;
import com.phase1.project1.simplilearn.userinfo;

public class deserialization {
    
    // Input data
    private static Scanner keyboard = new Scanner(System.in);
    private static Scanner input;
    private static Scanner lockerInput;
    // Output data
    private static PrintWriter output;
    private static PrintWriter lockerOutput;
    // Model to store data
    private static user currentUser = new user();
    private static userinfo currentUserInfo = new userinfo();

    public static void main(String[] args) {
        welcomeScreen();
        signInOptions();
    }

    public static void signInOptions() {
        System.out.println("1. Registration");
        System.out.println("2. Login");
        int option = keyboard.nextInt();
        switch (option) {
            case 1:
                registerUser();
                break;
            case 2:
                loginUser();
                break;
            default:
                System.out.println("Please select 1 or 2");
                break;
        }
    }

    public static void lockerOptions(String inpUsername) {
        System.out.println("1. Fetch Stored Information");
        System.out.println("2. Store Information");
        int option = keyboard.nextInt();
        switch (option) {
            case 1:
                fetchCredentials(inpUsername);
                break;
            case 2:
                storeCredentials(inpUsername);
                break;
            default:
                System.out.println("Please select 1 or 2");
                break;
        }
    }

    public static void registerUser() {
        System.out.println("* Welcome to Registration Page *");

        System.out.println("Enter the Username:");
        String user_name = keyboard.next();
        currentUser.setUsername(user_name);

        System.out.println("Enter Password:");
        String password = keyboard.next();
        currentUser.setPassword(password);

        try {
            output = new PrintWriter("users.txt");
            output.println(currentUser.getUsername());
            output.println(currentUser.getPassword());
            System.out.println("User Registration is Successful!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    public static void loginUser() {
        System.out.println("* Welcome to Login Page *");

        System.out.println("Enter the Username:");
        String inpUsername = keyboard.next();
        boolean found = false;

        try {
            input = new Scanner(new File("users.txt"));
            while (input.hasNext() && !found) {
                if (input.next().equals(inpUsername)) {
                    System.out.println("Enter Password:");
                    String inpPassword = keyboard.next();
                    if (input.next().equals(inpPassword)) {
                        System.out.println("Login Successful! 200 OK");
                        found = true;
                        lockerOptions(inpUsername);
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }
        }

        if (!found) {
            System.out.println("User Not Found: Login Failure");
        }
    }

    public static void welcomeScreen() {
        System.out.println("* Welcome to LockMe Website *");
    }

    public static void storeCredentials(String userloggedIn) {
        System.out.println("* Welcome to the Locker to store all the information *");

        currentUserInfo.setUserLoggedIn(userloggedIn);

        System.out.println("Enter Site Name:");
        String siteName = keyboard.next();
        currentUserInfo.setSiteName(siteName);

        System.out.println("Enter Username:");
        String user_name = keyboard.next();
        currentUserInfo.setUsername(user_name);

        System.out.println("Enter Password:");
        String password = keyboard.next();
        currentUserInfo.setPassword(password);

        try {
            lockerOutput = new PrintWriter("locker.txt");
            lockerOutput.println(currentUserInfo.getUserLoggedIn());
            lockerOutput.println(currentUserInfo.getSiteName());
            lockerOutput.println(currentUserInfo.getUsername());
            lockerOutput.println(currentUserInfo.getPassword());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (lockerOutput != null) {
                lockerOutput.close();
            }
        }
    }

    public static void fetchCredentials(String inpUsername) {
        System.out.println("* Welcome to the Locker *");

        try {
            lockerInput = new Scanner(new File("locker.txt"));
            while (lockerInput.hasNext()) {
                if (lockerInput.next().equals(inpUsername)) {
                    System.out.println("Site Name: " + lockerInput.next());
                    System.out.println("User Name: " + lockerInput.next());
                    System.out.println("User Password: " + lockerInput.next());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (lockerInput != null) {
                lockerInput.close();
            }
        }
    }
}
