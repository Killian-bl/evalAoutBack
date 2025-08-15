package com.greta.evalAout.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greta.evalAout.Dtos.OrderDTO;
import com.greta.evalAout.Entity.Order;
import com.greta.evalAout.Service.OrderService;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/api/order")
public class OrderController {
    
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/search")
    public ResponseEntity<List<Order>> searchOrder(@RequestParam Long orderId) {
        List<Order> order = orderService.searchOrder(orderId);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{orderId}/order")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return  ResponseEntity.noContent().build();
    }

    @PutMapping("order/{orderId}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long orderId, @Valid @RequestBody OrderDTO dto) {
        Order updated = orderService.updateOrder(orderId, dto);
        return ResponseEntity.ok(new OrderDTO(updated));
    }

    @PostMapping("/order")
    public ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderDTO dto) {
        Order order = orderService.createOrder(dto);
        return ResponseEntity.ok(new OrderDTO(order));
    }
    
    
}
