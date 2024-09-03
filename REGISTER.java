package com.company;

import java.io.FileWriter;
import java.util.Scanner;

public class REGISTER {
    static String[] email_arr = new String[20];
    static String[] pass_arr = new String[20];
    private static String first_name;
    private static String last_name;
    private static String place;
    private static String state;
    private static long number;
    private static Scanner sc = new Scanner(System.in);
    private static int index = 0;

    static void register() {
        System.out.println("Enter your email:");
        String email = sc.next();

        // Check if the email already exists
        if (emailExists(email)) {
            System.out.println("You have entered an existing email. Please login.");
            return;
        }

        System.out.println("Enter your first name:");
        first_name = sc.next();
        System.out.println("Enter your last name:");
        last_name = sc.next();
        System.out.println("Enter your phone number:");
        number = sc.nextLong();
        System.out.println("Enter your city:");
        place = sc.next();
        System.out.println("Enter your state:");
        state = sc.next();

        // Store email and password
        email_arr[index] = email;
        System.out.println("Please enter your password:");
        String password = sc.next();
        pass_arr[index] = password;
        index++;

        // Write the email and password to the file
        try {
            FileWriter fw = new FileWriter("Login and register.txt", true);
            fw.write(email + " " + password + "\n");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception by printing stack trace
        }

        System.out.println("Registration successful");
    }

    // Helper method to check if the email already exists
    private static boolean emailExists(String email) {
        for (int i = 0; i < index; i++) {
            if (email_arr[i].equals(email)) {
                return true;
            }
        }
        return false;
    }
}
