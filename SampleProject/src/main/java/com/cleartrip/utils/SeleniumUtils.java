package com.cleartrip.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtils extends FrontEnd{
	
	public void enterText(WebElement object,String text){
		object.clear();
		object.sendKeys(text);
	}
	
	public void clickOnElement(WebElement object){
		object.click();
	}
	
	public void selectDropdownList(WebElement object,String text){
		Select select=new Select(object);
		select.selectByVisibleText(text);
	}
	
	public void scriptclickOnElement(WebElement object){
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", object);
	}
	
	public void moveToElementClickOnElement(WebElement object){
		Actions act=new Actions(driver);
		act.click(object).build().perform();
	}

	
	
}
