package com.wojciech.gaudnik.spock_test.model.request;

import com.wojciech.gaudnik.spock_test.model.Employee;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CarConverted {
	private final String name;
	private Integer horsePower;
	private Employee employee;
}
   
