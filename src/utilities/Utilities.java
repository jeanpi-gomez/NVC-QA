package utilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {
	public static void captureScreenshot(WebDriver driver, String filename){
		
		try {
			TakesScreenshot ss = (TakesScreenshot)driver;
			
			File source = ss.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(source, new File("./Screenshot/"+ filename + ".png"));
			
			System.out.println("Screenshot taken");
			
		} catch(Exception e) {
			e.printStackTrace();	
			System.out.println("Not able to take screenshot"+ e.getMessage());
		}
	}
	
	public static boolean checkElement(By ele) {
		
			boolean present;
			
			try {
				Init.driver.findElement(ele);
				System.out.println("Element found.Test Passed");
				present = true;
			} catch(Exception e) {	
				e.getMessage();
				System.out.println("Element was not found. Test Failed. ERROR");
				present = false;
			}
			return present;
	}
	
	public static void goBack () {	
		Init.driver.navigate().back();
	}
	
}
