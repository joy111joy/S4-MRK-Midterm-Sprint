package com.keyin.domain.Passenger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    Long PassengerCountForAirport(String airportCode);
}