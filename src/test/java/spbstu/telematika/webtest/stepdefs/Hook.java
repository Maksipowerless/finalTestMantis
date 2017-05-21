package spbstu.telematika.webtest.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import spbstu.telematika.MantisSite;
import spbstu.telematika.helper.ResourseLoaderSTU;

import java.util.concurrent.TimeUnit;

public class Hook {
    WebDriver driver;


    @Before
    public void before(Scenario scenario) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--lang=en-GB");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MantisSite.init(driver);
        MantisSite.open();
    }

    @After
    public void after(Scenario scenario) {

        MantisSite.issuePage.checkRow(ResourseLoaderSTU.getFieldData("form1"));
        MantisSite.issuePage.deleteIssues();
        MantisSite.issuePage.logout();
        driver.close();
    }
}