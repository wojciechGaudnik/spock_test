package com.wojciech.gaudnik.spock_test.ttd_by_pivotal.model;

import lombok.Getter;

import javax.persistence.*;


@Getter
// Choose your inheritance strategy:
//@Inheritance(strategy=InheritanceType.JOINED)
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class BaseEntity {
	@Id
	@GeneratedValue
	private Long id;
}
   
