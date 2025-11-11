package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {

    ChromeDriver driver;
    WebDriverWait wait;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }

    @Test
    public void testCase01() throws InterruptedException{

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Wrappers wrapper = new Wrappers(driver);


        wrapper.navigateToForm();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@jsname = 'YPqjbf']//input[@class = 'whsOnd zHQkBf']")));

        wrapper.enterTextByXpath("//div[@jsname = 'YPqjbf']//input[@class = 'whsOnd zHQkBf']", "Crio Learner");


        String epochTime = String.valueOf(System.currentTimeMillis() / 1000);
        String textToEnter = String.format("I want to be the best QA Engineer! %s", epochTime);

        wrapper.enterTextByXpath("//textarea[@class = 'KHxj8b tL9Q4c']", textToEnter);


        List<String> optionsToSelect = Arrays.asList("0 - 2");

        wrapper.selectOptions("//div[@class = 'nWQGrd zwllIb']//div[@class = 'ulDsOb']//span", optionsToSelect);


        optionsToSelect = Arrays.asList("Java", "Selenium", "TestNG");

        wrapper.selectOptions("//div[@class = 'eBFwI']//div[@class = 'ulDsOb']//span", optionsToSelect);
        
        wrapper.clickElementByXpath("//div[contains(@class, 'DEh1R')]");

        Thread.sleep(500);

        optionsToSelect = Arrays.asList("Mr");

        wrapper.selectOptions("//div[contains(@class, 'QXL7Te')]//div[contains(@class, 'OIC90c ')]//span", optionsToSelect);

        
        LocalDate sevenDaysBefore = LocalDate.now().minusDays(7);

        String sevenDaysBeforeFormatted = sevenDaysBefore.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        
        wrapper.enterTextByXpath("//div[@jsname = 'jPalo']//input[contains(@class, 'whsOnd zHQkBf')]", sevenDaysBeforeFormatted);


        LocalTime curTime = LocalTime.now();

        // String hr = curTime.format(DateTimeFormatter.ofPattern("hh"));
        // String min = String.valueOf(curTime.getMinute());
        String amPm = curTime.format(DateTimeFormatter.ofPattern("a"));

        wrapper.enterTextByXpath("//div[@jsname = 'MKaSrf']//input[contains(@class, 'whsOnd zHQkBf')]", "07");
        wrapper.enterTextByXpath("//div[@jsname = 'QbtXXe']//input[contains(@class, 'whsOnd zHQkBf')]", "30");

        wrapper.clickElementByXpath("//div[@jsname = 'CXE57d']//div[@class = 'e2CuFe eU809d']");

        optionsToSelect = Arrays.asList(amPm);

        wrapper.selectOptions("//div[@jsname = 'V68bde']//div[@jsname = 'wQNmvb']//span", optionsToSelect);

        //submitting the form
        wrapper.clickElementByXpath("//span[normalize-space(text()) = 'Submit']");

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'vHW8K']")));


        String successMessage = driver.findElement(By.xpath("//div[@class= 'vHW8K']")).getText();

        System.out.println(String.format("Message after form submission: %s", successMessage));


    }
    
}