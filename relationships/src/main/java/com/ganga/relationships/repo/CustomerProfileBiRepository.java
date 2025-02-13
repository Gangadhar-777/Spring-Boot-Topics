package com.ganga.relationships.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.relationships.bientity.CustomerProfile1;

public interface CustomerProfileBiRepository extends JpaRepository<CustomerProfile1, Long> {

}
