package br.com.barriga.page;

import br.com.barriga.core.BasePage;
import org.openqa.selenium.By;

import static br.com.barriga.core.BaseDriver.initBrowser;

public class LoginPage extends BasePage {

    public void setField(By by, String message) {
        initBrowser().findElement(by).clear();
        initBrowser().findElement(by).sendKeys(message);
    }

    public String getAlert() {
        return initBrowser().findElement(By.className("alert")).getText();
    }

    public void clickButtonLogin() {
        initBrowser().findElement(By.xpath("//button[contains(text(), 'Entrar')]")).click();
    }
}
