package com.Spring.CourseProject.Repos;

import com.Spring.CourseProject.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    Product findByBarCode(String barCode);
}
