package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.NoSuchElementException;

public abstract class BasePage {

    public WebDriver driver;
    public Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void writeToField(By element, String text){
        driver.findElement(element).sendKeys(text);
    }

    public Boolean isElementDisplayed(By element){
        try{
            driver.findElement(element).getText();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public void clickElement(By element){
        driver.findElement(element).click();
    }

    public void scrollTillTheEndOfPage() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.tagName("body")).sendKeys(Keys.END);
    }
}