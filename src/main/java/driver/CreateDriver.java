package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateDriver {

    protected static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver(){
        if (driver!=null){
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}
/*
    Patten Singleton
 */



