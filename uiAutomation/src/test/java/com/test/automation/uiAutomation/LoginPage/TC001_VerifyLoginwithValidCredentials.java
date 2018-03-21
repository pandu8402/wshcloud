package com.test.automation.uiAutomation.LoginPage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.BasePage;
import com.test.automation.uiAutomation.uiActions.LoginPage;


public class TC001_VerifyLoginwithValidCredentials extends TestBase{
	
	LoginPage loginpage;
	BasePage basepage;
	
	public static final Logger log = Logger.getLogger(TC001_VerifyLoginwithValidCredentials.class.getName());
	
	
	@BeforeTest
	public void setUp() {
		init();				
	}
	
	
	@Test
	public void verifyLoginwithInvalidCredentials() {
		try {
			log.info("================Starting verifyLoginwithValidCredentials test=============== ");
			loginpage = new LoginPage(driver);
			loginpage.loginToApplication("IPMN\\Admin1", "WSCAdmin");		
			log.info("================Ending verifyLoginwithValidCredentials test=============== ");
			basepage = new BasePage(driver);
			Assert.assertTrue(basepage.veriyLoginFunctionality() );
			log.info("login is successfull");
		}catch(Exception e)
		{
			log.info("Login is not successfull");
		}	
	}
	
	@Test(dependsOnMethods = { "verifyLoginwithInvalidCredentials" })
	public void verifyFinancialsMenu() {
		try {
			log.info("================Starting verifyFinancialsMenu test=============== ");
				
			log.info("================Ending verifyFinancialsMenu test=============== ");
			basepage = new BasePage(driver);
			Assert.assertTrue(basepage.clickOnMainMenuItem().contains("Billing"));
			log.info("Financials menu found");
		}catch(Exception e)
		{
			log.info("Financials menu not found");
		}	
	}
	
	@AfterClass
	public void endTest() {
		
	}

}
