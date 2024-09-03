package com.company;

import java.util.Scanner;

public class Login {
    private Scanner scanner = new Scanner(System.in);
    private static String[] email_arr = REGISTER.email_arr;  // Accessing the same email array as REGISTER
    private static String[] pass_arr = REGISTER.pass_arr;  // Accessing the same password array as REGISTER

    public void login() {
        System.out.println("Please enter your email:");
        String email = scanner.next();

        // Find email index
        int emailIndex = findEmailIndex(email);

        if (emailIndex == -1) {
            System.out.println("Email not registered. Please register first.");
        } else {
            System.out.println("Please enter your password:");
            String pass = scanner.next();

            // Check password
            if (pass_arr[emailIndex].equals(pass)) {
                System.out.println("Welcome user, you're precious to us.");
            } else {
                System.out.println("Incorrect password. Please try again.");
            }
        }
    }

    // Helper method to find the index of an email in the array
    private static int findEmailIndex(String email) {
        for (int i = 0; i < email_arr.length; i++) {
            if (email_arr[i] != null && email_arr[i].equals(email)) {
                return i;
            }
        }
        return -1;  // Return -1 if email not found
    }
}
