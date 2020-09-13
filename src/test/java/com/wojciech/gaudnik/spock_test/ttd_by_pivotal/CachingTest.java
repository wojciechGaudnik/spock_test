package com.wojciech.gaudnik.spock_test.ttd_by_pivotal;

import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.Car;
import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.repository.CarRepository;
import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//@RunWith(SpringRunner.class)  todo <--- JUnit 4
@ExtendWith(SpringExtension.class)  //todo <--- JUnit 5
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {CachingTest.class, CarService.class})
@AutoConfigureTestDatabase
@AutoConfigureCache
class CachingTest {

	@Autowired
	private CarService carService;

	@MockBean
	private CarRepository carRepository;

	@Test
	void caching() throws Exception {
		given(carRepository.findByName(anyString())).willReturn(new Car("prius", "hybrid"));

		carService.getCarDetails("prius");
		carService.getCarDetails("prius");

		verify(carRepository, times(2)).findByName("prius");

	}
}
   
