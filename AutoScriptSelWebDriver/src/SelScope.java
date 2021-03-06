import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelScope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * Count the links are present in the web form using tagName and size method
		 */
		System.setProperty("webdriver.chrome.driver",
				"//Users//prashantvaghela//Documents//SeleniumWork//chromedriver");
		WebDriver driver = new ChromeDriver();
		/*
		 * Maximize the window and delete all the cookies
		 */
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://atp.com/");
		//System.out.println(driver.findElements(By.tagName("a")).size());
		/*
		 * Count links in footer section Limit the scope using selenium store footer Div
		 * tag division into the WebElement variable then using that variable get the
		 * count of a tags inside the Div tag
		 */
		WebElement footerLinks = driver.findElement(By.xpath
				("//div[@class='fusion-widget fusion-widget-element fusion-widget-area fusion-content-widget-area wpWidget-1 cb-footer-menu']"));
		System.out.println(footerLinks.findElements(By.tagName("a")).size());
//
//		WebElement footerLinks1 = driver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
//		System.out.println(footerLinks1.findElements(By.tagName("a")).size());
		/*
		 * Click on the link and check whether it is working or not use COMMAND for
		 * macbook and CONTROL for widnows as an argument in Keys method.
		 */
		for (int i = 1; i < footerLinks.findElements(By.tagName("a")).size(); i++) {

			String clickLinks = Keys.chord(Keys.COMMAND, Keys.ENTER);
			footerLinks.findElements(By.tagName("a")).get(i).sendKeys(clickLinks);
			Thread.sleep(5000L);
		}
		/*
		 * Print the title of every window opens in new tab
		 */
		Set<String> tabIndex = driver.getWindowHandles();
		Iterator<String> it = tabIndex.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

	}

}
