package qtriptest.pages;

import java.util.UUID;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    RemoteWebDriver driver;

    @FindBy(id = "floatingInput")
    WebElement emailField;
     

    @FindBy(id = "floatingPassword")
    WebElement passwordField;

    @FindBy(name = "confirmpassword")
    WebElement confirmPasswordField;

    @FindBy(className = "btn-login")
    WebElement registerBtn;

    @FindBy(xpath = "//a[text()='Login Now']")
    WebElement LoginnowBtn;

    public RegisterPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void RegiUser(String email, String password, String confirmPassword) throws InterruptedException {
        
    
        Thread.sleep(5000);
        emailField.clear();
        emailField.sendKeys(email);
    
        Thread.sleep(5000);
        passwordField.clear();
        passwordField.sendKeys(password);
    
        confirmPasswordField.sendKeys(confirmPassword);
        registerBtn.click();
    }
}