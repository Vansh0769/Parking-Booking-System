package com.company;

public class ParkingSpot {
    private String id;
    private String location;
    private boolean available;
    private double price;
    private String bookedByUser; // New field to store user who booked the spot

    // Constructor
    public ParkingSpot(String id, String location, boolean available, double price) {
        this.id = id;
        this.location = location;
        this.available = available;
        this.price = price;
        this.bookedByUser = null; // No user initially
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPrice() {
        return price;
    }

    public String getBookedByUser() {
        return bookedByUser;
    }

    public void setBookedByUser(String bookedByUser) {
        this.bookedByUser = bookedByUser;
    }
}
