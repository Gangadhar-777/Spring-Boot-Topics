package com.ganga.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ganga.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
