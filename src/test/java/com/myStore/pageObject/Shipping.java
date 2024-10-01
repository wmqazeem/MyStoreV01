package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shipping {
WebDriver ldriver;
public Shipping(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements( rdriver, this);

}

@FindBy(name="processCarrier")WebElement process;
@FindBy(name="cgv")WebElement term;

public void ProcessToCarrier() {
	process.click();
}

public void CheckOnTerm() {
	term.click();
}

}
