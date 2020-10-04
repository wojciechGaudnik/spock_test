//package com.wojciech.gaudnik.spock_test.configuration;
//
//import com.wojciech.gaudnik.spock_test.model.request.CarConverted;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.core.convert.converter.ConverterFactory;
//import org.springframework.stereotype.Component;
//
//
//@Slf4j
//@Component
//public class StringToCar implements ConverterFactory<String, CarConverted> {
//
//	private static class StringToCarConverted<T extends CarConverted> implements Converter<String, T> {
//
//		private Class<T> car;
//
//		public StringToCarConverted(Class<T> aClass) {
//			this.car = aClass;
//		}
//
//		@Override
//		public T convert(String s) {
//			log.error("-----------");
//			log.error(s);
//			return CarConverted.builder().horsePower(666).build();
//		}
//	}
//
//
//	@Override
//	public <T extends CarConverted> Converter<String, T> getConverter(Class<T> aClass) {
//		return new StringToCarConverted<>(aClass);
//	}
//}
//
