package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private final WebElement signIn = driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]"));

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage(){
        signIn.click();
        return new LoginPage(driver);
    }

}
