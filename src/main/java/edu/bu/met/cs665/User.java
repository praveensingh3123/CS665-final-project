package edu.bu.met.cs665;

/**
 * Name: Praveen Singh
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: User.java
 * Description: This is the User class. Here the functions for getting the name, address, and phone number of the users
 * are defined.
 */
public class User {
    // Unique identifier for the user
    private int id;
    // Name of the user
    private String name;
    // Address of the user
    private String address;
    // Username of the user (not used in this implementation)
    private String username;
    // Password of the user (not used in this implementation)
    private String password;
    // Phone number of the user
    private String phone;

    // Constructor to initialize the user with name and phone number
    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Getter method to retrieve the name of the user
    public String getName() {
        return name;
    }

    // Getter method to retrieve the address of the user
    public String getAddress() {
        return address;
    }

    // Getter method to retrieve the phone number of the user
    public String getPhone() {
        return phone;
    }

    // Override toString method to provide a string representation of the user
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
