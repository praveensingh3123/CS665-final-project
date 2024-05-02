package edu.bu.met.cs665;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OrderLogTest {

    @Test
    public void testOrderLogCreation() {
        // Create a test date and order status
        Date testDate = new Date();
        OrderStatus testStatus = OrderStatus.CREATED;

        // Create an order log
        OrderLog orderLog = new OrderLog(testDate, testStatus);

        // Check if the order log is not null
        assertNotNull(orderLog);

        // Check if the creation timestamp matches the test date
        assertEquals(testDate, orderLog.getCreationTimestamp());

        // Check if the order status matches the test status
        assertEquals(testStatus, orderLog.getStatus());
    }
}
