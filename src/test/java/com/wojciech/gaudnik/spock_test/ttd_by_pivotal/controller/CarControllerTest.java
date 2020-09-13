package com.wojciech.gaudnik.spock_test.ttd_by_pivotal.controller;

import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.Car;
import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CarController.class)
class CarControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CarService carService;

	@Test
	void getCar_ShouldReturnCar() throws Exception {
		given(carService.getCarDetails(anyString())).willReturn(new Car("prius", "hybrid"));


		mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("name").value("prius"))
				.andExpect(jsonPath("type").value("hybrid"));
	}

	@Test
	void gatCar_notFound() throws Exception {
		given(carService.getCarDetails(anyString())).willThrow(new CarNotFoundException());

		mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
		.andExpect(status().isNotFound());
	}
}
   
