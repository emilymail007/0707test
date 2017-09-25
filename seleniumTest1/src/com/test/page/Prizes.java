package com.test.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by user on 2017/9/25.
 */
public class Prizes {
    //营销活动菜单
    @FindBy(xpath = "//ul/li[1]/div/div[1]/span")
    public static WebElement MarketingCampaigns;
    //企业奖品菜单
    @FindBy(xpath = "//ul/li[1]/div/div[2]/ul/li[2]/div/div[1]/div/span")
    public static WebElement prizes;
    //奖品管理
    @FindBy(xpath = "//ul/li[1]/div/div[2]/ul/li[2]/div/div[2]/ul/li[1]/div")
    public static WebElement prizesManage;

}
