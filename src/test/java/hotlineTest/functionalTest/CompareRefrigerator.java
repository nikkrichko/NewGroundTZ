package hotlineTest.functionalTest;

import hotlineTest.HotlinePages.GoodsPage;
import hotlineTest.HotlinePages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class CompareRefrigerator extends FunctionalTest {
    WebDriver webDriver;
    MainPage mainPage;
    GoodsPage goodsPage;

    @BeforeClass
    public void initDriver() {
        webDriver = FunctionalTest.webDriver.getOriginalDriver();
    }

    @BeforeMethod
    public void setup() {
        mainPage = new MainPage(webDriver);
    }

    @Test(priority = 5)
    public void comprateTwoPrices(){
        mainPage.getMainPage();
        mainPage.choseCategory(mainPage.getBt());
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        mainPage.pressRefrigeratorLink();
        goodsPage = new GoodsPage(webDriver);
        goodsPage.moveMouseDown(5);
        goodsPage.FilterMark("LG");
        goodsPage.sortBy("возрастанию цены");
        Assert.assertTrue(goodsPage.compareprice());
    }


}
