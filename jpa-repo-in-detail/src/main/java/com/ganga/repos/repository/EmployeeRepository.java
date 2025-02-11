package com.ganga.repos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.repos.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
