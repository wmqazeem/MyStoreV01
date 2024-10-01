package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	 // create object of webDriver
		WebDriver ldriver;
	//	constructor
		public MyAccount(WebDriver rdriver) {
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
	//identify web element
		@FindBy(name="email_create")WebElement email;
		@FindBy(id="SubmitCreate")WebElement SubmitCreate;
		
		//Identify action on webElement
		public void enterCreateEmail(String emailId) {
			email.sendKeys(emailId);
		}
		
		public void clickSubmit() {
			SubmitCreate.click();
		}
}
