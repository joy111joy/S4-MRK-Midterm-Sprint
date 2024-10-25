package com.keyin.domain.Airport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    @Query("SELECT a.city.province, COUNT(a) FROM Airport a GROUP BY a.city.province HAVING COUNT(a) > 1")
    List<Object[]> findProvincesWithMultipleAirports();

}
