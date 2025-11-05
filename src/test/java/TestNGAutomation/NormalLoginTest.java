package TestNGAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import Base.BaseTest;

public class NormalLoginTest extends BaseTest {

    @Test(priority = 1)
    public void normalLoginDemo() {
        System.out.println("🔹 Executing Normal Selenium Login Test");

        // Login actions
        driver.findElement(By.id("username")).sendKeys("learning@tecskool.com");
        driver.findElement(By.id("password")).sendKeys("tecskool123");
        driver.findElement(By.id("login-button")).click();

        // Selection Controls
        driver.findElement(By.id("male")).click();
        driver.findElement(By.id("female")).click();

        // Dropdown example
        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByVisibleText("India");

        System.out.println("✅ Normal Selenium Login flow completed successfully.");
    }
}
