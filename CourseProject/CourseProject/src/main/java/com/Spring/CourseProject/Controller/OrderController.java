package com.Spring.CourseProject.Controller;

import com.Spring.CourseProject.Dto.OrderDto;
import com.Spring.CourseProject.Entity.Order;
import com.Spring.CourseProject.Services.OrderService;
import com.Spring.CourseProject.Services.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {


   private final OrderService orderservice;
    private final SaleService saleService;
    @GetMapping("/make-order")
    public Order makeOrder(@RequestBody  List<OrderDto>orders){
        return saleService.makeOrder(orders);
    }
    @GetMapping("/get-orders")
    public List<Order>getOrders(){
        return orderservice.getOrders();
    }

}
