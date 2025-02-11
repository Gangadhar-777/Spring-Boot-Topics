package com.ganga.repos.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ganga.repos.entity.Employee;
import com.ganga.repos.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @GetMapping("/emp")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/empAsc")
    public List<Employee> getEmployeesByAsc() {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @GetMapping("/emp/{offset}/{pageSize}")
    public List<Employee> findProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Employee> emps = employeeRepository.findAll(PageRequest.of(offset, pageSize));
        return emps.getContent();
    }

    @GetMapping("/emps/{offset}/{pageSize}/{field}")
    public List<Employee> findProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,
            @PathVariable String field) {
        Page<Employee> emps = employeeRepository
                .findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.DESC, field)));
        return emps.getContent();

    }
}
