package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class base {
    protected WebDriver driver;
    protected Properties prop;
    protected WebDriverWait wait;


    public void launchBrowser() {
        String url = "https://www.amazon.in/";
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_leak_detection", false);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);

    }


    @BeforeMethod
    public void setUpMethod() {
        launchBrowser(); // new browser per iteration
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit(); // kill browser
    }


}