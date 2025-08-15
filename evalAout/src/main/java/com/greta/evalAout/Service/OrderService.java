package com.greta.evalAout.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greta.evalAout.Dtos.OrderDTO;
import com.greta.evalAout.Entity.Order;
import com.greta.evalAout.Repositories.OrderRepositories;

@Service
public class OrderService {
    
    private final OrderRepositories orderRepositories;

    public OrderService(OrderRepositories orderRepositories) {
        this.orderRepositories = orderRepositories;
    }

    public Order getOrderById(Long orderId) {
        return orderRepositories.findByOrderId(orderId)
        .stream().findFirst().orElseThrow(() -> new RuntimeException("Commande non trouvé"));
    }

    public List<Order> getAllOrder() {
        return orderRepositories.findAll();
    }

    public List<Order> searchOrder(Long orderId) {
        return orderRepositories.findByOrderId(orderId);
    }

    public List<Order> deleteOrder(Long orderId) {
        orderRepositories.deleteById(orderId);
        return orderRepositories.findAll();
    }

    public Order updateOrder(Long orderId, OrderDTO dto) {
        Order order = orderRepositories.findById(orderId)
        .orElseThrow(() -> new RuntimeException("Commande non trouvé"));
        order.setDate(dto.getDate());
        order.setCartPrice(dto.getCartPrice());
        order.setProductNumber(dto.getProductNumber());
        return orderRepositories.save(order);
    }

    public Order createOrder(OrderDTO dto) {
        Order order = new Order();
        order.setDate(dto.getDate());
        order.setCartPrice(dto.getCartPrice());
        order.setProductNumber(dto.getProductNumber());
        return orderRepositories.save(order);
    }
}
