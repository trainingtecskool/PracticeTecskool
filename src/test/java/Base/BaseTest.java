package Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected static WebDriver driver;
    private static final Logger log = LogManager.getLogger(BaseTest.class);

    @Parameters("headless") // ✅ Reads value from testng.xml
    @BeforeSuite
    public void setup(String headless) {
        log.info("Setting up browser...");

        // Setup ChromeDriver automatically new code
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions(); 

        // ✅ Enable headless dynamically
        if (headless.equalsIgnoreCase("true")) {
            options.addArguments("--headless=new"); // Selenium 4 headless mode
//            options.addArguments("--window-size=1920,1080");
//            options.addArguments("--disable-gpu");
//            options.addArguments("--remote-allow-origins=*");
            log.info("🚀 Running in HEADLESS mode");
            log.info("🚀 Running in HEADLESS HOTFIX");
            log.info("🚀 Running in HEADLESS mode123jjAA");
        } else {
            log.info("🧭 Running in NORMAL mode");
        }

        // Launch driver with options
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://practice.tecskool.com");
        log.info("Navigated to Tecskool Practice site successfully.");
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            log.info("Closing browser session...");
            driver.quit();
            log.info("Browser closed successfully.");
        }
    }
}
