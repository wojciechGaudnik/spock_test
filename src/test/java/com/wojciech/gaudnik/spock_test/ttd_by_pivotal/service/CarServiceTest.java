package com.wojciech.gaudnik.spock_test.ttd_by_pivotal.service;

import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.controller.CarNotFoundException;
import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.Car;
import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class) //TODO pure Unite test without Spring at all
class CarServiceTest {

	@Mock
	private CarRepository carRepository;

	private CarService carService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		carService = new CarService(carRepository);
	}

	@Test
	void getCarDetails_returnCarInfo() {
		given(carRepository.findByName("prius")).willReturn(new Car("prius", "hybrid"));
		Car car = carService.getCarDetails("prius");

		assertThat(car.getName()).isEqualTo("prius");
		assertThat(car.getType()).isEqualTo("hybrid");
	}

	@Test
	void getCarDetails_whenCarNotFound() throws Exception {
		given(carRepository.findByName("prius")).willReturn(null);

		Assertions.assertThrows(CarNotFoundException.class, () -> carService.getCarDetails("prius"));
	}
}