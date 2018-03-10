package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Financials_Page 
{
    final WebDriver driver;
    
	@FindBy(how = How.XPATH, using = "//div[@id='FinancialsMenu']//div[text()='Billing Volume']")
	public static WebElement billingTab;

	@FindBy(how = How.XPATH, using = "//div[@id='FinancialsMenu']//div[text()='Collections']")
	public static WebElement collectionsTab;
	
	public Financials_Page(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public static void gotoBilling()
	{
	  billingTab.click();
	}
	
	
	public static void gotoCollections()
	{
		collectionsTab.click();
	}
}
