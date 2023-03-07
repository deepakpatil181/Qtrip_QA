package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverFactory;
import qtriptest.pages.AdventureDetailsPage;
import qtriptest.pages.AdventurePage;
import qtriptest.pages.HistoryPage;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import qtriptest.pages.RegisterPage;
import java.net.MalformedURLException;
import java.nio.charset.MalformedInputException;
import java.util.UUID;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCase_03 {
    RemoteWebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    AdventurePage adventurePage;
    AdventureDetailsPage adventureDetailsPage;
    HistoryPage    historyPage;

      
    @BeforeTest(alwaysRun=true)
    public void setUp() throws Exception {
         driver = DriverFactory.getDriver();
         homePage=new HomePage(driver);
         registerPage=new RegisterPage(driver);
         loginPage=new LoginPage(driver);
         adventurePage=new AdventurePage(driver);
         adventureDetailsPage=new AdventureDetailsPage(driver);


    }
    @Test(description = "testCase_03", priority = 3,dataProvider = "userData",dataProviderClass = DP.class,groups = "Booking and Cancellation Flow")
    public void TestCase03(String test,String email,String password,String cityName,String AdventureName,String GuestName,String date,String count) throws InterruptedException {
        String generatedRandomUser =email+ UUID.randomUUID().toString()+"gmail.com" ;
        String loginUser=generatedRandomUser;
    
        // 1. Navigate to Home Page of QTrip
      
        // 2. Click on the Register Page
        homePage.homeregister();

        Thread.sleep(1000);
    
        // 3. Verify that registration page is displayed
        
        // 4. Enter email , Password & Confirm Password
        registerPage.RegiUser(generatedRandomUser, password, password);


    
        //Assert.assertTrue(loginPage.isLogInDisplayed(), "Login page is not displayed.");
        Thread.sleep(1000);
    
        // 7. Enter the created user credentials and click on Login
        loginPage.login(loginUser, password);
        Thread.sleep(1000);
        // 3. Search for an adventure
        homePage.searchCity(cityName);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[@id='"+cityName.toLowerCase()+"']")).click();

        //clear filter
        driver.findElement(By.xpath("//div[@onclick='clearDuration(event)']")).click();
        driver.findElement(By.xpath("//div[@onclick='clearCategory(event)']")).click();

        //select adventure
        adventurePage.selectAdventure(AdventureName);

        // 4. Enter Name and Date and Reserve the adventure
        Thread.sleep(5000);

        adventureDetailsPage.adventureBook(GuestName, date, count);
        Thread.sleep(3000);

        // 5. Verify that the adventure booking was successful
        driver.findElement(By.xpath("//a[normalize-space()='Reservations']")).click();

        Thread.sleep(5000);
        adventureDetailsPage.isbookingSuccessFully();
        // 6. Click on the history page

        // 7. Note down the transaction ID
         // 8. Cancel the Reservation
        driver.findElement(By.xpath("//button[@class='cancel-button']")).click();
        Thread.sleep(2000);
       
        // 9. Refresh the page
         driver.navigate().refresh();
         Thread.sleep(3000);
        // 10. Check if the transaction ID is removed
        adventureDetailsPage.isBookingCanceled();
        Thread.sleep(1000);
        adventureDetailsPage.logOutClick();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@class='nav-link']")).click();
                
    }
    @AfterTest
    public void tearDown() {
        
            driver.quit();
        
    }
}
