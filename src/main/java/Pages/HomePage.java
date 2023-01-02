package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    private By USERNAME_KEY = new AppiumBy.ByAccessibilityId("test-Username");
    private By PASSWORD_KEY= new AppiumBy.ByAccessibilityId("test-Password");
    private By LOGIN_BUTTON= new AppiumBy.ByAccessibilityId("test-LOGIN");
    private By ERROR_MESS = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * This method is to enter a valid userName
     */
    public HomePage enterUserName(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(USERNAME_KEY).sendKeys("standard_user");
        return new HomePage(driver);
    }
    /**
     * This method is to enter a valid Password
     */
    public HomePage enterPassword(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(PASSWORD_KEY).sendKeys("secret_sauce");
        return new HomePage(driver);
    }
    /**
     * This method is to enter click Login
     */
    public ProductsPage clickLogIn(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }
    /**
     * This method is to enter invalid UserName
     */
    public HomePage enterInValidUserName(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(USERNAME_KEY).sendKeys("Sohaila/abdelaziz");
        return new HomePage(driver);
    }
    /**
     * This method is to check the error message
     */
    public String getErrorMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(ERROR_MESS).getText();
    }
}

