package testng;

import com.test.page.LoginPage;
import com.test.pageAction.LoginAction;
import com.test.pageAction.Common;
import com.test.pageAction.SetupBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Created by user on 2017/9/15.
 */
public class LoginTest {
    WebDriver driver = null;
    LoginPage loginPage = new LoginPage();
    LoginAction login = null;


    @BeforeTest
    public void openURL(){
        driver = new SetupBrowser().setupFirefox();
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
        System.out.println("**********依次点击各输入框**********");
        System.out.println("刷新前句柄"+driver.getWindowHandle());
        //刷新页面
//        common.refresh(driver);
        driver.navigate().refresh();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginPage.username(driver).click();

        loginPage.password(driver).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getPageSource().contains("用户名不能为空"));

        loginPage.code(driver).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getPageSource().contains("请填写密码"));

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
        System.out.println("*******点击忘记密码*********");
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

        driver.navigate().refresh();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        System.out.println("**********登录成功************");
        //刷新页面
        driver.navigate().refresh();
        Thread.sleep(1000);
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
