package com.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by user on 2017/9/20.
 */
public class RedPackageWish {
    private static WebElement element;
    //新建按钮
    public static WebElement create(WebDriver driver){
        element = driver.findElement(By.xpath("//div[@class='wishings-manage']/button"));
        return element;
    }
}
