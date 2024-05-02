package edu.bu.met.cs665;

/**
 * Name: Praveen Singh
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: Category.java
 * Description: This is the Category class. Here the category name and description are defined and the function for
 * getting the category name is defined.
 */
public class Category {
    // Name of the category
    private String name;
    // Description of the category
    private String description;

    // Constructor to initialize the category with a name
    public Category(String name) {
        this.name = name;
    }

    // Function to get the name of the category
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name; // Assuming categoryName is a field in the Category class
    }
}
