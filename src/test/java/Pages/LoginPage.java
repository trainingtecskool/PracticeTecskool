package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    // Page Elements
    @FindBy(id = "username") WebElement txtUsername;
    @FindBy(id = "password") WebElement txtPassword;
    @FindBy(id = "login-button") WebElement btnLogin;
    @FindBy(id = "male") WebElement rdoMale;
    @FindBy(id = "female") WebElement rdoFemale;
    @FindBy(id = "country") WebElement ddlCountry;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void login(String user, String pass) {
        log.info("Entering username: " + user);
        txtUsername.sendKeys(user);
        log.info("Entering password...");
        txtPassword.sendKeys(pass);
        log.info("Clicking login button.");
        btnLogin.click();
    }

    public void selectGender(String gender) {
        log.info("Selecting gender: " + gender);
        if (gender.equalsIgnoreCase("male"))
            rdoMale.click();
        else if (gender.equalsIgnoreCase("female"))
            rdoFemale.click();
    }

    public void selectCountry(String countryName) {
        log.info("Selecting country: " + countryName);
        Select select = new Select(ddlCountry);
        select.selectByVisibleText(countryName);
    }
}
