//package com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class CarTest {
//
//	@Autowired
//	private TestRestTemplate restTemplate;
//
//	@Test
//	void getCar_returnCarDetails() throws Exception {
//		//arange
//
//		//act
//		ResponseEntity<Car> response = restTemplate.getForEntity("/cars/prius", Car.class);
//
//		//assert
//		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//		assertThat(response.getBody().getName()).isEqualTo("prius");
//		assertThat(response.getBody().getType()).isEqualTo("prius");
//	}
//
//}