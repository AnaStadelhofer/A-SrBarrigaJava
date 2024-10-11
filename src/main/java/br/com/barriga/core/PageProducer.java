package br.com.barriga.core;

import br.com.barriga.page.AccountPage;
import br.com.barriga.page.LoginPage;
import br.com.barriga.page.MovementPage;
import org.openqa.selenium.WebDriver;

public class PageProducer {
    private static LoginPage login;
    private static AccountPage account;
    private static BasePage basepage;
    private static MovementPage movement;

    public PageProducer() {
    }

    public static LoginPage getLoginPage() {
        return login;
    }

    public static AccountPage getAccountPage() {
        return account;
    }

    public static BasePage getBasePage() {
        return basepage;
    }

    public static MovementPage getMovementPage() {
        return movement;
    }

    protected void initializePages(WebDriver driver) {
        login = new LoginPage(driver);
        account = new AccountPage(driver);
        basepage = new BasePage(driver);
        movement = new MovementPage(driver);

    }


}
