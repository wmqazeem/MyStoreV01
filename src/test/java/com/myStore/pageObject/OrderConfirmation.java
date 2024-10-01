package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmation {
	WebDriver ldriver;
	public OrderConfirmation(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(xpath="//p[@class='alert alert-success']")WebElement confirmation;
	
	
	public String OrderConfirm() {
		return(confirmation.getText());
		
	}

}
