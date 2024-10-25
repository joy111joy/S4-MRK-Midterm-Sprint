package com.keyin.domain.City;

import com.keyin.domain.Airport.Airport;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    private String name;
    private String city;
    private String province;  // Removed static
    private int city_pop;
    private int province_pop;  // Removed static

    @OneToMany(mappedBy = "city")  // Changed to match the field in Airport
    private List<Airport> airports;

    // No-args constructor
    public City() {
    }

    public City(Long cityId, String name, String city, String province, int city_pop, int province_pop) {
        this.cityId = cityId;
        this.name = name;
        this.city = city;
        this.province = province;  // Changed to instance variable
        this.city_pop = city_pop;
        this.province_pop = province_pop;  // Changed to instance variable
    }

    // Corrected method name
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;  // Changed to instance variable
    }

    public int getCity_pop() {
        return city_pop;
    }

    public void setCity_pop(int city_pop) {
        this.city_pop = city_pop;
    }

    public int getProvince_pop() {
        return province_pop;
    }

    public void setProvince_pop(int province_pop) {
        this.province_pop = province_pop;  // Changed to instance variable
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }
}
