package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Utilities {
    WebDriver driver;


    // get the Strings from resources
    public String getProp(String get) throws IOException {
        Properties prop = new Properties();
        String propertiesPath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties";
        FileInputStream fis = new FileInputStream(propertiesPath);
        prop.load(fis);
        return prop.getProperty(get);
    }

    // get the childs of Webelement
    public int getChildCount(WebElement parent) {
        List<WebElement> allChildElements = parent.findElements(By.xpath("*"));
        return allChildElements.size();
    }

    // validation of search suggestion are unique
    public boolean searchSuggestions(WebElement searchList) {
        boolean result = true;
        HashSet<String> set = new HashSet();
        List<WebElement> searchTwoList = searchList.findElements(By.xpath("*"));
        List<WebElement> firstList = searchTwoList.get(0).findElements(By.xpath("*"));
        List<WebElement> secondList = searchTwoList.get(1).findElements(By.xpath("*"));
        for (WebElement element : firstList) {
            set.add(element.getText());
        }
        for (WebElement webElement : secondList) {
            set.add(webElement.getText());
        }
        int suggNum = firstList.size() + secondList.size();
        if (set.size() != suggNum) {
            result = false;
        }

        return result;
    }

    // Infinity Scroll Handling
    public void scrollDown(WebDriver driver) throws InterruptedException {
        long lenOfPage = (Long) ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);var lenOfPage=document.body.scrollHeight;return lenOfPage;");
        boolean scrolled = true;
        long lastCount = 0;
        while (scrolled == true) {
            Thread.sleep(1500);
            lastCount = lenOfPage;
            lenOfPage = (Long) ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);var lenOfPage=document.body.scrollHeight;return lenOfPage;");
            if (lastCount == lenOfPage) {
                scrolled = false;
            }

        }
    }

    // Webdriver initializer
    public WebDriver initializeBrowser() throws IOException {
        String browserName = getProp("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("egde")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

}
