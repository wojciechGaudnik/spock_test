package com.wojciech.gaudnik.spock_test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
public class Employee {

	public Employee(@Size(min = 3, max = 20) String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	@Size(min = 3, max = 20)
	private String name;

	@CreditCardNumber
	private String secondName;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String pass;

}
   
