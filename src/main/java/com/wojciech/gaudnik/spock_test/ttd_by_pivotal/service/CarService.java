package com.wojciech.gaudnik.spock_test.ttd_by_pivotal.service;

import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.controller.CarNotFoundException;
import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.Car;
import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {


	private final CarRepository carRepository;

	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public Car getCarDetails(String name) {
		var car = carRepository.findByName(name);
		if (car == null) {
			throw new CarNotFoundException();
		}
		return car;
	}
}
   
