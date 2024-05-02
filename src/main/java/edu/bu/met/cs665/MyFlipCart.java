package edu.bu.met.cs665;

import java.util.ArrayList;

/**
 * Name: Praveen Singh
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: MyFlipCart.java
 * Description: This is the entry point of the MyFlipCart Application. New customers and sellers are created and all
 * the products and categories are initialized here and the customer places the order from here.
 */
public class MyFlipCart {
    // Catalog of products for the application
    public ProductsCatalog productsCatalog;

    // Constructor to initialize the product catalog
    public MyFlipCart() {
        productsCatalog = new ProductsCatalog();
    }

    // Main method, entry point of the application
    public static void main(String[] args) {
        // -------Data generation code ---- START ------------------------------//

        // Creating Customer --> Praveen Singh
        Customer customer = new Customer("Praveen Singh","8574523808");

        // Creating Seller --> Daily Needs Groceries
        Seller dailyNeedsGrocery = new Seller("Daily Needs Groceries","9876543210");

        // Creating Seller --> Fashion Point
        Seller fashionPoint = new Seller("Fashion Point","9988776655");

        // Creating Seller --> Digi Electronics
        Seller digiElectronics = new Seller("Digi Electronics","9876598765");

        // Creating category --> Electronics
        Category electronics = new Category("Electronics");

        // Creating category --> Cosmetics
        Category cosmetics = new Category("Cosmetics");

        // Creating category --> Grocery
        Category grocery = new Category("Groceries");

        // Creating category --> Clothing
        Category clothing = new Category("Clothing");

        // -------Data generation code ---- END ------------------------------//

        // Creating MyFlipCart instance
        MyFlipCart myFlipKart = new MyFlipCart();

        // Adding all the categories to Flipkart catalog
        myFlipKart.productsCatalog.addCategory(clothing);
        myFlipKart.productsCatalog.addCategory(grocery);
        myFlipKart.productsCatalog.addCategory(cosmetics);
        myFlipKart.productsCatalog.addCategory(electronics);

        // Seller Digi Electronics adding Mobile to myFlipKart catalog
        digiElectronics.registerProduct(myFlipKart.productsCatalog,
                new Product("Mobile","Latest Technology",10000.00,electronics,5));

        // Seller Digi Electronics adding Camera to myFlipKart catalog
        digiElectronics.registerProduct(myFlipKart.productsCatalog,
                new Product("Camera","Advanced Technology",50000.00,electronics,10));

        // Seller FashionPoint adding Wearables to myFlipKart catalog
        fashionPoint.registerProduct(myFlipKart.productsCatalog,
                new Product("Mens Jackets","XL - Size",1000.00,clothing,10));

        fashionPoint.registerProduct(myFlipKart.productsCatalog,
                new Product("Jackets","XL - Size",1000.00,clothing,10));

        // Seller FashionPoint adding Cosmetics to myFlipKart catalog
        fashionPoint.registerProduct(myFlipKart.productsCatalog,
                new Product("Nail Paint","Red Color",500.00,cosmetics,25));

        // Seller dailyNeedsGrocery adding grocery to myFlipKart catalog
        dailyNeedsGrocery.registerProduct(myFlipKart.productsCatalog,
                new Product("Sugar","Fine quality",40.00,grocery,1000));

        // Seller dailyNeedsGrocery adding grocery to myFlipKart catalog
        dailyNeedsGrocery.registerProduct(myFlipKart.productsCatalog,
                new Product("Milk","100% Pure",50.00,grocery,250));

        dailyNeedsGrocery.registerProduct(myFlipKart.productsCatalog,
                new Product("Toned Milk","Hygienic and Pure",45.00,grocery,250));

        dailyNeedsGrocery.registerProduct(myFlipKart.productsCatalog,
                new Product("Milk Cream","Natural",145.00,grocery,100));

        // Customer searching for product --> milk
        ArrayList<Product> milkResults = myFlipKart.productsCatalog.searchProduct("Milk");

        // Customer searching for all the products in grocery
        ArrayList<Product> groceryProducts = myFlipKart.productsCatalog.searchCategory("Groceries");

        // Customer adding products to cart
        Item milkTenPackets = new Item(milkResults.get(0), 10);
        customer.addItemToCart(milkTenPackets);
        Item groceryItems = new Item(groceryProducts.get(0), 20);
        customer.addItemToCart(groceryItems);

        // Printing current cart status
        customer.printCartItems();

        // Customer searching for another product --> camera
        ArrayList<Product> cameraResults = myFlipKart.productsCatalog.searchProduct("Camera");
        // Customer adding 1 camera to cart
        Item camera = new Item(cameraResults.get(0), 1);
        customer.addItemToCart(camera);

        // Customer searching for another product --> Mens Jackets
        ArrayList<Product> jacketsResults = myFlipKart.productsCatalog.searchProduct("Mens Jackets");
        //Customer adding 5 Jackets to the cart
        Item jackets = new Item(jacketsResults.get(0), 5);
        customer.addItemToCart(jackets);

        // Customer updating quantity of milk packets from 10 to 15
        customer.updateItemCount(milkTenPackets, 15);

        // Customer removes jacket from the cart
        customer.removeItemFromCart(jackets);

        // Printing current cart status
        customer.printCartItems();

        // Customer placing the order
        customer.placeOrder();

        // Customer cart is empty after checkout
        customer.printCartItems();

        // Printing the current Order of customer
        System.out.println(customer.getCurrentOrder());

        // Customer order is moved to shipment
        Shipment s = customer.getCurrentOrder().moveToShipment();

        // Printing the shipment details
        System.out.println(s);
        System.out.println();
        System.out.println(customer.getCurrentOrder());
    }
}