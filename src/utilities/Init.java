package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Init {
	
	public static WebDriver driver;
	
	private Init(){}
	
	public static void Initialition() {
		//System.setProperty("webdriver.chrome.driver", "/Users/talos/libs/Selenium/chromedriver");

		//driver = new ChromeDriver();	
		//driver.manage().window().maximize();
		//TODO: Waiting for a url valid
		//driver.navigate().to("http://www.google.com");
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Capabilities caps = new DesiredCapabilities();
        ((DesiredCapabilities) caps).setJavascriptEnabled(true);                
        ((DesiredCapabilities) caps).setCapability("takesScreenshot", true);  
        ((DesiredCapabilities) caps).setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                "/Users/talos/libs/Selenium/phantomjs"
            );
        driver = new  PhantomJSDriver(caps);
        driver.manage().window().maximize();
        driver.navigate().to("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	public static void finish(){
		driver.quit();
	}
}