package Pages;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class YourCartPage {
    WebDriver driver;
    private By FIRST_ITEM_TITLE=By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
    private By FIRST_ITEM_PRICE=By.xpath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");
    private By REMOVE_BUTTON=By.xpath("//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]");
    private By REMOVE=new AppiumBy.ByAccessibilityId("test-REMOVE");
    private By CONTAIN=By.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE SHOPPING\"]/android.widget.TextView");
    private By CHECKOUT_BUTTON=By.xpath("//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]/android.widget.TextView");
    private By NUMBER1=By.xpath("//android.view.ViewGroup[@content-desc=\"test-Amount\"]/android.widget.TextView");
    public YourCartPage(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * This method is to Validate the first item title
     */
    public String  checkFirstItemTitleInCart(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(FIRST_ITEM_TITLE).getText();

    }
    /**
     * This method is to Validate the first item price
     */
    public String  checkFirstItemPriceInCart(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       return driver.findElement(FIRST_ITEM_PRICE).getText();

    }
    /**
     * This method is to click remove item from your cart
     */
    public YourCartPage clickRemove(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(REMOVE).click();
        return new YourCartPage(driver);
    }
    /**
     * This method is to click checkout
     */
    public CheckOutInfoPage clickCheckOut(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckOutInfoPage(driver);
    }
    /**
     * This method is to click contain
     */
    public ProductsPage clickContain() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(CONTAIN).click();
        return new ProductsPage(driver);
    }



}
