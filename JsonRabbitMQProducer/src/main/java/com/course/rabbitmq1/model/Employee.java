package com.course.rabbitmq1.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.course.rabbitmq1.serializer.CustomLocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Employee {
	@JsonProperty("employee_id")
	private String employeeId;
	private String name;
	@JsonProperty("birth_date")
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	private LocalDate birthDate;
	public Employee(String employeeId, String name, LocalDate birthDate) {
		this.employeeId = employeeId;
		this.name = name;
		this.birthDate = birthDate;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
