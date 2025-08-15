package com.greta.evalAout.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greta.evalAout.Entity.Order;

public interface  OrderRepositories extends JpaRepository<Order, Long>{
    List<Order> findByOrderId(Long orderId);
}
