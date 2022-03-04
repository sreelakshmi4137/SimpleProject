package com.cleartrip.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class FrontEnd {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prob;
	public static FileInputStream fis;
	public String curdir=System.getProperty("user.dir");

	@BeforeSuite
	public void initBrowser() throws IOException, InterruptedException{
		configprob(curdir+"\\src\\main\\resources\\config\\config.properties");
		if ("Chrome".equals(prob.getProperty("browser"))) {
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
		}else if ("IE".equals(prob.getProperty("browser"))) {
			System.setProperty("webdriver.ie.driver", curdir+"\\src\\main\\resources\\browsers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
		}else if ("Firefox".equals(prob.getProperty("browser"))) {
			System.setProperty("webdriver.chrome.driver", curdir+"\\src\\main\\resources\\browsers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else {
			System.out.println("Invalid Browser Details .........");
		}
		driver.get(prob.getProperty("url"));
		Thread.sleep(3000);
	}

	private void configprob(String file) throws IOException {
		try {
			fis = new FileInputStream(file);
			prob=new Properties();
			prob.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void closeAllBrowsers(){
		driver.quit();
	}

}
