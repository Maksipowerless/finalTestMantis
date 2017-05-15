package spbstu.telematika.webtest;


import cucumber.api.java.it.Ma;
import org.testng.annotations.Test;
import spbstu.telematika.MantisSite;
import spbstu.telematika.helper.ResourseLoaderSTU;


import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by maxfromperek on 04.04.17.
 */
public class ManstisFactoryPageobjectsTest extends BaseFactoryPagebjectsTest {

    @Test
    public void adminReportIssueUserCheckTest() {

        MantisSite.open();
        MantisSite.contactFormPage.fillLoginPasswordForm(ResourseLoaderSTU.getUser("tester"));
        MantisSite.contactFormPage.submitContactForm();

        MantisSite.issuePage.openReportIssuePage();
        MantisSite.issuePage.fillFieldsIssue(ResourseLoaderSTU.getFieldData("form1"));
        MantisSite.issuePage.submitIssue();
        MantisSite.issuePage.openViewIssuePage();
        softAssert.assertTrue(MantisSite.issuePage.isExistRow(ResourseLoaderSTU.getFieldData("form1"),"assigned"));
        MantisSite.issuePage.logout();

        MantisSite.contactFormPage.fillLoginPasswordForm(ResourseLoaderSTU.getUser("developer"));
        MantisSite.contactFormPage.submitContactForm();
        MantisSite.issuePage.openViewIssuePage();
        softAssert.assertTrue(MantisSite.issuePage.isExistRow(ResourseLoaderSTU.getFieldData("form1"), "assigned"));
        MantisSite.issuePage.clickIDIssue(ResourseLoaderSTU.getFieldData("form1"));
        softAssert.assertTrue(MantisSite.issuePage.checkIssueForm(ResourseLoaderSTU.getFieldData("form1")));

        MantisSite.issuePage.setStatusIssue("resolved");
        MantisSite.issuePage.changeStatus();
        MantisSite.issuePage.logout();

        MantisSite.contactFormPage.fillLoginPasswordForm(ResourseLoaderSTU.getUser("manager"));
        MantisSite.contactFormPage.submitContactForm();
        MantisSite.issuePage.openViewIssuePage();
        softAssert.assertTrue(MantisSite.issuePage.isExistRow(ResourseLoaderSTU.getFieldData("form1"), "resolved"));

        MantisSite.issuePage.clickIDIssue(ResourseLoaderSTU.getFieldData("form1"));
        MantisSite.issuePage.setStatusIssue("closed");
        MantisSite.issuePage.closeIssue();

        softAssert.assertAll();
    }

}
