package spbstu.telematika.factoryPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spbstu.telematika.factoryPageObjects.entities.User;


import java.util.Map;

/**
 * Created by maxfromperek on 04.04.17.
 */
public class FactoryPageobjectsContactFormPage {

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(css = "[type = 'submit']")
    WebElement buttonSubmit;

    public void fillLoginPasswordForm(User user) {
        this.username.sendKeys(user.getLogin());
        this.password.sendKeys(user.getPassword());
    }

    public void submitContactForm() {
        this.buttonSubmit.click();
    }

}
