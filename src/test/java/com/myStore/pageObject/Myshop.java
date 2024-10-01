package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Myshop {
	 // create object of webDriver
	WebDriver ldriver;
//	constructor
	public Myshop(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
//identify web element
	@FindBy(linkText="Sign out")WebElement signOut;
	@FindBy(id="email")WebElement email;
	@FindBy(id="passwd")WebElement password;
	@FindBy(id="SubmitLogin")WebElement Login;
	@FindBy(xpath="//a[@title='View my customer account']")WebElement verifyUser;
	@FindBy(id="search_query_top")WebElement searchBox;
	@FindBy(name="submit_search")WebElement enterKey;
	//Identify action on webElement
	public void enterEmail(String emailId) {
		email.sendKeys(emailId);
	}
	public void enterPassword(String passWord) {
		password.sendKeys(passWord);
	}
	
	public void signOut() {
		signOut.click();
	}
	public void Login() {
		Login.click();
	}
	public void enterSearchButton() {
		enterKey.click();
	}
	public void searchBox(String searchProduct) {
		searchBox.sendKeys(searchProduct);
	}
	public String VerifyUserName() {
		String UserName=verifyUser.getText();
		return UserName;
	}
}
