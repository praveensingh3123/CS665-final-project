package edu.bu.met.cs665;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;

public class SearchDelegateTest extends TestCase {

    @Test
    public void testSearchProduct() {
        // Create test data
        ConcurrentHashMap<String, ArrayList<Product>> similarProducts = new ConcurrentHashMap<>();
        HashMap<String, ArrayList<Product>> categoryProductMap = new HashMap<>();
        SearchDelegate searchDelegate = new SearchDelegate(similarProducts, categoryProductMap);

        // Add test products
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product("Test Product 1", "Description", 10.0, new Category("Test Category"), 100));
        productList.add(new Product("Test Product 2", "Description", 20.0, new Category("Test Category"), 200));
        similarProducts.put("test product", productList);

        // Test search for product
        ArrayList<Product> searchResult = searchDelegate.searchProduct("test product");
        assertEquals(2, searchResult.size()); // Expecting 2 products
        assertEquals("Test Product 1", searchResult.get(0).getName()); // First product name
        assertEquals("Test Product 2", searchResult.get(1).getName()); // Second product name
    }

    @Test
    public void testSearchCategory() {
        // Create test data
        ConcurrentHashMap<String, ArrayList<Product>> similarProducts = new ConcurrentHashMap<>();
        HashMap<String, ArrayList<Product>> categoryProductMap = new HashMap<>();
        SearchDelegate searchDelegate = new SearchDelegate(similarProducts, categoryProductMap);

        // Add test products
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product("Test Product", "Description", 10.0, new Category("Test Category 1"), 100));
        productList.add(new Product("Test Product", "Description", 20.0, new Category("Test Category 2"), 200));
        categoryProductMap.put("test category 1", productList);

        // Test search for category
        ArrayList<Product> searchResult = searchDelegate.searchCategory("test category 1");
        assertEquals(2, searchResult.size());
        assertEquals("Test Product", searchResult.get(0).getName()); // First product name
    }
}
