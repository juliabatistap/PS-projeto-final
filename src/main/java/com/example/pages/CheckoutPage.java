package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void inserirNome(String name) {
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void inserirPais(String country) {
        WebElement countryInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("country")));
        countryInput.clear();
        countryInput.sendKeys(country);
    }

    public void inserirCidade(String city) {
        WebElement cityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city")));
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void inserirCartao(String cartaoCredito) {
        WebElement creditCardInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card")));
        creditCardInput.clear();
        creditCardInput.sendKeys(cartaoCredito);
    }

    public void inserirMes(String month) {
        WebElement monthInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("month")));
        monthInput.clear();
        monthInput.sendKeys(month);
    }

    public void inserirAno(String year) {
        WebElement yearInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("year")));
        yearInput.clear();
        yearInput.sendKeys(year);
    }

    public void compra() {
        WebElement purchaseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text() = 'Purchase']")));
        purchaseButton.click();
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text() = 'OK']")));
        okButton.click();
    }
}
