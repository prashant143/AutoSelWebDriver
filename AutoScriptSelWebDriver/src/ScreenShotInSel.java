import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotInSel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"//Users//prashantvaghela//Documents//SeleniumWork//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		/*
		 * Use deleteCokieNamed method when you have scenario like 
		 * logout the session and click on any link and redirect to the login page to verify 
		 */
		//driver.manage().deleteCookieNamed("SessionKey");
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.ca");
		/*
		 * Change behaviour of driver object by Casting with method call TakeScreenshot
		 * Casting - take an object of particular type and "turning it into"
		 * another object type 
		 */
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("//Users//prashantvaghela//Documents//screenshot.png"));
		driver.close();
		
		
	}

}
