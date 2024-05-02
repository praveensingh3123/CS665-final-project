
| CS-665        | Software Design & Patterns |
|---------------|----------------------------|
| Name          | PRAVEEN SINGH              |
| Date          | 04/23/2024                 |
| Course        | Spring                     |
| Final Project |                            |

# Project Overview

The objective of this project is to create an e-commerce application which has various features. 
It allows customers to browse products, add them to their carts, and place orders. Sellers can register 
their products and manage their inventory.

# GitHub Repository Link:
https://github.com/praveensingh3123/CS665-Assignment-2

# Features
* Customer Management: Customers can register, browse products, add items to their cart, and place orders.
* Seller Management: Sellers can register, add products to the catalog, and manage their inventory.
* Product Catalog: The application maintains a catalog of products organized into categories.
* Order Management: Customers can place orders, and orders can be tracked through the shipment process.

# Usage
* To use MyFlipCart, follow these steps:

* Run the Application: Execute the MyFlipCart.java file to start the application.
* Data Generation: Upon startup, the application generates sample data including customers, sellers, categories, and products.
* Interact with the Application: Use the provided menu options to browse products, add items to the cart, and place orders.
* Explore Features: Explore various features such as searching for products, updating item quantities, and tracking orders.

# Components

The main components of the MyFlipCart application are:

* Cart: Manages the items added by a customer for purchase.
* Category: Represents a category of products for organizing the product catalog.
* Customer: Represents a customer who can browse products, add items to the cart, and place orders.
* Item: Represents the items available on the e-commerce application.
* MyFlipCart: Represents the main entry point of the e-commerce application. 
* Order: Represents an order placed by a customer, containing details such as order items, total amount, and shipping address.
* OrderLog: Represents as the order history of the orders placed by the customer, which can be used to retrieve the past orders.
* OrderStatus: Represents an enum class which contains all the states in which the order can be.
* Product: Represents a product available for purchase, with details such as name, description, price, and category.
* ProductCatalog: Represents as the catalog for the products which segregates the products in different categories.
* Searchable: Represents an interface to search for products present on MyFlipCart application.
* SearchDelegate: Represents a class that implements the search functionality for the e-commerce application. 
* Seller: Represents a seller who can register products and manage inventory.
* Shipment: Represents a shipment of ordered items, with details such as shipment number, date, and estimated arrival.
* User: Represents the user class which is extended by customers and sellers.

# Dependencies
* Java: The application is written in Java and requires a Java runtime environment to execute.
No external dependencies are required to run the application.
