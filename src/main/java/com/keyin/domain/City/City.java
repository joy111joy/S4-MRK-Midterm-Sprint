package com.keyin.domain.City;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.keyin.domain.Airport.Airport;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cityId")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    private String name;
    private String province;
    private int cityPopulation;
    private int provincePopulation;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Airport> airports = new ArrayList<>();

    public City() {
    }

    public City(String name, String province, int cityPopulation, int provincePopulation) {
        this.name = name;
        this.province = province;
        this.cityPopulation = cityPopulation;
        this.provincePopulation = provincePopulation;
    }

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
