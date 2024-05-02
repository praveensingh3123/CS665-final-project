package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Name: Praveen Singh
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: Order.java
 * Description: This is the Order class. Here the functions to move items to shipment, add order logs, set order status,
 * set order date, set items, set amount and set shipping address is defined.
 */
public class Order {
    // Counter to generate unique order numbers
    private static int numberCounter = 0;
    // Unique order number
    private int orderNumber;
    // Current status of the order
    private OrderStatus orderStatus;
    // Date when the order was placed
    private Date orderDate;
    // List of items in the order
    private ArrayList<Item> items;
    // Total amount of the order
    private double amount;
    // Shipping address for the order
    private String shippingAddress;
    // List to store order logs
    private ArrayList<OrderLog> orderLogs;

    // Constructor to initialize an order with a unique number, order logs, and set initial status as CREATED
    public Order() {
        numberCounter += 1;
        this.orderNumber = numberCounter;
        orderLogs = new ArrayList<>();
        addOrderLog(new OrderLog(new Date(), OrderStatus.CREATED));
    }

    // Function to move the order to shipment
    public Shipment moveToShipment() {
        Shipment shipment = new Shipment(this);
        return shipment;
    }

    // Function to add an order log
    public void addOrderLog(OrderLog orderLog) {
        orderLogs.add(orderLog);
    }

    // Function to set the status of the order
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        addOrderLog(new OrderLog(new Date(), orderStatus));
    }

    // Function to set the date of the order
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    // Function to set the items in the order
    public void setItems(ArrayList<Item> items) {
        // Create a new list to avoid modifying the original list
        this.items = new ArrayList<>(items);
    }

    // Function to set the total amount of the order
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Function to set the shipping address for the order
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    // Override toString method to provide a string representation of the order
    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", orderStatus=" + orderStatus +
                ", orderDate=" + orderDate +
                ", items=" + items +
                ", amount=" + amount +
                ", shippingAddress='" + shippingAddress + '\'' +
                '}';
    }

    public Collection<OrderLog> getOrderLogs() {
        return orderLogs;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getAmount() {
        return amount;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }
}
