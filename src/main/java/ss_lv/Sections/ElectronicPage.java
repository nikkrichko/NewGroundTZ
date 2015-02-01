package ss_lv.sections;


import hotlineTest.utils.Log4Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicPage {

    private WebDriver webDriver;

    public ElectronicPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        Log4Test.info("get ElectronicPagePage");
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//a[starts-with(@href, '/ru/electronics/')]")
    private WebElement ElectronicPageId;

    @FindBy(xpath = "//a[starts-with(@href, '/ru/electronics/search/')]")
    private WebElement searchLink;

    public WebElement getElectronicPageId() {
        return ElectronicPageId;
    }

    public void openSerchPageOnElectronicPage(){
        searchLink.click();
    }
}
