package qtriptest.tests;


import qtriptest.DP;
import qtriptest.DriverFactory;
import qtriptest.pages.AdventureDetailsPage;
import qtriptest.pages.AdventurePage;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import qtriptest.pages.RegisterPage;
import java.net.URL;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.apache.poi.ss.formula.functions.Count;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class testCase_02{
    

        RemoteWebDriver driver;
        RegisterPage registerPage;
        HomePage homePage;
        LoginPage loginPage;
        AdventurePage adventurePage;
        int actualCount=0;
        int actualallCount=0;
        
        @BeforeTest(alwaysRun=true)
        public void setUp() throws Exception {
             driver = DriverFactory.getDriver();

            // // Set up the desired capabilities for the remote WebDriver
            // DesiredCapabilities capabilities = new DesiredCapabilities();
            // //capabilities.setBrowserName("chrome");
            // capabilities.setBrowserName(BrowserType.CHROME);
    
            // // Create a URL object for the Selenium Grid server
            // URL url = new URL("http://localhost:8082/wd/hub");
    
            // // Create a new RemoteWebDriver instance
            // driver = new RemoteWebDriver(url, capabilities);
            // driver.manage().window().maximize();
            // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
            // // Navigate to the registration page
            // driver.get("https://qtripdynamic-qa-frontend.vercel.app/");
    
            // Thread.sleep(15000);
    
            // Initialize the RegistrationPage object
            homePage = new HomePage(driver);
            registerPage = new RegisterPage(driver);
            loginPage = new LoginPage(driver);
            adventurePage= new AdventurePage(driver);
        }

        @Test(description = "testCase_02", priority = 2, dataProvider = "userData",dataProviderClass = DP.class)
        public void TestCase02(String test,String cityName,String Category_Filter,String duration,String ExpectedFilteredResults, String ExpectedUnFilteredResults ) throws InterruptedException {

            String generateRandomCityName="Deepak";

            Thread.sleep(5000);

            // 2. Search for a city that's not present
            homePage.searchCity(generateRandomCityName);

           

            // 3. Verify if the no matches found message is displayed
            homePage.selectCity("Deepak");

            Thread.sleep(2000);
            
            driver.findElement(By.xpath("//input[@id='autocomplete']")).clear();
           

            Thread.sleep(4000);
         

            // 4. Search for a city that's present
            homePage.searchCity(cityName);
            Thread.sleep(1000);

            // 5. verify that the city is displayed on auto complete
        //     homePage.assertautocompleteTest();
        //    Thread.sleep(1000);
        //    Assert.assertTrue(homePage.assertautocompleteTest(),"autoComplete is not working");
    

            
            // 6. Click on the city
            driver.findElement(By.xpath("//a[@id='"+cityName.toLowerCase()+"']")).click();
          //  homePage.selectCity("Bengaluru");

            // 7. Select Filters : hours
            adventurePage.setCatagoryValue(Category_Filter);
            adventurePage.setFilterValue(duration);
            
            Thread.sleep(1000);
            
            
            // 8. Verify that appropriate data is displayed
            adventurePage.getResultCount();
            
            Assert.assertEquals(String.valueOf(adventurePage.getResultCount()), ExpectedFilteredResults, "it showing wrong");


           
      
           //  Assert.assertEquals(actualCount, 1, "Count of activities does not match the expected count");

           Thread.sleep(2000);

            // 9. Select category
            // 10. Verify that appropriate data is displayed
            driver.findElement(By.xpath("//div[@onclick='clearDuration(event)']")).click();
            driver.findElement(By.xpath("//div[@onclick='clearCategory(event)']")).click();
            Thread.sleep(1000);

            
            
           //  Assert.assertEquals(actualallCount, 9, "Count of activities does not match the expected count");
            // 11. Clear Filters and category

            // 12. Verify that all the records are displayed"	
            Assert.assertEquals(String.valueOf(adventurePage.getResultCount()), ExpectedUnFilteredResults,"it showing wrong");
            
            driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
            Thread.sleep(1000);

}
@AfterTest
public void tearDown() {
    
        driver.quit();
    
}

}
