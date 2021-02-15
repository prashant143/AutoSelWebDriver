import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcomSeleniumAuto {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Prashant\\chromedriver_win32\\chromedriver.exe");
		// Create object for ChromeDriver
		WebDriver driver = new ChromeDriver();
		//Give global timeout using implicit wait 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Declare array variable
		String[] vegetables = { "Cucumber", "Brocolli", "Beetroot" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		//Thread.sleep(4000);
		addItems(driver, vegetables);
	}

	public static void addItems(WebDriver driver, String[] vegetables) {

		int j = 0;
		// Exctract all the products from the web page using css class name
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		// Create for loop to iterate all the products name
		for (int i = 0; i < products.size(); i++) {
			// store the split product name into the array variable
			String[] productName = products.get(i).getText().split("-");
			// remove all the spaces front and back using trim method, before comparing to
			// the productname, trim the product name
			String trimmedVeggieNames = productName[0].trim();
			// convert Array to arraylist
			List vegetablesList = Arrays.asList(vegetables);
			// Create if to match with our products listed in array
			if (vegetablesList.contains(trimmedVeggieNames)) {
				j++;
				// Click to Add to cart for particular product
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == vegetables.length) {
					break;
				}
			}

		}
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("Rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		/*
		 * Explicit wait applies wherever required
		 * WebDriverWait is selenium class and it takes two parameters. 
		 * One is object name of WebDriver and number of seconds
		 */
		WebDriverWait explicitWait = new WebDriverWait(driver, 5);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
	}

}
