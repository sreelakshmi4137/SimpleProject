package com.cleartrip.testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cleartrip.pages.GmailLoginUtils;
import com.cleartrip.utils.FrontEnd;
import com.cleartrip.utils.SeleniumUtils;

public class GmailLoginScripts extends FrontEnd{

	/*
	 * We are maintaining scripts using @test for test 
	 */

	public SeleniumUtils seleniumUtil;
	public GmailLoginUtils gmailLoginUtils;

	/**
	 * Class instantiation Before class.
	 */
	@BeforeClass
	public void loading_Objects_Classes() {
		seleniumUtil=PageFactory.initElements(driver, SeleniumUtils.class);
		gmailLoginUtils=PageFactory.initElements(driver, GmailLoginUtils.class);
	}


	@Test
	public void gmailLogin() throws InterruptedException{
		gmailLoginUtils.gmailLogin(prob.getProperty("username"), prob.getProperty("password"));
		
	}

}
