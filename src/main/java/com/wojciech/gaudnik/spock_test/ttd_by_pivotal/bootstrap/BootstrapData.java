package com.wojciech.gaudnik.spock_test.ttd_by_pivotal.bootstrap;

import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.Car;
import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class BootstrapData implements CommandLineRunner {

	final CarRepository carRepository;

	public BootstrapData(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		var car1 = new Car("prius", "hybrid");
		carRepository.save(car1);
	}
}
   
