package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverFactory;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import qtriptest.pages.RegisterPage;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testCase_01  {

    RemoteWebDriver driver;
    RegisterPage registerPage;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeTest(alwaysRun=true)
    public void setUp() throws Exception {
         driver = DriverFactory.getDriver();


        // Navigate to the registration page
        



        // Initialize the RegistrationPage object
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }  
    
    // @BeforeTest
    // public void setUp() throws Exception {
    //     // Set up the desired capabilities for the remote WebDriver
    //     DesiredCapabilities capabilities = new DesiredCapabilities();
    //     //capabilities.setBrowserName("chrome");
    //     capabilities.setBrowserName(BrowserType.CHROME);

    //     // Create a URL object for the Selenium Grid server
    //     URL url = new URL("http://localhost:8082/wd/hub");

    //     // Create a new RemoteWebDriver instance
    //     driver = new RemoteWebDriver(url, capabilities);
    //     driver.manage().window().maximize();
    //     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    //     // Navigate to the registration page
    //     driver.get("https://qtripdynamic-qa-frontend.vercel.app/");

    //     Thread.sleep(15000);

    //     // Initialize the RegistrationPage object
    //     homePage = new HomePage(driver);
    //     registerPage = new RegisterPage(driver);
    //     loginPage = new LoginPage(driver);
    //    // adventurePage= new AdventurePage(driver);
    // }
    @Test(description = "testCase_01", priority = 1, dataProvider="userData",dataProviderClass = DP.class)
    public void TestCase01(String test ,String email, String password ) throws InterruptedException {
        // Generate a random email address using UUID
        String generatedRandomUser =email+ UUID.randomUUID().toString()+"gmail.com" ;
        String loginUser=generatedRandomUser;
    
        // 1. Navigate to Home Page of QTrip
        Assert.assertTrue(homePage.isPageDisplayed(), "Home page is not displayed.");
    
        // 2. Click on the Register Page
        homePage.homeregister();

        Thread.sleep(1000);
    
        // 3. Verify that registration page is displayed
        
        // 4. Enter email , Password & Confirm Password
        registerPage.RegiUser(generatedRandomUser, password, password);


    
        Assert.assertTrue(loginPage.isLogInDisplayed(), "Login page is not displayed.");
        Thread.sleep(1000);
    
        // 7. Enter the created user credentials and click on Login
        loginPage.login(loginUser, password);
        Thread.sleep(1000);
  
        // Assert.assertTrue(loginPage.isUserLoggedIn(), "User is not logged in.");
        // Thread.sleep(3000);
    
        // 9. Click on the Logout Button
        // homePage.Logoutbtnclick();
        driver.findElement(By.xpath("//*[@onclick='Logout()']")).click();
        // Thread.sleep(3000);
    
       
        Assert.assertTrue(homePage.isUserLoggedOut(), "User is not logged out.");
    }

    @AfterTest
public void tearDown() {
    
        driver.quit();
    
}
}
    