package spbstu.telematika.webtest;

import org.testng.annotations.Test;
import spbstu.telematika.MantisSite;
import spbstu.telematika.helper.ResourseLoaderSTU;


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

        MantisSite.issuePage.openRecentlyModified();
        softAssert.assertTrue(MantisSite.issuePage.isExistRow(ResourseLoaderSTU.getFieldData("form1"), "closed"));

        MantisSite.issuePage.checkRow(ResourseLoaderSTU.getFieldData("form1"));
        MantisSite.issuePage.deleteIssues();
        MantisSite.issuePage.logout();
        softAssert.assertAll();
    }

}
