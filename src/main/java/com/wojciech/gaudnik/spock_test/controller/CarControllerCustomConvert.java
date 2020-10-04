package com.wojciech.gaudnik.spock_test.controller;

import com.wojciech.gaudnik.spock_test.model.request.CarConverted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/cars")
public class CarControllerCustomConvert {

	@GetMapping
	public String get() {
		return "hello";
	}

	@PostMapping
	public CarConverted add(@RequestBody CarConverted carConverted) {
		log.error(String.valueOf(carConverted));
//		carConverted.setHorsePower(carConverted.getHorsePower() + 100);
		return carConverted;
	}
}

