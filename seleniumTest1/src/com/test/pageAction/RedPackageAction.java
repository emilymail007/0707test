package com.test.pageAction;

import com.test.page.CreateRedPackageWish;
import com.test.page.RedPackageWish;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 2017/9/22.
 */
public class RedPackageAction {
    private WebDriver driver;

    public RedPackageAction(WebDriver driver) {
        this.driver = driver;
    }

    RedPackageWish redPackageWish;
    Actions actions;

    //点击新建按钮，跳转到新建页面
    public void createRedPackage(String nickName, String wish, String activityName, String remarks) {
        CreateRedPackageWish.nickName(driver).clear();
        CreateRedPackageWish.nickName(driver).sendKeys(nickName);
        CreateRedPackageWish.wish(driver).clear();
        CreateRedPackageWish.wish(driver).sendKeys(wish);
        CreateRedPackageWish.activityName(driver).clear();
        CreateRedPackageWish.activityName(driver).sendKeys(activityName);
        CreateRedPackageWish.remarks(driver).clear();
        CreateRedPackageWish.remarks(driver).sendKeys(remarks);
        CreateRedPackageWish.saveButton(driver).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean openPage() {
        actions = new Actions(driver);
        redPackageWish = PageFactory.initElements(driver, RedPackageWish.class);
        System.out.println("sssss" + RedPackageWish.MarketingCampaigns.toString());
        actions.moveToElement(RedPackageWish.MarketingCampaigns).perform();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.moveToElement(RedPackageWish.prizes).perform();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.moveToElement(RedPackageWish.redPackageMenu).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getPageSource().contains("奖品管理");
    }

}
