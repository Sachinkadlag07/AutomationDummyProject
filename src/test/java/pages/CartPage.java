package pages;

import Utilities.LocatorReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CartPage {
    WebDriver driver;
    LocatorReader locator;

    public CartPage(WebDriver driver) throws IOException {
        this.driver = driver;
        locator= new LocatorReader("src/test/resources/locators/Cartpage_Locators");

    }

    public boolean isCartItemAdded(){
        return driver.findElement(By.xpath(locator.get("cartItem"))).isDisplayed();
    }

    public void clickonCheckOut(){
        driver.findElement(By.xpath(locator.get("checkoutButton"))).click();
    }

}
