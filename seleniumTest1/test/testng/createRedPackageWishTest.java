package testng;

import com.test.page.LoginPage;
import com.test.page.createRedPackageWish;
import com.test.pageAction.LoginAction;
import com.test.pageAction.setupBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by user on 2017/9/20.
 */
public class createRedPackageWishTest {
    private WebDriver driver;
    LoginPage loginPage = new LoginPage();
    LoginAction login = null;
    @BeforeClass
    public void step1(){
        driver = new setupBrowser().setupFirefox();
        driver.get("https://top-test.sao.so/#/login");
        login = new LoginAction(driver);
        login.Login("123@qq.com","123456","1111");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getPageSource().contains("你好"));
        driver.get("https://top-test.sao.so/#/activityservicered_packet/Wishingadd");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Test(priority = 1,testName = "点击确定按钮")
    public void onlyClick(){
        createRedPackageWish.saveButton(driver).click();
        Assert.assertTrue(driver.getPageSource().contains("商户名称不能为空"));
        Assert.assertTrue(driver.getPageSource().contains("祝福语不能为空"));
        Assert.assertTrue(driver.getPageSource().contains("活动名称不能为空"));
        Assert.assertTrue(driver.getPageSource().contains("备注不能为空"));
    }
    @Test(priority = 2,testName = "商户名称为空")
    public void nickNameNULL(){
        driver.navigate().refresh();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        createRedPackageWish.nickName(driver).clear();
        createRedPackageWish.wish(driver).clear();
        createRedPackageWish.wish(driver).sendKeys("祝福语");
        createRedPackageWish.activityName(driver).clear();
        createRedPackageWish.activityName(driver).sendKeys("活动名称");
        createRedPackageWish.remarks(driver).clear();
        createRedPackageWish.remarks(driver).sendKeys("备注");
        createRedPackageWish.saveButton(driver).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
