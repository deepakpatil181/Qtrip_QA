package qtriptest.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdventurePage {
    private static RemoteWebDriver driver;

    


    public AdventurePage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void setFilterValue(String duration) {
        WebElement durationFiltr = driver.findElement(By.id("duration-select"));

        Select select = new Select(durationFiltr);
        select.selectByVisibleText(duration);
       
    }

    public void setCatagoryValue(String Category_Filter) {

        WebElement catagoryvalue=driver.findElement(By.id("category-select"));
        Select select = new Select(catagoryvalue);
        select.selectByVisibleText(Category_Filter);       
    }

    public int getResultCount(){
      
   

        java.util.List<WebElement> resultItems = driver.findElements(By.className("category-banner"));

        int count=resultItems.size();
        return count;
       

    }

    public void selectAdventure(String AdventureName) {
        WebElement selectadv=driver.findElement(By.xpath("//h5[text()='"+AdventureName+"']"));
        selectadv.click();    
    }
}
