package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchQuery {
	 // create object of webDriver
	WebDriver ldriver;
//	constructor
	public SearchQuery(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="group_1")WebElement selectSize;
	@FindBy(name="Submit")WebElement addToCart;

	@FindBy(xpath="//a[@id='color_8']")WebElement SelectColor2;
	@FindBy(xpath="//a[@class='btn btn-default button-plus product_quantity_up']")WebElement addQuantity;
	@FindBy(linkText="Proceed to checkout")WebElement checkOut;
	
	
	
	public void SelectSize(String size) {
		Select dropdown=new Select(selectSize);
		dropdown.selectByVisibleText(size);
	}
	public void AddQuantity() {
		addQuantity.click();
	}
	public void SelectColor() {
		SelectColor2.click();
	}
	public void AddToCart() {
		addToCart.click();
	}
	public void clickOnProceedToCheckOut() {
		checkOut.click();
	}
}
