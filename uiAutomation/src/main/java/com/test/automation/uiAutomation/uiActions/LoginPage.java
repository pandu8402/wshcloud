package com.test.automation.uiAutomation.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

public class LoginPage 
{
   //WebDriver driver;
   
   public static final Logger log = Logger.getLogger(LoginPage.class.getName());
   
   @FindBy(how = How.ID, using = "userName")
   public static WebElement txtUserName;
   
   @FindBy(how = How.ID, using = "password")
   public static WebElement txtPassword;
   
   @FindBy(how = How.ID, using = "login")
   public static WebElement btnLogin;
   
   
   public LoginPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   //Login action
   public void loginToApplication(String sUserName, String sPassword)
   {	   
	 txtUserName.sendKeys(sUserName);
	 log.info("Entered username = "+ sUserName);
     txtPassword.sendKeys(sPassword);
     log.info("Entered password = "+ sPassword);
     btnLogin.click();
   }    
}
