package com.ganga.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String email;

	private String phoneNumber;
	private LocalDate dateOfJoining;

	private String gender;

	private String status;

	private Long salary;

	public Employee() {

	}

	public Employee(String name, String email, String phoneNumber, LocalDate dateOfJoining, String gender,
			String status, Long salary) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfJoining = dateOfJoining;
		this.gender = gender;
		this.status = status;
		this.salary = salary;
	}

	public Employee(Integer id, String name, String email, String phoneNumber, LocalDate dateOfJoining, String gender,
			String status, Long salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfJoining = dateOfJoining;
		this.gender = gender;
		this.status = status;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", dateOfJoining=" + dateOfJoining + ", gender=" + gender + ", status=" + status + ", salary="
				+ salary + "]";
	}

}
