package com.wojciech.gaudnik.spock_test.ttd_by_pivotal;

import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.Car;
import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.repository.CarRepository;
import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.service.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//@RunWith(SpringRunner.class)  todo <--- JUnit 4
@ExtendWith(SpringExtension.class)  //todo <--- JUnit 5 <--- this is in SpringBootTest
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
//		classes = {CachingTest.class, CarService.class, CacheManager.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
//@ContextConfiguration
//@AutoConfigureCache
class CachingTest {

	@Autowired
	private CarService carService;

	@MockBean
	private CarRepository carRepository;

	@Autowired
	private CacheManager cacheManager;

	@Test
	@Order(1)
	void cachingOneWay() {
		given(carRepository.findByName(anyString())).willReturn(new Car("prius", "hybrid"));

		carService.getCarDetails("prius");
		carService.getCarDetails("prius");

		verify(carRepository, times(1)).findByName("prius");
	}

	@Test
	@Order(2)
	void cachingSecondWay() {
		given(carRepository.findByName(anyString())).willReturn(new Car("prius second", "hybrid"));

		Assertions.assertFalse(getCachedCar("prius second").isPresent());

		carService.getCarDetails("prius second");

		Assertions.assertTrue(getCachedCar("prius second").isPresent());
	}

	private Optional<Car> getCachedCar(String name) {
		return Optional.ofNullable(cacheManager.getCache("car")).map(car -> car.get(name, Car.class));
	}
}


