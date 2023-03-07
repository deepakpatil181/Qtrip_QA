
package qtriptest.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;
import javax.swing.text.StyledEditorKit.BoldAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeoutException;


public class AdventureDetailsPage {
    public RemoteWebDriver driver;

    @FindBy(name = "name")
    WebElement typeName;

    @FindBy(xpath = "//input[@name='date']")
    WebElement dateSelect;

    @FindBy(xpath = "//input[@name='person']")
    WebElement personCount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitBooking;

    @FindBy(xpath ="//input[@name='date']" )
    WebElement datePicker;

    @FindBy(xpath = "//div[@class='nav-link login register']")
    WebElement logOutBtnadventDetailPage;

    public AdventureDetailsPage(RemoteWebDriver driver) {
        this.driver =  driver;
        PageFactory.initElements(driver, this);
    }

    public void adventureBook(String name,String date,String count) {
        typeName.sendKeys(name);

        datePicker.sendKeys(date);

        personCount.clear();
        personCount.sendKeys(count);
        submitBooking.click();
        
    }

    public boolean isbookingSuccessFully() {
         return driver.findElement(By.xpath("//button[text()='Cancel']")).isDisplayed();
        
    }

    public boolean isBookingCanceled() {
     
            WebElement element = driver.findElement(By.xpath("//div[@id='no-reservation-banner']"));
            return element.isDisplayed();
}
    public void logOutClick() {
        logOutBtnadventDetailPage.click();
        
    }


}