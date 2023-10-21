package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SearchAmazon {
    ChromeDriver driver;

    public SearchAmazon(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void  testCase01(){
//        Navigate to URL  www.google.com
        driver.get("https://www.google.com");

//        Click on search bar and Enter text 'amazon' Using Locator "ID" APjFqb | Sendkeys("Amazon")

        WebElement Search = driver.findElementById("APjFqb");
        Search.click();
        Search.sendKeys("Amazon");

//        Click on Search Button Using Locator "XPath" (//input[@value='Google Search'])[1]

        driver.findElement(By.xpath("(//input[@value='Google Search'])[1]")).click();

//        Validate in search result for amazon.in Using Locator "XPath" //a[@href='https://www.amazon.in/' or @href='https://www.amazon.com/'] using isDisplayed()

        boolean Displayed =driver.findElement(By.xpath("//a[@href='https://www.amazon.in/' or @href='https://www.amazon.com/']")).isDisplayed();
        System.out.println("Validate in search result for amazon.in" + Displayed);
    }

}