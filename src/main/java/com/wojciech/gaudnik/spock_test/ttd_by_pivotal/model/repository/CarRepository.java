package com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.repository;

import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	Car findByName(String prius);
}