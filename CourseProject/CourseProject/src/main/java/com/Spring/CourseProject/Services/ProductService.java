package com.Spring.CourseProject.Services;

import com.Spring.CourseProject.Entity.Product;
import com.Spring.CourseProject.Repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productrepo;
    public Product addProduct(Product product){
        return productrepo.save(product);
    }
    public void delete(Integer id){
        productrepo.deleteById(id);
    }
    public List<Product>getProducts(){
        return productrepo.findAll();
    }
    public void update(Product product){
        productrepo.save(product);
    }
    public Product getProductById(Integer id){
        Optional<Product>product= productrepo.findById(id);
        return product.orElse(new Product());
    }
    public Product findByBarCode(String barcode){
         Optional<Product>product= Optional.ofNullable(productrepo.findByBarCode(barcode));
         return product.orElse(null);
    }
}
