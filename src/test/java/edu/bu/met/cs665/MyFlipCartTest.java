package edu.bu.met.cs665;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyFlipCartTest {
    private MyFlipCart myFlipCart;
    private Customer customer;

    @Before
    public void setUp() {
        myFlipCart = new MyFlipCart();
        customer = new Customer("John Doe", "1234567890");
    }

    @Test
    public void testAddItemToCart() {
        Product product = new Product("TestProduct", "Description", 10.0, new Category("TestCategory"), 10);
        Item item = new Item(product, 1);
        customer.addItemToCart(item);
        assertEquals(1, customer.getCart().getItemList().size());
    }

    @Test
    public void testUpdateItemCount() {
        Product product = new Product("TestProduct", "Description", 10.0, new Category("TestCategory"), 10);
        Item item = new Item(product, 1);
        customer.addItemToCart(item);
        customer.updateItemCount(item, 2);
        assertEquals(2, customer.getCart().getItemList().get(0).getCount());
    }

    @Test
    public void testPlaceOrder() {
        Product product = new Product("TestProduct", "Description", 10.0, new Category("TestCategory"), 10);
        Item item = new Item(product, 1);
        customer.addItemToCart(item);
        customer.placeOrder();
        assertEquals(1, customer.getOrderHistory().size());
    }

    @Test
    public void testGetOrderHistory() {
        Product product = new Product("TestProduct", "Description", 10.0, new Category("TestCategory"), 10);
        Item item = new Item(product, 1);
        customer.addItemToCart(item);
        customer.placeOrder();
        assertEquals(1, customer.getOrderHistory().size());
    }
}
