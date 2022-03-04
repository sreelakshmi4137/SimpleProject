package com.cleartrip.pages;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.cleartrip.objects.ClearTripHotelsObjects;
import com.cleartrip.utils.FrontEnd;
import com.cleartrip.utils.SeleniumUtils;


public class ClearTripHotelsUtils extends FrontEnd{
	
	/*
	 * We are maintaining module level reusable method 
	 */

	public SeleniumUtils seleniumutil;
	public ClearTripHotelsObjects  clearTripHotelsObjects;

	public ClearTripHotelsUtils(WebDriver driver) {
		seleniumutil=PageFactory.initElements(driver,SeleniumUtils.class);
		clearTripHotelsObjects=PageFactory.initElements(driver, ClearTripHotelsObjects.class);
	}

	public void hotels(){
		seleniumutil.clickOnElement(clearTripHotelsObjects.hotels);
	}

	public void selectDestinationsWithCity(String textToSelect) {
		try {
			Thread.sleep(2000);
			List<WebElement> optionsToSelect = clearTripHotelsObjects.locationlist;
			System.out.println(optionsToSelect );
			for (int i = 0; i < optionsToSelect.size(); i++) {
				String text=optionsToSelect.get(i).getText();
				if (text.contains(textToSelect)) {
					optionsToSelect.get(i).click();
					break;
				}
			}
		}catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println("test-----");
		}
	}

	public void location(String city,String selectcity) throws InterruptedException{
		seleniumutil.enterText(clearTripHotelsObjects.location, city);
		seleniumutil.enterText(clearTripHotelsObjects.location, "");
		seleniumutil.enterText(clearTripHotelsObjects.location, "Chenn");
		Thread.sleep(20000);
		selectDestinationsWithCity(selectcity);
	}

	
	public void CheckInDate(){
		seleniumutil.clickOnElement(clearTripHotelsObjects.CheckInDate);
		String cal_firstxpath="(//div[text()=";
		String cal_endxpath="])[1]";
		Date date=new Date();
		@SuppressWarnings("deprecation")
		int today=date.getDate();
		String cal_TotalPath=cal_firstxpath+today+cal_endxpath;
		WebElement selectDepartDate=driver.findElement(By.xpath(cal_TotalPath));
		seleniumutil.clickOnElement(selectDepartDate);
	}

	public void CheckOutDate(){
		seleniumutil.clickOnElement(clearTripHotelsObjects.CheckOutDate);
		String cal_firstxpath="(//div[text()=";
		String cal_endxpath="])";
		Date date=new Date();
		@SuppressWarnings("deprecation")
		int today=date.getDate()+2;
		String cal_TotalPath=cal_firstxpath+today+cal_endxpath;
		WebElement selectDepartDate=driver.findElement(By.xpath(cal_TotalPath));
		seleniumutil.clickOnElement(selectDepartDate);
	}
	
	public void searchHotelsButton(){
		seleniumutil.clickOnElement(clearTripHotelsObjects.SearchHotelsButton);
	}
	
}
