import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FluetWaitExa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "//Users//prashantvaghela//Documents//SeleniumWork//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.close();
		
		

	}

}
