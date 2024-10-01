package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct {
	 // create object of webDriver
	WebDriver ldriver;
//	constructor
	public SearchProduct(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(linkText="More")WebElement MoreButton;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")WebElement searchResultProduct;	
	public void MoreButton() {
		MoreButton.click();
	}
	public String getSearchResultProductName() {
		String productName=searchResultProduct.getText();
		return productName;
	}
}
