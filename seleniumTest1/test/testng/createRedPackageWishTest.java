package testng;

import com.test.page.CreateRedPackageWish;
import com.test.page.LoginPage;
import com.test.page.RedPackageWish;
import com.test.pageAction.Common;
import com.test.pageAction.LoginAction;
import com.test.pageAction.RedPackageAction;
import com.test.pageAction.SetupBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by user on 2017/9/25.
 */
public class CreateRedPackageWishTest {
    private WebDriver driver;
    LoginPage loginPage = new LoginPage();
    RedPackageAction redPackage = null;
    public static RedPackageWish redPackageWish;
    Actions actions;
    @BeforeClass
    public void step01(){
        driver = new SetupBrowser().setupFirefox();
        driver.get("https://top-test.sao.so/#/login");
        Common.login(driver);
        Common.openPrizes(driver);
        Assert.assertTrue(driver.getPageSource().contains("红包祝福语管理"));
        //点击新建按钮
        redPackageWish.create.click();

    }
    @Test(priority = 1,testName = "点击确定按钮")
    public void onlyClick(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CreateRedPackageWish.saveButton(driver).click();
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
        CreateRedPackageWish.nickName(driver).clear();
        CreateRedPackageWish.wish(driver).clear();
        CreateRedPackageWish.wish(driver).sendKeys("祝福语");
        CreateRedPackageWish.activityName(driver).clear();
        CreateRedPackageWish.activityName(driver).sendKeys("活动名称");
        CreateRedPackageWish.remarks(driver).clear();
        CreateRedPackageWish.remarks(driver).sendKeys("备注");
        CreateRedPackageWish.saveButton(driver).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 3,testName = "祝福语为空")
    public void wishNull(){
        driver.navigate().refresh();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CreateRedPackageWish.nickName(driver).clear();
        CreateRedPackageWish.nickName(driver).sendKeys("商户名称");
        CreateRedPackageWish.wish(driver).clear();
        CreateRedPackageWish.activityName(driver).clear();
        CreateRedPackageWish.activityName(driver).sendKeys("活动名称");
        CreateRedPackageWish.remarks(driver).clear();
        CreateRedPackageWish.remarks(driver).sendKeys("备注");
        CreateRedPackageWish.saveButton(driver).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
