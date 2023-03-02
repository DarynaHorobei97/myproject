package pack.old;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.HomePage;
import org.example.LoginPage;
import org.example.ProfileForm;
import org.example.RepositoriesPage;
import ui.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class Some extends BaseTest {


    @Test
    public void checkLogoIsShownOnTheHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        Assertions.assertTrue(loginPage.getLogo().isDisplayed());
    }

    @Test
    public void checkListRepositories() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successfulLogin("test9874@ukr.net", "test9874@ukr.net");
        ProfileForm profileForm = new ProfileForm(driver);
        profileForm.goToRepositoriesTab();
        List <String>expectedReposList = new ArrayList<>();
        expectedReposList.add("test2");
        expectedReposList.add("test1");
        expectedReposList.add("test");


        RepositoriesPage repositoriesPage = new RepositoriesPage(driver);

        Assertions.assertEquals(expectedReposList,repositoriesPage.getRepositories());
    }
}
