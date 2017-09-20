package com.test.pageAction;

import com.test.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class LoginAction {
    private WebDriver driver;
    public LoginAction(WebDriver driver) {
        this.driver = driver;
    }
    public void Login(String username, String password, String code) {
        LoginPage.username(driver).clear();
        LoginPage.username(driver).sendKeys(username);
        LoginPage.password(driver).clear();
        LoginPage.password(driver).sendKeys(password);
        LoginPage.code(driver).clear();
        LoginPage.code(driver).sendKeys(code);
        LoginPage.loginButton(driver).click();
    }

    public void sendUserName(String username) {
        LoginPage.username(driver).clear();
        LoginPage.username(driver).click();
        LoginPage.username(driver).sendKeys(username);
    }

    public void sendPassword(String password) {
        LoginPage.password(driver).clear();
        LoginPage.password(driver).click();
        LoginPage.password(driver).sendKeys(password);
    }

    public void sendCode(String code) {
        LoginPage.code(driver).clear();
        LoginPage.code(driver).click();
        LoginPage.code(driver).sendKeys(code);
    }


}



