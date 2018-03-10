package com.test.automation.uiAutomation.LoginPage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;
import com.test.automation.uiAutomation.uiActions.LoginPage;


public class TC001_VerifyLoginwithInvalidCredentials extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public static final Logger log = Logger.getLogger(TC001_VerifyLoginwithInvalidCredentials.class.getName());
	
	
	@BeforeTest
	public void setUp() {
		init();				
	}
	
	
	@Test
	public void verifyLoginwithInvalidCredentials() {
		try {
			log.info("================Starting verifyLoginwithInvalidCredentials test=============== ");
			loginpage = new LoginPage(driver);
			loginpage.loginToApplication("IPMN\\Admin1", "WSCAdmin");		
			log.info("================Ending verifyLoginwithInvalidCredentials test=============== ");
			homepage = new HomePage(driver);
			Assert.assertTrue(homepage.veriyLoginFunctionality());
			log.info("login is successfull");
		}catch(Exception e)
		{
			log.info("Login is not successfull");
		}
		
	}
	
	@AfterClass
	public void endTest() {
		
	}

}
