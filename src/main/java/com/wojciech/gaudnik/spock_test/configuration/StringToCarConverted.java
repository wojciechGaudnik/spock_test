//package com.wojciech.gaudnik.spock_test.configuration;
//
//import com.wojciech.gaudnik.spock_test.model.request.CarConverted;
//import com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model.Car;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//public class StringToCarConverted implements Converter<CarConverted, Car> {
//
//	@Override
//	public Car convert(CarConverted s) {
//		log.error(s + "<--- from Converter");
//		var car = new Car();
//		car.setName(s.toString());
//		return car;
//	}
//}
//
