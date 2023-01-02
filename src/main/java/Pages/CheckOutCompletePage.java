package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutCompletePage {
    WebDriver driver;
    private By COMPLETE_TITLE=By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]");
    private By BACK_HOME_BUTTON=By.xpath("//android.view.ViewGroup[@content-desc=\"test-BACK HOME\"]");

    public CheckOutCompletePage(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * This method is Validate complete title
     */
    public String checkCompleteTitle(){
        return driver.findElement(COMPLETE_TITLE).getText();
    }
    /**
     * This method is to enter click backHome to return you back to the product page
     */
    public ProductsPage clickBackHome(){
        driver.findElement(BACK_HOME_BUTTON).click();
        return new ProductsPage(driver);
    }

}
