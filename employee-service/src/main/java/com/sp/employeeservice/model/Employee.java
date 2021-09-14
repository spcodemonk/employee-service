package com.sp.employeeservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "phone_settings")
public class Employee {
	
	@Id
	private int id;
	private String name;
	
}
