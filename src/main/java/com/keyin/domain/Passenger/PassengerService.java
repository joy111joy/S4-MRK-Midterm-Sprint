package com.keyin.domain.Passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<Passenger> getAllPassenger() {
        return passengerRepository.findAll();
    }

    public Optional<Passenger> getPassengerById(Long id) {
        return passengerRepository.findById(id);
    }

    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger updatedPassenger) {
        return passengerRepository.findById(id)
                .map(existingPassenger -> {
                    // Update fields only if they are not null in the request
                    if (updatedPassenger.getFirstName() != null) {
                        existingPassenger.setFirstName(updatedPassenger.getFirstName());
                    }
                    if (updatedPassenger.getLastName() != null) {
                        existingPassenger.setLastName(updatedPassenger.getLastName());
                    }
                    if (updatedPassenger.getEmail() != null) {
                        existingPassenger.setEmail(updatedPassenger.getEmail());
                    }
                    if (updatedPassenger.getPhoneNumber() != null) {
                        existingPassenger.setPhoneNumber(updatedPassenger.getPhoneNumber());
                    }
                    if (updatedPassenger.getCity() != null) {
                        existingPassenger.setCity(updatedPassenger.getCity());
                    }
                    if (updatedPassenger.getAircraft() != null && !updatedPassenger.getAircraft().isEmpty()) {
                        existingPassenger.setAircraft(updatedPassenger.getAircraft());
                    }

                    return passengerRepository.save(existingPassenger);
                })
                .orElseThrow(() -> new RuntimeException("Passenger not found with id " + id));
    }


    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
