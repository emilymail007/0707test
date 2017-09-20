

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class demo1{
    public static void main(String[] args){
        System.out.println("start firefox browser...");
        System.setProperty("webdriver.chrome.driver", "D:\\tools\\chromeDriver\\chromedriver.exe");//指定驱动路径
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        System.out.println("start firefox browser succeed...");
    }
}
