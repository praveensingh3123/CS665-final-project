package edu.bu.met.cs665;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class OrderTest extends TestCase {
    private Order order;

    @Before
    public void setUp() {
        order = new Order();
    }

    @Test
    public void testMoveToShipment() {
        Shipment shipment = order.moveToShipment();
        assertNotNull(shipment);
    }

    @Test
    public void testAddOrderLog() {
        order.addOrderLog(new OrderLog(new Date(), OrderStatus.SHIPPED));
        assertEquals(2, order.getOrderLogs().size()); // One log added during order creation
    }

    @Test
    public void testSetOrderStatus() {
        order.setOrderStatus(OrderStatus.SHIPPED);
        assertEquals(OrderStatus.SHIPPED, order.getOrderStatus());
    }

    @Test
    public void testSetOrderDate() {
        Date date = new Date();
        order.setOrderDate(date);
        assertEquals(date, order.getOrderDate());
    }

    @Test
    public void testSetItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(new Product("Product1", "Description", 10.0, new Category("Category"), 10), 1));
        items.add(new Item(new Product("Product2", "Description", 20.0, new Category("Category"), 10), 2));
        order.setItems(items);
        assertEquals(2, order.getItems().size());
    }

    @Test
    public void testSetAmount() {
        order.setAmount(100.0);
        assertEquals(100.0, order.getAmount(), 0.001);
    }

    @Test
    public void testSetShippingAddress() {
        String address = "123 Main St, City, Country";
        order.setShippingAddress(address);
        assertEquals(address, order.getShippingAddress());
    }
}
