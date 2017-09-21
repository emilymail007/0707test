package testng;

import com.test.page.LoginPage;
import com.test.pageAction.LoginAction;
import com.test.pageAction.common;
import com.test.pageAction.setupBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Created by user on 2017/9/15.
 */
public class login2Test {
    WebDriver driver = null;
    LoginPage loginPage = new LoginPage();
    LoginAction login = null;


    @BeforeClass
    public void openURL(){
        driver = new setupBrowser().setupFirefox();
        driver.get("https://top-test.sao.so/#/login");
        login = new LoginAction(driver);
    }
//    String currentWindow = driver.getWindowHandle();
    @Test(priority = 1,testName = "直接点击登录按钮")
    public void clickButton(){
        loginPage.loginButton(driver).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getPageSource().contains("用户名不能为空"));
        Assert.assertTrue(driver.getPageSource().contains("请填写密码"));
        Assert.assertTrue(driver.getPageSource().contains("请输入验证码"));

    }
    @Test(priority= 2,testName = "点击输入框，移开后报错")
    public void justClick(){
        System.out.println("**********点击用户名，在点击密码，用户名输入框下报错**********");
        //刷新页面
        common.refresh(driver);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("*******点击用户名->点击密码*******");
        loginPage.username(driver).click();

        loginPage.password(driver).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getPageSource().contains("用户名不能为空"));
        System.out.println("*******在点击验证码框*******");
        loginPage.code(driver).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getPageSource().contains("请填写密码"));
        System.out.println("***********在点击用户名输入框************");
        loginPage.username(driver).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getPageSource().contains("请输入验证码"));

    }


    @Test(priority = 3,testName = "忘记密码")
    public void forgotPasswordTest(){
        System.out.println("*******忘记密码*********");
        LoginPage.forgotPassword(driver).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getPageSource().contains("请输入您的登录账号，以进行密码重置"));
        driver.navigate().back();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test(priority=11,testName = "密码为空，其他正确")
    public void passwordIsNULL(){
        System.out.println("********密码为空，其他正确，报错：请输入密码**********");
//        //刷新页面
//        common.refresh(driver);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        loginPage.username(driver).clear();
        loginPage.username(driver).sendKeys("123@qq.com");
        loginPage.password(driver).clear();
        loginPage.code(driver).clear();
        loginPage.code(driver).sendKeys("1234");
        loginPage.loginButton(driver).click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getPageSource().contains("请输入密码"));
        System.out.println("当前句柄"+driver.getWindowHandle());

    }
    @Test(priority = 12,testName = "登录成功",groups = {"login"})
    public void loginSuccess() throws InterruptedException {
        //刷新页面
        driver.navigate().refresh();
        loginPage.username(driver).clear();
        loginPage.username(driver).sendKeys("123@qq.com");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginPage.password(driver).clear();
        loginPage.password(driver).sendKeys("123456");
        loginPage.code(driver).clear();
        loginPage.code(driver).sendKeys("1234");
        loginPage.loginButton(driver).click();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getPageSource().contains("你好"));
    }


}
