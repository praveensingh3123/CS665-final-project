package edu.bu.met.cs665;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CartTest {

    private Cart cart;
    private Item item1;
    private Item item2;

    @Before
    public void setUp() {
        cart = new Cart();
        item1 = new Item(new Product("Product1", "Description1", 10.0, new Category("Category1"), 5), 2);
        item2 = new Item(new Product("Product2", "Description2", 20.0, new Category("Category2"), 3), 3);
    }

    @Test
    public void testAddItem() {
        cart.addItem(item1);
        ArrayList<Item> itemList = cart.getItemList();
        assertTrue(itemList.contains(item1));
    }

    @Test
    public void testRemoveItem() {
        cart.addItem(item1);
        cart.removeItem(item1);
        ArrayList<Item> itemList = cart.getItemList();
        assertFalse(itemList.contains(item1));
    }

    @Test
    public void testUpdateItemCount() {
        cart.addItem(item1);
        cart.updateItemCount(item1, 5);
        ArrayList<Item> itemList = cart.getItemList();
        assertEquals(5, itemList.get(0).getCount());
    }

    @Test
    public void testGetItemList_EmptyCart() {
        ArrayList<Item> itemList = cart.getItemList();
        assertTrue(itemList.isEmpty());
    }

    @Test
    public void testGetItemList_NonEmptyCart() {
        cart.addItem(item1);
        cart.addItem(item2);
        ArrayList<Item> itemList = cart.getItemList();
        assertEquals(2, itemList.size());
        assertTrue(itemList.contains(item1));
        assertTrue(itemList.contains(item2));
    }

    @Test
    public void testCheckout() {
        cart.addItem(item1);
        cart.addItem(item2);
        cart.checkout();
        ArrayList<Item> itemList = cart.getItemList();
        assertTrue(itemList.isEmpty());
    }
}