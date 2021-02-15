import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClearTripAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebElement classAirline, infDropdown, childDropdown, adultDropdown;
		String PreferredAirline = "Etihad";
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Prashant\\chromedriver_win32\\chromedriver.exe");
		// Create object for ChromeDriver
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.findElement(By.id("DepartDate")).click();
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		Thread.sleep(2000);
		// Select Adults from dropdown
		adultDropdown = driver.findElement(By.id("Adults"));
		Select adults = new Select(adultDropdown);
		adults.selectByIndex(5);

		// select children from dropdown
		childDropdown = driver.findElement(By.id("Adults"));
		Select children = new Select(childDropdown);
		children.selectByIndex(1);

		// select infant from dropdown
		infDropdown = driver.findElement(By.id("Childrens"));
		Select infant = new Select(infDropdown);
		infant.selectByIndex(0);

		// click on more options link
		driver.findElement(By.id("MoreOptionsLink")).click();
		// Select class
		classAirline = driver.findElement(By.id("Class"));
		Select classAir = new Select(classAirline);
		classAir.selectByIndex(3);

		driver.findElement(By.id("AirlineAutocomplete")).sendKeys(PreferredAirline);

		driver.findElement(By.id("SearchBtn")).click();

		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

	}

}
