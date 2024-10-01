package br.com.barriga.core;
import java.io.IOException;

import java.io.File;

import br.com.barriga.page.AccountPage;
import br.com.barriga.page.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static br.com.barriga.core.BaseDriver.*;

public class BaseTest {
    protected static LoginPage login = new LoginPage();
    protected static AccountPage account = new AccountPage();

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() {
        login.setField(By.id("email"), "ana@teste.com");
        login.setField(By.id("senha"), "12345");
        login.clickButtonLogin();
    }

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