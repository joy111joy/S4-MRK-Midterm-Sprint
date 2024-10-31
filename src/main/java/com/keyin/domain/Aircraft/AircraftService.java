package com.keyin.domain.Aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;

    @Autowired
    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public List<Aircraft> getAllAircrafts() {
        return aircraftRepository.findAll();
    }

    public Optional<Aircraft> getAircraftById(Long id) {
        return aircraftRepository.findById(id);
    }

    public Aircraft addAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    public Aircraft updateAircraft(Long id, Aircraft updatedAircraft) {
        return aircraftRepository.findById(id)
                .map(existingAircraft -> {
                    // Update fields only if they are not null in the request
                    if (updatedAircraft.getAirline() != null) {
                        existingAircraft.setAirline(updatedAircraft.getAirline());
                    }
                    if (updatedAircraft.getModel() != null) {
                        existingAircraft.setModel(updatedAircraft.getModel());
                    }
                    if (updatedAircraft.getCapacity() != 0) {
                        existingAircraft.setCapacity(updatedAircraft.getCapacity());
                    }
                    if (updatedAircraft.getPassengers() != null && !updatedAircraft.getPassengers().isEmpty()) {
                        existingAircraft.setPassengers(updatedAircraft.getPassengers());
                    }
                    if (updatedAircraft.getAirports() != null && !updatedAircraft.getAirports().isEmpty()) {
                        existingAircraft.setAirports(updatedAircraft.getAirports());
                    }

                    return aircraftRepository.save(existingAircraft);
                })
                .orElseThrow(() -> new RuntimeException("Aircraft not found with id " + id));
    }

    public void deleteAircraft(Long id) {
        aircraftRepository.deleteById(id);
    }
}
