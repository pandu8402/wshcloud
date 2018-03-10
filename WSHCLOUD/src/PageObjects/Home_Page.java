package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Home_Page 
{
	final WebDriver driver;
	
	/*@FindBy(how = How.ID, using = "TopLevelMenu")
	public WebElement topMenu;*/ 
	
	@FindBy(how = How.ID, using = "menuIcon-EngagementMenu")
	public static WebElement engagementMenu;
	
	@FindBy(how = How.ID, using = "topMenu")
	public static WebElement topMenu;
	
	@FindBy(how = How.CLASS_NAME, using = "wsc-menuLogOff")
	public static WebElement btnLogout;
	
	@FindBy(how = How.XPATH, using = "//div[@id='TopLevelMenu']//div[text()='Financials']")
	public static WebElement financialsMenu;
	
	public Home_Page(WebDriver driver)
	{
	  this.driver = driver;	
	}
	
	
	public static void _gotoPage(String tabname)
	{
		switch(tabname)
		{
		case "Financials" : 
			financialsMenu.click();
			break;
		}
	}
	
	public static void logOut()
	{
		topMenu.click();
		btnLogout.click();		
	}
}
