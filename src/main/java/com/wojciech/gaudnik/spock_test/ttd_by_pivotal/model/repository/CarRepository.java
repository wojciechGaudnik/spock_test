package com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.repository;

import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
//public class CarRepository {
//	public Car findByName(String name) {
//		return null;
//	}
//}

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	public Car findByName(String prius);
}