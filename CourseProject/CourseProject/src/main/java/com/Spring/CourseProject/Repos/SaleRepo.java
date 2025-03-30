package com.Spring.CourseProject.Repos;

import com.Spring.CourseProject.Entity.Order;
import com.Spring.CourseProject.Entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SaleRepo extends JpaRepository<Sale,Integer> {

    List<Sale> findAllByOrder(Order order);

}
