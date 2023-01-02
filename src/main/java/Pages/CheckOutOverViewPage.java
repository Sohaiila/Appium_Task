package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutOverViewPage {
    WebDriver driver;
    private By FIRST_ITEM_TITLE=By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
    private By FIRST_ITEM_PRICE=By.xpath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");
    private By ITEM_TOTAL=By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[5]");
    private By TAX_PRICE=By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[6]");
    private By TOTAL=By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[7]");
    private By FINISH_BUTTON=By.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]/android.widget.TextView");

    public CheckOutOverViewPage(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * This method is to Validate the item total price
     */
    public String checkItemTotal(){
        return driver.findElement(ITEM_TOTAL).getText();
    }
    /**
     * This method is to Validate the total price
     */
    public String  checkTotal(){
       return driver.findElement(TOTAL).getText();
    }
    /**
     * This method is to click finish
     */
    public CheckOutCompletePage clickFinish(){
        driver.findElement(FINISH_BUTTON).click();
        return new CheckOutCompletePage(driver);
    }
}
