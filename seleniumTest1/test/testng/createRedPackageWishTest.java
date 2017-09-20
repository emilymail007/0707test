package testng;

import org.testng.annotations.Test;

/**
 * Created by user on 2017/9/20.
 */
public class createRedPackageWishTest {
    @Test(dependsOnGroups = {"login2Test.loginSuccess"})
    public void test1(){
        System.out.println("000");
    }
}
