package org.example;

import org.openqa.selenium.WebDriver;

public class ProfileForm extends BasePage {



    public ProfileForm(WebDriver driver) {
        super(driver);
    }

    public RepositoriesPage goToRepositoriesTab(){
        driver.get("https://github.com/darynahorobei123?tab=repositories");
        return new RepositoriesPage(driver);
    }
}
