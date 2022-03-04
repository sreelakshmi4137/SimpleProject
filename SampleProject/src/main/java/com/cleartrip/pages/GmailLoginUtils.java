package com.cleartrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.cleartrip.objects.GmailLoginObjects;
import com.cleartrip.utils.FrontEnd;
import com.cleartrip.utils.SeleniumUtils;


public class GmailLoginUtils extends FrontEnd{

	/*
	 * We are maintaining scripts using @test for test 
	 */

	public SeleniumUtils seleniumUtil;
	public GmailLoginObjects gmailLoginObjects;

	/**
	 * Class instantiation Before class.
	 */
	public GmailLoginUtils(WebDriver driver) {
		seleniumUtil=PageFactory.initElements(driver, SeleniumUtils.class);
		gmailLoginObjects=PageFactory.initElements(driver, GmailLoginObjects.class);
	}

	public void gmailLogin(String username,String password) throws InterruptedException{
		seleniumUtil.enterText(gmailLoginObjects.username, username);
		seleniumUtil.scriptclickOnElement(gmailLoginObjects.nextButton);
		Thread.sleep(1000);
		seleniumUtil.enterText(gmailLoginObjects.password, password);
		seleniumUtil.scriptclickOnElement(gmailLoginObjects.nextButton);
		Thread.sleep(1000);
	}

}
