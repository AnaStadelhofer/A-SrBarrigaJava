package br.com.barriga.core;
import java.io.IOException;

import java.io.File;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest extends PageProducer{

    public BaseTest() {
        initBrowser();
        initializePages(driver);
    }

    protected static WebDriver driver;

    public static boolean closeBrowser = false;

    public static WebDriver initBrowser() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://seubarriga.wcaquino.me/login");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void quitBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    @Rule
    public TestName testName = new TestName();

    @After
    public void endTests() throws IOException {

        TakesScreenshot ss = (TakesScreenshot) initBrowser();
        File archive = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archive, new File("Target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));

        if (closeBrowser) {
            quitBrowser();
        }
    }
}