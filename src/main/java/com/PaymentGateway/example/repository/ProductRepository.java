package com.PaymentGateway.example.repository;

import com.PaymentGateway.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
