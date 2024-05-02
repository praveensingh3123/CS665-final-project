package edu.bu.met.cs665;

import java.util.ArrayList;

/**
 * Name: Praveen Singh
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: Cart.java
 * Description: This is the Cart class. Here the functions for adding items to the cart, removing items from the cart,
 * updating the count of the cart items, fetching the items from the cart and checking out are defined.
 */
public class Cart {
    // ArrayList to hold the items in the cart
    private ArrayList<Item> itemList;

    // Constructor to initialize the cart with an empty list of items
    public Cart() {
        this.itemList = new ArrayList<>();
    }

    // Function to add an item to the cart
    public void addItem(Item item){
        itemList.add(item);
    }

    // Function to remove an item from the cart
    public void removeItem(Item item){
        itemList.remove(item);
    }

    // Function to update the count of a particular item in the cart
    public void updateItemCount(Item item, int newCount){
        int index = itemList.indexOf(item);
        itemList.get(index).updateCount(newCount);
    }

    // Function to retrieve the list of items in the cart
    public ArrayList<Item> getItemList(){
        if(itemList.isEmpty()){
            System.out.println("Your cart is empty!");
        }
        return itemList;
    }

    // Function to clear the cart during checkout
    public void checkout(){
        itemList.clear();
    }
}
