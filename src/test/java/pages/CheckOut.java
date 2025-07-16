package pages;

import Utilities.LocatorReader;
import org.apache.poi.hssf.record.chart.AreaFormatRecord;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CheckOut {

    WebDriver driver;
    LocatorReader locator;

    public CheckOut(WebDriver driver) throws IOException {
    this.driver=driver;
    locator= new LocatorReader("src/test/resources/locators/CheckOuPage_locator");

    }

    public void submitingUserDetails(String firstname,String lastname,String pincode){
        driver.findElement(By.xpath(locator.get("firstName"))).sendKeys(firstname);
        driver.findElement(By.xpath(locator.get("lastName"))).sendKeys(lastname);
        driver.findElement(By.xpath(locator.get("postalCode"))).sendKeys(pincode);
        driver.findElement(By.xpath(locator.get("continueButton"))).click();

    }

    public boolean isOverviewPageDisplay(){
        return driver.findElement(By.xpath(locator.get("overviewPageTitle"))).isDisplayed();

    }

    public void clickFinishButton(){
        driver.findElement(By.xpath(locator.get("finishButton"))).click();
    }

    public boolean isThankYouMessageDisplay(){
        return driver.findElement(By.xpath(locator.get("thankYouMessage"))).isDisplayed();
    }

    public void clickBackHome(){
        driver.findElement(By.xpath(locator.get("backHomeButton"))).click();
    }
}
