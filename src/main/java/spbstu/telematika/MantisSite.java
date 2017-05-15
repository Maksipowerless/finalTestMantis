package spbstu.telematika;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import spbstu.telematika.factoryPageObjects.FactoryPageobjectsContactFormPage;
import spbstu.telematika.factoryPageObjects.FactoryPageobjectsIssuePage;


public class MantisSite {

    public static FactoryPageobjectsContactFormPage contactFormPage;
    public static FactoryPageobjectsIssuePage issuePage;
    private static WebDriver driver;

    public static void init(WebDriver driver){
        MantisSite.contactFormPage = PageFactory.initElements(driver, FactoryPageobjectsContactFormPage.class);
        MantisSite.issuePage = PageFactory.initElements(driver, FactoryPageobjectsIssuePage.class);
        MantisSite.driver = driver;
    }

    public static void open(){
        driver.navigate().to("http://localhost/mantisbt/login_page.php");
    }
}
