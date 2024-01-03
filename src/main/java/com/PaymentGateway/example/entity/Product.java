package com.PaymentGateway.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data
public class Product {


    public double getPaymentIntentId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    private Long productId;

    private  String name;
    private String description;
    private double price;
}
