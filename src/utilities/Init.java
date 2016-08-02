package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Init {
	
	public static WebDriver driver;
	
	private Init(){}
	
	public static void Initialition() {
		System.setProperty("webdriver.chrome.driver", "/Users/talos/libs/Selenium/chromedriver");

		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		//TODO: Waiting for a url valid
		driver.navigate().to("https://nvc.com/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	public static void finish(){
		driver.quit();
	}
}