package com.keyin.domain.Passenger;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.keyin.domain.Aircraft.Aircraft;
import com.keyin.domain.City.City;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerId;

    private String firstName;
    private String lastName;
    private String email;

    @ElementCollection
    private List<String> airportsVisited;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cityId")
    private City city;

    @ManyToMany
    @JoinTable(
            name = "passenger_aircraft",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "aircraft_id")
    )
    private List<Aircraft> aircraft;

    public Passenger() {
    }

    public Passenger(Long passengerId, String firstName, String lastName, String email, List<String> airportsVisited) {
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.airportsVisited = airportsVisited;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getAirportsVisited() {
        return airportsVisited;
    }

    public void setAirportsVisited(List<String> airportsVisited) {
        this.airportsVisited = airportsVisited;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Aircraft> getAircraft() {
        return aircraft;
    }

    public void setAircraft(List<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }
}
