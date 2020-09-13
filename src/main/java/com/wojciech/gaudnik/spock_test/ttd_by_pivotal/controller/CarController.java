package com.wojciech.gaudnik.spock_test.ttd_by_pivotal.controller;

import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.Car;

@RestController
public class CarController {

	private final CarService carService;

	public CarController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping("/cars/{name}")
	private Car getCar(@PathVariable String name) {
		return carService.getCarDetails(name);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	private void carNotFoundHandler(CarNotFoundException exception) {

	}
}
   
