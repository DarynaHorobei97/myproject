package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private  By signInButton = By.xpath("//a[contains(text(),\"Sign in\")]");
    private final static String TITLE = "Home page";

    public HomePage(WebDriver driver) {
        super(driver, TITLE);
    }

    public LoginPage goToLoginPage() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }



}
