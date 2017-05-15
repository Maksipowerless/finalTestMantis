package spbstu.telematika.factoryPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import spbstu.telematika.factoryPageObjects.entities.FieldData;
import sun.awt.motif.X11CNS11643;


import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * Created by maxfromperek on 09.04.17.
 */
public class FactoryPageobjectsIssuePage {

    @FindBy(xpath = "//a[contains(text(), 'Report Issue')]")
    WebElement buttonReportIssue;

    @FindBy(id = "category_id")
    WebElement checkCategory;

    @FindBy(id = "reproducibility")
    WebElement checkReproducibility;

    @FindBy(id = "severity")
    WebElement checkSeverity;

    @FindBy(id = "priority")
    WebElement checkPriority;

    @FindBy(xpath = "//*[@alt = '+']")
    WebElement buttonUncover;

    @FindBy(id = "platform")
    WebElement fieldPlatform;

    @FindBy(id = "os")
    WebElement fielsOS;

    @FindBy(id = "os_build")
    WebElement fieldOSBuild;

    @FindBy(id = "handler_id")
    WebElement checkAssignTo;

    @FindBy(id = "summary")
    WebElement fieldSummary;

    @FindBy(id = "description")
    WebElement fieldDescription;

    @FindBy(id = "steps_to_reproduce")
    WebElement fieldStepToReproduce;

    @FindBy(id = "additional_info")
    WebElement fieldAdditionalInfo;

    @FindBy(id = "tag_string")
    WebElement fieldTagString;

    @FindBy(xpath = "//input[contains(@class, 'btn btn-primary')]")
    WebElement buttonSubmitUssue;

    @FindBy(xpath = "//select[@name='action']//option[@value='DELETE']")
    WebElement menuDelete;

    @FindBy(xpath = "//input[@value='OK']")
    WebElement buttonChoseOk;

    @FindBy(xpath = "//input[@value='Delete Issues']")
    WebElement buttonDeleteIssues;

    @FindBy(xpath = "//*[@class='user-info']")
    WebElement buttonUserInfo;

    @FindBy(xpath = "//a[@href='/mantisbt/logout_page.php']")
    WebElement menuLogout;

    @FindBy(xpath = "//span[contains(text(),'View Issues')]")
    WebElement buttonViewIssue;

    @FindAll({@FindBy(xpath = "//table[@id='buglist']/tbody/tr[*]")})
    List<WebElement> listRowsTableIssues;

    @FindBy(xpath = "//*/td[@class='bug-reporter']")
    WebElement issueTableReporter;

    @FindBy(xpath = "//*/td[@class='bug-assigned-to']")
    WebElement issueTableAssignedTo;

    @FindBy(xpath = "//*/td[@class='bug-platform']")
    WebElement issueTalbePlatform;

    @FindBy(xpath = "//*/td[@class='bug-severity']")
    WebElement issueTableSeverity;

    @FindBy(xpath = "//*/td[@class='bug-resolution']")
    WebElement issueTableResolution;

    @FindBy(xpath = "//*/td[@class='bug-os']")
    WebElement issueTableOS;

    @FindBy(xpath = "//*/td[@class='bug-reproducibility']")
    WebElement issueTableReproducibility;

    @FindBy(xpath = "//*/td[@class='bug-os-version']")
    WebElement issueTableOSVersion;

    @FindBy(xpath = "//*/td[@class='bug-status']")
    WebElement issueTableBugStatus;

    @FindBy(xpath = "//*/td[@class='bug-priority']")
    WebElement issueTablePriority;

    @FindBy(xpath = "//*/td[@class='bug-summary']")
    WebElement issueTableSummary;

    @FindBy(xpath = "//*/td[@class='bug-description']")
    WebElement issueTableDescription;

    @FindBy(xpath = "//*/td[@class='bug-steps-to-reproduce']")
    WebElement issueTableStepsToReproduce;

    @FindBy(xpath = "//*/td[@class='bug-additional-information']")
    WebElement issueTableAdditionalInfo;


    @FindBy(xpath = " //*[@name='new_status' and @class='input-sm']")
    WebElement buttonNewStatus;

    @FindBy(xpath = "//input[@type='submit' and @value='Change Status To:']")
    WebElement buttonChangeStatusTo;

    @FindBy(xpath = "//input[@type='submit' and @value='Resolve Issue']")
    WebElement buttonResolveIssue;

    @FindBy(xpath = "//input[@type='submit' and @value='Close']")
    WebElement buttonClose;

