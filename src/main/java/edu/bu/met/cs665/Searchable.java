package edu.bu.met.cs665;

import java.util.ArrayList;

/**
 * Name: Praveen Singh
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: Searchable.java
 * Description: This is the Searchable interface. Here the functions for searching the products and searching the
 * category are initialized.
 */
public interface Searchable {
    // Function to search for products by name
    public ArrayList<Product> searchProduct(String productName);
    // Function to search for products by category
    public ArrayList<Product> searchCategory(String categoryName);
}
