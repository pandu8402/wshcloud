package com.test.automation.uiAutomation.testBase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver driver;
	public String browser = "chrome";
	public String url = "https://wshcloud.com";
	
	public void init()
	{
      String log4jConfigPath = "log4j.properties";
	  PropertyConfigurator.configure(log4jConfigPath);
	  log.info("-------Launching browser--------");
	  selectBrowser(browser);
	  getURL(url);	  
	  log.info("-------browser launched--------");
	}
	
	
	public void selectBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
	}
	
	
	public void getURL(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

}
