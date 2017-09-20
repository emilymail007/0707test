package main.com.test.demo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 2017/9/7.
 */
public class test2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", "D:\\tools\\browers-drivers\\chromedriver.exe");


        //System.setProperty("webdriver.gecko.driver", ".\\Tools\\geckodriver.exe");

        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
        driver.get("https://www.icloud.com/");
    }
}
