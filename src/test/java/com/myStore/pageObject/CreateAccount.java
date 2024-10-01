package com.myStore.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
	 // create object of webDriver
	WebDriver ldriver;
//	constructor
	public CreateAccount(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
//identify web element
	@FindBy(id="id_gender1")WebElement genderBtn;
	@FindBy(id="customer_firstname")WebElement EntrFName;
	@FindBy(id="customer_lastname")WebElement EntrLName;
	@FindBy(id="passwd")WebElement password;
	@FindBy(name="days")WebElement days;
	@FindBy(name="months")WebElement month;
	@FindBy(name="years")WebElement years;
	@FindBy(id="submitAccount")WebElement Register;
	
	
	//Identify action on webElement
	
	public void genderBtn() {
		genderBtn.click();
	}
	public void enterFname(String name) {
		EntrFName.sendKeys(name);
	}
	public void enterLname(String Lname) {
		EntrLName.sendKeys(Lname);
	}
	public void enterPassword(String pswrd) {
		password.sendKeys(pswrd);
	}
	public void clickOnDays(String selectDay) {
		days.click();
		days.sendKeys(selectDay);
		days.sendKeys(Keys.ENTER);
	}
	public void clickOnMonth(String selectMonth) {
		month.click();
		month.sendKeys(selectMonth);
		month.sendKeys(Keys.ENTER);
	}
	public void clickOnYears(String selectYear) {
		years.click();
		years.sendKeys(selectYear);
		years.sendKeys(Keys.ENTER);
	}
	public void registerBtn() {
		Register.click();
	}
	
}
