package com.cleartrip.testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cleartrip.pages.ClearTripHotelsUtils;
import com.cleartrip.utils.FrontEnd;
import com.cleartrip.utils.SeleniumUtils;

public class ClearTripHotelsScripts extends FrontEnd{

	/*
	 * We are maintaining scripts using @test for test 
	 */

	public SeleniumUtils seleniumUtil;
	public ClearTripHotelsUtils clearTripHotelsUtils;

	/**
	 * Class instantiation Before class.
	 */
	@BeforeClass
	public void loading_Objects_Classes() {
		seleniumUtil=PageFactory.initElements(driver, SeleniumUtils.class);
		clearTripHotelsUtils=PageFactory.initElements(driver, ClearTripHotelsUtils.class);
	}


	@Test
	public void hotelbooking() throws InterruptedException{
		clearTripHotelsUtils.hotels();
		clearTripHotelsUtils.location(prob.getProperty("city"), prob.getProperty("selectcity"));
		clearTripHotelsUtils.CheckInDate();
		Thread.sleep(10000);
		clearTripHotelsUtils.CheckOutDate();
		clearTripHotelsUtils.searchHotelsButton();
	}

}
