package br.com.barriga.page;
import static br.com.barriga.core.BaseTest.initBrowser;
import br.com.barriga.core.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountPage extends BasePage {

    @FindBy(id = "nome")
    private WebElement name;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSave;

    public AccountPage(WebDriver driver)
    {
        super(driver);
    }

    public void insertAccount(String accountName) {
        navegeMenuInsertAccount();

        name.sendKeys(accountName);
        buttonSave.click();
    }

    public void deleteAccount(String accountName) {
        initBrowser().findElement(By.xpath("//tr[td[contains(normalize-space(text()), '" + accountName + "')]]//a[contains(@href, '/removerConta')]")).click();
    }

    public void editAccount(String accountName, String newValue) {
        initBrowser().findElement(By.xpath("//tr[td[contains(normalize-space(text()), '" + accountName + "')]]//a[contains(@href, '/editarConta')]")).click();
        name.clear();
        name.sendKeys(newValue);
        buttonSave.click();
    }

    public Boolean validateAccountExist(String accountName) {
        navegeMenuListAccount();
        List<WebElement> elements = initBrowser().findElements(By.xpath("//td[contains(text(), '" + accountName + "')]"));

        if(!elements.isEmpty()) {
        } else {
            insertAccount(accountName);
        }

        return !elements.isEmpty();
    }

}
