package com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model;

import lombok.*;

import javax.persistence.Entity;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Car extends BaseEntity{
	private String name;
	private String type;

}
   
