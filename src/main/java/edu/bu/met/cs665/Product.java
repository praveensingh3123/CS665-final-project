package edu.bu.met.cs665;

/**
 * Name: Praveen Singh
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: Product.java
 * Description: This is the Product class. Here the functions to getId, getName, getDescription, getPrice, getRatings,
 * getCategory, getAvailableCount, setSeller and getSeller is defined.
 */
public class Product {
    // Counter to generate unique IDs for products
    private static int idCounter = 0;
    // Unique identifier for the product
    private int id;
    // Name of the product
    private String name;
    // Description of the product
    private String description;
    // Price of the product
    private double price;
    // Ratings of the product
    private double ratings;
    // Category of the product
    private Category category;
    // Available count of the product
    private int availableCount;
    // Seller of the product
    private Seller seller;

    // Constructor to initialize a product with name, description, price, category, and available count
    public Product(String name, String description, double price,
                   Category category, int availableCount) {
        idCounter += 1;
        this.id = idCounter;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.availableCount = availableCount;
    }

    // Function to get the ID of the product
    public int getId() {
        return id;
    }

    // Function to get the name of the product
    public String getName() {
        return name;
    }

    // Function to get the description of the product
    public String getDescription() {
        return description;
    }

    // Function to get the price of the product
    public double getPrice() {
        return price;
    }

    // Function to get the ratings of the product
    public double getRatings() {
        return ratings;
    }

    // Function to get the category of the product
    public Category getCategory() {
        return category;
    }

    // Function to get the available count of the product
    public int getAvailableCount() {
        return availableCount;
    }

    // Function to set the seller of the product
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    // Function to set the available count of the product
    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    // Function to get the seller of the product
    public Seller getSeller() {
        return seller;
    }

    // Override toString method to provide a string representation of the product
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", ratings=" + ratings +
                ", category=" + category +
                ", availableCount=" + availableCount +
                ", seller=" + seller +
                '}';
    }
}
