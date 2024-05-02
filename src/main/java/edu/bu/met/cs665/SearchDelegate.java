package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Name: Praveen Singh
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: SearchDelegate.java
 * Description: This is the SearchDelegate class. Here the functions for searching products and searching the categories
 * are defined. It also implements the Searchable interface.
 */
class SearchDelegate {
    // Mapping of similar product names to a list of similar products
    private ConcurrentHashMap<String, ArrayList<Product>> similarProducts;
    // Mapping of category names to products in that category
    private HashMap<String, ArrayList<Product>> categoryProductMap;

    // Constructor to initialize the SearchDelegate with mappings
    public SearchDelegate(ConcurrentHashMap<String, ArrayList<Product>> similarProducts,
                          HashMap<String, ArrayList<Product>> categoryProductMap) {
        this.similarProducts = similarProducts;
        this.categoryProductMap = categoryProductMap;
    }

    // Function to search for products by name
    public ArrayList<Product> searchProduct(String productName) {
        return similarProducts.getOrDefault(productName.toLowerCase(), new ArrayList<>());
    }

    // Function to search for products by category
    public ArrayList<Product> searchCategory(String categoryName) {
        return categoryProductMap.getOrDefault(categoryName.toLowerCase(), new ArrayList<>());
    }
}
