

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class BrokenLinksDemo {

	public static void main(String[] args) throws MalformedURLException, IOException {
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
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		/*
		 * Find broken URL in webopage 
		 * Java methods will call URL and get the status of each and every URL 
		 * Step 1 - get all URL and gets you the status code
		 * if status code us > 400 then URL is not working -> Link which is tied up to the anchor tag
		 */
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert soft = new SoftAssert();
		
		for(WebElement link : links)
		{
			String url =link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			soft.assertTrue(respCode<400, "The link with text " + link.getText() +" is broken with code "+ respCode);
		}
		soft.assertAll();
		driver.close();
	}

}
