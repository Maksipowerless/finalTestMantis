package spbstu.telematika.factoryPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import spbstu.telematika.factoryPageObjects.entities.FieldData;


import java.util.List;
import java.util.stream.Collectors;


public class PageobjectsReportIssuePage {

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

    @FindBy(xpath = "//input[@value='Submit Issue']")
    WebElement buttonSubmitUssue;



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

}
