package ss_lv;

import hotlineTest.utils.Log4Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by никита on 01.02.2015.
 */
public class SearchPage {

    private WebDriver webDriver;

    public SearchPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        Log4Test.info("get ElectronicPagePage");
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//h2[text()='Поиск']")
    private WebElement searchPageId;

    @FindBy(xpath = "//*[@class='in1']")
    private WebElement searchInputTXTField;

    @FindBy(xpath = "//*[@id='sbtn']")
    private WebElement submitSearchButton;

    public WebElement getSearchPageId() {
        return searchPageId;
    }

    public void searchText(String text){

        searchInputTXTField.sendKeys(text);
        submitSearchButton.submit();
    }
}
