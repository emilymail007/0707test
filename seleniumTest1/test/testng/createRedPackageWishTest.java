package testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by user on 2017/9/20.
 */
public class createRedPackageWishTest {
    private WebDriver driver;

    @Test(groups = {"redPackage"},dependsOnGroups = {"login"})
    public void test1(){
        System.out.println("000");
    }
}
