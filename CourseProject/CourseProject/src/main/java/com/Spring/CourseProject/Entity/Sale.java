package com.Spring.CourseProject.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Sales")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="saleId")
    private Integer saleId;
    @Column(name="orderId")
    private Integer orderId;
    @Column(name="productId")
    private Integer productId;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="orderId",insertable = false,updatable = false)
    private Order order;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="productId",insertable = false,updatable = false)
    private Product product;


}
