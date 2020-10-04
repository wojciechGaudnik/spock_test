//package com.wojciech.gaudnik.spock_test.configuration;
//
//import com.wojciech.gaudnik.spock_test.model.request.CarConverted;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//
//@Slf4j
//@Component
//public class StringToCar implements Converter<String, CarConverted> {
//
//	@Override
//	public CarConverted convert(String s) {
//		return CarConverted.builder().name("from custom conver").build();
//	}
//}
//
