package com.example.springBoot_idempotent_payment_api.modules.payment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBoot_idempotent_payment_api.common.constants.AppConstants;
import com.example.springBoot_idempotent_payment_api.common.dto.ApiResponse;
import com.example.springBoot_idempotent_payment_api.modules.payment.service.PaymentService;

/**
 * Hello World controller demonstrating the boilerplate structure. Replace this with your actual
 * business controllers.
 */
@RestController
@RequestMapping(AppConstants.API_V1 + "/hello")
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /** Personalized greeting with path variable. Example: GET /api/v1/hello/John */
    @GetMapping("/{name}")
    public ResponseEntity<ApiResponse<String>> postPayment(@PathVariable String name) {
        logger.info("Personalized hello endpoint called for: {}", name);

        final String message = paymentService.postPayments(name);
        final ApiResponse<String> response = ApiResponse.success(message);

        return ResponseEntity.ok(response);
    }
}
