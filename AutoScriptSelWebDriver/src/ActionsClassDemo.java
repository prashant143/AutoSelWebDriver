import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"//Users//prashantvaghela//Documents//SeleniumWork//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.ca");
		WebElement signInMove = driver.findElement(By.cssSelector("span[class='nav-line-2 nav-long-width']"));
		WebElement searchBoxMoveClick = driver.findElement(By.id("twotabsearchtextbox"));
		Actions mouseHover = new Actions(driver);
		mouseHover.moveToElement(signInMove).build().perform();
		mouseHover.moveToElement(searchBoxMoveClick).click().keyDown(Keys.SHIFT).sendKeys("glass for iphone xr")
				.doubleClick().build().perform();
		mouseHover.contextClick(signInMove).build().perform();
		//mouseHover.moveToElement(searchBoxMoveClick);
		driver.quit();

	}

}
