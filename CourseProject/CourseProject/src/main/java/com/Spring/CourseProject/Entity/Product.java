package com.Spring.CourseProject.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.processing.Exclude;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="productId")
    private Integer productId;

    @Column(name="productName")
    private String productName;

    @Column(name="productPrice")
    private Double productPrice;

    @Column(name="barCode")
    private String barCode;


    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<Sale>sales;


}
