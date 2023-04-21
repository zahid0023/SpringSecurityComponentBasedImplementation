package com.example.tacos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public ResponseEntity<String> currentOrder(){
        return null;
    }

    @PostMapping
    public ResponseEntity<Order> processOrder(Order order, SessionStatus sessionStatus){
        orderRepository.save(order);
        sessionStatus.setComplete();
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
