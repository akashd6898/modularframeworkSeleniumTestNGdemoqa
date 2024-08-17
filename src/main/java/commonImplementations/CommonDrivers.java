package commonImplementations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CommonDrivers {
    private WebDriver driver;
    public String currentDir;

    private int pageLoadTimeout = 20;
    private int elementDetectionTimeout = 20;

    public CommonDrivers(String browserType) throws Exception
    {
        currentDir = System.getProperty("user.dir");
        if(browserType.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
            System.setProperty("webdriver.driver.chrome",currentDir+"drivers/chromedriver.exe");
        }
        if(browserType.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
            System.setProperty("webdriver.driver.edge",currentDir+"drivers/msedgedriver.exe");
        }
        if (browserType.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
            System.setProperty("webdriver.driver.firefox",currentDir+"driver/geckodriver.exe");
        }
        else{
            throw new Exception("invalid browser");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public WebDriver getDriver()
    {
        return driver;
    }
    public void navigatetoURL(String url)
    {
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(elementDetectionTimeout, TimeUnit.SECONDS);
        driver.get(url);
    }

    public void currentPageTitle()
    {
        driver.getTitle();
    }

    public void setPageLoadTimeout(int pageLoadTimeout)
    {
        this.pageLoadTimeout = pageLoadTimeout;
    }

    public void setElementDetectionTimeout(int elementDetectionTimeout) {
        this.elementDetectionTimeout = elementDetectionTimeout;
    }
    public void closeAllBrowser()
    {
        driver.quit();
    }
}
