package br.com.barriga.test;
import br.com.barriga.core.BaseTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Movement extends BaseTest {

    @Before
    public void initLogin() {
        getLoginPage().login("ana@teste.com", "12345");
        getAccountPage().validateAccountExist("Telefone");
    }

    @After
    public void endLogout(){
        getLoginPage().logout();
    }

    @Order(1)
    @Test
    public void insertMovement() {
        getMovementPage().createMovement("Despesa","Telefone", "08/10/2024", "08/10/2024",
                                        "Descrição de pagamento", "Governo", "100", "Pago");

        Assert.assertEquals("Movimentação adicionada com sucesso!", getBasePage().getAlert());
    }

    @Order(2)
    @Test
    public void insertFutureMovement() {
        getMovementPage().createMovement("Despesa","Telefone", "08/10/2030", "08/10/2024",
                "Descrição de pagamento", "Governo", "100", "Pago");

        Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", getBasePage().getAlert());
    }

    @Order(3)
    @Test
    public void deleteMovement() {
        getMovementPage().createMovement("Despesa","Telefone", "08/10/2024", "08/10/2024",
                "Remover teste", "Governo", "100", "Pago");

        getBasePage().navegeMovementMonthly();
        getMovementPage().filterDate("Outubro", "2024");
        getMovementPage().removeMovementRecent("Remover teste");

        Assert.assertEquals("Movimentação removida com sucesso!", getBasePage().getAlert());
    }

    @Order(4)
    @Test
    public void numberInvalid() {
        getMovementPage().createMovement("Despesa","Telefone", "08/10/2024", "08/10/2024",
                "Descrição de pagamento", "Governo", "R$ 10,00", "Pago");

        Assert.assertEquals("Valor deve ser um número", getBasePage().getAlert());
    }

    @Order(5)
    @Test
    public void mandatoryMovementDescription() {
        getMovementPage().createMovement("Despesa","Telefone", "08/10/2024", "08/10/2024",
                "", "Governo", "100", "Pago");

        Assert.assertEquals("Descrição é obrigatório", getBasePage().getAlert());
    }

    @Order(6)
    @Test
    public void mandatoryMovementDateMove() {
        getMovementPage().createMovement("Despesa","Telefone", "", "08/10/2024",
                "Descrição de pagamento", "Governo", "100", "Pago");

        Assert.assertEquals("Data da Movimentação é obrigatório", getBasePage().getAlert());
    }

    @Order(7)
    @Test
    public void mandatoryMovementDatePay() {
        getMovementPage().createMovement("Despesa","Telefone", "08/10/2024", "",
                "Descrição de pagamento", "Governo", "100", "Pago");

        Assert.assertEquals("Data do pagamento é obrigatório", getBasePage().getAlert());
    }

    @Order(8)
    @Test
    public void mandatoryMovementStakeholder() {
        getMovementPage().createMovement("Despesa","Telefone", "08/10/2024", "08/10/2024",
                "Descrição de pagamento", "", "100", "Pago");

        Assert.assertEquals("Interessado é obrigatório", getBasePage().getAlert());
    }

    @Order(9)
    @Test
    public void mandatoryMovementValue() {
        getMovementPage().createMovement("Despesa","Telefone", "08/10/2024", "08/10/2024",
                "Descrição de pagamento", "Governo", "", "Pago");

        Assert.assertEquals("Valor é obrigatório\n" + "Valor deve ser um número", getBasePage().getAlert());
    }

}
