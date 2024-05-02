package edu.bu.met.cs665;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class ProductTest extends TestCase {
    private Product product;
    private Category category;
    private Seller seller;

    @Before
    public void setUp() {
        category = new Category("Test Category");
        seller = new Seller("Test Seller", "1234567890");
        product = new Product("Test Product", "Description", 10.0, category, 100);
        product.setSeller(seller);
    }

    @Test
    public void testGetId() {
        assertEquals(3, product.getId()); // Assuming it's the first product created
    }

    @Test
    public void testGetName() {
        assertEquals("Test Product", product.getName());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Description", product.getDescription());
    }

    @Test
    public void testGetPrice() {
        assertEquals(10.0, product.getPrice(), 0.0);
    }

    @Test
    public void testGetCategory() {
        assertEquals(category, product.getCategory());
    }

    @Test
    public void testGetAvailableCount() {
        assertEquals(100, product.getAvailableCount());
    }

    @Test
    public void testSetAvailableCount() {
        product.setAvailableCount(50);
        assertEquals(50, product.getAvailableCount());
    }

    @Test
    public void testGetSeller() {
        assertEquals(seller, product.getSeller());
    }

    @Test
    public void testToString() {
        String expectedToString = "Product{id=4, name='Test Product', description='Description', " +
                "price=10.0, ratings=0.0, category=Test Category, availableCount=100, seller=Test Seller}";
        assertEquals(expectedToString, product.toString());
    }
}
