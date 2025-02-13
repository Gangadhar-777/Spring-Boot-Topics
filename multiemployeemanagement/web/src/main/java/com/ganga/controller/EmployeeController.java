package com.ganga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganga.entities.Employee;
import com.ganga.exceptions.EmployeeAlreadyExistsException;
import com.ganga.exceptions.ErrorResponse;
import com.ganga.exceptions.NoEmployeeException;
import com.ganga.services.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees() {
		return ResponseEntity.ok(empService.employees()); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
		var result = empService.retireveEmployee(id);
		return ResponseEntity.ok(result);
	}
    
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = empService.saveEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED)
					.body(savedEmployee);
	}
        
	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee updatedEmployee = empService.updateEmployee(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id) {
		var deletedEmployee = empService.deleteEmployee(id);
		return ResponseEntity.ok(deletedEmployee);
	}
	
	@ExceptionHandler(EmployeeAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException ex) {
		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.CONFLICT.value(),
				ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(NoEmployeeException.class)
	public ResponseEntity<ErrorResponse> handleNoEmployeeException(NoEmployeeException ex) {
		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}