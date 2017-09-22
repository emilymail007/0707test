package com.test.pageAction;

import com.test.page.createRedPackageWish;
import org.openqa.selenium.WebDriver;

/**
 * Created by user on 2017/9/22.
 */
public class redPackage {
    private WebDriver driver;
    public void redPackage(){
        this.driver = driver;
    }
    //点击新建按钮，跳转到新建页面
    public void createRedPackage(String nickName,String wish,String activityName,String remarks){
        createRedPackageWish.nickName(driver).clear();
        createRedPackageWish.nickName(driver).sendKeys(nickName);
        createRedPackageWish.wish(driver).clear();
        createRedPackageWish.wish(driver).sendKeys(wish);
        createRedPackageWish.activityName(driver).clear();
        createRedPackageWish.activityName(driver).sendKeys(activityName);
        createRedPackageWish.remarks(driver).clear();
        createRedPackageWish.remarks(driver).sendKeys(remarks);
        createRedPackageWish.saveButton(driver).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
