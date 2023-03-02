package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ProfileForm extends BasePage {
    private final static String TITLE = "ProfileForm page";
    private WebElement yourRepositoriesButton = driver.findElement(By.xpath("//a[text()='Your repositories']"));
    private By sloganLocator = By.xpath("//h1");
    private By signOutButtonLocator = By.xpath("//button[contains(text(),'Sign out')]");

    public ProfileForm(WebDriver driver) {
        super(driver, TITLE);
    }

    public RepositoriesPage goToRepositoriesPage() {
        yourRepositoriesButton.click();
        return new RepositoriesPage(driver);
    }

    public HomePage signOutFromGitHub() {
        Assertions.assertTrue(driver.findElement(signOutButtonLocator).isDisplayed());
        driver.findElement(signOutButtonLocator).click();
        Assertions.assertEquals("Let’s build from here", driver.findElement(sloganLocator).getText());
        return new HomePage(driver);
    }


}
