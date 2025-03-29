package com.Spring.CourseProject.Controller;

import com.Spring.CourseProject.Entity.Product;
import com.Spring.CourseProject.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productservice;
    @PostMapping("/insert-product")
    public Product addProduct(@RequestBody Product product){
        return productservice.addProduct(product);
    }
    @GetMapping("/delete-product")
    public String delete(@RequestParam Integer id){
        productservice.delete(id);
        return "Deleted Successfully ....";
    }

    @GetMapping("/get-products")
    public List<Product>getProducts(){
        return productservice.getProducts();
    }
    @GetMapping("/update-product")
    public String update(@RequestBody Product product){
        productservice.update(product);
        return "Updated\n";
    }
    @GetMapping("/get-product-id")
    public Product getProductById(@RequestParam Integer id){
        return productservice.getProductById(id);
    }
    @GetMapping("/find-barcode")
    public Product findByBarCode(@RequestParam String barcode){
        return productservice.findByBarCode(barcode);
    }
}
