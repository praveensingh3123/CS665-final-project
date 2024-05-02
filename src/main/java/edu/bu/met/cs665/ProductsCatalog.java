package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Name: Praveen Singh
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: ProductsCatalog.java
 * Description: This is the ProductsCatalog class. Here the functions for updateSimilarProductsMap,
 * updateCategoryProductMap, updateProductSellerMap, addCategory, addProduct, searchProduct,
 * searchCategory, updateProductQuantity, and remove products are defined.
 */
public class ProductsCatalog implements Searchable {
    // List of products in the catalog
    private ArrayList<Product> products;
    // List of categories in the catalog
    private ArrayList<Category> categories;
    // Mapping of category names to products in that category
    private HashMap<String, ArrayList<Product>> categoryProductMap;
    // Mapping of product names to sellers selling that product
    private HashMap<String, ArrayList<Seller>> productSellerMap;
    // Mapping of similar product names to a list of similar products
    private ConcurrentHashMap<String, ArrayList<Product>> similarProducts;
    // Delegate for search operations
    private SearchDelegate searchDelegate;

    // Constructor to initialize the catalog and mappings
    public ProductsCatalog() {
        products = new ArrayList<>();
        categories = new ArrayList<>();
        categoryProductMap = new HashMap<>();
        similarProducts = new ConcurrentHashMap<>();
        similarProducts.put("Dummy Product", new ArrayList<Product>());
        productSellerMap = new HashMap<>();
        searchDelegate = new SearchDelegate(similarProducts, categoryProductMap);
    }

    // Function to update the mapping of similar products
    public void updateSimilarProductsMap(Product newProduct) {
        String productName = newProduct.getName().toLowerCase();
        Set<String> keySet = similarProducts.keySet();
        boolean isSimilar = false;
        for (String key : keySet) {
            if (key.toLowerCase().contains(productName) || productName.contains(key.toLowerCase())) {
                isSimilar = true;
                similarProducts.get(key).add(newProduct);
            }
        }
        if (!isSimilar) {
            similarProducts.put(newProduct.getName().toLowerCase(), new ArrayList<>(List.of(newProduct)));
        }
    }

    // Function to update the mapping of category to products
    private void updateCategoryProductMap() {
        for (Category category : categories) {
            categoryProductMap.put(category.getName().toLowerCase(), new ArrayList<>());
        }
    }

    // Overloaded function to update the mapping of category to products with a given product
    private void updateCategoryProductMap(Product product) {
        if (categoryProductMap.containsKey(product.getCategory().getName().toLowerCase())) {
            categoryProductMap.get(product.getCategory().getName().toLowerCase()).add(product);
        } else {
            categoryProductMap.put(product.getCategory().getName().toLowerCase(), new ArrayList<>(List.of(product)));
        }
    }

    // Function to update the mapping of product to sellers
    private void updateProductSellerMap(Product newProduct) {
        if (productSellerMap.containsKey(newProduct.getName().toLowerCase())) {
            productSellerMap.get(newProduct.getName().toLowerCase()).add(newProduct.getSeller());
        } else {
            productSellerMap.put(newProduct.getName().toLowerCase(), new ArrayList<>(List.of(newProduct.getSeller())));
        }
    }

    // Function to add a new category to the catalog
    public void addCategory(Category newCategory) {
        categories.add(newCategory);
        updateCategoryProductMap();
    }

    // Function to add a new product to the catalog
    public void addProduct(Product product) {
        products.add(product);
        updateProductSellerMap(product);
        updateCategoryProductMap(product);
        updateSimilarProductsMap(product);
    }

    // Function to search for products with a given name
    @Override
    public ArrayList<Product> searchProduct(String productName) {
        // Delegate the search operation to the SearchDelegate
        return searchDelegate.searchProduct(productName);
    }

    // Function to search for products in a given category
    @Override
    public ArrayList<Product> searchCategory(String categoryName) {
        // Delegate the search operation to the SearchDelegate
        return searchDelegate.searchCategory(categoryName);
    }

    // Function to update the available quantity of a product
    public void updateProductQuantity(Product product, int newQuantity) {
        for (Product prod : products) {
            if (prod.getId() == product.getId()) {
                prod.setAvailableCount(newQuantity);
            }
        }
    }

    // Function to remove a product from the catalog
    public void removeProduct(Product product) {
        products.remove(product);
    }

    // Getter for similar products mapping
    public ConcurrentHashMap<String, ArrayList<Product>> getSimilarProducts() {
        return similarProducts;
    }

    // Override toString method to provide a string representation of the catalog
    @Override
    public String toString() {
        return "ProductsCatalog{" +
                "products=" + products +
                '}';
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }
}
