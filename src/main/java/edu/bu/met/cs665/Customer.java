package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.Date;

/**
 * Name: Praveen Singh
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: Customer.java
 * Description: This is the Customer class. Here the functions for adding item to the cart, removing item from the cart,
 * printing cart items, update item count, placing the order, getting order history and getting the current order is
 * defined.
 */
public class Customer extends User {
    // Cart instance to manage items for the customer
    private Cart cart;
    // Current order being processed
    private Order currentOrder;
    // List to store order history
    private ArrayList<Order> orderHistory;

    // Constructor to initialize a customer with name, phone, cart, and order history
    public Customer(String name, String phone) {
        super(name, phone);
        cart = new Cart();
        orderHistory = new ArrayList<>();
    }

    // Function to add an item to the customer's cart
    public void addItemToCart(Item item) {
        this.cart.addItem(item);
    }

    // Function to remove an item from the customer's cart
    public void removeItemFromCart(Item item) {
        this.cart.removeItem(item);
    }

    // Function to print the items in the customer's cart
    public void printCartItems() {
        System.out.println(this.cart.getItemList());
    }

    // Function to update the quantity of an item in the customer's cart
    public void updateItemCount(Item item, int newQuantity) {
        this.cart.updateItemCount(item, newQuantity);
    }

    // Function to place an order
    public void placeOrder() {
        currentOrder = new Order();
        currentOrder.setOrderStatus(OrderStatus.UNSHIPPED);
        currentOrder.setOrderDate(new Date());
        ArrayList<Item> orderedItems = this.cart.getItemList();
        double orderAmount = 0;
        // Calculate total order amount
        for (Item item : orderedItems) {
            orderAmount += item.getPrice();
        }
        // Set order details
        currentOrder.setItems(orderedItems);
        currentOrder.setAmount(orderAmount);
        currentOrder.setShippingAddress(this.getAddress());
        this.cart.checkout();
        this.orderHistory.add(currentOrder);
        System.out.println("Your order is placed!");
    }

    // Function to get the order history of the customer
    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    // Function to get the current order of the customer
    public Order getCurrentOrder() {
        return currentOrder;
    }

    public Cart getCart() {
        return cart;
    }
}
