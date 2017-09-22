package com.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by user on 2017/9/20.
 */
public class RedPackageWish {
    private static WebElement element;
    //新建按钮
//    public static WebElement create(WebDriver driver){
//        element = driver.findElement(By.xpath("//div[@class='wishings-manage']/button"));
//        return element;
//    }
    //新建按钮
    @FindBy(xpath = "//div[@class='wishings-manage']/button" )
    public static WebElement create;
    //列表
    @FindBy(xpath = "//table/tbody")
    public static WebElement list;
    //列表首行编辑
    @FindBy(xpath = "//table/tbody/tr[1]/td[6]/a[1]")
    public static WebElement firstLineEdit;
    //列表首行删除按钮
    @FindBy(xpath = "//table/tbody/tr[1]/td[6]/a[2]")
    public static WebElement firstLineDelete;
    @FindBy(xpath = "//table/tbody/tr[1]/td[2]")
    public static WebElement firstLineNickName;

    public boolean ListNotNull(){
        List<WebElement> listData = list.findElements(By.tagName("tr"));
        for (WebElement e:listData){
            System.out.println("祝福语ID："+e.findElement(By.tagName("td")).getText());
        }
        return listData.size()>0;
    }
}
