import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import pageobjects.ResultPage;
import resources.Utilities;

import static org.testng.Assert.*;


public class SearchTest extends Utilities {

    public WebDriver driver;


    @BeforeMethod
    public void openURL() throws IOException, InterruptedException {
        driver = initializeBrowser();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(getProp("URL"));
    }

    @AfterMethod
    public void clouser() throws InterruptedException, IOException {
        //7-Close the browser window
        driver.quit();
    }


    @Test()
    public void search() throws IOException, InterruptedException {
        HomePage homePage = new HomePage(driver);
        ResultPage resultPage = new ResultPage(driver);

        //1-Open https://www.google.com and search for any keyword
        homePage.search().sendKeys(getProp("search_keyword_1")); //Enter keyword in search field
        homePage.search().sendKeys(Keys.RETURN); //Search

        //2-Remove the keyword and search for a new one
        resultPage.clear().click(); //Clear search
        resultPage.search().sendKeys(getProp("search_keyword_2")); //Enter keyword in search field
        resultPage.search().sendKeys(Keys.RETURN); //Search

        //3-Assert that number of results exist on UI
        assertNotEquals(resultPage.resultStats().getText().length(), 0);

        //4-Scroll down and go to the next page -> (Page 2)
        scrollDown(driver); //Scroll Down
        resultPage.nextPage().click(); //click Next page -> (page 2)

        //5-Validate if the number of results on page 2 is equal to page 3 or not
        int pageTwoResutNumber = getChildCount(resultPage.numberOfResults()); // Number of results in page 2
        scrollDown(driver); //Scroll Down
        resultPage.nextPage().click(); //click Next page -> (page 3)
        int pageThreeResutNumber = getChildCount(resultPage.numberOfResults()); // Number of results in page 3
        assertEquals(pageTwoResutNumber, pageThreeResutNumber); //validation of number of result in page 2 and page 3

        //6-Validate there are different search suggestions displayed at the end of the page
        scrollDown(driver);
        assertTrue(searchSuggestions(resultPage.relatSearchBox())); //validation there are different search suggestions displayed at the end of the page
    }


}
