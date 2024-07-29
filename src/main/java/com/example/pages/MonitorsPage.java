package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MonitorsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MonitorsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    public void selectMonitor() {
        WebElement monitorImage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img.card-img-top.img-fluid")));
        monitorImage.click();
    }
}
