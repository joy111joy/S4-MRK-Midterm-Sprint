package com.keyin.domain.Aircraft;

import com.keyin.domain.Airport.Airport;
import com.keyin.domain.Passenger.Passenger;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aircraftId;
    private String airline;
    private String model;
    private int capacity;
    private LocalDate lastServiceDate;
    private String status;

    @ManyToMany(mappedBy = "aircraft")
    private List<Passenger> passengers;

    @ManyToMany(mappedBy = "aircraft")
    private List<Airport> airports;


    public Aircraft() {
    }


    public Aircraft(Long aircraftId, String airline, String model, int capacity, String status) {

        this.aircraftId = aircraftId;
        this.airline = airline;
        this.model = model;
        this.capacity = capacity;
        this.status = "Active";
    }

    public Long getAircraftId() {
        return aircraftId;
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



    public LocalDate getLastServiceDate() {
        return lastServiceDate;
    }


    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setLastServiceDate(LocalDate lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }


}



