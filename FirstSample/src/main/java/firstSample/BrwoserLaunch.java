package firstSample;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class BrwoserLaunch {
	WebDriver driver;
	
	@Test
	public void launchBroswer() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		System.setProperty("webdriver.chrome.driver", "D:\\AutomationProjects\\Gopikrishna_Settipalli_Project\\Gopikrishna_Settipalli_Project\\src\\main\\resources\\browsers\\chromedriver.exe");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.skype.com/en/blogs/2019-03-skype-online/");
		driver.quit();
	}
}
