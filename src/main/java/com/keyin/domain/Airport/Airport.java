package com.keyin.domain.Airport;

import com.keyin.domain.Aircraft.Aircraft;
import com.keyin.domain.City.City;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airportId;

    private String name;
    private String IATA_code;  // Removed static

    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    @ManyToMany
    @JoinTable(
            name = "airport_aircraft",
            joinColumns = @JoinColumn(name = "airport_id"),
            inverseJoinColumns = @JoinColumn(name = "aircraft_id")
    )
    private List<Aircraft> aircraft;

    // No-args constructor
    public Airport() {
    }

    public Airport(Long airportId, String name, String IATA_code) {
        this.airportId = airportId;
        this.name = name;
        this.IATA_code = IATA_code;
    }

    public long getAirportId() {
        return airportId;
    }

    public void setAirportId(long airportId) {
        this.airportId = airportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIATA_code() {
        return IATA_code;
    }

    public void setIATA_code(String IATA_code) {
        this.IATA_code = IATA_code;
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
