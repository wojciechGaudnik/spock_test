package com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model;

import lombok.Getter;

import javax.persistence.*;


@Getter
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class BaseEntity {
	@Id
	@GeneratedValue
	private Long id;
}
   
