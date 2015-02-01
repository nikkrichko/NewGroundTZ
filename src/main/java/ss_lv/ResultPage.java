package ss_lv;

import hotlineTest.utils.Log4Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by никита on 01.02.2015.
 */
public class ResultPage {
    private WebDriver webDriver;

    public ResultPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        Log4Test.info("get result page");
        this.webDriver = webDriver;
    }



    @FindBy(xpath = "//h2[text()='Результат поиска']")
    private WebElement searchPageId;

    @FindBy(xpath = "//h2[text()='Результат поиска']")
    private WebElement searchPageIdBySelling;

    @FindBy(xpath = "//a[text()='\"Цена\"']")
    private WebElement priceRange;

    @FindBy(xpath = "//a[contains(@href, '/sell/')]")
    private WebElement sellFilter;

    public void setFilterBySelling(){
        sellFilter.click();
    }

    public void rangeByPrice(){
        priceRange.click();
    }

    public WebElement getSearchPageId() {
        return searchPageId;
    }

    public WebElement getSearchPageIdBySelling() {
        return searchPageIdBySelling;
    }
}

