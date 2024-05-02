package edu.bu.met.cs665;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SellerTest {

    private Seller seller;
    private ProductsCatalog productsCatalog;

    @BeforeEach
    public void setUp() {
        seller = new Seller("Test Seller", "1234567890");
        productsCatalog = new ProductsCatalog();
    }

    @Test
    public void testRegisterProduct() {
        // Create a product
        Product product = new Product("Test Product", "Description", 10.0, new Category("Test Category"), 100);

        // Register the product with the seller
        seller.registerProduct(productsCatalog, product);

        // Check if the product is added to the seller's list of products
        assertEquals(1, seller.getProducts().size());
        assertEquals(product, seller.getProducts().get(0));

        // Check if the product is added to the catalog
        assertEquals(1, productsCatalog.getProducts().size());
        assertEquals(product, productsCatalog.getProducts().get(0));
    }

    @Test
    public void testUpdateProductQuantity() {
        // Create a product
        Product product = new Product("Test Product", "Description", 10.0, new Category("Test Category"), 100);

        // Register the product with the seller
        seller.registerProduct(productsCatalog, product);

        // Update the quantity of the product
        seller.updateProductQuantity(productsCatalog, product, 50);

        // Check if the quantity is updated in the catalog
        assertEquals(50, product.getAvailableCount());
    }

    @Test
    public void testRemoveProduct() {
        // Create a product
        Product product = new Product("Test Product", "Description", 10.0, new Category("Test Category"), 100);

        // Register the product with the seller
        seller.registerProduct(productsCatalog, product);

        // Remove the product
        seller.removeProduct(productsCatalog, product);

        // Check if the product is removed from the seller's list of products
        assertEquals(0, seller.getProducts().size());

        // Check if the product is removed from the catalog
        assertEquals(0, productsCatalog.getProducts().size());
    }
}
