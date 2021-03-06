import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaStreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"//Users//prashantvaghela//Documents//SeleniumWork//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		/*
		 * Step 1: Click on Column to sort the product list
		 * Step 2: Get all the presents webelements in the column using gettext() method
		 * Step 3: Sort the list using sort method (original list)
		 * Step 4: Compare the original list to present list to check whether it arranged or not
		 */
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> itemNames = driver.findElements
				(By.xpath("//tr/td[1]"));
		List<String> originalSortedNames = itemNames.stream()
				.map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedNames =  originalSortedNames.
				stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalSortedNames.equals(sortedNames));
		List<String> itemPrice;
		do {
			List<WebElement> rows = driver.findElements
					(By.xpath("//tr/td[1]"));
			itemPrice = rows.stream().filter(s->s.getText().
					contains("Rice")).map(s->getItemPrice(s)).
					collect(Collectors.toList());
			itemPrice.forEach(a->System.out.println(a));
			
			if(itemPrice.size()<1)
			{
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		}while(itemPrice.size()<1);
		//driver.close();
		
	}

	private static String getItemPrice(WebElement s) {
		// TODO Auto-generated method stub
		String value = s.findElement(By.xpath("//tr/td[1]/following-sibling::td[1]")).getText();
		return value;
	}

}
