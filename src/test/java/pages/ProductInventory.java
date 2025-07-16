package pages;

import Utilities.LocatorReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ProductInventory {
    WebDriver driver;
    LocatorReader locator;

    public ProductInventory(WebDriver driver) throws IOException {
        this.driver=driver;
        locator=new LocatorReader("src/test/resources/locators/ProductInventorypage_Locators");
    }

    public boolean isInventoryPageDisplayed(){
        return driver.getCurrentUrl().contains("inventory");
    }

    public void addFirstItemtoChart(){
        driver.findElement(By.xpath(locator.get("firstAddToCartButton"))).click();

    }
    public String getCartBadgeCount(){
        return driver.findElement(By.xpath(locator.get("cartBadge"))).getText();
    }

    public void clickOnCartIcon(){
        driver.findElement(By.xpath(locator.get("cartIcon"))).click();
    }
}
