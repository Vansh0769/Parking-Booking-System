package com.company;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> spots;

    public ParkingLot() {
        this.spots = new ArrayList();
    }

    // Method to add a parking spot to the lot
    public void addParkingSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    // Method to search for available parking spots
    public List<ParkingSpot> searchAvailableSpots() {
        List<ParkingSpot> availableSpots = new ArrayList();
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                availableSpots.add(spot);
            }
        }
        return availableSpots;
    }

    // Method to find a specific parking spot by ID
    public ParkingSpot findSpotById(String id) {
        for (ParkingSpot spot : spots) {
            if (spot.getId().equals(id)) {
                return spot;
            }
        }
        return null;  // Return null if no spot with the given ID is found
    }

    // Method to book a parking spot
    public boolean bookSpot(String id, String user) {
        ParkingSpot spot = findSpotById(id);
        if (spot != null && spot.isAvailable()) {
            spot.setAvailable(false);
            spot.setBookedByUser(user);
            return true;
        }
        return false;
    }

    // Method to check booking status
    public boolean isSpotBooked(String id) {
        ParkingSpot spot = findSpotById(id);
        return spot != null && !spot.isAvailable();
    }

    // Additional methods can be added for more functionality
}
