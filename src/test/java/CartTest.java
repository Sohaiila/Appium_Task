import Pages.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class CartTest {
    WebDriver driver;
    @BeforeClass
    public void setupDevice() throws MalformedURLException {
        String AppName = System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataFiles\\Android.SauceLabs.Mobile.Sample.app.2.2.0 (1).apk";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Demo");
        caps.setCapability("appium:appWaitActivity", "com.swaglabsmobileapp.MainActivity");
        caps.setCapability("appium:app", "C:\\Users\\abdelazizs4\\Downloads\\Android.SauceLabs.Mobile.Sample.app.2.2.0 (1).apk");
        caps.setCapability("appium:platformVersion", "8.1");
        caps.setCapability("appium:automationName", "UiAutomator2");
        driver = new AndroidDriver(new URL("http://localhost:4723/"), caps);
    }
    @BeforeMethod
    public void logIn(){
        //login
     new HomePage(driver)
                .enterUserName()
                .enterPassword()
                .clickLogIn();
    }
    @Test
    public void addItemToCart(){
     //Add Item to the cart and validate that Title and price of the Item at Home page equals to the cart
       String itemInProducts =new ProductsPage(driver)
               .checkFirstItemTitle();
       String itemPriceInProducts=new ProductsPage(driver)
               .checkFirstItemPrice();
       String itemInCart=new ProductsPage(driver)
               .clickAddToCart()
               .clickCart()
               .checkFirstItemTitleInCart();
       String itemPriceInCart= new YourCartPage(driver)
               .checkFirstItemPriceInCart();
       Assert.assertEquals(itemInCart,itemInProducts);
       Assert.assertEquals(itemPriceInCart,itemPriceInProducts);
    }
    @Test
    public void removeItemFromCart(){
    //Validate Removing Items from the cart and validate that the item is removed
        String txt =new ProductsPage(driver)
               .clickAddToCart()
               .clickCart()
               .clickRemove().clickContain().checkAddToCartTitle();
        Assert.assertEquals(txt,"ADD TO CART");
    }
    @Test
    public void onlineOrderCompletedFlow(){
     //Online Ordering and complete the flow from adding element to cart till the checkout, Also Validate the price
       String txt= new ProductsPage(driver)
               .clickAddToCart()
               .clickCart()
               .clickCheckOut()
               .enterFirstName()
               .enterLastName()
               .enterZipCode()
               .clickContain()
               .checkItemTotal();
       String txt1=new CheckOutOverViewPage(driver).checkTotal();
       Assert.assertEquals(txt1,"Total: $32.39");
       Assert.assertEquals(txt,"Item total: $29.99");
       String txt2=new CheckOutOverViewPage(driver)
               .clickFinish()
               .checkCompleteTitle();
       Assert.assertEquals(txt2,"THANK YOU FOR YOU ORDER");
       new CheckOutCompletePage(driver).clickBackHome();

    }
    @AfterClass
    public void quit(){
        driver.quit();
    }

}
