package com.ganga.relationships.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.relationships.bientity.Customer1;
import com.ganga.relationships.bientity.Orders1;
import java.util.List;

public interface OrdersBiRepository extends JpaRepository<Orders1, Long> {
    List<Orders1> findByCustomer(Customer1 customer);
}
