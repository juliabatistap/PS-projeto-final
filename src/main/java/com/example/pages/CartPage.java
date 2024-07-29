package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void placeOrder() {
        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text() = 'Place Order']")));
        placeOrderButton.click();
    }
}
