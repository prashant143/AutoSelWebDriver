import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksDemo {

	public static void main(String[] args) {
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
		
		driver.close();
	}

}
