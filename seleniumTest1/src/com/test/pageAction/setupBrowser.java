package com.test.pageAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

/**
 * Created by user on 2017/9/8.
 */
public class setupBrowser {
    public WebDriver setupChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\tools\\browers-drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized","allow-running-insecure-content", "--test-type");
        options.addArguments("--user-data-dir=C:/Users/user/AppData/Local/Google/Chrome/User Data/Default"
                ,"--lang-zh-CN","--test-type"
                ,"--no-default-browser-check"
                ,"--ingore-certificate-errors");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
    public WebDriver setupFirefox(){
        System.out.println("**************firefox启动*******************");
        System.setProperty("webdriver.gecko.driver", "D:\\tools\\FirefoxDriver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        //窗口最大化
//        driver.manage().window().maximize();
//        File pathToFirefoxBinary = new File("C:\\Program Files\\Firefox\\firefox.exe");
//        FirefoxBinary firefoxbin = new FirefoxBinary(pathToFirefoxBinary);
//        driver = new FirefoxDriver(firefoxbin,null);//这里使用这个构造方法。


        return driver;
    }

}
