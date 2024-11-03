package com.keyin.domain.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query("SELECT c.province, SUM(c.cityPopulation), COUNT(a) FROM City c LEFT JOIN c.airports a GROUP BY c.province HAVING SUM(c.provincePopulation) BETWEEN 900000 AND 1100000")
    List<Object[]> findProvincesWithPopulationAndAirports();

    @Query("SELECT c.name, c.province, c.cityPopulation, SUM(c2.cityPopulation) as provincePopulation FROM City c JOIN City c2 ON c.province = c2.province WHERE EXISTS (SELECT 1 FROM Airport a WHERE a.city = c) GROUP BY c.name, c.province, c.provincePopulation")
    List<Object[]> findCityProvincePopulationComparison();

    @Query("SELECT a.city.province, COUNT(a) FROM Airport a GROUP BY a.city.province HAVING COUNT(a) > 1")
    List<Object[]> findProvincesWithMultipleAirports();



    }
