package qtriptest.pages;

import java.util.concurrent.TimeUnit;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private RemoteWebDriver driver;
    RegisterPage registerPage;
    String noresultFd;


    @FindBy(xpath = "//a[@id='bengaluru']")
    WebElement SelectCity;

    @FindBy(xpath  = "//a[@class='nav-link login register']")
    private WebElement homeregisterBtn;

    @FindBy(className = "nav-link login")
    private WebElement homeLogIn;

    @FindBy(id = "autocomplete")
    private WebElement searchCityhome;

    @FindBy(className = "nav-link logout")
    private WebElement logoutbtn;

  
    @FindBy(xpath = "//*[@onClick='clearDuration(event)']")
    WebElement clearBtnDuration;

    @FindBy(xpath ="//h5[normalize-space()='No City found']")
    WebElement noresultFoun;
  
    @FindBy(xpath = "//a[@id='bengaluru']")
    WebElement dropdwn;

    String noresultF;
  
   

    public HomePage(RemoteWebDriver driver) {
        this.driver = driver;
        registerPage = new RegisterPage(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    public void homeregister() {
        homeregisterBtn.click();
    }

    public void Logoutbtnclick() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(logoutbtn)).click();
    }

    public boolean isUserLoggedOut() {
        return homeregisterBtn.isDisplayed();
    }

    public boolean isPageDisplayed() {
        return driver.getCurrentUrl().contains("https://qtripdynamic-qa-frontend.vercel.app/");
    }



    public void searchCity(String cityName) throws InterruptedException {
        searchCityhome.sendKeys(cityName);
       
    }

    // public boolean assertautocompleteTest() {
    //   return dropdwn.isDisplayed();       
    // }

public void selectCity(String cityName) {
    noresultF =noresultFoun.getText();
    if(noresultF.equals("No City found")){
       searchCityhome.clear();
    }else{
        SelectCity.click();
    }   
}


    
    


}
