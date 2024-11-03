package com.keyin.domain.Aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;

    @Autowired
    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public List<Aircraft> getAllAircraft() {
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
                    if (updatedAircraft.getStatus() != null && !updatedAircraft.getStatus().isEmpty()) {
                        existingAircraft.setStatus(updatedAircraft.getStatus());
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

    public LocalDate NextServiceDate(Aircraft aircraft) {
        if (aircraft.getLastServiceDate() == null) {
            return LocalDate.now().plusDays(30);
        } else {
            return aircraft.getLastServiceDate().plusDays(30);
        }
    }

    public void updateLastServiceDate(long aircraftId, LocalDate serviceDate) {
        Optional<Aircraft> optionalAircraft = aircraftRepository.findById(aircraftId);
        if (optionalAircraft.isPresent()) {
            Aircraft aircraft = optionalAircraft.get();
            aircraft.setLastServiceDate(serviceDate);
            aircraftRepository.save(aircraft);
        }
    }

    public Aircraft updateAircraftStatus(Long id, String status) {
        Optional<Aircraft> optionalAircraft = aircraftRepository.findById(id);
        if (optionalAircraft.isPresent()) {
            Aircraft aircraft = optionalAircraft.get();
            aircraft.setStatus(status);
            return aircraftRepository.save(aircraft);
        }
        return null;
    }

}
