package hotlineTest.selenium;


import hotlineTest.utils.PropertyLoader;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {
    public static final String FIREFOX = "firefox";
    public static final String FIREFOX_REMOTE = "firefox_remote";
    public static final String HTML_UNIT = "htmlunit";

    public static WebDriverWraper initDriver(String driverName){
        WebDriverWraper driverWraper = null;
        if(driverName.equals(FIREFOX)){
            driverWraper =  new WebDriverWraper(new FirefoxDriver());
        } else
        if (driverName.equals(FIREFOX_REMOTE)){
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            try {
                driverWraper = new WebDriverWraper(
                        new RemoteWebDriver(
                                new URL(PropertyLoader.loadProperty("selenium.hub")), capabilities));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else
        if (driverName.equals(HTML_UNIT)){
            driverWraper = new WebDriverWraper(new HtmlUnitDriver());
        }
        else {
            Assert.fail("invalid driver configuration");

        }
        return driverWraper;
    }
}
