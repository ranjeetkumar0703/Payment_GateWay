package com.PaymentGateway.example.controller;

import com.PaymentGateway.example.entity.Product;
import com.PaymentGateway.example.repository.ProductRepository;
import com.PaymentGateway.example.service.PaymentService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payments")
public class PaymentController {

    @Value("${stripe.api.key}")
    private String stripeApiKey;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/initiate")
    public ResponseEntity<String>createPaymentIntent(@RequestParam Long productId) {
        Product product=productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        String paymentIntentId=paymentService.createPaymentIntent(product.getPaymentIntentId);

        return ResponseEntity.ok(paymentIntentId);
    }
}
