package com.Spring.CourseProject.Services;

import com.Spring.CourseProject.Dto.OrderDto;
import com.Spring.CourseProject.Entity.Order;
import com.Spring.CourseProject.Repos.OrderRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

   public Order makeOrder(List<OrderDto>orders){
       Double total=0.0;
       for(OrderDto o:orders){
           total+=o.getProductPrice();
       }
       Order order= new Order();
       order.setTotal(total);
       return orderRepo.save(order);
   }
   public List<Order>getOrders(){
       return orderRepo.findAll();
   }
}
