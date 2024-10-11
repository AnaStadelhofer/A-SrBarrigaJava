package br.com.barriga.test;
import br.com.barriga.core.BaseTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Account extends BaseTest {

    @Before
    public void initLogin() {
        getLoginPage().login("ana@teste.com", "12345");
    }

    @After
    public void endLogout(){
        getLoginPage().logout();
    }

    @Order(1)
    @Test
    public void insertAccount() {
        getAccountPage().insertAccount("Luz");
        Assert.assertEquals("Conta adicionada com sucesso!", getBasePage().getAlert());
        getAccountPage().deleteAccount("Luz");
    }

    @Order(2)
    @Test
    public void insertRepeatAccount() {
        getAccountPage().insertAccount("Boleto");
        getAccountPage().insertAccount("Boleto");
        Assert.assertEquals("Já existe uma conta com esse nome!", getBasePage().getAlert());

        getBasePage().navegeMenuListAccount();
        getAccountPage().deleteAccount("Boleto");
    }

    @Order(3)
    @Test
    public void editAccount() {
        getAccountPage().insertAccount("Cartão Credit");
        getAccountPage().editAccount("Cartão Credit", "Cartão Credito");
        Assert.assertEquals("Conta alterada com sucesso!", getBasePage().getAlert());
    }

    @Order(4)
    @Test
    public void removeAccount() {
        getAccountPage().insertAccount("Internet");
        getAccountPage().deleteAccount("Internet");
        Assert.assertEquals("Conta removida com sucesso!", getBasePage().getAlert());
    }

    @Order(5)
    @Test
    public void removeAccountWithMovement() {
        getAccountPage().validateAccountExist("Telefone");
        getMovementPage().createMovement("Despesa","Telefone", "08/10/2024", "08/10/2024",
                "Descrição de pagamento", "Governo", "100", "Pago");

        getBasePage().navegeMenuListAccount();

        getAccountPage().deleteAccount("Telefone");
        Assert.assertEquals("Conta em uso na movimentações", getBasePage().getAlert());

        getBasePage().navegeMovementMonthly();
        getMovementPage().filterDate("Outubro", "2024");
        getMovementPage().removeMovementRecent("Descrição de pagamento");
    }
}
