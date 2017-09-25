package com.test.pageAction;

import com.test.page.RedPackageWish;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by user on 2017/9/18.
 */
public class Common {
    public  static Actions actions;
    public  static RedPackageWish redPackageWish;
    //F5刷新页面
    public static void refresh(WebDriver driver){
        actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).perform();
        try {
            pressKeyEvent(KeyEvent.VK_F5);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    //按物理按键
    public static void pressKeyEvent(int keycode) throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);//按下enter键
        robot.keyPress(keycode);
    }
    public static void openPrizes(WebDriver driver){
        actions = new Actions(driver);
        redPackageWish = PageFactory.initElements(driver,RedPackageWish.class);

        actions.moveToElement(redPackageWish.MarketingCampaigns).perform();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.moveToElement(redPackageWish.prizes).perform();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        redPackageWish.redPackageMenu.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.release();
    }
    public static void login(WebDriver driver){
        LoginAction login = new LoginAction(driver);
        login.Login("123@qq.com","123456","1111");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
