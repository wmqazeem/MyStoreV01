package com.myStore.testcases;

import com.myStore.pageObject.CreateAccount;
import com.myStore.pageObject.Indexpage;
import com.myStore.pageObject.MyAccount;
import com.myStore.pageObject.Myshop;

import junit.framework.Assert;

import java.io.IOException;

import org.testng.annotations.*;

public class Testcase_MyAccountPage extends BaseClass{

	@Test(enabled=false)
	public void VerifyRegistrationAndLogin() {
		
		Indexpage pg=new Indexpage(driver);
		pg.clickOnSignIn();
		logger.info("click on sign in link");
		MyAccount pg1=new MyAccount(driver);
		pg1.enterCreateEmail("wmqazeem95@gmail.com");
		logger.info("Email adress enters in create account section");
		pg1.clickSubmit();
		logger.info("url of sign in openned ");
		CreateAccount pg2=new CreateAccount(driver);
		pg2.genderBtn();
		pg2.enterFname("Wamiq");
		pg2.enterLname("Asif");
		pg2.enterPassword("Azeem@123");
		pg2.clickOnDays("17");
		pg2.clickOnMonth("June");
		pg2.clickOnYears("1998");
		pg2.registerBtn();
		logger.info("personal info enter ");
		Myshop pg3=new Myshop(driver);
		pg3.signOut();
		pg3.enterEmail("wmqazeem95@gmail.com");
		pg3.enterPassword("Azeem@123");
		pg3.Login();
		
		
	}
	@Test
	public void verifyLoginW() throws IOException {
		Indexpage pg=new Indexpage(driver);
		pg.clickOnSignIn();
		logger.info("click on sign in link");
		
		Myshop pg3=new Myshop(driver);
		pg3.enterEmail(emailAddress);
		pg3.enterPassword(password);
		logger.info("Enter username & password");
		pg3.Login();
		 String ActualName=pg3.VerifyUserName();
		 System.out.println(ActualName);
		if(ActualName.equals("Wamiq Asif")) {
			logger.info("VerifyLogin:- Passed");
			
			Assert.assertTrue(true);
			pg3.signOut();
			
		}
		else {
			logger.info("Verify Login:- Failed");
			captureSceenShot(driver,"verifyLogin");
			Assert.assertTrue(false);
		}
	
	}
	@Test
	public void verifySignOut() throws IOException {
		Indexpage pg=new Indexpage(driver);
		pg.clickOnSignIn();
		logger.info("click on sign in link");
		
		Myshop pg3=new Myshop(driver);
		pg3.enterEmail(emailAddress);
		pg3.enterPassword(password);
		logger.info("Enter username & password");
		pg3.Login();
		pg3.signOut();
		String pageTitle=pg.getPageTitle();
		System.out.println(pageTitle);
		
		if(pageTitle.equals("Login - My Shop"))
		{
			logger.info("VerifySignOut - Passed");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("VerifySignOut - Failed");
			captureSceenShot(driver,"verifySignOut");
			Assert.assertTrue(false);
			logger.info("Verify sign out   failed");
		}
		
	}
}

