package TestNGAutomation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import Base.BaseTest;
import Pages.LoginPage;

public class PageFactoryLoginTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(PageFactoryLoginTest.class);

    @Test(priority = 2)
    public void loginUsingPageFactory() {
        log.info("Executing PageFactory Model Login Test...");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("learning@tecskool.com", "tecskool123");
        loginPage.selectGender("Male");
        loginPage.selectCountry("India");

        log.info("PageFactory Model Login flow completed successfully.");
    }
}
