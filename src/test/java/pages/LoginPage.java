package pages;

import Utilities.LocatorReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPage {
    WebDriver driver;
    LocatorReader locator;

    public LoginPage(WebDriver driver) throws IOException {
        this.driver=driver;
        locator =new LocatorReader("src/test/resources/locators/LoginPage_Locators");
    }

    public void login(String user,String pass){
        driver.findElement(By.xpath(locator.get("username"))).sendKeys(user);
        driver.findElement(By.xpath(locator.get("password"))).sendKeys(pass);
        driver.findElement(By.xpath(locator.get("loginButton"))).click();
    }


}
