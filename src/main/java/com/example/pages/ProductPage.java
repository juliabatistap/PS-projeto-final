package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void addToCart() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text() = 'Add to cart']")));
        addToCartButton.click();
    }
}
