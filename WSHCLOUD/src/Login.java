import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Login {

	public static void main(String[] args) throws InterruptedException 
	{
	  String driverPath = System.getProperty("user.dir") + "\\lib\\chromedriver.exe";
	  System.setProperty("webdriver.chrome.driver", driverPath);
      WebDriver driver = new ChromeDriver();
      driver.get("https://wshcloud.com");
      Thread.sleep(10000);
      driver.manage().window().maximize();
      driver.findElement(By.id("userName")).sendKeys("IPMN\\Admin1");
      driver.findElement(By.id("password")).sendKeys("WSCAdmin");
      driver.findElement(By.id("login")).click();
      Thread.sleep(15000);
      WebElement topmenu = driver.findElement(By.id("TopLevelMenu"));
      topmenu.findElement(By.xpath("//div[contains(text(),'Financials')]")).click();
      Thread.sleep(5000);
      WebElement FinancialsMenu = driver.findElement(By.id("FinancialsMenu"));
      FinancialsMenu.findElement(By.xpath("//div[contains(text(),'Collections')]")).click();
      Thread.sleep(5000);
//      System.out.println(driver.getCurrentUrl());
      if(driver.getCurrentUrl().contains("Receivables"))
         System.out.println("Navigated to receivalbles page");
      else
    	 System.out.println("Unable to navigate receivables page");
      
      Thread.sleep(10000);
      
      WebElement page = driver.findElement(By.id("page"));
      
      WebElement widgetTitle;
      WebElement filterIcon;
      WebElement filterLabel;
      
      boolean flag = false;
      
      
      
      List<WebElement> widgetlist = page.findElements(By.className("wsc-widgetContainer"));
      for(WebElement widget : widgetlist)
      {
    	  widgetTitle =  widget.findElement(By.className("wsc-widgetTitleText"));
    	     	  
    	  if(widgetTitle.getText().equals("Charges/Payments/Adjustments summary"))
    	  {
    		filterIcon = widget.findElement(By.xpath("//a[@title='Filter']"));
    		filterIcon.click();
    		
    		List<WebElement>  filterlist= widget.findElements(By.className("wsc-filterDialogListItem"));
            for(WebElement filterItem : filterlist)
            {
            	filterLabel  = filterItem.findElement(By.className("wsc-filterDialogLabel"));
            	System.out.println(filterLabel.getText());
            	if(filterLabel.getText().equals("Provider"))
            	{         			
                  filterItem.findElement(By.xpath("//div[contains(@class, 'dx-texteditor-container')]")).click();
                  WebElement listContainer = driver.findElement(By.className("dx-scrollview-content"));
                  List<WebElement> providerList = listContainer.findElements(By.xpath("//div[contains(@class,'dx-item-content')]"));
                  for(WebElement providerItem : providerList)
                	  System.out.println(providerItem.getText());
                }
            }        	
            flag = true;        	  
            break;
    	  }
      }
      
      
      if(flag)
    	  System.out.println("CPA chart found");
      else
    	  System.out.println("CPA chart not found");
      
      
      
	}
}
