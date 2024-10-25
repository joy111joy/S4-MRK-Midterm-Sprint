package com.keyin.domain.Aircraft;

import com.keyin.domain.Airport.Airport;
import com.keyin.domain.Passenger.Passenger;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aircraftId;  // Use Long instead of long for JPA compatibility
    private String airline;
    private String model;
    private int capacity;

    @ManyToMany(mappedBy = "aircraft") // Change to match the field name in Passenger
    private List<Passenger> passengers;

    @ManyToMany(mappedBy = "aircraft") // Change to match the field name in Airport if applicable
    private List<Airport> airports;

    // No-args constructor for JPA
    public Aircraft() {
    }

    // Constructor with parameters
    public Aircraft(Long aircraftId, String airline, String model, int capacity) {
        this.aircraftId = aircraftId;
        this.airline = airline;
        this.model = model;
        this.capacity = capacity;
    }

    public Long getAircraftId() {
        return aircraftId;  // Return type should match the field type
    }

    public void setAircraftId(Long aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Optional: Getters and Setters for passengers and airports
    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }
}
