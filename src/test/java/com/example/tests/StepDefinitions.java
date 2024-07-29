package com.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.pages.*;

public class StepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private MonitorsPage monitorsPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private static ExtentReports extent;
    private ExtentTest test;

    @Before
    public void setUp() {
        extent = ExtentManager.getInstance();
        test = extent.createTest("Fluxo Completo de Compra");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");

        homePage = new HomePage(driver);
        monitorsPage = new MonitorsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        extent.flush();
    }

    @Given("que o usuario esta na homepage")
    public void acessar_home_page() {
        test.info("Usuário está na homepage");
    }

    @When("entra no menu de monitores")
    public void acessar_menu_monitores() {
        test.info("Usuário navega para o menu de monitores");
        homePage.goToMonitors();
    }

    @When("o usuario seleciona um dos monitores")
    public void selecionar_monitor() {
        test.info("Usuário seleciona um monitor");
        monitorsPage.selectMonitor();
    }

    @When("o usuario adiciona o monitor ao carrinho")
    public void adicionar_ao_carrinho() {
        test.info("Usuário adiciona o monitor ao carrinho");
        productPage.addToCart();
    }

    @When("o usuario acessa a pagina do carrinho")
    public void acessar_carrinho() {
        test.info("Usuário acessa a página do carrinho");
        driver.get("https://www.demoblaze.com/cart.html");
    }

    @When("clica em \"place order\" pra finalizar a compra")
    public void finalizar_compra() {
        test.info("Usuário clica em 'place order' para finalizar a compra");
        cartPage.placeOrder();
    }

    @When("o usuario informa os dados {string}, {string}, {string}, {string}, {string}, e {string}")
    public void informar_dados(String nome, String pais, String cidade, String cartaoCredito, String mes, String ano) {
        test.info(String.format("Usuário informa os dados: %s, %s, %s, %s, %s, %s", nome, pais, cidade, cartaoCredito, mes, ano));
        checkoutPage.inserirNome(nome);
        checkoutPage.inserirPais(pais);
        checkoutPage.inserirCidade(cidade);
        checkoutPage.inserirCartao(cartaoCredito);
        checkoutPage.inserirMes(mes);
        checkoutPage.inserirAno(ano);
    }

    @When("o usuario completa a compra")
    public void concluir_compra() {
        test.info("Usuário completa a compra");
        checkoutPage.compra();
    }

    @Then("a compra deve ser bem sucedida")
    public void mensagem_sucesso() {
        test.pass("Compra realizada com sucesso.");
        // Adicione verificações para garantir que a compra foi bem-sucedida
    }
}
