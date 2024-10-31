package com.keyin.domain.Aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aircraft")
public class AircraftController {

    private final AircraftService aircraftService;

    @Autowired
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping
    public List<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircrafts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable Long id) {
        return aircraftService.getAircraftById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aircraft addAircraft(@RequestBody Aircraft aircraft) {
        return aircraftService.addAircraft(aircraft);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Aircraft> updateAircraft(@PathVariable Long id, @RequestBody Aircraft updatedAircraft) {
        Optional<Aircraft> existingAircraft = aircraftService.getAircraftById(id);
        if (existingAircraft.isPresent()) {
            Aircraft updated = aircraftService.updateAircraft(id, updatedAircraft);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable Long id) {
        Optional<Aircraft> aircraft = aircraftService.getAircraftById(id);
        if (aircraft.isPresent()) {
            aircraftService.deleteAircraft(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
