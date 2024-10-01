package com.myStore.testcases;
import java.io.IOException;

import org.testng.annotations.*;

import com.myStore.pageObject.AddressCredential;
import com.myStore.pageObject.Indexpage;
import com.myStore.pageObject.Myshop;
import com.myStore.pageObject.OrderConfirmation;
import com.myStore.pageObject.Payment;
import com.myStore.pageObject.SearchProduct;
import com.myStore.pageObject.SearchQuery;
import com.myStore.pageObject.Shipping;

import junit.framework.Assert;

public class TC_ProductPageTest extends BaseClass {
	@Test(enabled=true)
	public void addToCart() throws  IOException {
		String searchKey="Blouse";
		Indexpage pg=new Indexpage(driver);
		pg.clickOnSignIn();
		logger.info("click on sign in link");

		Myshop pg3=new Myshop(driver);
		pg3.enterEmail(emailAddress);
		pg3.enterPassword(password);
		logger.info("Enter username & password");
		pg3.Login();
		logger.info("login is Successful");
		pg3.searchBox(searchKey);
		pg3.enterSearchButton();
		logger.info("Product is showed in page");

		SearchProduct pg4=new SearchProduct(driver);
		String SearchResultProductname=pg4.getSearchResultProductName();

		if(SearchResultProductname.contains(searchKey))
		{
			logger.info("Search Product testcase - Passed"); 
			Assert.assertTrue(true);

			pg3.signOut();

		}
		else
		{
			logger.info("Search Product testcase - Failed");
			captureSceenShot(driver,"addToCart");
			Assert.assertTrue(false);

		}
		logger.info("search test case end");
	}

	@Test(enabled = false)
	public void VerifyBuyProduct() throws InterruptedException, IOException {
		String searchKey="Blouse";
		Indexpage pg=new Indexpage(driver);
		pg.clickOnSignIn();
		logger.info("click on sign in link");

		Myshop pg3=new Myshop(driver);
		pg3.enterEmail(emailAddress);
		pg3.enterPassword(password);
		logger.info("Enter username & password");
		pg3.Login();
		logger.info("login is Successful");
		pg3.searchBox(searchKey);
		pg3.enterSearchButton();
		logger.info("Product is showed in page");

		SearchProduct pg4=new SearchProduct(driver);
		pg4.MoreButton();
		Thread.sleep(2000);
		SearchQuery pg5=new SearchQuery(driver);
		pg5.SelectColor();
		logger.info("Product color choosen");
		Thread.sleep(3000);
		pg5.AddQuantity();
		logger.info("Product'S quantity is increased");
		pg5.SelectSize("M");
		logger.info("Product'S size is selected");
		pg5.AddToCart();
		logger.info("Product added to cart");
		pg5.clickOnProceedToCheckOut();
		pg5.clickOnProceedToCheckOut();
		logger.info("CheckOut...");
		AddressCredential address=new AddressCredential(driver);
		address.Adress1("78/20 H Block okhla phase1");
		address.Adress2("Near Karbonn company");
		address.City("New Delhi");
		address.State("Florida");
		address.Postalcode("00000");
		address.PhoneNo("9818997861");
		logger.info("Address credential are completed");
		address.SubmitAddress();
		address.ProcessAddress();
		Shipping shipping=new Shipping(driver);
		shipping.CheckOnTerm();
		shipping.ProcessToCarrier();
		logger.info("Ready for shipping ...");
		Payment payment=new Payment(driver);
		payment.payByCheck();
		payment.OrderConfirm();
		logger.info("payment completed");
		OrderConfirmation orderConfirm=new OrderConfirmation(driver);
		String SuccessMsg=orderConfirm.OrderConfirm();
		if (SuccessMsg.equals("Your order on My Shop is complete.")) {
			logger.info("Passed");
			Assert.assertTrue(true);
			pg3.signOut();
		}
		else {
			logger.info("failed");
			Assert.assertTrue(false);
			captureSceenShot(driver," VerifyBuyProduct");
		}

	}

	@Test(enabled = true)
	public void BuyProductAgain() throws InterruptedException, IOException {
		String searchKey="Blouse";
		Indexpage pg=new Indexpage(driver);
		pg.clickOnSignIn();
		logger.info("click on sign in link");

		Myshop pg3=new Myshop(driver);
		pg3.enterEmail(emailAddress);
		pg3.enterPassword(password);
		logger.info("Enter username & password");
		pg3.Login();
		logger.info("login is Successful");
		pg3.searchBox(searchKey);
		pg3.enterSearchButton();
		logger.info("Product is showed in page");

		SearchProduct pg4=new SearchProduct(driver);
		pg4.MoreButton();
		Thread.sleep(2000);
		SearchQuery pg5=new SearchQuery(driver);
		pg5.SelectColor();
		logger.info("Product color choosen");
		Thread.sleep(3000);
		pg5.AddQuantity();
		logger.info("Product'S quantity is increased");
		pg5.SelectSize("M");
		logger.info("Product'S size is selected");
		pg5.AddToCart();
		logger.info("Product added to cart");
		pg5.clickOnProceedToCheckOut();
		pg5.clickOnProceedToCheckOut();
		logger.info("CheckOut...");
		AddressCredential address=new AddressCredential(driver);
		address.ProcessAddress();
		Shipping shipping=new Shipping(driver);
		shipping.CheckOnTerm();
		shipping.ProcessToCarrier();
		logger.info("Ready for shipping ...");
		Payment payment=new Payment(driver);
		payment.payByCheck();
		payment.OrderConfirm();
		logger.info("payment completed");
		OrderConfirmation orderConfirm=new OrderConfirmation(driver);
		String SuccessMsg=orderConfirm.OrderConfirm();
		if (SuccessMsg.equals("Your order on My Shop is complete.")) {
			logger.info("Passed");
			Assert.assertTrue(true);
			pg3.signOut();
		}
		else {
			logger.info("failed");
			Assert.assertTrue(false);
			captureSceenShot(driver," VerifyBuyProduct");
		}



	}
	@Test
	public void addToWishListWithoutLogin() {
		logger.info("TestCase addtoWishList has been started");
		Indexpage indexpg=new Indexpage(driver);
		indexpg.clickOnTshirtMenu();
		indexpg.mouseOverOnTshirt();
		logger.info("....mouseOver");
	}


}