package com.ganga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganga.dao.EmployeeRepository;
import com.ganga.entities.Employee;
import com.ganga.exceptions.EmployeeAlreadyExistsException;
import com.ganga.exceptions.NoEmployeeException;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> employees() {
		return employeeRepository.findAll();
	}
	
	public Employee saveEmployee(Employee employee) {
		if(employee.getId() == null) {
			return employeeRepository.save(employee);
		} else {
			Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
			if(existingEmployee == null) {
				employeeRepository.save(employee);
				return employee;
			}			
			throw new EmployeeAlreadyExistsException("Employee Already Exists!");
		}
	}

	public Employee updateEmployee(Employee employee) {
		Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
		if(existingEmployee == null) {
			throw new NoEmployeeException("No Employee Exist With Id - "+ employee.getId());
		} else {
			existingEmployee.setName(employee.getName());
			existingEmployee.setEmail(employee.getEmail());
			existingEmployee.setPhoneNumber(employee.getPhoneNumber());
			existingEmployee.setDateOfJoining(employee.getDateOfJoining());
			existingEmployee.setGender(employee.getGender());
			existingEmployee.setSalary(employee.getSalary());
			existingEmployee.setStatus(employee.getStatus());
			employeeRepository.save(existingEmployee);
		}
		return existingEmployee;
		
	}

	public Employee deleteEmployee(Integer id) {
		Employee emp = employeeRepository.findById(id).orElseThrow(() -> new NoEmployeeException("Employee With ID - " + id + " Doesn't Exist!"));
		employeeRepository.delete(emp);
		return emp;
	}

	public Employee retireveEmployee(Integer id) {
		Employee emp = employeeRepository.findById(id)
				.orElseThrow(() -> new NoEmployeeException("No Customer Present With Id : " + id));
		return emp;
	}
}
