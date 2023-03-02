package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    private final static String TITLE = "Main page";
    WebElement img = driver.findElement(By.xpath("//summary[@aria-label='View profile and more']"));

    public MainPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public ProfileForm goToProfileForm() {
        img.click();
        return new ProfileForm(driver);
    }
}
