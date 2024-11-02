package com.keyin.domain.Airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Optional<Airport> getAirportById(Long id) {
        return airportRepository.findById(id);
    }

    public Airport addAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport updateAirport(Long id, Airport updatedAirport) {
        return airportRepository.findById(id)
                .map(existingAirport -> {
                    if (updatedAirport.getName() != null) {
                        existingAirport.setName(updatedAirport.getName());
                    }
                    if (updatedAirport.getIATA_code() != null) {
                        existingAirport.setIATA_code(updatedAirport.getIATA_code());
                    }
                    if (updatedAirport.getCity() != null) {
                        existingAirport.setCity(updatedAirport.getCity());
                    }
                    if (updatedAirport.getAircraft() != null && !updatedAirport.getAircraft().isEmpty()) {
                        existingAirport.setAircraft(updatedAirport.getAircraft());
                    }

                    return airportRepository.save(existingAirport);
                })
                .orElseThrow(() -> new RuntimeException("Airport not found with id " + id));
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}
