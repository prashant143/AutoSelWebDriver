import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBoxAssignment extends SelWebDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nametext = "Prashant";
		System.setProperty("webdriver.chrome.driver", "C:\\Prashant\\chromedriver_win32\\chromedriver.exe");
		//Create object for ChromeDriver
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(nametext);
		driver.findElement(By.id("alertbtn")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();
		//driver.findElement(By.id("checkBoxOption1")).click();
		//Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//driver.findElement(By.id("checkBoxOption1")).click();
		//Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//System.out.println( driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		//driver.quit();
		
		
	
		
	}

}
