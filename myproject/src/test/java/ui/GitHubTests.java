package ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GitHubTests extends BaseTest {
    protected Logger logger;

    @Test
    public void checkLogoOnTheLoginPage() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.getLogo().isDisplayed());
    }


    @Test
    public void checkRepositoriesList() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSuccessful("test9874@ukr.net", "test9874@ukr.net");
        MainPage mainPage = new MainPage(driver);
        mainPage.goToProfileForm();
        ProfileForm profileForm = new ProfileForm(driver);
        profileForm.goToRepositoriesPage();

        List<String> expectedRepositoriesList = new ArrayList<>();
        expectedRepositoriesList.add("test2");
        expectedRepositoriesList.add("test1");
        expectedRepositoriesList.add("test");

        RepositoriesPage repositoriesPage = new RepositoriesPage(driver);
        Assertions.assertEquals(expectedRepositoriesList, repositoriesPage.getRepositories());
        Logger logger = LogManager.getLogger();
        logger.info("checkRepositoriesList Test passed successfully!");
    }

    @Test
    public void verifyNegativeLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSuccessful("test9874@ukr.net", "test9874@ukr.net");
        MainPage mainPage = new MainPage(driver);
        mainPage.goToProfileForm();

    }

    @Tag("production")
    @Test
    public void verifyLogOutFromGitHub() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSuccessful("test9874@ukr.net", "test9874@ukr.net");
        MainPage mainPage = new MainPage(driver);
        mainPage.goToProfileForm();
        ProfileForm profileForm = new ProfileForm(driver);
        profileForm.signOutFromGitHub();
    }
}