    @FindBy(xpath = "//input[@type='submit' and @value='Close Issue']")
    WebElement buttonCloseIssue;



    public void openReportIssuePage() {
        buttonReportIssue.click();
    }

    public void fillFieldsIssue(FieldData fieldData) {

        String category = fieldData.getCategory();
        checkCategory.findElement(By.xpath("//option[contains(text(), '" + category + "')]")).click();

        String reproducibility = fieldData.getReproducibility();
        checkReproducibility.findElement(By.xpath("//option[contains(text(), '" + reproducibility + "')]")).click();

        String severity = fieldData.getSeverity();
        checkSeverity.findElement(By.xpath("//option[contains(text(), '" + severity + "')]")).click();

        String priority = fieldData.getPriority();
        checkPriority.findElement(By.xpath("//option[contains(text(), '" + priority + "')]")).click();


        if (buttonUncover.isDisplayed())
            buttonUncover.click();
        fieldPlatform.sendKeys(fieldData.getPlatform());
        fielsOS.sendKeys(fieldData.getOs());
        fieldOSBuild.sendKeys(fieldData.getOsVersion());

        String assignTo = fieldData.getAssignTo();
        checkAssignTo.findElement(By.xpath("//option[contains(text(), '" + assignTo + "')]")).click();

        fieldSummary.sendKeys(fieldData.getSummary());
        fieldDescription.sendKeys(fieldData.getDescription());
        fieldStepToReproduce.sendKeys(fieldData.getSteptoreproduce());
        fieldAdditionalInfo.sendKeys(fieldData.getAdditionalinfo());
    }

    public void submitIssue() {
        buttonSubmitUssue.click();
    }

    public void deleteIssues() {
        menuDelete.click();
        buttonChoseOk.click();
        buttonDeleteIssues.click();
    }

    public void logout() {
        buttonUserInfo.click();
        menuLogout.click();
    }

    public void openViewIssuePage() {
        buttonViewIssue.click();
    }

    public boolean isExistRow(FieldData data, String str) {

        List<String> checkedFields = listRowsTableIssues.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        return checkedFields.stream().anyMatch(e -> e.contains(data.getSummary()) && e.contains(data.getCategory())
            && e.contains(data.getSeverity()) && e.contains(data.getAssignTo()) && e.contains(str));
    }

    public void clickIDIssue(FieldData data)
    {

        listRowsTableIssues.stream()
                .filter(issue -> issue.getText().contains(data.getSummary()) && issue.getText().contains(data.getCategory())
                && issue.getText().contains(data.getSeverity()) && issue.getText().contains(data.getAssignTo()))
                .findFirst().get()
                .findElement(By.xpath("//table[@id='buglist']/tbody/tr[*]/td[4]/a"))
                .click();
    }

    public boolean checkIssueForm(FieldData data)
    {
        return (issueTableAdditionalInfo.getText().equals(data.getAdditionalinfo()) && issueTableAssignedTo.getText().equals(data.getAssignTo())
                && issueTableBugStatus.getText().equals("assigned") && issueTableDescription.getText().equals(data.getDescription())
                && issueTableOS.getText().equals(data.getOs()) && issueTableOSVersion.getText().equals(data.getOsVersion())
                && issueTableReporter.getText().equals("tester") && issueTableReproducibility.getText().equals(data.getReproducibility())
                && issueTableResolution.getText().equals("open") && issueTableSeverity.getText().equals(data.getSeverity())
                && issueTalbePlatform.getText().equals(data.getPlatform()) && issueTableSummary.getText().contains(data.getSummary())
                && issueTablePriority.getText().equals(data.getPriority()) && issueTableStepsToReproduce.getText().equals(data.getSteptoreproduce()));
    }

    public void setStatusIssue(String str)
    {
        buttonNewStatus.click();
        buttonNewStatus.findElement(By.xpath("//*/option[contains(text(), '" + str + "')]")).click();

    }

    public void changeStatus()
    {
        buttonChangeStatusTo.click();
        buttonResolveIssue.click();
    }

    public void closeIssue()
    {
        buttonClose.click();
        buttonCloseIssue.click();
    }
    public void ckeckRow(String str) {

        //listRowsSummary.stream()
        //       .filter(issue -> issue.getText().equals(str))
        //      .findFirst().get()
        //       .findElement(By.xpath("//*/td[1]//span[@class='lbl']"))
        //       .click();
    }
}
