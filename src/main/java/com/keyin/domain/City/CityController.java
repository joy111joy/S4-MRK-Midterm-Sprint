package com.keyin.domain.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getAllCity() {
        return cityService.getAllCity();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        return cityService.getCityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public City addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }

    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/json;charset=UTF-8" })
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City updatedCity) {

        System.out.println("Updating city with ID: " + id);
        System.out.println("Updated City: " + updatedCity);

        Optional<City> existingCity = cityService.getCityById(id);
        if (existingCity.isPresent()) {
            City updated = cityService.updateCity(id, updatedCity);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }
}
