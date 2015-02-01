package ss_lv;

import hotlineTest.utils.Log4Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by никита on 01.02.2015.
 */
public class MainPage {

    private WebDriver webDriver;
    private String WebSiteName;

    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        Log4Test.info("get main page");
        this.webDriver = webDriver;
        this.WebSiteName = "http://ss.lv/";
    }

    @FindBy(xpath = "//a[starts-with(@href, '/ru/')]")
    private WebElement russianLanguage;

    @FindBy(xpath = "//a[starts-with(@href, '/lv/')]")
    private WebElement latvianLanguage;



    @FindBy(xpath = "//a[text()='Электротехника']")
    private WebElement electronic;

    public WebElement getElectronic() {
        return electronic;
    }

    public WebElement getLatvianLanguage() {
        return latvianLanguage;
    }

    public WebElement getRussianLanguage() {
        return russianLanguage;
    }

    public void changeLanguageToRussian(){
        russianLanguage.click();
    }

    public void changeLanguageToLatvian(){
        latvianLanguage.click();
    }

    public void goToElectronic(){
        electronic.click();
    }

    public void getMainPage(){
        webDriver.get(WebSiteName);
    }


}
