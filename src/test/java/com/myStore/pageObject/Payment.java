package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment {
	WebDriver ldriver;
	public Payment(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
 @FindBy(xpath="//a[@title='Pay by check.']")WebElement check;
 @FindBy(xpath="//button[@class='button btn btn-default button-medium']")WebElement orderConfirm;
 
 public void payByCheck() {
	 check.click();
 
	}
 public void OrderConfirm() {
	 orderConfirm.click();
 
	}

}
