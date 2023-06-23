package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
    WebDriver driver;
    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "APjFqb")
    private WebElement search;

    @FindBy(css = "div[class='M2vV3 vOY7J']")
    private WebElement clear;

    @FindBy(id = "result-stats")
    private WebElement resultStats;

    @FindBy(id = "pnnext")
    private WebElement nextPage;
    @FindBy(id = "rso")
    private WebElement numberOfResults;
    @FindBy(xpath = "//div[@class='EIaa9b']")
    private WebElement relatSearchBox;

    public WebElement search() {
        return search;
    }

    public WebElement clear() {
        return clear;
    }

    public WebElement resultStats() {
        return resultStats;
    }

    public WebElement nextPage() {
        return nextPage;
    }

    public WebElement numberOfResults() {
        return numberOfResults;
    }

    public WebElement relatSearchBox() {
        return relatSearchBox;
    }
}
