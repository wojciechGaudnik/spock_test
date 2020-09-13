package com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.repository;

import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest  //todo Jpa without any other MVC components
class CarRepositoryTest {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	void getCar_returnsCarDetails() throws Exception {
		var savedCar = entityManager.persistFlushFind(new Car("prius", "hybrid"));
		var car = carRepository.findByName("prius");
		Assertions.assertThat(car.getName()).isEqualTo(savedCar.getName());
	}
}