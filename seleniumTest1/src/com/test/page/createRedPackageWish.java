package com.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by user on 2017/9/20.
 */
public class createRedPackageWish {
    private static WebElement element;
    public static WebElement nickName(WebDriver driver){
        element = driver.findElement(By.xpath("//form/div[1]/div[1]/div/div/input"));
        return element;
    }
    public static WebElement wish(WebDriver driver){
        element = driver.findElement(By.xpath("//form/div[1]/div[2]/div/div/input"));
        return element;
    }
    public static WebElement activityName(WebDriver driver){
        element = driver.findElement(By.xpath("//form/div[1]/div[3]/div/div/input"));
        return element;
    }
    public static WebElement remarks(WebDriver driver){
        element = driver.findElement(By.xpath("//form/div[1]/div[4]/div/div/textarea"));
        return element;
    }
    public static WebElement cancelButton(WebDriver driver){
        element = driver.findElement(By.xpath("//form/div[2]/div/button[1]"));
        return element;
    }
    public static WebElement saveButton(WebDriver driver){
        element = driver.findElement(By.xpath("//form/div[2]/div/button[2]"));
        return element;
    }
}
