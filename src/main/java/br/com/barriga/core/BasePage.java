package br.com.barriga.core;

import org.openqa.selenium.By;

import static br.com.barriga.core.BaseDriver.initBrowser;


public class BasePage {

    public void setField(By by, String message) {
        initBrowser().findElement(by).clear();
        initBrowser().findElement(by).sendKeys(message);
    }

    public void navegeMenuInsertAccount() {
        initBrowser().findElement(By.className("dropdown-toggle")).click();
        initBrowser().findElement(By.xpath("//a[contains(text(), 'Adicionar')]")).click();
    }

    public void navegeMenuListAccount() {
        initBrowser().findElement(By.className("dropdown-toggle")).click();
        initBrowser().findElement(By.xpath("//a[contains(text(), 'Listar')]")).click();
    }

}
