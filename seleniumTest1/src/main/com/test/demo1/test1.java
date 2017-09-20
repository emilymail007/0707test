package main.com.test.demo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class test1 {
    private static final String URL = "https://www.baidu.com/";
    public static void main(String args[]){
        System.out.println("执行到此1");
        System.setProperty("webdriver.chrome.driver","D:\\tools\\browers-drivers\\chromedriver.exe");
        //C:\Program Files (x86)\Google\Chrome\Application
       // System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        System.out.println("执行到此2");
        ChromeOptions options = new ChromeOptions();
        System.out.println("执行到此3");
        options.addArguments("--start-maximized","allow-running-insecure-content", "--test-type");
        System.out.println("执行到此4");
        //地址栏显示"data:,",可以在driver启动之前设置User Data解决。
        options.addArguments("--user-data-dir=C:/Users/user/AppData/Local/Google/Chrome/User Data/Default"
        ,"--lang-zh-CN","--test-type"
        ,"--no-default-browser-check"
        ,"--ingore-certificate-errors");
        //options.addArguments("--user-data-dir="+System.getenv("USERPROFILE")+"/AppData/Local/Google/Chrome/User Data/Default");
        System.out.println("执行到此5");
        WebDriver driver= new ChromeDriver(options);
        System.out.println("执行到此6");

        driver.manage().window().maximize(); //最大化浏览器界面
        System.out.println("执行到此7");
        driver.get("https://www.jd.com/"); // 等同于 driver.navigate().to(URL); 访问谷哥的首页 ，此处放弃度娘。
        System.out.println("执行到此9");

        System.out.println("执行到此10");
        String title = driver.getTitle(); //获取当前页面的title
        System.out.println("执行到此11");
        String currentUrl = driver.getCurrentUrl(); // 获取当前页面的URL
        System.out.println("执行到此12");
        System.out.println(currentUrl);
        System.out.println("执行到此13");




        driver.quit();  //彻底退出WebDriver

    }
}
