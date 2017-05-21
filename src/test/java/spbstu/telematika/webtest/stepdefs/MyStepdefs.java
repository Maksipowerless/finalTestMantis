package spbstu.telematika.webtest.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.asserts.SoftAssert;
import spbstu.telematika.MantisSite;
import spbstu.telematika.helper.ResourseLoaderSTU;

/**
 * Created by maxfromperek on 16.05.17.
 */
public class MyStepdefs {
    SoftAssert softAssert;

    @Given("^Login with \"([^\"]*)\"$")
    public void loginWith(String arg0) throws Throwable {
        MantisSite.contactFormPage.fillLoginPasswordForm(ResourseLoaderSTU.getUser(arg0));
        MantisSite.contactFormPage.submitContactForm();
    }

    @And("^Click button Report Issue$")
    public void clickButtonReportIssue() throws Throwable {
        MantisSite.issuePage.openReportIssuePage();
    }

    @When("^Fill fields issue with \"([^\"]*)\"$")
    public void fillFieldsIssueWith(String arg0) throws Throwable {
        MantisSite.issuePage.fillFieldsIssue(ResourseLoaderSTU.getFieldData(arg0));

    }

    @And("^Create issue$")
    public void createIssue() throws Throwable {
        MantisSite.issuePage.submitIssue();
    }

    @And("^Click view issues$")
    public void clickViewIssues() throws Throwable {
        MantisSite.issuePage.openViewIssuePage();
    }

    @Then("^Check view issues contains create issue with \"([^\"]*)\" and with \"([^\"]*)\"$")
    public void checkViewIssuesContainsCreateIssueWithAndWith(String status, String form) throws Throwable {
        softAssert.assertTrue(MantisSite.issuePage.isExistRow(ResourseLoaderSTU.getFieldData(form),status));
    }

    @Given("^Logout$")
    public void logout() throws Throwable {
        MantisSite.issuePage.logout();
    }

    @When("^Click view issue$")
    public void clickViewIssue() throws Throwable {
        MantisSite.issuePage.openViewIssuePage();
    }

    @When("^Open issue by number with \"([^\"]*)\"$")
    public void openIssueByNumberWith(String arg0) throws Throwable {
        MantisSite.issuePage.clickIDIssue(ResourseLoaderSTU.getFieldData(arg0));

    }

    @Then("^Check data in issue with \"([^\"]*)\"$")
    public void checkDataInIssueWith(String arg0) throws Throwable {
        softAssert.assertTrue(MantisSite.issuePage.checkIssueForm(ResourseLoaderSTU.getFieldData(arg0)));

    }

    @When("^Change issue status to \"([^\"]*)\"$")
    public void changeIssueStatusTo(String arg0) throws Throwable {
        MantisSite.issuePage.setStatusIssue(arg0);
    }


}
