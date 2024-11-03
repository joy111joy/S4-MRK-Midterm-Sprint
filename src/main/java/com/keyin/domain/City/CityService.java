package com.keyin.domain.City;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCity() {
        return cityRepository.findAll();
    }

    public Optional<City> getCityById(Long id) {
        return cityRepository.findById(id);
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City updatedCity) {
        return cityRepository.findById(id).map(existingCity -> {
            if (updatedCity.getName() != null) {
                existingCity.setName(updatedCity.getName());
            }
            if (updatedCity.getProvince() != null) {
                existingCity.setProvince(updatedCity.getProvince());
            }
            if (updatedCity.getCityPopulation() != 0) {
                existingCity.setCityPopulation(updatedCity.getCityPopulation());
            }
            if (updatedCity.getProvincePopulation() != 0) {
                existingCity.setProvincePopulation(updatedCity.getProvincePopulation());
            }
            return cityRepository.save(existingCity);
        }).orElseThrow(() -> new EntityNotFoundException("City not found"));
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
