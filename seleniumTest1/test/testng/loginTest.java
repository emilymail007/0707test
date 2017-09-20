package testng;


import com.test.page.LoginPage;
import com.test.pageAction.LoginAction;
import com.test.pageAction.setupBrowser;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.text.Document;


/**
 * Created by user on 2017/9/7.
 */
public class loginTest {
    LoginAction login = null;
      WebDriver driver = new setupBrowser().setupChrome();

      WebDriverWait wait = new WebDriverWait(driver,3);

      @BeforeTest
    public void beforeTest(){
          login = new LoginAction(driver);
          driver.get("https://top-test.sao.so/#/login");
          driver.manage().window().maximize();
      }
      //每个测试用例执行后等待1s
    @AfterMethod
      public void setWait(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//    //每个测试用例执行前清空数据
//    @BeforeMethod
//
//      public void clearData(){
//          LoginPage.username(driver).clear();
//          LoginPage.password(driver).clear();
//          LoginPage.code(driver).clear();
////          try {
////              Thread.sleep(3000);
////          } catch (InterruptedException e) {
////              e.printStackTrace();
////          }
//      }
    @Test(priority = 1,testName = "用户不存在")
    public void userNotExit() throws InterruptedException {
          System.out.println("******用户不存在******");
//        login.Login("222", "234234234", "12342");

        LoginPage.username(driver).click();
        LoginPage.username(driver).sendKeys("222");
        LoginPage.password(driver).click();
        LoginPage.password(driver).sendKeys("111111");
        LoginPage.code(driver).click();
        LoginPage.code(driver).sendKeys("1234");
        LoginPage.loginButton(driver).click();
        Thread.sleep(300);
        Assert.assertTrue(driver.getPageSource().contains("该用户不存在"));

        System.out.println("用户不存在" + driver.getPageSource().contains("该用户不存在"));
        Thread.sleep(1000);
    }
    @Test(priority = 2,testName = "用户名为空")
    public void userNameNUll() throws InterruptedException{
        System.out.println("******用户名为空******");
        LoginPage.username(driver).clear();
        LoginPage.username(driver).click();
        //LoginPage.username(driver).sendKeys("");
        Thread.sleep(1000);
        LoginPage.password(driver).clear();
        LoginPage.password(driver).click();
        Thread.sleep(5000);
        LoginPage.password(driver).sendKeys("111111");
        LoginPage.code(driver).clear();
        LoginPage.code(driver).click();
        LoginPage.code(driver).sendKeys("1234");
//        LoginPage.loginButton(driver).click();
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/form/div[1]/div/div/div[2]"));
        Thread.sleep(1000);
        Assert.assertTrue(element.getText().contains("用户名不能为空"));
//        LoginPage.username(driver).clear();
//        LoginPage.password(driver).click();
//        LoginPage.password(driver).clear();
//        LoginPage.password(driver).click();
//        LoginPage.password(driver).sendKeys("111111");
        Assert.assertTrue(driver.getPageSource().contains("用户名不能为空"));



        System.out.println("用户名为空");
    }
//    @Test(priority = 3,testName = "密码为空")
//    public void passwordWrong() throws InterruptedException{
//        System.out.println("******密码为空******");
//          login.Login("123@qq.com","","1111");
////          WebElement element = wait.until(new ExpectedCondition<WebElement>() {
////              public WebElement apply(WebDriver driver){
////                  return  driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/form/div[2]/div/div/div[2]"));
////              }
////          });
//        //WebElement element = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/form/div[1]/div/div/div[2]"));
//
//        Assert.assertTrue(driver.getPageSource().contains("请填写密码"));
//        Thread.sleep(1000);
//          //Assert.assertTrue(element.getText().contains("请填写密码"));
//    }
//
//
//    @Test(priority = 4,testName = "用户名为空，密码为空")
//    public void usernameAndPasswordNull() throws InterruptedException{
//        System.out.println("******用户名、密码均为空******");
//        login.Login("","","1111");
////        WebElement element = wait.until(new ExpectedCondition<WebElement>() {
////            public WebElement apply(WebDriver driver){
////                return  driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/form/div[1]/div/div/div[2]"));
////            }
////        });
//        WebElement element = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/form/div[1]/div/div/div[2]"));
//        Thread.sleep(1000);
//        Assert.assertTrue(element.getText().contains("用户名不能为空"));
////        WebElement element1 = wait.until(new ExpectedCondition<WebElement>() {
////            public WebElement apply(WebDriver driver){
////                return  driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/form/div[2]/div/div/div[2]"));
////            }
////        });
//        WebElement element1 = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/form/div[2]/div/div/div[2]"));
//        Thread.sleep(1000);
//        Assert.assertTrue(element1.getText().contains("请填写密码"));
//        System.out.println("用户名，密码为空");
//    }
//    @Test(priority = 5,testName = "用户名为空，密码为空,验证码为空")
//    public void allNull() throws InterruptedException{
//        System.out.println("******用户名、密码、验证码均为空******");
//        login.Login("","","");
////        WebElement element = wait.until(new ExpectedCondition<WebElement>() {
////            public WebElement apply(WebDriver driver){
////                return driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/form/div[2]/div/div/div[2]"));
////            }
////        });
//        WebElement element1 = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/form/div[2]/div/div/div[2]"));
//        Thread.sleep(1000);
//        Assert.assertTrue(element1.getText().contains("请填写密码"));
//        Assert.assertTrue(driver.getPageSource().contains("用户名不能为空"));
//        Assert.assertTrue(driver.getPageSource().contains("请输入验证码"));
//        System.out.println("用户名密码，验证码为空");
//    }
//
//
//
//
////      @Test(priority = 22,testName = "登录成功")
////    public void login() throws InterruptedException{
////        login.Login("123@qq.com","123456","1234");
////        WebElement e = wait.until(new ExpectedCondition<WebElement>() {
////            public WebElement apply(WebDriver driver) {
////                return driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[1]"));
////            }
////        });
////
////         Assert.assertTrue(e.getText().contains("你好"));
////         System.out.println("success");
////      }
//
//
////      @AfterTest
////    public void afterTest(){
////        driver.close();
////      }

}
