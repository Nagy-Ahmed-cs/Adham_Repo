package com.Spring.CourseProject.Services;


import com.Spring.CourseProject.Entity.Order;
import com.Spring.CourseProject.Entity.Sale;
import com.Spring.CourseProject.Dto.OrderDto;
import com.Spring.CourseProject.Repos.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    SaleRepo salerepo;
    private final OrderService orderService;
    public SaleService(OrderService orderService){
         this.orderService=orderService;
    }

    public Order makeOrder(List<OrderDto>orders){
        if(orders.isEmpty()){
            return null ;
        }
        Order order= orderService.makeOrder(orders);
        for(OrderDto o : orders){
            Sale sale= new Sale();
            sale.setOrderId(order.getOrderId());

            sale.setProductId(o.getProductId());
            salerepo.save(sale);
        }
        return order;
    }
    public List<Sale>getSales(){
        return salerepo.findAll();
    }
    public List<Sale>findAllByOrderId(Integer orderId){
       return salerepo.findAllByOrderId(orderId);
    }
}
