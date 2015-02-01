package hotlineTest.functionalTest;

import hotlineTest.HotlinePages.GoodsPage;
import hotlineTest.HotlinePages.MainPage;
import hotlineTest.HotlinePages.ProductPage;
import hotlineTest.utils.Log4Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPrice extends FunctionalTest{

    String product = "iPhone";
    MainPage mainPage;
    GoodsPage goodsPage;
    ProductPage productPage;

    @BeforeMethod
    public void initTest(){
        mainPage = new MainPage(webDriver);
        mainPage.getMainPage();
        mainPage.serchProduct(product);
    }

    @Test
    public void OneThanOnePrice(){
        Log4Test.info("positive check that one than one price");
        goodsPage = new GoodsPage(webDriver);
        goodsPage.productPrice();
        productPage = new ProductPage(webDriver);
        Assert.assertTrue(productPage.isMoreThanOnePrice());
    }
}
