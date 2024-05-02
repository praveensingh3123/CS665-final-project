package edu.bu.met.cs665;

/**
 * Name: Praveen Singh
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: Item.java
 * Description: This is the Item class. Here the functions to get item price and update item count is defined.
 */
public class Item {
    // Unique identifier for the product
    private int productId;
    // Count of the items
    private int count;
    // Price of the item
    private double price;

    private String name;

    // Constructor to initialize an item with a product and count
    public Item(Product product, int count) {
        this.name = product.getName();
        this.productId = product.getId();
        this.count = count;
        this.price = product.getPrice() * count;
    }

    // Function to get the price of the item
    public double getPrice() {
        return price;
    }

    // Override toString method to provide a string representation of the item
    @Override
    public String toString() {
        return "Item{" +
                "productId=" + productId +
                ", productName=" + name +
                ", count=" + count +
                ", price=" + price +
                '}';
    }

    // Function to update the count of the item
    public void updateCount(int newCount) {
        price = (price / count) * newCount;
        count = newCount;
    }

    public int getCount() {
        return count;
    }
}
