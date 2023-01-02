import Pages.HomePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;


public class LoginTest {
    WebDriver driver;
    @BeforeMethod
    public void setupDevice() throws MalformedURLException {
        String AppName = System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataFiles\\Android.SauceLabs.Mobile.Sample.app.2.2.0 (1).apk";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Demo");
        caps.setCapability("appium:appWaitActivity", "com.swaglabsmobileapp.MainActivity");
        //caps.setCapability("appium:app", AppName);
        caps.setCapability("appium:app", "C:\\Users\\abdelazizs4\\Downloads\\Android.SauceLabs.Mobile.Sample.app.2.2.0 (1).apk");
        caps.setCapability("appium:platformVersion", "8.1");
        caps.setCapability("appium:automationName", "UiAutomator2");
        driver = new AndroidDriver(new URL("http://localhost:4723/"), caps);
    }
    @Test
    public void logInValidCase(){
    //Login with Valid Email and password and validate that login is performed successfully by validate the item in product page appears
       String txt= new HomePage(driver)
               .enterUserName()
               .enterPassword()
               .clickLogIn()
               .checkFirstItemTitle();
       Assert.assertEquals(txt,"Sauce Labs Backpack");
    }
    @Test
    public void logInInValidCase(){
    //Login with invalid email or password and validate the error message that appears
        new HomePage(driver)
                .enterInValidUserName()
                .enterPassword()
                .clickLogIn();
        String txt= new HomePage(driver).getErrorMessage();
        Assert.assertEquals(txt,"Username and password do not match any user in this service.");
    }
    @AfterClass
    public void quit(){
        driver.quit();
    }

}
