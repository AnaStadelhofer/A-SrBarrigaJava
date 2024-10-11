package br.com.barriga.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static br.com.barriga.core.BaseTest.*;


public class BasePage {

    protected WebDriver driver;

    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

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

    public void navegeMovement() {
        initBrowser().findElement(By.xpath("//a[contains(text(), \"Criar Movimentação\")]")).click();
    }

    public String getAlert() {
        return initBrowser().findElement(By.className("alert")).getText();
    }

    public void navegeMovementMonthly() {
        initBrowser().findElement(By.xpath("//a[@href=\"/extrato\"]")).click();
    }

}
