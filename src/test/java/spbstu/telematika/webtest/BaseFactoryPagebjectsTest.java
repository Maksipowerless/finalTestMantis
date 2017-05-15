package spbstu.telematika.webtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import spbstu.telematika.MantisSite;


import java.util.concurrent.TimeUnit;


public class BaseFactoryPagebjectsTest {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeSuite
    public void beforeSuite() {

        //настройка веб драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MantisSite.init(driver);
        softAssert = new SoftAssert();
    }

    @AfterSuite
    public void afterSute() {
        driver.close();
    }
}
