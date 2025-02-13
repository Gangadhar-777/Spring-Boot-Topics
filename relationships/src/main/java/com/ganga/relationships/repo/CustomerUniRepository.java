package com.ganga.relationships.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.relationships.entity.Customer;

public interface CustomerUniRepository extends JpaRepository<Customer, Long> {

}
