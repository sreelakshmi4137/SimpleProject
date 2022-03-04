package com.cleartrip.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClearTripHotelsObjects {

	/*
	 * here we are maintaining all module wise object 
	 */

	@FindBy(xpath="//a[@href='/hotels']")
	public WebElement hotels;

	@FindBy(name="search")
	public WebElement location;

	@FindBy(xpath="//li[contains(@class,'dropdown__item')]")
	public List<WebElement> locationlist;
	
	@FindBy(xpath="//button[@name='from']//div")
	public WebElement CheckInDate;
	
	@FindBy(xpath="//button[@name='to']//div")
	public WebElement CheckOutDate;
	
	@FindBy(xpath="//button[contains(text(),'Search')]")
	public WebElement SearchHotelsButton;
}
