package sausedemotests;

import core.BaseTest;

public class ProductsTests extends BaseTest {

//    @BeforeEach
//    public void beforeAllTests() {
//        driver = startBrowser(BrowserTypes.CHROME);
//
//        // configure wait
//        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//        // navigate to Saucedemo
//        driver.get("https://www.saucedemo.com/");
//
//        // login
//        authenticateWithUser("standard_user", "secret_sauce");
//    }
//
//    @Test
//    public void productAddedToShoppingCart_when_addToCart() {
//        // add backpack to cart
//        WebElement backpack = addProductToCart(Constants.BACKPACK_TITLE);
//        backpack.findElement(By.className("btn_inventory")).click();
//
//        // add t-shirt to cart
//        WebElement tShirt = addProductToCart(Constants.SHIRT_TITLE);
//        tShirt.findElement(By.className("btn_inventory")).click();
//
//        // click on shopping cart
//        driver.findElement(By.className("shopping_cart_link")).click();
//
//        // assert items
//        var items = driver.findElements(By.className("inventory_item_name"));
//        Assertions.assertEquals(2, items.size(), "Items count not as expected");
//
//        Assertions.assertEquals(Constants.BACKPACK_TITLE, items.get(0).getText(), "Item title not as expected");
//        Assertions.assertEquals(Constants.SHIRT_TITLE, items.get(1).getText(), "Item title not as expected");
//
//        // assert price
//        var itemsPrice = driver.findElements(By.className("inventory_item_price"));
//        Assertions.assertEquals(2, items.size(), "Items price not as expected");
//
//        Assertions.assertEquals(Constants.BACKPACK_PRICE, itemsPrice.get(0).getText(), "Items price not as expected");
//        Assertions.assertEquals(Constants.SHIRT_PRICE, itemsPrice.get(1).getText(), "Items price not as expected");
//    }
//
//    @Test
//    public void userDetailsAdded_when_checkoutWithValidInformation() {
//        // add backpack to cart
//        WebElement backpack = addProductToCart(Constants.BACKPACK_TITLE);
//        backpack.findElement(By.className("btn_inventory")).click();
//
//        // add t-shirt to cart
//        WebElement tShirt = addProductToCart(Constants.SHIRT_TITLE);
//        tShirt.findElement(By.className("btn_inventory")).click();
//
//        // click on shopping cart
//        driver.findElement(By.className("shopping_cart_link")).click();
//
//        // click on check out
//        driver.findElement(By.id("checkout")).click();
//
//        // fill form
//        fillShippingDetails("Jack", "Pott", "8888");
//
//        // click continue
//        driver.findElement(By.id("continue")).click();
//
//        // assert items
//        var items = driver.findElements(By.className("inventory_item_name"));
//        Assertions.assertEquals(2, items.size(), "Items count not as expected");
//        Assertions.assertEquals(Constants.BACKPACK_TITLE, items.get(0).getText(), "Item title not as expected");
//        Assertions.assertEquals(Constants.SHIRT_TITLE, items.get(1).getText(), "Item title not as expected");
//
//        // assert price
//        var itemsPrice = driver.findElements(By.className("inventory_item_price"));
//        Assertions.assertEquals(2, itemsPrice.size(), "Items price not as expected");
//
//        Assertions.assertEquals(Constants.BACKPACK_PRICE, itemsPrice.get(0).getText(), "Items price not as expected");
//        Assertions.assertEquals(Constants.SHIRT_PRICE, itemsPrice.get(1).getText(), "Items price not as expected");
//
//        // calculate total price with tax
//        double backpackPrice = Double.parseDouble(Constants.BACKPACK_PRICE.replace("$", ""));
//        double shirtPrice = Double.parseDouble(Constants.SHIRT_PRICE.replace("$", ""));
//        double subtotal = backpackPrice + shirtPrice;
//        double tax = subtotal * 0.08;
//        double totalWithTax = subtotal + tax;
//
//        String expectedTotal = String.format("Total: $%.2f", totalWithTax);
//
//        var total = driver.findElement(By.className("summary_total_label")).getText();
//        Assertions.assertEquals(expectedTotal, total, "Items total price not as expected");
//    }
//
//
//    @Test
//    public void orderCompleted_when_addProduct_and_checkout_withConfirm() {
//        // add backpack to cart
//        WebElement backpack = addProductToCart(Constants.BACKPACK_TITLE);
//        backpack.findElement(By.className("btn_inventory")).click();
//
//        // add t-shirt to cart
//        WebElement tShirt = addProductToCart(Constants.SHIRT_TITLE);
//        tShirt.findElement(By.className("btn_inventory")).click();
//
//        // click on shopping cart
//        driver.findElement(By.className("shopping_cart_link")).click();
//
//        // click on check out
//        driver.findElement(By.id("checkout")).click();
//
//        // fill form
//        fillShippingDetails("Jack", "Pott", "8888");
//
//        // click continue
//        driver.findElement(By.id("continue")).click();
//
//        // click finish
//        driver.findElement(By.id("finish")).click();
//
//        // verify items are removed after from Shopping Cart after the order is completed
//        //click on back to products
//        driver.findElement(By.id("back-to-products")).click();
//
//        //click on shopping cart
//        driver.findElement(By.className("shopping_cart_link")).click();
//
//        //assert shopping cart is empty
//        var items = driver.findElements(By.className("inventory_item_name"));
//        Assertions.assertEquals(0, items.size(), "Items count not as expected");
//    }
}