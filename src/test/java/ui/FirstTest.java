package ui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;

public class FirstTest extends BaseTest {

    @Test
    public void someChecks() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();

        WebElement loginField = driver.findElement(By.xpath("//input[@id='login_field']"));
        loginField.sendKeys("test9874@ukr.net");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("test9874@ukr.net");

        WebElement signInButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
        signInButton.click();


        WebElement textArea = driver.findElement(By.xpath("//h2[@class='h2 lh-condensed mb-2']"));

        String actualResult = textArea.getText();

        String expectedResult = "Discover interesting projects and people to populate your personal news feed.";

        System.out.println(actualResult);


    }

}
