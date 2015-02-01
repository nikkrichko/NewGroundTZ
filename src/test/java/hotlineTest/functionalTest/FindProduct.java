package hotlineTest.functionalTest;

import hotlineTest.HotlinePages.GoodsPage;
import hotlineTest.HotlinePages.MainPage;
import hotlineTest.utils.Log4Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by bionic on 11/5/14.
 */
public class FindProduct extends FunctionalTest {


    MainPage mainPage;
    GoodsPage goodsPage;
    String product = "iPhone";
    String noneProduct = "yablophone";

    @BeforeMethod
    public void setup() {
        mainPage = new MainPage(webDriver);
    }

    @Test
    public void findProduct() {
        Log4Test.info("positive findProduct " + product);
        mainPage.getMainPage();
        mainPage.serchProduct(product);
        goodsPage = new GoodsPage(webDriver);
        Assert.assertTrue(goodsPage.getGoods(product).isDisplayed());
    }

    @Test
    public void findProductNegative() {
        Log4Test.info("negative findProduct " + noneProduct);
        mainPage.getMainPage();
        mainPage.serchProduct(noneProduct);
        goodsPage = new GoodsPage(webDriver);
        Assert.assertFalse(goodsPage.isElementPresent(noneProduct));
    }
}
