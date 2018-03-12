package com.test.automation.uiAutomation.uiActions;

import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testBase.TestBase;

public class HomePage extends TestBase
{
  @FindBy(how = How.ID, using = "leftBrand")
  public static WebElement leftbrand;
  
  public HomePage(WebDriver driver)
  {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
  }
  
  
  public boolean veriyLoginFunctionality()
  {
	  try {
		  waitForElement(100, leftbrand);
		  leftbrand.isDisplayed();
		  log.info("User logged in succesfully and company barnd is displayed ");
		  return true;
	  }catch(Exception e)
	  {
		return false;  
	  }
	  
  }
}
