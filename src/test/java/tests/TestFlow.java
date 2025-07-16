package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOut;
import pages.LoginPage;
import pages.ProductInventory;

import java.io.IOException;

public class TestFlow extends Basetest{
    LoginPage lp;
    ProductInventory  inventory;
    CartPage cartpage;
    CheckOut checkout;

    @Test
    public void loginToApplication() throws IOException {

        logger.info("**** Test case 01 **** ");

         lp = new LoginPage(driver);
        lp.login(p.getProperty("Username"),p.getProperty("Password"));

       inventory= new ProductInventory(driver);
        Assert.assertTrue(inventory.isInventoryPageDisplayed());

    }

   @Test (dependsOnMethods = {"loginToApplication"})
    public void addToCartTest() throws IOException {
       logger.info("**** Test case 02 **** ");
       inventory = new ProductInventory(driver);
        inventory.addFirstItemtoChart();
        Assert.assertEquals(inventory.getCartBadgeCount(),"1");

    }

    @Test(dependsOnMethods = {"addToCartTest"})
    public void cardVerification() throws IOException {
        logger.info("**** Test case 01 **** ");
        inventory.clickOnCartIcon();
         cartpage = new CartPage(driver);
        Assert.assertTrue(cartpage.isCartItemAdded());
    }

    @Test(dependsOnMethods = {"cardVerification"})
    public void checkOutAndUserDetails() throws IOException {
        logger.info("**** Test case 04 **** ");
        cartpage.clickonCheckOut();
       checkout= new CheckOut(driver);
        checkout.submitingUserDetails("John","Doe","12345");
        Assert.assertTrue(checkout.isOverviewPageDisplay());

    }

    @Test(dependsOnMethods = {"checkOutAndUserDetails"})
    public void finishOrder() throws IOException {
        logger.info("**** Test case 05 **** ");
        checkout.clickFinishButton();
        Assert.assertTrue(checkout.isThankYouMessageDisplay());
        checkout.clickBackHome();
        Assert.assertTrue(inventory.isInventoryPageDisplayed());

    }

    }

