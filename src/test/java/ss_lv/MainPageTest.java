package ss_lv;

import hotlineTest.utils.Log4Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ss_lv.sections.ElectronicPage;

public class MainPageTest extends FunctionalTest{
//    WebDriver webDriver;
    ss_lv.MainPage mainPage;
    ElectronicPage electronicPage;
    SearchPage searchPage;
    ResultPage resultPage;

    @BeforeMethod
    public void setup() {
//        webDriver = new FirefoxDriver();
//        webDriver.manage().window().maximize();
        mainPage = new MainPage(webDriver);

    }

    @Test
    public void openMainPage(){
        mainPage.getMainPage();
        Assert.assertTrue(mainPage.getRussianLanguage().isDisplayed());
    }

    @Test(dependsOnMethods = { "openMainPage" })
    public void changeLanguageToRussian() {
//    mainPage = new MainPage(webDriver);
    Log4Test.info("change language");
    mainPage.changeLanguageToRussian();
    Assert.assertTrue(mainPage.getLatvianLanguage().isDisplayed());
    }

    @Test(dependsOnMethods = { "changeLanguageToRussian" })
    public void goToElectronic() {
        Log4Test.info("go to electronic");
        mainPage.goToElectronic();
        electronicPage = new ElectronicPage(webDriver);
        Assert.assertTrue(electronicPage.getElectronicPageId().isDisplayed());
    }

    @Test(dependsOnMethods = { "goToElectronic" })
    public void goToElectronicSearch() {
        Log4Test.info("go to electronic search");
        electronicPage.openSerchPageOnElectronicPage();
        searchPage = new SearchPage(webDriver);
        Assert.assertTrue(searchPage.getSearchPageId().isDisplayed());
    }

    @Test(dependsOnMethods = { "goToElectronicSearch" })
    public void serchText() {
        Log4Test.info("search");
        searchPage.searchText("компьютер");
        resultPage = new ResultPage(webDriver);
        Assert.assertTrue(resultPage.getSearchPageId().isDisplayed());
    }

    @Test(dependsOnMethods = { "serchText" })
    public void filterTest() {
        Log4Test.info("filter test");
//        resultPage.rangeByPrice();
        resultPage.setFilterBySelling();
        Assert.assertTrue(resultPage.getSearchPageIdBySelling().isDisplayed());
    }


//    @AfterMethod
//    public void tearDown(){
//        webDriver.quit();
//    }
}