package br.com.barriga.test;
import br.com.barriga.core.BaseTest;

import org.junit.Assert;
import org.junit.Test;

public class Login extends BaseTest {

    @Test
    public void loginSuccessfully () {
        getLoginPage().login("ana@teste.com", "12345");
        Assert.assertEquals("Bem vindo, ana!", getBasePage().getAlert());
        getLoginPage().logout();
    }

    @Test
    public void loginMandatoryEmail() {
        getLoginPage().login("", "12345");
        Assert.assertEquals("Email é um campo obrigatório", getBasePage().getAlert());
    }

    @Test
    public void loginMandatoryPassword() {
        getLoginPage().login("ana@teste.com", "");
        Assert.assertEquals("Senha é um campo obrigatório", getBasePage().getAlert());
    }

    @Test
    public void loginInvalid() {
        getLoginPage().login("ana@teste.com", "senha errada");
        Assert.assertEquals("Problemas com o login do usuário", getBasePage().getAlert());
    }

}
