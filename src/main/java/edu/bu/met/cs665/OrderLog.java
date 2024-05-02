package edu.bu.met.cs665;

import java.util.Date;

/**
 * Name: Praveen Singh
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: OrderLog.java
 * Description: This is the OrderLog class. Here the date of order creating and order status are used to get the order
 * log for the orders.
 */
public class OrderLog {
    // Timestamp when the order log was created
    private Date creationTimestamp;
    // Status of the order at the time of creating the log
    private OrderStatus status;

    // Constructor to initialize an order log with creation timestamp and status
    public OrderLog(Date creationTimestamp, OrderStatus status) {
        this.creationTimestamp = creationTimestamp;
        this.status = status;
    }

    public Date getCreationTimestamp() {
        return creationTimestamp;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
