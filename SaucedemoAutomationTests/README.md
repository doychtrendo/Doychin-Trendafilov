Saucedemo Automation Tests
==========================

Description
-----------

This project contains automated test scripts for the Saucedemo application. It focuses on testing the functionality of the shopping cart, checkout process, and order completion.

Installation
------------

1.  Clone the repository
2.  Navigate to the project directory
3.  Install dependencies
4.  Run Tests

Test Scenarios
--------------

### 1\. Product Added to Shopping Cart

**Method**: `productAddedToShoppingCart_when_addToCart()`

-   **Description**: Verifies that products are correctly added to the shopping cart.
-   **Steps**:
    -   Login
    -   Add 2 products to the shopping cart
    -   Go to the shopping cart
    -   Assert correct items are added

### 2\. User Details Added

**Method**: `userDetailsAdded_when_checkoutWithValidInformation()`

-   **Description**: Ensures user details are properly added during checkout.
-   **Steps**:
    -   Login
    -   Add 2 products to the shopping cart
    -   Go to the shopping cart
    -   Go to checkout
    -   Fill in user information
    -   Go to the summary page
    -   Verify summary page details

### 3\. Order Completed

**Method**: `orderCompleted_when_addProduct_and_checkout_withConfirm()`

-   **Description**: Confirms that an order is completed successfully and items are removed from the shopping cart.
-   **Steps**:
    -   Login
    -   Add 2 products to the shopping cart
    -   Go to the shopping cart
    -   Go to checkout
    -   Fill in user information
    -   Go to the summary page
    -   Complete the order
    -   Verify items are removed from the shopping cart

Technologies
------------

-   Selenium
