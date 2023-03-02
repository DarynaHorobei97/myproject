package pages;

import dev.failsafe.internal.util.Assert;
import helpers.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.jupiter.api.Assertions;

import static dev.failsafe.internal.util.Assert.*;
import static helpers.ColorPrinter.printColorMessage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginPage extends BasePage {

    private final static String TITLE = "Login page";
    private WebElement loginField = driver.findElement(By.xpath("//input[@id='login_field']"));
    private WebElement passwordField = driver.findElement(By.id("password"));
    private WebElement signInButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
    private By errorMessage = By.xpath("//div[contains(text(), 'Incorrect')]");


    private WebElement logo = driver.findElement(By.className("header-logo"));

    public LoginPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public WebElement getLogo() {
        return logo;
    }

    public MainPage loginSuccessful(String login, String password) {
        webDriverWait.until(elementToBeClickable(loginField));
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        signInButton.click();
        log.info("Successful authorization");
        printColorMessage("Successful authorization", log, Level.INFO);
        return new MainPage(driver);
    }

    public LoginPage loginNegative(String login, String password){
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        signInButton.click();
        return this;
    }

    public LoginPage validateErrorMessage(String expectedMessage){
        assertEquals(expectedMessage, driver.findElement(errorMessage).getText());
        return this;
    }

    public LoginPage checkAuthFields(){
        printColorMessage("Authorization fields are being validating", log, Level.INFO);
        Assertions.assertTrue(loginField.isDisplayed(), "Login field is visible");
        Assertions.assertTrue(passwordField.isDisplayed(), "Password field is visible");
        Assertions.assertTrue(signInButton.isDisplayed(), "signInButton is visible");
        return this;
    }

}
