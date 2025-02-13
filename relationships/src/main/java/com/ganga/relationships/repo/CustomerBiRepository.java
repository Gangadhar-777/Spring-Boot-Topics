package com.ganga.relationships.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.relationships.bientity.Customer1;

public interface CustomerBiRepository extends JpaRepository<Customer1, Long> {

}
