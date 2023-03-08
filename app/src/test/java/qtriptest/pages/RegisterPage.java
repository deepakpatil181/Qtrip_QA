package qtriptest.pages;

import qtriptest.SeleniumWrapper;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    public RemoteWebDriver driver;
    private SeleniumWrapper seleniumwWrapper;
    private By emailField = By.id("floatingInput");
    private By passwordField = By.id("floatingPassword");
    private By confirmPasswordField = By.name("confirmpassword");
    private By registerBtn = By.xpath("//button[@type='submit']");
    private By loginNowBtn = By.xpath("//a[text()='Login Now']");

    public RegisterPage(RemoteWebDriver driver) {
        this.seleniumwWrapper = new SeleniumWrapper(driver);
    }
    
    public void RegiUser(String email, String password, String confirmPassword) throws InterruptedException {
        
        Thread.sleep(2000);
        seleniumwWrapper.AdvancesetKey(emailField, email);
        Thread.sleep(1000);
        seleniumwWrapper.AdvancesetKey(passwordField, password);
        Thread.sleep(1000);
        seleniumwWrapper.AdvancesetKey(confirmPasswordField, confirmPassword);
        Thread.sleep(1000);
        seleniumwWrapper.clickElement(registerBtn);
        Thread.sleep(2000);
    }
}