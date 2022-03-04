package com.cleartrip.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailLoginObjects {

	/*
	 * here we are maintaining all module wise object 
	 */

	@FindBy(xpath="//input[@id='identifierId']")
	public WebElement username;

	@FindBy(xpath="//div[@class='ZFr60d CeoRYc']")
	public WebElement nextButton;

	@FindBy(xpath="//input[@class='whsOnd zHQkBf']")
	public WebElement password;


}
