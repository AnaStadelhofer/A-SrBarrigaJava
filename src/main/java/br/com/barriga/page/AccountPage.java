package br.com.barriga.page;

import br.com.barriga.core.BasePage;
import org.openqa.selenium.By;

import static br.com.barriga.core.BaseDriver.initBrowser;

public class AccountPage extends BasePage {

    public void setField(By by, String message) {
        initBrowser().findElement(by).clear();
        initBrowser().findElement(by).sendKeys(message);
    }

    public void navegeMenuInsertAccount() {
        initBrowser().findElement(By.className("dropdown-toggle")).click();
        initBrowser().findElement(By.xpath("//a[contains(text(), 'Adicionar')]")).click();
    }

}
