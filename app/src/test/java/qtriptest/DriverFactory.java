package qtriptest;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
public class DriverFactory {
    private static RemoteWebDriver driver;

    private DriverFactory() {}

    public static RemoteWebDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(BrowserType.CHROME);
            driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qtripdynamic-qa-frontend.vercel.app/");

        }
        return driver;
    }
}