package br.com.barriga.page;
import br.com.barriga.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static br.com.barriga.core.BaseTest.initBrowser;

public class MovementPage extends BasePage {

    @FindBy(id = "data_transacao")
    private WebElement dateTransaction;

    @FindBy(id = "data_pagamento")
    private WebElement datePayment;

    @FindBy(id = "descricao")
    private WebElement description;

    @FindBy(id = "interessado")
    private WebElement stakeholder;

    @FindBy(id = "valor")
    private WebElement value;

    @FindBy(id = "status_pago")
    private WebElement statusPaid;

    @FindBy(id = "status_pendente")
    private WebElement statusPayPending;

    @FindBy(xpath = "//button[contains(text(), \"Salvar\")]")
    private WebElement buttonSave;

    @FindBy(id = "tipo")
    private WebElement typeMovement;

    @FindBy(id = "conta")
    private WebElement typeAccount;

    @FindBy(id = "mes")
    private WebElement month;

    @FindBy(id = "ano")
    private WebElement year;

    protected WebDriver driver;
    protected Actions actions;

    public MovementPage(WebDriver driver) {
        super(driver);
    }

    public void selectMovement(String type) {
        WebElement elementMovement = typeMovement;
        Select typeMovement = new Select(elementMovement);
        typeMovement.selectByVisibleText(type);
    }

    public void selectTypeAccount(String type) {
        WebElement elementAccount = typeAccount;
        Select typeAccount = new Select(elementAccount);
        typeAccount.selectByVisibleText(type);
    }

    public void selectMonth(String selectMonth) {
        WebElement elementMonth = month;
        Select month = new Select(elementMonth);
        month.selectByVisibleText(selectMonth);
    }

    public void selectYear(String selectYear) {
        WebElement elementYear = year;
        Select year = new Select(elementYear);
        year.selectByVisibleText(selectYear);
    }

    public void selectPayment(String pay) {
        if(pay == "Pago"){
            statusPaid.click();
        } else {
            statusPayPending.click();
        }
    }

    public void createMovement(String typeAccount, String movement, String dateTransaction,
                               String datePayment, String description, String stakeholder,
                               String value, String statusPayment) {
        navegeMovement();

        selectMovement(typeAccount);
        selectTypeAccount(movement);

        this.dateTransaction.sendKeys(dateTransaction);
        this.datePayment.sendKeys(datePayment);
        this.description.sendKeys(description);
        this.stakeholder.sendKeys(stakeholder);
        this.value.sendKeys(value);
        selectPayment(statusPayment);
        buttonSave.click();
    }

    public void removeMovementRecent(String name) {
        initBrowser().findElement(By.xpath("//tr[td[contains(normalize-space(text()), '" + name + "')]]//a[contains(@href, 'removerMovimentacao')]")).click();
    }

    public void filterDate(String month, String year) {
        selectMonth(month);
        selectYear(year);
    }

}
