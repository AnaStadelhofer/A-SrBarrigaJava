package br.com.barriga.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {

    private static WebDriver driver;

    public static boolean closeBrowser = false;

    private BaseDriver() {
    }

    public static WebDriver initBrowser() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://seubarriga.wcaquino.me/login");
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}