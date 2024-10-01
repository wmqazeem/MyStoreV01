package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressCredential {

	 // create object of webDriver
	WebDriver ldriver;
//	constructor
	public AddressCredential(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//identify web element
		@FindBy(id="address1")WebElement address1;
		@FindBy(id="address2")WebElement address2;
		@FindBy(id="city")WebElement city;
		@FindBy(id="id_state")WebElement state;
		@FindBy(id="postcode")WebElement postcode;
		@FindBy(id="phone")WebElement phone;
		@FindBy(id="submitAddress")WebElement submitbtn;
		@FindBy(name="processAddress")WebElement processAddress;
		
		//Identify action on webElement
		
		public void Adress1(String addrs) {
			address1.sendKeys(addrs);
		}
		public void Adress2(String addrs) {
			address2.sendKeys(addrs);
		}
		public void City(String addrs) {
			city.sendKeys(addrs);
		}
		public void State(String addrs) {
			Select select=new Select(state);
			select.selectByVisibleText(addrs);
		}
		public void Postalcode(String addrs) {
			postcode.sendKeys(addrs);
		}
		public void PhoneNo(String addrs) {
			phone.sendKeys(addrs);
		}
		public void SubmitAddress() {
			submitbtn.click();
		}
		public void ProcessAddress() {
			 processAddress.click();
		}
		
		
}
