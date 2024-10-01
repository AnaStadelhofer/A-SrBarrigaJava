package br.com.barriga.test;

import br.com.barriga.core.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class Login extends BaseTest {

    @Before
    public void setUp() {
    }

    @Test
    public void loginSuccessfully () {
        login.setField(By.id("email"), "ana@teste.com");
        login.setField(By.id("senha"), "12345");
        login.clickButtonLogin();
        Assert.assertEquals("Bem vindo, ana!", login.getAlert());
    }

}
