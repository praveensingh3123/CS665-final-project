package edu.bu.met.cs665;

import java.time.LocalDateTime;

/**
 * Name: Praveen Singh
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: Shipment.java
 * Description: This is the Shipment class. Here the function for moving the product to shipment is defined.
 */
public class Shipment {
    // Counter to generate unique shipment numbers
    private static int numberCounter = 0;
    // Unique shipment number
    private int shipmentNumber;
    // Date when the shipment was created
    private LocalDateTime date;
    // Estimated arrival date of the shipment
    private LocalDateTime estimatedArrival;
    // Details of the order associated with the shipment
    private Order orderDetails;

    // Constructor to initialize the shipment with order details
    public Shipment(Order orderDetails) {
        // Incrementing the counter to generate a unique shipment number
        numberCounter += 1;
        // Assigning the shipment number
        this.shipmentNumber = numberCounter;
        // Setting the shipment creation date to the current date and time
        this.date = LocalDateTime.now();
        // Calculating the estimated arrival date (3 days from the shipment date)
        this.estimatedArrival = this.date.plusDays(3);
        // Associating the order details with the shipment
        this.orderDetails = orderDetails;
        // Updating the order status to SHIPPED
        orderDetails.setOrderStatus(OrderStatus.SHIPPED);
    }

    // Override toString method to provide a string representation of the shipment
    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentNumber=" + shipmentNumber +
                ", dates='" + date + '\'' +
                ", estimatedArrival=" + estimatedArrival +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
