package com.example.springBoot_idempotent_payment_api.unit.payment.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.springBoot_idempotent_payment_api.modules.payment.service.impl.PaymentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for HelloService.
 *
 * <p>This demonstrates: - Pure unit testing without Spring context - Testing business logic in
 * isolation - Input validation testing - Exception testing
 *
 * <p>Use this pattern for testing your service classes.
 */
class PaymentServiceTest {

    private PaymentServiceImpl paymentService;

    @BeforeEach
    void setUp() {
        paymentService = new PaymentServiceImpl();
    }

    @Test
    void getPersonalizedGreeting_WithValidName_ShouldReturnPersonalizedMessage() {
        // Given
        String name = "Developer";

        // When
        String result = paymentService.postPayments(name);

        // Then
        assertNotNull(result);
        assertTrue(result.contains("Hello, Developer!"));
        assertTrue(result.contains("Welcome to our API!"));
    }

    @Test
    void getPersonalizedGreeting_WithNullName_ShouldThrowException() {
        // When & Then
        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> paymentService.postPayments(null));

        assertEquals("Name cannot be empty", exception.getMessage());
    }

    @Test
    void getPersonalizedGreeting_WithEmptyName_ShouldThrowException() {
        // When & Then
        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> paymentService.postPayments("   "));

        assertEquals("Name cannot be empty", exception.getMessage());
    }

    // TODO: Add more unit tests as you develop features
    // Examples:
    // - Test complex business logic calculations
    // - Test data transformations
    // - Mock external dependencies (repositories, HTTP clients)
    // - Test edge cases and boundary conditions
}
