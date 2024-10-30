package com.keyin.domain.City;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.keyin.domain.Airport.Airport;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    private String name;  // City name
    private String province; // Province name
    private int cityPopulation;
    private int provincePopulation;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL) // Cascade if needed
    @JsonManagedReference // Manage the serialization of the relationship

    private List<Airport> airports = new ArrayList<>(); // Initialize to avoid NullPointerException

    // Constructors
    public City() {
    }

    public City(String name, String province, int cityPopulation, int provincePopulation) {
        this.name = name;
        this.province = province;
        this.cityPopulation = cityPopulation;
        this.provincePopulation = provincePopulation;
    }

    // Getters and Setters
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(int cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public int getProvincePopulation() {
        return provincePopulation;
    }

    public void setProvincePopulation(int provincePopulation) {
        this.provincePopulation = provincePopulation;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }
}
