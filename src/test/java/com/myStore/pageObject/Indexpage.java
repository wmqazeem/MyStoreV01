package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Indexpage {
 // create object of webDriver
	WebDriver ldriver;
	//constructor
	public Indexpage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	
	}
//identify web element
	@FindBy(linkText="Sign in")WebElement signIn;
	@FindBy(xpath="(//a[@title='T-shirts'])[2]")WebElement tshirtMenu;
	@FindBy(xpath="	(//a[@title='Faded Short Sleeve T-shirts'])[2]")WebElement mouseover;

	//Identify action on webElement
	public void clickOnSignIn() {
		signIn.click();
	}
	public void clickOnTshirtMenu() {
		tshirtMenu.click();
	}
	public void mouseOverOnTshirt() {
		Actions action=new Actions (ldriver);
		action.moveToElement(mouseover).build().perform();
				
		}
	public String getPageTitle()
	{
		return(ldriver.getTitle());
	}

}
