package hotlineTest.functionalTest;

import hotlineTest.HotlinePages.MainPage;
import hotlineTest.HotlinePages.RegisterPage;
import hotlineTest.HotlinePages.User;
import hotlineTest.HotlinePages.WelcomePage;
import hotlineTest.utils.Log4Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Register extends FunctionalTest {

    MainPage mainPage;
    RegisterPage registerPage;
    WelcomePage welcomePage;
    User user;

    @BeforeClass
    public void initUser(){
        user = new User();
    }

    @BeforeMethod
    public void setup() throws NoSuchMethodException {

        mainPage = new MainPage(webDriver);
        }

    @AfterMethod
    public void tearDown(ITestResult result) {
            if (result.getStatus() == ITestResult.FAILURE) {
            }
    }

    @Test(priority = 1)
    public void registerTest() {
        Log4Test.info("positive test register");
        mainPage.getMainPage();
        mainPage.pressRegisterLink();
        registerPage = new RegisterPage(user, webDriver);
        registerPage.register();
        welcomePage = new WelcomePage(webDriver);
        Assert.assertTrue(welcomePage.getWELCOME_PAGE_FIRST_NAME().isDisplayed());
        Assert.assertTrue(welcomePage.getWELCOME_PAGE_SECOND_NAME().isDisplayed());
    }

    @Test(priority = 2)
    public void doubleRegister() {
        Log4Test.info("negative test register");
        mainPage.getMainPage();
        mainPage.pressRegisterLink();
        registerPage = new RegisterPage(user, webDriver);
        registerPage.register();
        Assert.assertTrue(registerPage.getProof().isDisplayed());
    }

}
