
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SelWebDriver {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Access chrome driver from Local machine
		System.setProperty("webdriver.chrome.driver", "C:\\Prashant\\chromedriver_win32\\chromedriver.exe");
		// Create object for ChromeDriver
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// driver.manage().window().fullscreen();
		// store element locator in variable
		WebElement StaticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		// Pass variable
		Select dropdown = new Select(StaticDropDown);
		// Select text by index, value and visibletext
		dropdown.selectByIndex(3);
		// dropdown.getFirstSelectedOption();
		dropdown.selectByValue("AED");
		dropdown.selectByVisibleText("INR");

		driver.findElement(By.id("divpaxinfo")).click();
		// Thread.sleep(3000L);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		/*
		 * int i = 1; while(i<5) { driver.findElement(By.id("hrefIncAdt")).click(); i++;
		 * }
		 */
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='STV']")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		// driver.findElement(By.xpath("(//a[@value='AMD'])[2] ")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='AMD']"))
				.click();

		// Work with auto suggestive dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}

		// work with radio buttons and check boxes
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		// Check if checkbox got selected or not
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		driver.close();
	}

}
