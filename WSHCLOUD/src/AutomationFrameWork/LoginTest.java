package AutomationFrameWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.Collections_Page;
import PageObjects.Financials_Page;
import PageObjects.Home_Page;
import PageObjects.Login_Page;
import Utility.Constant;

public class LoginTest 
{
	public static WebDriver driver;
	Login_Page LoginPage;
	Home_Page HomePage;
	Financials_Page FinancialsPage;
	
	 @BeforeClass	 
	  public void beforeMethod() 
	 {
		String driverPath = System.getProperty("user.dir") + "\\lib\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(Constant.URL);
	    PageFactory.initElements(driver, Login_Page.class);
	    PageFactory.initElements(driver, Home_Page.class);
	    PageFactory.initElements(driver, Financials_Page.class);
	    PageFactory.initElements(driver, Collections_Page.class);
	  }
	 
	  @Test
	  public void VerifyLogin() throws InterruptedException 
	  {
		Login_Page.LogIn_Action(Constant.Username, Constant.Password);
		Thread.sleep(10000);
		Assert.assertEquals(Home_Page.financialsMenu.isDisplayed(), true, "Login is not sucessfull");
	  }
	  
	  
	  @Test
	  public void VerifygoToFinancials() throws InterruptedException 
	  {
		Home_Page._gotoPage("Financials");
		Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl().contains("BillingPage"), true, "Unable to navigate to Financial page");
	  }
	  
	  
	  @Test
	  public void verifyCollectionsPageWidget() throws InterruptedException 
	  {
		Financials_Page.gotoCollections();
		Thread.sleep(15000);
		Assert.assertEquals(Collections_Page.verifyWidgets(), true, "all widget are not available in collections page");
	  }
	  
	 
	  @AfterClass	 
	  public void afterMethod() throws InterruptedException 
	  { 
		Home_Page.logOut();
		Thread.sleep(3000);
		Assert.assertEquals(Login_Page.btnLogin.isDisplayed(), true, "Logout is not successfull");
		driver.close();
		driver.quit();
	  }
	 
	
	
}
