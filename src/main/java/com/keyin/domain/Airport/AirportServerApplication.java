package com.keyin.domain.Airport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.keyin.domain.City", "com.keyin.domain.Airport", "com.keyin.domain.Aircraft", "com.keyin.domain.Passenger"})  // Entity scanning
public class AirportServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AirportServerApplication.class, args);
    }
}
