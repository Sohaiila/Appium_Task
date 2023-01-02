package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutInfoPage {
    WebDriver driver;
    private By FIRSTNAME=new AppiumBy.ByAccessibilityId("test-First Name");
    private By LASTNAME=new AppiumBy.ByAccessibilityId("test-Last Name");
    private By ZIPCODE=new AppiumBy.ByAccessibilityId("test-Zip/Postal Code");
    private By CONTAIN_BUTTON=By.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]/android.widget.TextView");


    public CheckOutInfoPage(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * This method is to enter first name
     */
    public CheckOutInfoPage enterFirstName(){
        driver.findElement(FIRSTNAME).sendKeys("Sohaila");
        return new CheckOutInfoPage(driver);
    }
    /**
     * This method is to enter last name
     */
    public CheckOutInfoPage enterLastName(){
        driver.findElement(LASTNAME).sendKeys("Abdelaziz");
        return new CheckOutInfoPage(driver);
    }
    /**
     * This method is to enter zipCode
     */
    public CheckOutInfoPage enterZipCode(){
        driver.findElement(ZIPCODE).sendKeys("204050");
        return new CheckOutInfoPage(driver);
    }
    /**
     * This method is to click contain
     */
    public CheckOutOverViewPage clickContain(){
        driver.findElement(CONTAIN_BUTTON).click();
        return new CheckOutOverViewPage(driver);
    }

}
