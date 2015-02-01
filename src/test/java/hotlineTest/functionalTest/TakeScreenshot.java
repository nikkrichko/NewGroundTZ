package hotlineTest.functionalTest;

import hotlineTest.HotlinePages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TakeScreenshot extends FunctionalTest {
    MainPage mainPage;

    @BeforeMethod
    public void setup() throws NoSuchMethodException {
        mainPage = new MainPage(webDriver);
    }

    @Test
    public void TakeScreenShotTest(){
        mainPage.getMainPage();
        screenShotMaker.takeScreenShot("mainpage");

    }
}
