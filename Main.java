package com.company;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();

        // Generate random parking spots
        generateRandomParkingSpots(parkingLot, 10);  // Adjust the number of spots to generate as needed

        boolean exit = false;
        boolean loggedIn = false;
        String currentUser = null;

        while (!exit) {
            if (!loggedIn) {
                System.out.println("Select an option:");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                int choice = sc1.nextInt();
                sc1.nextLine(); // Consume newline

                if (choice == 1) {
                    REGISTER reg = new REGISTER();
                    reg.register();
                } else if (choice == 2) {
                    Login log = new Login();
                    log.login();
                    loggedIn = true;  // Set loggedIn to true after successful login
                    currentUser = "user@example.com";  // Assume user email as an identifier
                } else if (choice == 3) {
                    System.out.println("Exiting........");
                    exit = true;
                } else {
                    System.out.println("Invalid option. Please select again.");
                }
            } else {
                // User is logged in, show parking options
                System.out.println("Select an option:");
                System.out.println("1. Search Available Parking Spots");
                System.out.println("2. Book a Parking Spot");
                System.out.println("3. Logout");
                System.out.println("4. Exit");
                int choice = sc1.nextInt();
                sc1.nextLine(); // Consume newline

                if (choice == 1) {
                    // Search for available parking spots
                    List<ParkingSpot> availableSpots = parkingLot.searchAvailableSpots();
                    if (availableSpots.isEmpty()) {
                        System.out.println("No available parking spots at the moment.");
                    } else {
                        System.out.println("Available parking spots:");
                        for (ParkingSpot spot : availableSpots) {
                            System.out.println("Spot ID: " + spot.getId() + ", Location: " + spot.getLocation() + ", Price: INR " + spot.getPrice());
                        }
                    }
                } else if (choice == 2) {
                    // Book a parking spot
                    System.out.println("Enter the Spot ID to book:");
                    String spotId = sc1.nextLine();
                    if (parkingLot.bookSpot(spotId, currentUser)) {
                        System.out.println("Parking spot booked successfully.");
                    } else {
                        System.out.println("Unable to book spot. It may already be booked or does not exist.");
                    }
                } else if (choice == 3) {
                    loggedIn = false;  // Set loggedIn to false after logging out
                    currentUser = null;  // Clear the current user
                    System.out.println("Logged out successfully.");
                } else if (choice == 4) {
                    System.out.println("Exiting........");
                    exit = true;
                } else {
                    System.out.println("Invalid option. Please select again.");
                }
            }
        }

        sc1.close();
    }

    // Method to generate random parking spots
    public static void generateRandomParkingSpots(ParkingLot parkingLot, int numberOfSpots) {
        Random random = new Random();
        double conversionRate = 80.0; // Conversion rate from USD to INR
        for (int i = 0; i < numberOfSpots; i++) {
            String id = String.valueOf(i + 1); // Generate IDs starting from "1"
            String location = getRandomLocation(random); // Generate random location
            boolean isAvailable = random.nextBoolean(); // Random availability status
            double price = 5 * random.nextDouble();
            ParkingSpot spot = new ParkingSpot(id, location, isAvailable, price);
            parkingLot.addParkingSpot(spot);
        }
    }

    // Helper method to generate a random location string (e.g., "A1", "B2", etc.)
    public static String getRandomLocation(Random random) {
        char section = (char) ('A' + random.nextInt(6)); // Random letter from A to F
        int number = random.nextInt(10) + 1; // Random number from 1 to 10
        return section + String.valueOf(number);
    }
}
