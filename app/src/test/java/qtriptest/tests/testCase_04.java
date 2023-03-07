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

public class testCase_04 {
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
         historyPage=new HistoryPage(driver);

    }
    @Test(description = "testCase_04", priority = 4,dataProvider = "userData",dataProviderClass = DP.class)
    public void TestCase04(String test,String email, String password,String dataSet,String dataSet1,String dataSet2) throws InterruptedException {

            String generatedRandomUser =email+ UUID.randomUUID().toString()+"gmail.com" ;
            String loginUser=generatedRandomUser;

            String data = dataSet;
            String[] adventureData = data.split(";");

            String data1= dataSet1;
            String[] adventureData1 = data1.split(";");

            String data2= dataSet2;
            String[] adventureData2= data2.split(";");

        
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
            homePage.searchCity(adventureData[0]);
            Thread.sleep(1000);
            

            driver.findElement(By.xpath("//a[@id='"+adventureData[0].toLowerCase()+"']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[.//h5[text()='" + adventureData[1] + "']]")).click();

            
             adventureDetailsPage.adventureBook(adventureData[2], adventureData[3], adventureData[4]);
             Thread.sleep(3000);

                    
                // 5. Verify that the adventure booking was successful
                driver.findElement(By.xpath("//a[normalize-space()='Reservations']")).click();

                Thread.sleep(5000);
               

                driver.findElement(By.xpath("//a[@class='nav-link']")).click();
                Thread.sleep(2000);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////    

        homePage.searchCity(adventureData1[0]);
        Thread.sleep(1000);
        

        driver.findElement(By.xpath("//a[@id='"+adventureData1[0].toLowerCase()+"']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[.//h5[text()='" + adventureData1[1] + "']]")).click();

        
         adventureDetailsPage.adventureBook(adventureData1[2], adventureData1[3], adventureData1[4]);
         Thread.sleep(3000);

                
            // 5. Verify that the adventure booking was successful
            driver.findElement(By.xpath("//a[normalize-space()='Reservations']")).click();

            Thread.sleep(5000);

            driver.findElement(By.xpath("//a[@class='nav-link']")).click();
            Thread.sleep(2000);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                homePage.searchCity(adventureData2[0]);
                Thread.sleep(1000);


                driver.findElement(By.xpath("//a[@id='"+adventureData2[0].toLowerCase()+"']")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//a[.//h5[text()='" + adventureData2[1] + "']]")).click();


                adventureDetailsPage.adventureBook(adventureData2[2], adventureData2[3], adventureData2[4]);
                Thread.sleep(3000);

                        
                    // 5. Verify that the adventure booking was successful
                    driver.findElement(By.xpath("//a[normalize-space()='Reservations']")).click();

                    Thread.sleep(5000);
                    historyPage.isallBooking();

                    driver.findElement(By.xpath("//a[@class='nav-link']")).click();
                    Thread.sleep(2000);
////////////////////////////////////////////////////////////////////////////////////////
            
    driver.findElement(By.xpath("//div[@class='nav-link login register']")).click();

    }
    @AfterTest
    public void tearDown() {
        
            driver.quit();
        
    }
}
     
