package com.test.automation.uiAutomation.uiActions;

import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
  @FindBy(how = How.ID, using = "leftBrand")
  public static WebElement leftbrand;
  
  public HomePage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
  
  
  public boolean veriyLoginFunctionality()
  {
	  if(leftbrand.isDisplayed())
		  return true;
	  else
		  return false;
  }
}
