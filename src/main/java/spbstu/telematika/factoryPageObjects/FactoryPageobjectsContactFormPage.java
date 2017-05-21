package spbstu.telematika.factoryPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spbstu.telematika.factoryPageObjects.entities.User;

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
