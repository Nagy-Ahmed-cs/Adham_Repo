package com.Spring.CourseProject.Services;


import com.Spring.CourseProject.Dto.OrderDto;
import com.Spring.CourseProject.Entity.Order;
import com.Spring.CourseProject.Entity.Product;
import com.Spring.CourseProject.Entity.Sale;
import com.Spring.CourseProject.Repos.OrderRepo;
import com.Spring.CourseProject.Repos.SaleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepo salerepo;
    private final OrderService orderService;
    private final ProductService productService;
    private  final OrderRepo orderRepo;



    public Order makeOrder(List<OrderDto> orders) {
        if (orders.isEmpty()) {
            return null;
        }

        // Create new Order and save it first
        Order order= orderService.makeOrder(orders);


        // Process each order item and create Sale entries
        for (OrderDto o : orders) {
            Product product = productService.getProductById(o.getProductId());


            Sale sale = new Sale();
            sale.setOrder(order);  // Associate order with sale
            sale.setProduct(product);  // Associate product with sale
            salerepo.save(sale);
        }

        return order;
    }

    public List<Sale>getSales(){
        return salerepo.findAll();
    }
    public List<Sale>findAllByOrderId(Integer orderId){
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        return salerepo.findAllByOrder(order);
    }
}
