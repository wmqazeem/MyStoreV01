package com.myStore.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;
	
	String path="C:\\Users\\User\\Downloads\\Config.properties";
   
	//create constructor
	public ReadConfig() {
    	
    	properties=new Properties();
    	try {
			FileInputStream fis= new FileInputStream(path);
			properties.load(fis);
			}
			 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    }
	public String  readURL () {
		String url=properties.getProperty("baseUrl");
		if(url!=null)
			return url;
		else
			throw new RuntimeException("url not specified in confi file");
	}
	public String  getBrowser () {
		String brw=properties.getProperty("browser");
		if(brw!=null)
			return brw;
		else
			throw new RuntimeException("browser not specified in confi file");
	}
	public String getEmail()
	{
		String email = properties.getProperty("email");
		if(email!=null)
			return email;
		else
			throw new RuntimeException("email not specified in config file.");

	}

	public String getPassword()
	{
		String password = properties.getProperty("password");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("password not specified in config file.");

	}
}
