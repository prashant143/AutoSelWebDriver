import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandleHTTPSCertificate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Create object for ChromeOptions to handle the SSL certificate of website 
		 * customize chrome browser using desired capabilities
		 * Aim is to accept SSL certificate
		 * General chrome profile
		 */
		DesiredCapabilities chro = DesiredCapabilities.chrome();
		chro.acceptInsecureCerts();
		chro.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		chro.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		//Belongs to local browser. Merging with local web browser from general web browser
		ChromeOptions optionsObject = new ChromeOptions();
		optionsObject.merge(chro);
		System.setProperty("webdriver.chrome.driver",
				"//Users//prashantvaghela//Documents//SeleniumWork//chromedriver");
		WebDriver driver = new ChromeDriver(optionsObject);
		driver.close();
		
	}

}
