package com.epam.repair.exception;

/**
 * The type Order not found exception.
 */
public class OrderNotFoundException extends RuntimeException {
    private static final String ORDER_NOT_FOUND = "Order not found for this id: ";

    /**
     * Instantiates a new Order not found exception.
     *
     * @param repairOrderId the repair order id
     */
    public OrderNotFoundException(Integer repairOrderId) {
        super(ORDER_NOT_FOUND + repairOrderId);
    }
}