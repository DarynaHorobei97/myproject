package ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    protected Logger logger;

    @BeforeEach
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\daryn\\Downloads\\G46Automation-g46\\src\\main\\resources\\drivers\\chromedriver.exe");
        Logger logger = LogManager.getLogger();
        logger.info("\"Chrome driver object creation starting\"");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://github.com");

    }

    @AfterEach
    public void tearDown() {
        //closeWebDriver();
        driver.quit();

    }
}
