package com.Spring.CourseProject.Controller;

import com.Spring.CourseProject.Dto.OrderDto;
import com.Spring.CourseProject.Entity.Order;

import com.Spring.CourseProject.Entity.Sale;
import com.Spring.CourseProject.Services.OrderService;

import com.Spring.CourseProject.Services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderservice;
    @Autowired
    private SaleService saleService;
    @GetMapping("/make-order")
    public Order makeOrder(@RequestBody  List<OrderDto>orders){
        return saleService.makeOrder(orders);
    }
    @GetMapping("/get-orders")
    public List<Order>getOrders(){
        return orderservice.getOrders();
    }

}
