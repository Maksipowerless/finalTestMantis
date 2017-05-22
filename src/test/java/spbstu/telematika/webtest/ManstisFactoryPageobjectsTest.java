package spbstu.telematika.webtest;

import nl.flotsam.xeger.Xeger;
import org.testng.annotations.Test;
import spbstu.telematika.MantisSite;
import spbstu.telematika.helper.ResourseLoaderSTU;



public class ManstisFactoryPageobjectsTest extends BaseFactoryPagebjectsTest {

    @Test
    public void adminReportIssueUserCheckTest() {

        MantisSite.open();
        MantisSite.contactFormPage.fillLoginPasswordForm(ResourseLoaderSTU.getUser("tester"));
        MantisSite.contactFormPage.submitContactForm();

        MantisSite.issueReportPage.openReportIssuePage();
        MantisSite.issueReportPage.fillFieldsIssue(ResourseLoaderSTU.getFieldData("form1"));
        MantisSite.issueReportPage.submitIssue();

        MantisSite.issueViewPage.openViewIssuePage();
        softAssert.assertTrue(MantisSite.issueViewPage.isExistRow(ResourseLoaderSTU.getFieldData("form1"),"assigned"));
        MantisSite.issueViewPage.logout();

        MantisSite.contactFormPage.fillLoginPasswordForm(ResourseLoaderSTU.getUser("developer"));
        MantisSite.contactFormPage.submitContactForm();
        MantisSite.issueViewPage.openViewIssuePage();
        softAssert.assertTrue(MantisSite.issueViewPage.isExistRow(ResourseLoaderSTU.getFieldData("form1"), "assigned"));
        MantisSite.issueViewPage.clickIDIssue(ResourseLoaderSTU.getFieldData("form1"));
        softAssert.assertTrue(MantisSite.issueViewPage.checkIssueForm(ResourseLoaderSTU.getFieldData("form1")));

        MantisSite.issueViewPage.setStatusIssue("resolved");
        MantisSite.issueViewPage.changeStatus();
        MantisSite.issueViewPage.logout();

        MantisSite.contactFormPage.fillLoginPasswordForm(ResourseLoaderSTU.getUser("manager"));
        MantisSite.contactFormPage.submitContactForm();
        MantisSite.issueViewPage.openViewIssuePage();
        softAssert.assertTrue(MantisSite.issueViewPage.isExistRow(ResourseLoaderSTU.getFieldData("form1"), "resolved"));

        MantisSite.issueViewPage.clickIDIssue(ResourseLoaderSTU.getFieldData("form1"));
        MantisSite.issueViewPage.setStatusIssue("closed");
        MantisSite.issueViewPage.closeIssue();

        MantisSite.issueViewPage.openRecentlyModified();
        softAssert.assertTrue(MantisSite.issueViewPage.isExistRow(ResourseLoaderSTU.getFieldData("form1"), "closed"));

        MantisSite.issueViewPage.checkRow(ResourseLoaderSTU.getFieldData("form1"));
        MantisSite.issueViewPage.deleteIssues();
        MantisSite.issueViewPage.logout();
        softAssert.assertAll();
    }

}
