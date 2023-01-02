package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.python.antlr.op.Add;

import java.time.Duration;

public class ProductsPage {
    WebDriver driver;
    private By PRODUCTS_TITLE=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]");
    private By FIRST_ITEM_TITLE=By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]");
    private By FIRST_ITEM_PRICE=By.xpath("(//android.widget.TextView[@content-desc=\"test-Price\"])[1]");
    private By ADD_TO_CART_BUTTON=By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]");
    private By ADD_TO_CART=By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView");
    private By CART_BUTTON=By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");
    private By REMOVE_BUTTON=new AppiumBy.ByAccessibilityId("test-REMOVE");
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * This method is to validate the first item title
     */
    public String checkFirstItemTitle(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(FIRST_ITEM_TITLE).getText();

    }
    /**
     * This method is to validate the price of the first item
     */
    public String checkFirstItemPrice(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(FIRST_ITEM_PRICE).getText();

    }
    /**
     * This method is to enter add to cart
     */
    public ProductsPage clickAddToCart(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(ADD_TO_CART_BUTTON).click();
        return new ProductsPage(driver);
    }
    /**
     * This method is to click on the Cart
     */
    public YourCartPage clickCart(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(CART_BUTTON).click();
        return new YourCartPage(driver);
    }
    /**
     * This method is to Validate the title of the Add to cart
     */
    public String  checkAddToCartTitle(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
        return driver.findElement(ADD_TO_CART).getText();
    }


 }



