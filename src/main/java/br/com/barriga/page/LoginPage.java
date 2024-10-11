package br.com.barriga.page;
import br.com.barriga.core.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(), 'Entrar')]")
    private WebElement submitLogin;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "senha")
    private WebElement password;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement buttonLogout;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        buttonLogout.click();
    }

    public void login(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        submitLogin.click();
    }

}
