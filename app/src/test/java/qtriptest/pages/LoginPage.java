package qtriptest.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  
    private WebDriver driver;

    @FindBy(id = "floatingInput")
    private WebElement emailLogIn;

    @FindBy(name = "password")
    private WebElement logInPwd;

    @FindBy(xpath ="//button[@type='submit']")
    private WebElement logInbtn;

    // @FindBy(xpath = "//div[@class='nav-link login register']")
    // private WebElement logOutBtn;



    public LoginPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    
    }

    public void login(String email,String passWord) throws InterruptedException {
        
        emailLogIn.sendKeys(email);
        logInPwd.sendKeys(passWord);
        logInbtn.click();
    }

    public boolean isLogInDisplayed() {
        return logInbtn.isDisplayed();
    }

    // public boolean isUserLoggedIn() {
    //     return logOutBtn.isDisplayed();
    // }
}
