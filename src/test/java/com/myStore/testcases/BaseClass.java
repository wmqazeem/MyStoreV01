package com.myStore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.myStore.Utilities.ReadConfig;
import com.myStore.Utilities.ReadExcelFile;

import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
ReadConfig readconfig=new ReadConfig();
String url=readconfig.readURL();
String browser=readconfig.getBrowser();
public String emailAddress = readconfig.getEmail() ;
String password = readconfig.getPassword();
public static WebDriver driver;
public static Logger logger;


//setup for browser launch
@BeforeClass
public void setup() {
	
	switch( browser.toLowerCase())
	{
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
	case "msedge":
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	
		break;
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	default:
		driver=null;
		break;
	}
	//implicit wait for all webElement
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	//for logging
	logger=LogManager.getLogger("MyStoreV01");
	
	//Open url
			driver.get(url);
			logger.info("url opened");
}

@AfterClass
public void tearDown() {
	//driver.close();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.quit();
}


public void captureSceenShot(WebDriver driver, String testName) throws IOException  {
	TakesScreenshot screenshot=((TakesScreenshot)driver);
	File src=screenshot.getScreenshotAs(OutputType.FILE);
			
	//File dest=new File("Screenshot_"+testName+".png");
	File dest=new File(System.getProperty("user.dir")+"//Screenshot//"+testName+".png");
    FileUtils.copyFile(src, dest);
}

//excell data read method()
@DataProvider(name="LoginDataProvider")
public static String [][] LoginDataProvider(){

		//System.out.println(System.getProperty("user.dir"));
		String fileName=System.getProperty("user.dir")+"\\TestData\\MyStoreTestData.xlsx";
		int ttlRows=ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttColumns=ReadExcelFile.getColCount(fileName, "LoginTestData");
		//String type 2 dimensional object created
		String data[][] =new String[ttlRows-1][ttColumns];
		
		for(int i=1;i<ttlRows;i++) { // rows =1,2
			
			for(int j=0;j<ttColumns;j++) { //col=0,1,2
				
				data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
				
			}
			
		}return data;
	}
}
