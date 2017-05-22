package spbstu.telematika.webtest.stepdefs;

import cucumber.api.PendingException;
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
    SoftAssert softAssert = new SoftAssert();


    @Given("^Login with \"([^\"]*)\"$")
    public void loginWith(String login) throws Throwable {
        MantisSite.contactFormPage.fillLoginPasswordForm(ResourseLoaderSTU.getUser(login));
        MantisSite.contactFormPage.submitContactForm();
    }


    @And("^Click button Report Issue$")
    public void clickButtonReportIssue() throws Throwable {
        MantisSite.issueReportPage.openReportIssuePage();
    }

    @When("^Fill fields issue with \"([^\"]*)\"$")
    public void fillFieldsIssueWith(String form) throws Throwable {
        MantisSite.issueReportPage.fillFieldsIssue(ResourseLoaderSTU.getFieldData(form));
    }

    @And("^Create issue$")
    public void createIssue() throws Throwable {
        MantisSite.issueReportPage.submitIssue();
    }

    @And("^Click view issues$")
    public void clickViewIssues() throws Throwable {
        MantisSite.issueViewPage.openViewIssuePage();
    }

    @Then("^Check view issues contains create issue with \"([^\"]*)\" and with \"([^\"]*)\"$")
    public void checkViewIssuesContainsCreateIssueWithAndWith(String status, String form) throws Throwable {
        softAssert.assertTrue(MantisSite.issueViewPage.isExistRow(ResourseLoaderSTU.getFieldData(form),status));
    }

    @Given("^Logout$")
    public void logout() throws Throwable {
        MantisSite.issueViewPage.logout();
    }

    @When("^Click view issue$")
    public void clickViewIssue() throws Throwable {
        MantisSite.issueViewPage.openViewIssuePage();
    }

    @When("^Open issue by number with \"([^\"]*)\"$")
    public void openIssueByNumberWith(String form) throws Throwable {
        MantisSite.issueViewPage.clickIDIssue(ResourseLoaderSTU.getFieldData(form));
    }

    @Then("^Check data in issue with \"([^\"]*)\"$")
    public void checkDataInIssueWith(String form) throws Throwable {
        softAssert.assertTrue(MantisSite.issueViewPage.checkIssueForm(ResourseLoaderSTU.getFieldData(form)));
    }

    @When("^Change issue status to \"([^\"]*)\"$")
    public void changeIssueStatusTo(String status) throws Throwable {
        MantisSite.issueViewPage.setStatusIssue(status);
    }

    @And("^Close issue$")
    public void closeIssue() throws Throwable {
        MantisSite.issueViewPage.closeIssue();
    }

    @And("^Open resentlty modified issues$")
    public void openResentltyModifiedIssues() throws Throwable {
        MantisSite.issueViewPage.openRecentlyModified();
    }
}
