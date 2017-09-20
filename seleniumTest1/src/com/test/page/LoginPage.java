package com.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by user on 2017/9/7.
 */
public class LoginPage {
    private static WebElement element;
    public static WebElement username(WebDriver driver){
//        element = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/form/div[1]/div/div/div/input"));
        element = driver.findElement(By.xpath("//input[@placeholder='请输入账号']"));
        return element;
    }
    public static WebElement password(WebDriver driver){
//        element = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/form/div[2]/div/div/div/input"));
        element = driver.findElement(By.xpath("//input[@placeholder='请输入密码']"));
        return element;
    }
    public static WebElement code(WebDriver driver){
//        element = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/form/div[3]/div[1]/div/div/div[1]/input"));
        element = driver.findElement(By.xpath("//input[@placeholder='请输入验证码']"));
        return element;
    }
    public static WebElement loginButton(WebDriver driver){
        element = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/form/div[4]/div/div/div/button"));
//        element = driver.findElement(By.cssSelector("[@class='ivu-btn ivu-btn-primary'"));

        return element;
    }
    public static WebElement rememberPasswordCheckBox(WebDriver driver){
        element = driver.findElement(By.className("ivu-checkbox-input"));
        return element;
    }
    public static WebElement forgotPassword(WebDriver driver){
        element = driver.findElement(By.className("pass-right"));
        return element;
    }

}
