package com.ganga.relationships.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ganga.relationships.entity.Orders;

public interface OrdersUniRepository extends JpaRepository<Orders, Long> {
    @Query("SELECT o FROM Orders o WHERE o.id IN(SELECT o.id FROM Customer c JOIN c.orders o WHERE c.id = :customerId)")
    List<Orders> findByCustomer(Long customerId);
}
