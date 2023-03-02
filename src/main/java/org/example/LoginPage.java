package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "login_field")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(name = "commit")
    private WebElement signInButton;

    @FindBy(className = "header-logo")
    private WebElement logo;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    public LoginPage logoIsShown() {
        Assert.isTrue(logo.isDisplayed(), "Logo is not shown");
        return this;
    }

    public WebElement getLogo() {
        return logo;
    }


    public MainPage successfulLogin(String login, String password) {
        loginField.sendKeys(login);
        this.password.sendKeys(password);
        signInButton.click();
        System.out.println("Success");
        return new MainPage(driver);
    }

}
