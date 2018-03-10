package PageObjects;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Collections_Page
{
  final WebDriver driver;
  
 
  @FindBy(how = How.XPATH, using = "//div[@data-widget='MonthlyChargespaymentsandadjustmentswithmappingWidget']")
  public static WebElement CPAWithMapWidget;
  
  @FindBy(how = How.XPATH, using = "//div[@data-widget='MonthlyChargespaymentsandadjustmentsWidget']")
  public static WebElement CPAWithOutMapWidget;
  
  @FindBy(how = How.XPATH, using = "//div[@data-widget='MonthlyCPTcategorycountWithMapWidget']")
  public static WebElement CPTCountWithMapWidget;
  
  @FindBy(how = How.XPATH, using = "//div[@data-widget='MonthlyCPTcategorycountWidget']")
  public static WebElement CPTCountWithOutMapWidget;
  
  @FindBy(how = How.XPATH, using = "//div[@data-widget='PaymentlagwithWidget']")
  public static WebElement paymentLagWidget;
  
  @FindBy(how = How.XPATH, using = "//div[@data-widget='CollectionPercentageWidget']")
  public static WebElement CollectionpercentWidget;
  
  @FindBy(how = How.XPATH, using = "//div[@data-widget='PaymentLagByBillNumberGridWidget']")
  public static WebElement paymentlagGridWidget;
  
  
  
  public Collections_Page(WebDriver driver)
  {
	 this.driver = driver; 
  }
  
    
  public static boolean verifyWidgets()
  {
	  if (CPAWithMapWidget.isDisplayed() && CPAWithOutMapWidget.isDisplayed() 
		  && CPTCountWithMapWidget.isDisplayed() &&  CPTCountWithOutMapWidget.isDisplayed()
	      && paymentLagWidget.isDisplayed() && CollectionpercentWidget.isDisplayed() 
	      && paymentlagGridWidget.isDisplayed())
	  
		  return true;
	  else
		  return false;
  }
}
