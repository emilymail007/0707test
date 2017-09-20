package com.test.pageAction;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by user on 2017/9/18.
 */
public class common {
    //F5刷新页面
    public static void refresh(WebDriver driver){
        Actions actions = new Actions(driver);
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
}
