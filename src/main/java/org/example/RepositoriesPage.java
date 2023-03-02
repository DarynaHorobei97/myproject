package org.example;

import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class RepositoriesPage extends BasePage {

    private List<WebElement> repositories = driver.findElements(By.xpath("//a[@itemprop='name codeRepository']"));

    public RepositoriesPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getRepositories() {
        List<String> list = repositories.stream().map(rep -> rep.getText()).collect(Collectors.toList());
        return list;
    }
}
