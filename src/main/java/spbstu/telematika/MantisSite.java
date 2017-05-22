package spbstu.telematika;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import spbstu.telematika.factoryPageObjects.PageObjectViewIssuePage;
import spbstu.telematika.factoryPageObjects.PageobjectsContactFormPage;
import spbstu.telematika.factoryPageObjects.PageobjectsReportIssuePage;


public class MantisSite {

    public static PageobjectsContactFormPage contactFormPage;
    public static PageobjectsReportIssuePage issueReportPage;
    public static PageObjectViewIssuePage issueViewPage;
    private static WebDriver driver;

    public static void init(WebDriver driver){
        MantisSite.contactFormPage = PageFactory.initElements(driver, PageobjectsContactFormPage.class);
        MantisSite.issueReportPage = PageFactory.initElements(driver, PageobjectsReportIssuePage.class);
        MantisSite.issueViewPage = PageFactory.initElements(driver, PageObjectViewIssuePage.class);
        MantisSite.driver = driver;
    }

    public static void open(){
        driver.navigate().to("http://localhost/mantisbt/login_page.php");
    }
}
