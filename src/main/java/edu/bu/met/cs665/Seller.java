package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: Praveen Singh
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: Seller.java
 * Description: This is the Seller class. Here the functions for registering the products, updating product quantity
 * and removing the products are defined.
 */
public class Seller {
    private final String name;
    // List of products associated with the seller
    private ArrayList<Product> products;

    // Constructor to initialize the Seller with a name and phone number
    public Seller(String name, String phone) {
        // Call to super() is unnecessary here as Seller doesn't have a superclass
        products = new ArrayList<>();
        this.name = name;
    }

    // Function to register a product with the seller
    public void registerProduct(ProductsCatalog productsCatalog, Product product) {
        // Set the seller of the product
        product.setSeller(this);
        // Add the product to the catalog
        productsCatalog.addProduct(product);
        // Add the product to the seller's list of products
        products.add(product);
    }

    // Function to update the quantity of a product associated with the seller
    public void updateProductQuantity(ProductsCatalog productsCatalog, Product product, int newQuantity) {
        // Update the quantity of the product in the catalog
        productsCatalog.updateProductQuantity(product, newQuantity);
    }

    // Function to remove a product associated with the seller
    public void removeProduct(ProductsCatalog productsCatalog, Product product) {
        // Remove the product from the catalog
        productsCatalog.removeProduct(product);
        // Remove the product from the seller's list of products
        products.remove(product);
    }
    @Override
    public String toString() {
        return name; // Assuming sellerName is a field in the Seller class
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
