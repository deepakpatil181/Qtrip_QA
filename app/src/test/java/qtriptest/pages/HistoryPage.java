
package qtriptest.pages;

import java.util.List;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

public class HistoryPage {

    public RemoteWebDriver driver;

    public HistoryPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

public boolean isallBooking()
{
    List<WebElement> cancelBtns = driver.findElements(By.xpath("//button[@class='cancel-button']"));
    int size = cancelBtns.size();

    if (size==3){
        return true;
    }
    return false;
}
}