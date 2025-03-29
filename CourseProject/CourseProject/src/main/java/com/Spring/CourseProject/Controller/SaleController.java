package com.Spring.CourseProject.Controller;

import com.Spring.CourseProject.Entity.Sale;
import com.Spring.CourseProject.Services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class SaleController {
    @Autowired
    private SaleService saleservice;
    @GetMapping("/get-sales")
    public List<Sale> getSales(){
        return saleservice.getSales();
    }
    @GetMapping("/get-sale-by-order-id")
    public List<Sale>  findAllByOrderId(@RequestParam Integer orderId){
        return saleservice.findAllByOrderId(orderId);
    }
}
